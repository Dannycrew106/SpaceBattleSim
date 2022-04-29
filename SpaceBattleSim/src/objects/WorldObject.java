package objects;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WorldObject{
	//public static String filePath = "C:\\Users\\904238007\\git\\SpaceBattleSim\\SpaceBattleSim\\src\\objects\\";
	//Home File Path: C:\\Users\\Danny\\git\\SpaceBattleSim\\SpaceBattleSim\\SpaceBattleSim\\src\\objects\\
	//School File Path: C:\\Users\\904238007\\git\\SpaceBattleSim\\SpaceBattleSim\\src\\objects\\
	
	public static void readLine(String fileName, int line) throws FileNotFoundException{
		File file = new File(System.getProperty("user.dir") + "\\src\\objects\\" + fileName);
		Scanner scanner = new Scanner(file);
		scanner.useDelimiter("\\\\");
		System.out.println(scanner.next());
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		readLine("Box v1.obj", 0);
	}
}