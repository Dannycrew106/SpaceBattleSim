package world;
import javax.swing.*;

import dependencies.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Renderer extends JFrame {
	
	private static final long serialVersionUID = 5110994671381635202L;
	ArrayList<Triangle> trianglesToRender = new ArrayList<>();
	private JFrame frame = null;
	private DrawGraphics g = new DrawGraphics();
	public Camera camera = new Camera(0, -3, 0);
	public JPanel panel;
	
	public static final int SCREEN_SIZE_X = UserPreferences.SCREEN_SIZE_X;
	public static final int SCREEN_SIZE_Y = UserPreferences.SCREEN_SIZE_Y;
	public static final int FOV = UserPreferences.FIELD_OF_VIEW;
	public static final double FOVRADIANS = Math.toRadians(FOV);
	
	public KeyboardInput keyboard = new KeyboardInput();
	
	public void createScreen(String name) {
		System.out.println(camera.directionFacing.toString());
		camera.directionFacing.rotate(0, 1, 0, 50);
		//camera.directionFacing.rotate(1, 0, 0, -10);
		panel = new DrawGraphics();
		frame = new JFrame(name);
		frame.add(g);
		//frame.setBackground(Color.red);
		frame.setSize(SCREEN_SIZE_X, SCREEN_SIZE_Y);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		for (Triangle currentTriangle : trianglesToRender) {
			System.out.println("New Triangle");
			System.out.println("V1: " + currentTriangle.v1.x + " " + currentTriangle.v1.y + " " + currentTriangle.v1.z);
			System.out.println("V2: " + currentTriangle.v2.x + " " + currentTriangle.v2.y + " " + currentTriangle.v2.z);
			System.out.println("V3: " + currentTriangle.v3.x + " " + currentTriangle.v3.y + " " + currentTriangle.v3.z);
		}
		
		addKeyListener(keyboard);
		frame.addKeyListener(keyboard);
	}
	
	public void refresh() {
		//panel.repaint();
		g.repaint();
	}
	
	public void setUIFont(javax.swing.plaf.FontUIResource font) {
		
	}
	
	class DrawGraphics extends JPanel {
		
		
		private static final long serialVersionUID = -963524664888441777L;
		public void paintComponent(Graphics g) {
			//camera.directionFacing.rotate(0, 1, 0, 1);
			System.out.println("Camera X Direction Facing: " + camera.directionFacing.xi);
			System.out.println("Camera X: " + camera.x + " Y: " + camera.y + " Z: " + camera.z);
			doQuickSort(trianglesToRender);
			
			for (int i = trianglesToRender.size()-1; i >= 0; i--) {
				
				int[] xPoints = {getScreenXPosition(trianglesToRender.get(i).v1), getScreenXPosition(trianglesToRender.get(i).v2), getScreenXPosition(trianglesToRender.get(i).v3)};
				int[] yPoints = {getScreenYPosition(trianglesToRender.get(i).v1), getScreenYPosition(trianglesToRender.get(i).v2), getScreenYPosition(trianglesToRender.get(i).v3)};
				//g.setColor(Color.black);
				//g.fillPolygon(xPoints, yPoints, 3);
				//System.out.println("XPoint 1: " + xPoints[0] + " XPoint 2: " + xPoints[1] + " XPoint 3: " + xPoints[2]);
				//System.out.println("YPoint 1: " + yPoints[0] + " YPoint 2: " + yPoints[1] + " YPoint 3: " + yPoints[2]);
				g.setColor(Color.red);
				g.drawPolygon(xPoints, yPoints, 3);
			}
		}
		private int getScreenXPosition(Vertex v) {
			double vXTheta = Math.atan((v.y-camera.y)/(v.x-camera.x)) - Math.asin(camera.directionFacing.xi)*2;
			//System.out.println("vXTheta: " + vXTheta);
			return (int) ((vXTheta*(SCREEN_SIZE_X / FOVRADIANS))/2+(SCREEN_SIZE_X/2));
		}
		
		private int getScreenYPosition(Vertex v) {
			double relativeX = v.x-camera.x;
			double relativeY = v.y-camera.y;
			double vYTheta = Math.atan((v.z-camera.z)/Math.sqrt(Math.abs(relativeX*relativeX)+Math.abs(relativeY*relativeY))) - Math.asin(camera.directionFacing.yj)*2;
			return (int) ((vYTheta*(SCREEN_SIZE_Y / (FOVRADIANS * (9.000/16.000))))/2+(SCREEN_SIZE_Y/2));
		}
	}
	
	// Yes I am using my own quicksort algorithm to sort nearest and farthest triangles
	public void doQuickSort(ArrayList<Triangle> triangles) {
		doQuickSort(triangles, 0, triangles.size() - 1);
	}
	
	private void doQuickSort(ArrayList<Triangle> triangles, int low, int high) {
		if (low < high) {
			swap(triangles, low, (int) Math.floor(Math.random()*(high-low))+low);
			Triangle pivotTriangle = triangles.get(low);
			double pivotValue = getDistanceToCamera(pivotTriangle.x, pivotTriangle.y, pivotTriangle.z);
			int index = low;
		
			for (int i = low + 1; i <= high; i++) {
				if (getDistanceToCamera(triangles.get(i).x,triangles.get(i).y, triangles.get(i).z) < pivotValue) {
					swap(triangles, i, index + 1);
					index++;
				}
			}
			
			swap(triangles, low, Math.min(index, triangles.size()));
			doQuickSort(triangles, low, index - 1);
			doQuickSort(triangles, Math.min(index + 1, triangles.size()), high);
		}
	}
	
	private void swap(ArrayList<Triangle> triangles, int firstIndex, int secondIndex) {
		Triangle temp = triangles.get(firstIndex);
		triangles.set(firstIndex, triangles.get(secondIndex));
		triangles.set(secondIndex, temp);
	}
	public double getDistanceToCamera(double x, double y, double z) {
		return Math.sqrt(Math.pow(x-camera.x, 2) + Math.pow(y-camera.y, 2) + Math.pow(z-camera.z, 2));
	}
}
