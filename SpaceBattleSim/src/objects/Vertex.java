package objects;

public class Vertex {
	// Create the actual vertex using quaternions relative to the center of an object
	public Quaternion qVertex;
	
	// When needing to render the vertex, we need a world coordinate
	public double x;
	public double y;
	public double z;
	
	public Vertex(double x, double y, double z) {
		qVertex = new Quaternion(Math.sqrt((x*x)+(y*y)+(z*z)), Math.atan(y/x), Math.atan(z/(Math.sqrt((x*x)+y*y))), 0);
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
}
