import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OBJReader{
	public static String filePath = "C:\\Users\\Danny\\git\\SpaceBattleSim\\SpaceBattleSim\\src\\objects\\";
	//Home File path: C:\Users\Danny\git\SpaceBattleSim\SpaceBattleSim
	
	public static void readLine(String fileName, int line) throws FileNotFoundException{
		System.out.println("FilePath is: " + filePath + fileName);
		File file = new File(filePath + fileName);
		Scanner scanner = new Scanner(file);
		scanner.useDelimiter("\\Z");
		System.out.println(scanner.next());
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		readLine("Box v1.obj", 0);
	}
}