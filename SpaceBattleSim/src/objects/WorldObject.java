package objects;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WorldObject{
	public Vertex[] vertices;
	
	public WorldObject(String fileName) throws FileNotFoundException {
		File file = new File(System.getProperty("user.dir") + "\\src\\objects\\" + fileName);
		Scanner scanner = new Scanner(file);
		scanner.useDelimiter("\\\\");
		String fileString = scanner.next();
		System.out.println(fileString);
		scanner.close();
	}
	
}