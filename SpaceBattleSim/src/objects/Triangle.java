package objects;

import java.awt.Color;

public class Triangle {
	public Vertex v1;
	public Vertex v2;
	public Vertex v3;
	
	public Quaternion normal;
	
	public Color color;
	
	public Triangle(Vertex v1, Vertex v2, Vertex v3) {
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	}
	
}
