package world;
import objects.WorldObject;
import objects.Quaternion;

public class SpaceBattleSim {
	private static Renderer screen = new Renderer();
	
	public static void main(String[] args) {
		Quaternion pp = new Quaternion(1, 0, 1, 0);
		System.out.println("S: " + pp.s + " xi: " + pp.xi + " yj: " + pp.yj + " zk: " + pp.zk);
		pp.rotate(0, 0, 1, 180);
		System.out.println("S: " + pp.s + " xi: " + pp.xi + " yj: " + pp.yj + " zk: " + pp.zk);
		screen.createScreen("Space Battle Simulator", 1360, 768);
	}
}
