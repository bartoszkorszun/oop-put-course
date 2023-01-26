package estorage.main.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {

	public File file;
	
	public FileManager() {
		
		file = new File("eid.txt");
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void writeToFile(int eid) {
		
		if(file.exists()) {
			try {
				FileWriter myWriter = new FileWriter("eid.txt");
				myWriter.write(Integer.toString(eid));
				myWriter.close();
				System.out.println("Successfully wrote to the file.");
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		}else {
			System.out.println("There is no such file! Write unsuccessful!");
		}
	}
	
	public Integer readFromFile() {
		
		String sEid = "";
		
		if(file.exists()) {
			Scanner myReader;
			try {
				myReader = new Scanner(file);
				while (myReader.hasNextLine()) {
					sEid = myReader.nextLine();
				}
				myReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		}else {
			System.out.println("There is no such file! Read unsuccessful!");
		}
		
		int eid = Integer.parseInt(sEid);
		
		return eid;
	}
}
