package world;

import java.util.ArrayList;
import java.util.Scanner;
import dependencies.*;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class GameWorld{
	ArrayList<WorldObject> objects = new ArrayList<>();
	ArrayList<Triangle> trianglesToRender = new ArrayList<>();
	
	public static final int FRAMES_PER_SECOND = UserPreferences.FRAMES_PER_SECOND;
	public static final int SCREEN_SIZE_X = UserPreferences.SCREEN_SIZE_X;
	public static final int SCREEN_SIZE_Y = UserPreferences.SCREEN_SIZE_Y;
	public static final int FOV = UserPreferences.FIELD_OF_VIEW;
	
	private long current_time = 0;								
	private long nextRefreshTime = 0;							
	private long lastRefreshTime = 0;
	private long minimumDeltaTime = 1000 / FRAMES_PER_SECOND;	
	private long actualDeltaTime = 0;			
	private Renderer render = new Renderer();
	private Camera camera = new Camera();
	
	public void start() {
		for (WorldObject currentObject : SpaceBattleSim.world.objects) {
			for (Triangle currentTriangle : currentObject.model.triangles) {
				trianglesToRender.add(currentTriangle);
			}
		}
		loop();
	}
	
	private void loop() {
		while (true) {
			nextRefreshTime = lastRefreshTime + minimumDeltaTime;
			
			while (System.currentTimeMillis() < nextRefreshTime) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			lastRefreshTime = System.currentTimeMillis();
			
			render.refresh();
		}
	}
	
	
	class DrawGraphics extends Canvas {
		private static final long serialVersionUID = -963524664888441777L;
		
		public void paint(Graphics g) {

			
			for (Triangle current : trianglesToRender) {
				int[] xPoints = {getScreenXPosition(current.v1), getScreenXPosition(current.v2), getScreenXPosition(current.v3)};
				int[] yPoints = {getScreenYPosition(current.v1), getScreenYPosition(current.v2), getScreenYPosition(current.v3)};
			}
		}
		private int getScreenXPosition(Vertex v) {
			double vXTheta = Math.atan(v.y/v.x);
			return (int) vXTheta*(SCREEN_SIZE_X * FOV);
		}
		
		private int getScreenYPosition(Vertex v) {
			double vYTheta = Math.atan(v.z/getScreenXPosition(v));
			return (int) vYTheta*(SCREEN_SIZE_Y * FOV);
		}
	}

}
