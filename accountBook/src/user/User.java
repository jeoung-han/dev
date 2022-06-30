package user;

import java.io.File;

public class User {
	public User(String name) {
		this.name = name;
		myfile = new File("D:/dev/mydev/accountBook/user/" + name + "/Main.txt");
	}

	private String name;
	private File myfile;

	private int 예산;
	private int 총지출액;
	private int 총입금액;

	public File getMyfile() {
		return myfile;
	}

}
