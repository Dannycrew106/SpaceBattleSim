package world;
import objects.WorldObject;

public class SpaceBattleSim {
	private static Renderer screen = new Renderer();
	
	public static void main(String[] args) {
		 screen.createScreen("Space Battle Simulator", 1360, 768);
	}
}
