package world;
import javax.swing.*;

import dependencies.Triangle;
import dependencies.Vertex;
import java.awt.*;
import java.util.ArrayList;

public class Renderer extends JFrame {
	
	private static final long serialVersionUID = 5110994671381635202L;
	ArrayList<Triangle> trianglesToRender = new ArrayList<>();
	private JFrame frame = null;
	private DrawGraphics g = new DrawGraphics();
	private Camera camera = new Camera(1, 0, 0);
	
	public static final int SCREEN_SIZE_X = UserPreferences.SCREEN_SIZE_X;
	public static final int SCREEN_SIZE_Y = UserPreferences.SCREEN_SIZE_Y;
	public static final int FOV = UserPreferences.FIELD_OF_VIEW;
	public static final double FOVRADIANS = ((FOV/360.0)*(Math.PI * 2));
	
	public void createScreen(String name) {
		System.out.println(camera.directionFacing.toString());
		frame = new JFrame(name);
		frame.add(g);
		frame.setBackground(Color.red);
		frame.setSize(SCREEN_SIZE_X, SCREEN_SIZE_Y);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		for (Triangle currentTriangle : trianglesToRender) {
			System.out.println("New Triangle");
			System.out.println("V1: " + currentTriangle.v1.x + " " + currentTriangle.v1.y + " " + currentTriangle.v1.z);
			System.out.println("V2: " + currentTriangle.v2.x + " " + currentTriangle.v2.y + " " + currentTriangle.v2.z);
			System.out.println("V3: " + currentTriangle.v3.x + " " + currentTriangle.v3.y + " " + currentTriangle.v3.z);
		}
	}
	
	public void refresh() {
		g.repaint();
	}
	
	public void setUIFont(javax.swing.plaf.FontUIResource font) {
		
	}
	
	class DrawGraphics extends Canvas {
		private static final long serialVersionUID = -963524664888441777L;
		
		public void paint(Graphics g) {
			camera.directionFacing.rotate(0, 1, 0, 1);
			System.out.println("Camera X Direction Facing: " + camera.directionFacing.xi);
			
			for (Triangle current : trianglesToRender) {
				
				int[] xPoints = {getScreenXPosition(current.v1), getScreenXPosition(current.v2), getScreenXPosition(current.v3)};
				int[] yPoints = {getScreenYPosition(current.v1), getScreenYPosition(current.v2), getScreenYPosition(current.v3)};
				g.fillPolygon(xPoints, yPoints, 3);
				System.out.println("XPoint 1: " + xPoints[0] + " XPoint 2: " + xPoints[1] + " XPoint 3: " + xPoints[2]);
				//g.drawPolygon(xPoints, yPoints, 3);
			}
		}
		private int getScreenXPosition(Vertex v) {
			double vXTheta = Math.atan((v.y-camera.y)/(v.x-camera.x)) - (((1 - (camera.directionFacing.xi * 1.000))-1)*Math.PI*2);
			return (int) ((vXTheta*(SCREEN_SIZE_X / FOVRADIANS))/2+(SCREEN_SIZE_X/2));
		}
		
		private int getScreenYPosition(Vertex v) {
			double relativeX = v.x-camera.x;
			double relativeY = v.y-camera.y;
			double vYTheta = Math.atan((v.z-camera.z)/Math.sqrt((relativeX*relativeX)+(relativeY*relativeY))) - (camera.directionFacing.yj*Math.PI*2);
			return (int) ((vYTheta*(SCREEN_SIZE_Y / (FOVRADIANS * (9.000/16.000))))/2+(SCREEN_SIZE_Y/2));
		}
	}
}
