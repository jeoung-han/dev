package test;

public class User {

	public User() {

	}

	public User(String userId, String userPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
	}

	public User(String userId, String userPwd, String userName, String address, String phone, char gender) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
	}

	private String userId;
	private String userPwd;
	private String userName;
	private String address;
	private String phone;
	private char gender;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public void print() {
		System.out.println("User [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", address="
				+ address + ", phone=" + phone + ", gender=" + gender + "]");
	}

}
