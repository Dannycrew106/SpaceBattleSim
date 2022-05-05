package dependencies;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class OBJFile {
	
	public ArrayList<Vertex> vertices = new ArrayList<>();
	public ArrayList<Triangle> triangles = new ArrayList<>();
	public MTLFile mtlLibrary;
	
	public OBJFile(String fileName) throws FileNotFoundException {
		File file = new File(System.getProperty("user.dir") + "\\src\\objects\\" + fileName);
		Scanner scanner = new Scanner(file);
		scanner.useDelimiter("\\\\");
		String fileString = scanner.next();
		System.out.println(fileString);
		scanner.close();
		String[] lines = fileString.split("\r\n|\r|\n");
		
		
		
		int vertexIndex = 0;
		int trianglesIndex = 0;
		MTLMaterial materialInUse = new MTLMaterial("Default");
		
		for (int i = 0; i < lines.length; i++) {
			if (lines[i].startsWith("#") || lines[i].startsWith("vn") || lines[i].startsWith("vt") || lines[i].startsWith("g")) {
				continue;
			} else if (lines[i].startsWith("v")) {
				String[] line = lines[i].split(" ");
				vertices.add(vertexIndex, new Vertex(parseDouble(line[1]), parseDouble(line[2]), parseDouble(line[3])));
				vertexIndex++;
			} else if (lines[i].startsWith("f")) {
				String[] line = lines[i].split(" ");
				int vertex1Index = (int)parseDouble((line[1].split("/"))[0]);
				int vertex2Index = (int)parseDouble((line[2].split("/"))[0]);
				int vertex3Index = (int)parseDouble((line[3].split("/"))[0]);
				triangles.add(trianglesIndex, new Triangle(vertices.get(vertex1Index-1), vertices.get(vertex2Index-1), vertices.get(vertex3Index-1), materialInUse));
				trianglesIndex++;
			} else if (lines[i].startsWith("mtllib")) {
				mtlLibrary = new MTLFile(lines[i].split(" ")[1]);
			} else if (lines[i].startsWith("usemtl")) {
				mtlLibrary.findMaterial(lines[i].split(" ")[1]);
			}
		}
		System.out.println("OBJFile length is: " + fileString.length());
		System.out.println("OBJFile lines is: " + lines.length);
	}
	
	private static double parseDouble(String str){
		try {
			return Double.parseDouble(str);
		} catch (Exception e) {
			System.out.println("Heck! ParseDouble failed in OBJFile");
			return 0;
		}
	}
}
