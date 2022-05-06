package world;
import java.io.FileNotFoundException;
import dependencies.WorldObject;

public class SpaceBattleSim {
	public static GameWorld world = new GameWorld();
	
	public static void main(String[] args) {
		world.start();
	}
}
