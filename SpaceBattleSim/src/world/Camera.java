package world;

import dependencies.KeyboardInput;
import dependencies.Quaternion;

public class Camera {
	private final long minimumDeltaTime = 1000 / UserPreferences.FRAMES_PER_SECOND;
	
	public double x;
	public double y;
	public double z;
	
	public Quaternion directionFacing;
	
	public Camera(Quaternion facing, double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		directionFacing = facing;
	}
	public Camera(double x, double y, double z) {
		this(new Quaternion(0, 1, 0, 0), x, y, z);
	}
	public Camera() {
		this(0, 0, 0);
	}
	
	public void moveForward(double distance) {
		
	}
	
	public void update(KeyboardInput keyboard, long deltaTime) {
		System.out.println("Updated Camera");
		double deltaTimeCoefficient = (deltaTime/minimumDeltaTime);
		if (keyboard.keyDown(87)) {
			System.out.println("W is pressed!");
			x += 1 * directionFacing.xi * deltaTimeCoefficient;
			y += 1 * directionFacing.yj * deltaTimeCoefficient;
		}
		if (keyboard.keyDown(83)) {
			x -= 1 * directionFacing.xi * deltaTimeCoefficient;
			y -= 1 * directionFacing.yj * deltaTimeCoefficient;
		}
	}
}
