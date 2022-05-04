package dependencies;

import java.awt.Color;

public class Triangle {
	public Vertex v1;
	public Vertex v2;
	public Vertex v3;
	public int x;
	public int y;
	public int z;
	
	public Quaternion normal;
	
	public Color color;
	
	public Triangle(Vertex v1, Vertex v2, Vertex v3, Color color) {
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.color = color;
	}
	
}
