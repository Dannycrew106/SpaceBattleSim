package objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class OBJFile {
	
	public ArrayList<Vertex> vertices;
	public ArrayList<Triangle> triangles;
	
	public OBJFile(String fileName) throws FileNotFoundException {
		File file = new File(System.getProperty("user.dir") + "\\src\\objects\\" + fileName);
		Scanner scanner = new Scanner(file);
		scanner.useDelimiter("\\\\");
		String fileString = scanner.next();
		System.out.println(fileString);
		scanner.close();
		String[] lines = fileString.split("\r\n|\r|\n");
		
		int vertexIndex = 0;
		for (int i = 0; i < lines.length; i++) {
			if (lines[i].startsWith("#") || lines[i].startsWith("vn") || lines[i].startsWith("vt") || lines[i].startsWith("g")) {
				continue;
			} else if (lines[i].startsWith("v")) {
				String[] line = lines[i].split(" ");
				vertices.add(vertexIndex, new Vertex(parseDouble(line[0]), parseDouble(line[0]), parseDouble(line[0])));
			} else if (lines[i].startsWith("f")) {
				String[] line = lines[i].split(" ");
				
			}
		}
	}
	
	private static double parseDouble(String str){
		try {
			return Double.parseDouble(str);
		} catch (Exception e) {
			return 0;
		}
	}
}
