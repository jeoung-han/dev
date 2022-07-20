package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import dto.EmployeeDto;

public class EmployeeController {

	public void selectEmployeeList() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 사용자로부터 값 입력
			Scanner sc = new Scanner(System.in);

			// 클래스 파일 읽어옴 (준비)
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 접속 정보
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "C##KH";
			String pwd = "KH";

			conn = DriverManager.getConnection(url, id, pwd);

//			boolean result = conn.isClosed();
//			System.out.println(result);

			// 쿼리 준비
			String sql = "SELECT * FROM EMPLOYEE";

			// statement 준비
			pstmt = conn.prepareStatement(sql);

			// 쿼리 실행 및 실행결과 저장
			rs = pstmt.executeQuery();

			while (rs.next()) { // 행 먼저 다음에 데이터가 있는지 없는지 boolean
				//칼럼 나중에
				EmployeeDto dto = new EmployeeDto();
				dto.setEmpId(rs.getString("EMP_ID"));
				dto.setEmpName(rs.getString("EMP_NAME"));
				dto.setHireDate(rs.getTimestamp("HIRE_DATE"));
				dto.setSalary(rs.getInt("SALARY"));
				dto.setEmail(rs.getString("EMAIL"));
				dto.setPhone(rs.getString("PHONE"));

				System.out.println(dto);
			}
			
		} catch (Exception e) {
			System.out.println("사원 조회 중 예외 발생 !");
			e.printStackTrace();
		}finally {
			if(conn!=null) try {conn.close();} catch (Exception e) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e) {}
			if(rs!=null) try {rs.close();} catch (Exception e) {}
		}
	}//method
	
	public void selectEmployeeById(String empId) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 사용자로부터 값 입력
			Scanner sc = new Scanner(System.in);

			// 클래스 파일 읽어옴 (준비)
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 접속 정보
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "C##KH";
			String pwd = "KH";

			conn = DriverManager.getConnection(url, id, pwd);

//			boolean result = conn.isClosed();
//			System.out.println(result);

			// 쿼리 준비
			String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";

			// statement 준비
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empId);

			// 쿼리 실행 및 실행결과 저장
			rs = pstmt.executeQuery();

			while (rs.next()) { // 행 먼저 다음에 데이터가 있는지 없는지 boolean
				//칼럼 나중에
				EmployeeDto dto = new EmployeeDto();
				dto.setEmpId(rs.getString("EMP_ID"));
				dto.setEmpName(rs.getString("EMP_NAME"));
				dto.setHireDate(rs.getTimestamp("HIRE_DATE"));
				dto.setSalary(rs.getInt("SALARY"));
				dto.setEmail(rs.getString("EMAIL"));
				dto.setPhone(rs.getString("PHONE"));

				System.out.println(dto);
			}
			
		} catch (Exception e) {
			System.out.println("사원 조회 중 예외 발생 !");
			e.printStackTrace();
		}finally {
			if(conn!=null) try {conn.close();} catch (Exception e) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e) {}
			if(rs!=null) try {rs.close();} catch (Exception e) {}
		}
	}//method
}











