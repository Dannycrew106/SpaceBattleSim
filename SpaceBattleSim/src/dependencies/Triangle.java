package dependencies;

import java.awt.Color;

public class Triangle{
	public Vertex v1;
	public Vertex v2;
	public Vertex v3;
	public double x;
	public double y;
	public double z;
	
	public Quaternion normal;
	
	public MTLMaterial material;
	
	public Triangle(Vertex v1, Vertex v2, Vertex v3, MTLMaterial material) {
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.material = material;
		
		x = (v1.x+v2.x+v3.x)/3;
		y = (v1.y+v2.y+v3.y)/3;
		z = (v1.z+v2.z+v3.z)/3;
	}
	
	public int compareTo(Triangle o) {
		
		return 0;
	}
	
}
