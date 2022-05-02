package world;
import objects.WorldObject;

import java.io.FileNotFoundException;

import objects.Quaternion;

public class SpaceBattleSim {
	private static Renderer screen = new Renderer();
	
	public static void main(String[] args) {
		try {
			WorldObject somefin = new WorldObject("Box v1.obj");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		screen.createScreen("Space Battle Simulator", 1360, 768);
	}
}
