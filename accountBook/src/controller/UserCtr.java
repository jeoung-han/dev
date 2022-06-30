package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import exception.notUserException;

public class UserCtr {
	
	private String userDir = "D:/dev/mydev/accountBook/user/";
	private File list = new File(userDir,"userList.txt");
	
	FileOutputCtr foc = new FileOutputCtr();
	FileInputCtr fic = new FileInputCtr();
	
	public void checkUser(String name) throws notUserException {
		List<String> list = fic.readAll(this.list);
		if(!list.contains(name)) throw new notUserException();
	}
	
	public void createUser(String name) throws IOException {
		foc.write(list, name);
		File user = new File(userDir,name);
		user.mkdir();
		File main = new File(userDir+name+"/","Main.txt");
		main.createNewFile();
	}

}
