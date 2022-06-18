package dependencies;

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
		System.out.println("Finished Reading MTLFile");
		
		int materialsIndex = 0;
		
		for (int i = 0; i < lines.length; i++) {
			if (lines[i].startsWith("#")) {
				continue;
			} else if (lines[i].startsWith("newmtl")) {
				System.out.println("New MTL: " + lines[i].split(" ")[1]);
				String mtlName = lines[i].split(" ")[1];
				materials.add(materialsIndex, new MTLMaterial(mtlName));
				materialsIndex++;
			} else if (lines[i].startsWith("Ka")) {
				String red = lines[i].split(" ")[1];
				String green = lines[i].split(" ")[2];
				String blue = lines[i].split(" ")[3];
				
				materials.get(materialsIndex - 1).ambientColor[0] = parseFloat(red);
				materials.get(materialsIndex - 1).ambientColor[1] = parseFloat(green);
				materials.get(materialsIndex - 1).ambientColor[2] = parseFloat(blue);
			} else if (lines[i].startsWith("Kd")) {
				String red = lines[i].split(" ")[1];
				String green = lines[i].split(" ")[2];
				String blue = lines[i].split(" ")[3];
				
				System.out.println("Kd Found!: " + red + " : " + green + " : " + blue);
				System.out.println("Writing To: " + materials.get(materialsIndex - 1).name);
				
				materials.get(materialsIndex - 1).setDiffuse(0, parseFloat(red));
				materials.get(materialsIndex - 1).setDiffuse(1, parseFloat(green));
				materials.get(materialsIndex - 1).setDiffuse(2, parseFloat(blue));
			} else if (lines[i].startsWith("Ks")) {
				String red = lines[i].split(" ")[1];
				String green = lines[i].split(" ")[2];
				String blue = lines[i].split(" ")[3];
				
				materials.get(materialsIndex - 1).specularColor[0] = parseFloat(red);
				materials.get(materialsIndex - 1).specularColor[1] = parseFloat(green);
				materials.get(materialsIndex - 1).specularColor[2] = parseFloat(blue);
			} else if (lines[i].startsWith("illum")) {
				byte illumValue = (byte) Math.min(parseDouble(lines[i].split(" ")[1]), 2);
				materials.get(materialsIndex - 1).illum = illumValue;
			} else if (lines[i].startsWith("Ns")) {
				double nsValue  = parseDouble(lines[i].split(" ")[1]);
				materials.get(materialsIndex - 1).Ns = nsValue;
			}
		}
		System.out.println("MTLFile length is: " + lines.length);
	}
	public MTLMaterial findMaterial(String materialName) {
		System.out.println("Finding Material: " + materialName);
		for (int i = 0; i < materials.size(); i++) {
			System.out.println("Material Is: " + materials.get(i).name);
			if (materials.get(i).name.equals(materialName)) {
				return materials.get(i);
			}
		}
		return null;
	}
	
	private double parseDouble(String str) {
		try {
			return Double.parseDouble(str);
		} catch (Exception e) {
			System.out.println("Parse Double failed at MTLFile");
			return 0;
		}
	}
	private float parseFloat(String str) {
		try {
			return Float.parseFloat(str);
		} catch (Exception e) {
			System.out.println("Parse Float failed at MTLFile");
			return 0;
		}
	}
}
