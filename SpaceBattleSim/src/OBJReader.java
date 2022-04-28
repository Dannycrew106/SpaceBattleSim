import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OBJReader{
	public static String filePath = "C:\\Users\\904238007\\git\\SpaceBattleSim\\SpaceBattleSim\\src\\objects\\";
	//Home File Path: C:\\Users\\Danny\\git\\SpaceBattleSim\\SpaceBattleSim\\SpaceBattleSim\\src\\objects\\
	//School File Path: C:\\Users\\904238007\\git\\SpaceBattleSim\\SpaceBattleSim\\src\\objects\\
	
	public static void readLine(String fileName, int line) throws FileNotFoundException{
		Path path = Paths.get(fileName);
		System.out.println("FilePath is: " + path.toAbsolutePath().toString().replace(fileName, "\\src\\objects\\" + fileName));
		File file = new File(path.toAbsolutePath().toString().replace(fileName, "\\src\\objects\\" + fileName));
		Scanner scanner = new Scanner(file);
		scanner.useDelimiter("\\\\");
		System.out.println("something");
		System.out.println(scanner.next());
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		readLine("Box v1.obj", 0);
	}
}