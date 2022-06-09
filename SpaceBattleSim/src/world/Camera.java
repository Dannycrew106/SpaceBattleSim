package world;

import dependencies.KeyboardInput;
import dependencies.PureQuaternion;

public class Camera {
	private final long minimumDeltaTime = 1000 / UserPreferences.FRAMES_PER_SECOND;
	
	public double x;
	public double y;
	public double z;
	
	public PureQuaternion directionFacing;
	
	public Camera(PureQuaternion facing, double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		directionFacing = facing;
	}
	public Camera(double x, double y, double z) {
		this(new PureQuaternion(0, 1, 0, 0), x, y, z);
	}
	public Camera() {
		this(0, 0, 0);
	}
	
	public void moveForward(double distance) {
		
	}
	
	public void update(KeyboardInput keyboard, long deltaTime) {
		System.out.println("Updated Camera");
		double deltaTimeCoefficient = (deltaTime/minimumDeltaTime);
		//W
		if (keyboard.keyDown(87)) {
			y += 0.1 * directionFacing.xi * deltaTimeCoefficient;
			x -= 0.1 * directionFacing.zk * deltaTimeCoefficient;
			z += 0.1 * directionFacing.yj * deltaTimeCoefficient;
		}
		//S
		if (keyboard.keyDown(83)) {
			y -= 0.1 * directionFacing.xi * deltaTimeCoefficient;
			x += 0.1 * directionFacing.zk * deltaTimeCoefficient;
			z -= 0.1 * directionFacing.yj * deltaTimeCoefficient;
		}
		//A
		if (keyboard.keyDown(65)) {
			y += 0.1 * directionFacing.xi * deltaTimeCoefficient;
			x += 0.1 * directionFacing.zk * deltaTimeCoefficient;
			z += 0.1 * directionFacing.yj * deltaTimeCoefficient;
		}
		//D
		if (keyboard.keyDown(68)) {
			y -= 0.1 * directionFacing.xi * deltaTimeCoefficient;
			x -= 0.1 * directionFacing.zk * deltaTimeCoefficient;
			z -= 0.1 * directionFacing.yj * deltaTimeCoefficient;
		}
		//E
		if (keyboard.keyDown(69)) {
			y -= 0.1 * directionFacing.xi * deltaTimeCoefficient;
			x -= 0.1 * directionFacing.zk * deltaTimeCoefficient;
			z -= 0.1 * directionFacing.yj * deltaTimeCoefficient;
		}
		//Q
		if (keyboard.keyDown(81)) {
			y -= 0.1 * directionFacing.xi * deltaTimeCoefficient;
			x -= 0.1 * directionFacing.yj * deltaTimeCoefficient;
			z -= 0.1 * directionFacing.yj * deltaTimeCoefficient;
		}
		//UP arrow
		if (keyboard.keyDown(38)) {
			directionFacing.rotate(1, 0, 0, -1*deltaTimeCoefficient);
		}
		//Down arrow
		if (keyboard.keyDown(40)) {
			directionFacing.rotate(1, 0, 0, 1*deltaTimeCoefficient);
		}
		//Left Arrow
		if (keyboard.keyDown(37)) {
			directionFacing.rotate(0, 1, 0, 1*deltaTimeCoefficient);
		}
		//Right arrow
		if (keyboard.keyDown(39)) {
			directionFacing.rotate(0, 1, 0, -1*deltaTimeCoefficient);
		}
	}
}
