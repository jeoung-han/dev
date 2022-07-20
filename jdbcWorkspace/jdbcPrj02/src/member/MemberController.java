package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import util.JDBCTemplate;

public class MemberController {
	
	public void login() {}
	
	public void edit() {}

	public int join() {
		
		int result = 0;
		
		MemberDto dto = showJoinView();
		
		System.out.println(dto);
		
		Connection conn = JDBCTemplate.getConnection();
		
		//커넥션 이용해서 sql실행
		String sql = "INSERT INTO MEMBER VALUES(?,?,?,SYSDATE,'N')";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getNick());

			result = pstmt.executeUpdate();
					
		} catch (SQLException e) {
			System.out.println("회원가입 중 예외 발생 !");
			e.printStackTrace();
		}
		
		return result;
		
	}

	private MemberDto showJoinView() {
		
		Scanner sc = new Scanner(System.in);
		
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
