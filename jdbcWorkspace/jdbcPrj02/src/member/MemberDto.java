package member;

import java.sql.Timestamp;

public class MemberDto {

	public MemberDto() {

	}

	public MemberDto(String id, String pwd, String nick, Timestamp enrollDate, char quitYn) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
		this.enrollDate = enrollDate;
		this.quitYn = quitYn;
	}

	private String id;
	private String pwd;
	private String nick;
	private Timestamp enrollDate;
	private char quitYn;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Timestamp getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Timestamp enrollDate) {
		this.enrollDate = enrollDate;
	}

	public char getQuitYn() {
		return quitYn;
	}

	public void setQuitYn(char quitYn) {
		this.quitYn = quitYn;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pwd=" + pwd + ", nick=" + nick + ", enrollDate=" + enrollDate + ", quitYn="
				+ quitYn + "]";
	}

}
