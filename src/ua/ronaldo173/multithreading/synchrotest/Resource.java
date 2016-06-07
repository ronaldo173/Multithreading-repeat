package ua.ronaldo173.multithreading.synchrotest;

import java.io.FileWriter;
import java.io.IOException;

public class Resource {
	private FileWriter fileWriter;

	public Resource(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}

	public Resource(String file) throws IOException {
		fileWriter = new FileWriter(file, true);
	}

	public void writing(String str, int i) {
		try {
			fileWriter.append(str + i);
			System.out.println(str + i);
			Thread.sleep((long) (Math.random() * 50));
			fileWriter.append("->" + i + " ");
			System.out.println("->" + i + " ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close(){
		try {
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
