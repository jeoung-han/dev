package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import util.JDBCTemplate;

public class MemberController {
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 * id, pwd 받아서 회원 닉네임 조회
	 * 
	 * 닉네임 안녕하세요 출력
	 */
	public void login() {
		
		System.out.print("ID  : ");
		String userId = sc.nextLine();
		System.out.print("PWD : ");
		String userPwd = sc.nextLine();
		
		Connection conn = JDBCTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT PWD, NICK FROM MEMBER WHERE ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("PWD").equals(userPwd)) {
					System.out.println(rs.getString("NICK") + "님 안녕하세요");
				}
				else System.out.println("비밀번호 틀림");
			}else System.out.println("그런 아이디 없음");
			
		} catch (SQLException e) {
			System.out.println("로그인 중 오류 발생");
			e.printStackTrace();
		} finally {
			if(conn!=null) try {conn.close();} catch (Exception e) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e) {}
			if(rs!=null) try {rs.close();} catch (Exception e) {}
		}
		
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
