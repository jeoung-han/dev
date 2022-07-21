package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

import main.Main;
import util.InputUtil;
import util.JDBCTemplate;

public class MemberController {

	Scanner sc = new Scanner(System.in);

	public void loginCheck(MemberDto dto) {
		if (dto != null) {
			System.out.println("----- 로그인유저정보 -----");
			System.out.println(dto);
		} else {
			System.out.println("로그인 실패 ...");
		}
	}// loginCheck

	/*
	 * id, pwd 받아서 회원 닉네임 조회
	 * 
	 * 닉네임 안녕하세요 출력
	 */
	public MemberDto login(MemberDto data) {

		String id = data.getId();
		String pwd = data.getPwd();

		// 디비와 연결, 아이디 패스워드로 조회

		// 드라이버 등록
		// 드라이버 이용해서 연결 가져오기
		Connection conn = JDBCTemplate.getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 연결된 정보를 이용해서, SQL 실행
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND QUIT_YN = 'N'";
		MemberDto loginMember = null;
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, pwd);

			// 지금 실행하는 쿼리는? SELECT 쿼리 -> 결과집합(ResultSet)
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String nick = rs.getString("NICK");
				String memberId = rs.getString("ID");
				Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");

				loginMember = new MemberDto();
				loginMember.setId(memberId);
				loginMember.setNick(nick);
				loginMember.setEnrollDate(enrollDate);
			}

		} catch (SQLException e) {
			System.out.println("로그인 에러 !!!");
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}

		return loginMember;

	}// login

	public MemberDto login() {
		System.out.print("id : ");
		String id = sc.nextLine();
		System.out.print("pwd : ");
		String pwd = sc.nextLine();

		MemberDto dto = new MemberDto();
		dto.setId(id);
		dto.setPwd(pwd);

		return login(dto);
	}

	public void edit() {

		if (Main.user == null) {
			System.out.println("로그인 해주세요");
			return;
		}
		System.out.println("======= 마이페이지 =======");
		System.out.println(Main.user);

		System.out.println("회원 정보를 수정 하시겠습니까?(Y/N)");
		String input = sc.nextLine();
		if (input.equals("Y")) {
			memberUpdate();
		} else {
			return;
		}

	}

	private void memberUpdate() {

		System.out.println("1. 비밀번호 변경");
		System.out.println("2. 닉네임 변경");
		System.out.println("3. 처음으로 돌아가기");

		int input = InputUtil.getInt();
		switch (input) {
		case 1:
			updatePwd();
			break;
		case 2:
			updateNick();
			break;
		case 3:
			return;
		default:
			System.out.println("잘못 입력했다 처음이다");
			return;
		}

	}

	private void updateNick() {
		String id = Main.user.getId();
		System.out.print("새로운 닉네임 : ");
		String newNick = sc.nextLine();

		String s = update("NICK", newNick, id);
		if (!s.equals("")) {
			System.out.println("성공");
			Main.user.setNick(s);
		} else
			System.out.println("실패");
	}

	private String update(String what, String how, String id) {

		String s = "";

		Connection conn = JDBCTemplate.getConnection();
		String sql = "UPDATE MEMBER SET ? = ? WHERE ID = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, what);
			pstmt.setString(2, how);
			pstmt.setString(3, id);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				s = how;
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}

		} catch (SQLException e) {
			JDBCTemplate.rollback(conn);
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
		}

		return s;

	}

	private void updatePwd() {
		// 현재 비밀번호 확인
		System.out.print("비밀번호 : ");
		String pwd = InputUtil.sc.nextLine();

		MemberDto dto = new MemberDto();
		dto.setId(Main.user.getId());
		dto.setPwd(pwd);

		MemberDto pwdCheckPesult = login(dto);
		if (pwdCheckPesult == null) {
			System.out.println("비번 틀림");
			return;
		}
		// 변경할 비밀번호
		System.out.print("비밀번호 : ");
		String newPwd = InputUtil.sc.nextLine();

		// 변경할 비밀번호 재입력
		System.out.print("비밀번호 : ");
		String newPwd2 = InputUtil.sc.nextLine();

		if (!newPwd.equals(newPwd2)) {
			System.out.println("신규 비밀번호가 일치하지 않음");
			return;
		}
		if (pwd.equals(newPwd)) {
			System.out.println("기존이랑 같음");
			return;
		}

		String s = update("PWD", newPwd, Main.user.getId());
		if (!s.equals(""))
			System.out.println("성공");
		else
			System.out.println("실패");
	}

	public int join(MemberDto dto) {

		int result = 0;

		System.out.println(dto);

		Connection conn = JDBCTemplate.getConnection();

		// 커넥션 이용해서 sql실행
		String sql = "INSERT INTO MEMBER VALUES(?,?,?,SYSDATE,'N')";

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getNick());

			result = pstmt.executeUpdate();
			if (result == 1)
				JDBCTemplate.commit(conn);
			else
				JDBCTemplate.rollback(conn);

		} catch (SQLException e) {
			JDBCTemplate.rollback(conn);
			System.out.println("회원가입 중 예외 발생 !");
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
		}

		return result;

	}

	private int join() {

		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		System.out.print("닉네임 : ");
		String nick = sc.nextLine();

		MemberDto dto = new MemberDto();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setNick(nick);

		return join(dto);

	}

}
