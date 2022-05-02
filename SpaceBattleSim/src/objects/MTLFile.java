package objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MTLFile {
	public ArrayList<MTLMaterial> materials = new ArrayList<>();
	
	public MTLFile(String fileName) throws FileNotFoundException {
		File file = new File(System.getProperty("user.dir") + "\\src\\objects\\" + fileName);
		Scanner scanner = new Scanner(file);
		scanner.useDelimiter("\\\\");
		String fileString = scanner.next();
		System.out.println(fileString);
		scanner.close();
		String[] lines = fileString.split("\r\n|\r|\n");
		
		for (int i = 0; i < lines.length; i++) {
			
		}
	}
}
