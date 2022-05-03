package objects;
import java.io.FileNotFoundException;

public class WorldObject{
	public double x = 0;
	public double y = 0;
	public double z = 0;
	public double scale = 1;
	
	public boolean visible = false;
	
	// The direction the object is facing. This will be used to rotate each vertice around
	public Quaternion objectFacing = new Quaternion(0, 1, 0, 0);
	// The direction the object is moving. The scalar quantity is in m/s.
	public Quaternion movementDirection = new Quaternion(0, 1, 0, 0);
	
	public OBJFile model;
	
	public WorldObject(String fileName) throws FileNotFoundException {
		model = new OBJFile(fileName);
	}
	
	public void setVisible(boolean visible) {
		
	}
}