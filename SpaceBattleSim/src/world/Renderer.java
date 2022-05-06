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
	private JButton button = new JButton("Exit");
	private DrawGraphics g = new DrawGraphics();
	
	public static final int SCREEN_SIZE_X = UserPreferences.SCREEN_SIZE_X;
	public static final int SCREEN_SIZE_Y = UserPreferences.SCREEN_SIZE_Y;
	public static final int FOV = UserPreferences.FIELD_OF_VIEW;
	
	public void createScreen(String name) {
		frame = new JFrame(name);
		frame.add(g);
		frame.setForeground(new Color(172, 211, 99));
		frame.setSize(SCREEN_SIZE_X, SCREEN_SIZE_Y);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void refresh() {
		g.repaint();
	}
	
	public void setUIFont(javax.swing.plaf.FontUIResource font) {
		
	}
	
	class DrawGraphics extends Canvas {
		private static final long serialVersionUID = -963524664888441777L;
		
		public void paint(Graphics g) {
			
			
			for (Triangle current : trianglesToRender) {
				int[] xPoints = {getScreenXPosition(current.v1), getScreenXPosition(current.v2), getScreenXPosition(current.v3)};
				System.out.println("Screen position for V1: " + getScreenXPosition(current.v1));
				int[] yPoints = {getScreenYPosition(current.v1), getScreenYPosition(current.v2), getScreenYPosition(current.v3)};
				g.drawPolygon(xPoints, yPoints, 3);
			}
		}
		private int getScreenXPosition(Vertex v) {
			double vXTheta = Math.atan(v.y/v.x);
			System.out.println("VXTheta: " + vXTheta);
			return (int) ((int) vXTheta*(SCREEN_SIZE_X * (FOV/360) * Math.PI * 2))+(SCREEN_SIZE_X/2);
		}
		
		private int getScreenYPosition(Vertex v) {
			double vYTheta = Math.atan(v.z/getScreenXPosition(v));
			return (int) ((int) vYTheta*(SCREEN_SIZE_Y * (FOV/360) * Math.PI * 2))+(SCREEN_SIZE_Y/2);
		}
	}
}
