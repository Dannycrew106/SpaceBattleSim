package world;
import java.io.FileNotFoundException;
import dependencies.WorldObject;

public class SpaceBattleSim {
	private static Renderer screen = new Renderer();
	public static GameWorld world = new GameWorld();
	
	public static void main(String[] args) {
		try {
			WorldObject somefin = new WorldObject("actual.obj");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		screen.createScreen("Space Battle Simulator", 1360, 768);
	}
}
