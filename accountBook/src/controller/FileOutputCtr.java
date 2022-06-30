package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputCtr {

	public void write(File f, String s) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(f, true))){
			bw.write(s);
			bw.write("\n");
			bw.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
