package main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Scanner;

import dto.EmployeeDto;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("===== JDBC TEST =====");
		
		//사용자로부터 값 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("money ::: ");
		int money = sc.nextInt();
		sc.nextLine();
		
		//클래스 파일 읽어옴 (준비)
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//접속 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "C##KH";
		String pwd = "KH";
		
		Connection conn = DriverManager.getConnection(url, id, pwd);
		
//		boolean result = conn.isClosed();
//		System.out.println(result);
		
		//쿼리 준비
		String sql = "SELECT * FROM EMPLOYEE WHERE SALARY > ?";
				
		//statement 준비
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, money);
				
		//쿼리 실행 및 실행결과 저장
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) { //행 먼저 다음에 데이터가 있는지 없는지 boolean
//			String empName = rs.getString("EMP_NAME");//칼럼 나중에
//			String empId = rs.getString("EMP_ID");
//			int salary = rs.getInt("SALARY");
//			Timestamp hireDate = rs.getTimestamp("HIRE_DATE");
			
			EmployeeDto dto = new EmployeeDto();
			dto.setEmpId(	rs.getString("EMP_ID"));
			dto.setEmpName(	rs.getString("EMP_NAME"));
			dto.setHireDate(rs.getTimestamp("HIRE_DATE"));
			dto.setSalary(	rs.getInt("SALARY"));
			dto.setEmail(	rs.getString("EMAIL"));
			dto.setPhone(	rs.getString("PHONE"));
			
			System.out.println(dto);
		}

		
	}

}
