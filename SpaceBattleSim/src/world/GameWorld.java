package world;

import java.util.ArrayList;
import java.util.Scanner;
import dependencies.*;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class GameWorld {
	ArrayList<WorldObject> objects = new ArrayList<>();
	ArrayList<Triangle> trianglesToRender = new ArrayList<>();
	
	public static final int FRAMES_PER_SECOND = UserPreferences.FRAMES_PER_SECOND;
	
	private long current_time = 0;								
	private long nextRefreshTime = 0;							
	private long lastRefreshTime = 0;
	private long minimumDeltaTime = 1000 / FRAMES_PER_SECOND;	
	private long actualDeltaTime = 0;			
	private Renderer render = new Renderer();
	
	public void start() {
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
		int[] xPoints = {100, 400, 200};
		int[] yPoints = {300, 600, 100};
		
		public void paint(Graphics g) {
			g.setColor(new Color(0, 0, 0));
			g.fillRect(0, 0, 1360, 768);
			g.setColor(new Color(90, 129, 191));
			g.fillPolygon(xPoints, yPoints, 3);
			
			for (WorldObject currentObject : SpaceBattleSim.world.objects) {
				
			}
		}
	}
}
