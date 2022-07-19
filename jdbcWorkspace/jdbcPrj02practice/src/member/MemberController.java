package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

import util.JDBCTemplate;

public class MemberController {
	
	Scanner sc = new Scanner(System.in);
	
	public void loginCheck(MemberDto dto) {
		if(dto != null) {
			System.out.println("----- 로그인유저정보 -----");
			System.out.println(dto);
		}else {
			System.out.println("로그인 실패 ...");
		}
	}//loginCheck
	
	/*
	 * id, pwd 받아서 회원 닉네임 조회
	 * 
	 * 닉네임 안녕하세요 출력
	 */
	public MemberDto login() {
		
		MemberDto result = showLoginView();
		String id = result.getId();
		String pwd = result.getPwd();
		
		//디비와 연결, 아이디 패스워드로 조회
		
		//드라이버 등록
		//드라이버 이용해서 연결 가져오기
		Connection conn = JDBCTemplate.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//연결된 정보를 이용해서, SQL 실행
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND QUIT_YN = 'N'";
		MemberDto loginMember = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			//지금 실행하는 쿼리는? SELECT 쿼리 -> 결과집합(ResultSet)
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
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
		
	}//login
	
	public MemberDto showLoginView() {
		String id = sc.nextLine();
		String pwd = sc.nextLine();
		
//		String[] strArr = {id, pwd};
		
		MemberDto dto = new MemberDto();
		dto.setId(id);
		dto.setPwd(pwd);
		
		return dto;
	}
	
	public void edit() {}

	public int join() {
		
		int result = 0;
		
		MemberDto dto = showJoinView();
		
		System.out.println(dto);
		
		Connection conn = JDBCTemplate.getConnection();
				
		//커넥션 이용해서 sql실행
		String sql = "INSERT INTO MEMBER VALUES(?,?,?,SYSDATE,'N')";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getNick());

			result = pstmt.executeUpdate();
					
		} catch (SQLException e) {
			System.out.println("회원가입 중 예외 발생 !");
			e.printStackTrace();
		} finally {
			if(conn!=null) try {conn.close();} catch (Exception e) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e) {}
		}
		
		return result;
		
	}

	private MemberDto showJoinView() {
		
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
		
		return dto;
		
	}

}
