package world;

import dependencies.Quaternion;

public class Camera {
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
}
