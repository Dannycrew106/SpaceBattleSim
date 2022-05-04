package world;

import java.util.ArrayList;
import java.util.Scanner;
import dependencies.*;
import java.awt.event.KeyEvent;

public class GameWorld {
	ArrayList<WorldObject> objects = new ArrayList<>();
	public static final int FRAMES_PER_SECOND = UserPreferences.FRAMES_PER_SECOND;
	
	private long current_time = 0;								//MILLISECONDS
	private long next_refresh_time = 0;							//MILLISECONDS
	private long last_refresh_time = 0;
	private long minimum_delta_time = 1000 / FRAMES_PER_SECOND;	//MILLISECONDS
	private long actual_delta_time = 0;							//MILLISECONDS
	
	
}
