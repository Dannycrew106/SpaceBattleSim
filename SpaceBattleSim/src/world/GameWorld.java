package world;

import java.util.ArrayList;
import java.util.Scanner;
import dependencies.*;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

public class GameWorld {
	ArrayList<WorldObject> objects = new ArrayList<>();
	
	public static final int FRAMES_PER_SECOND = UserPreferences.FRAMES_PER_SECOND;
	
	private long current_time = 0;								
	private long nextRefreshTime = 0;							
	private long lastRefreshTime = 0;
	private long minimumDeltaTime = 1000 / FRAMES_PER_SECOND;	
	private long actualDeltaTime = 0;			
	private Renderer render = new Renderer();
	
	public void start() {
		Thread thread = new Thread();
		try {
			objects.add(new WorldObject("actual.obj"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (WorldObject currentObject : SpaceBattleSim.world.objects) {
			System.out.println();
			for (Triangle currentTriangle : currentObject.model.triangles) {
				render.trianglesToRender.add(currentTriangle);
			}
		}
		render.createScreen("Space Battle Sim");
		thread.start();
		loop();
	}
	
	private void loop() {
		
		while (true) {
			nextRefreshTime = lastRefreshTime + minimumDeltaTime;
			
			while (System.currentTimeMillis() < nextRefreshTime) {
				Thread.yield();
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
	
	
	

}
