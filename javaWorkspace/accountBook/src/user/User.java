package user;

import java.io.File;

public class User {
	public User(String name) {
		myfile = new File(System.getProperty("user.dir")+"/user/" + name + "/Main.txt");
	}

	private File myfile;

//	private int 예산;
//	private int 총지출액;
//	private int 총입금액;

	public File getMyfile() {
		return myfile;
	}

}
