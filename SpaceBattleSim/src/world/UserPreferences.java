package world;

public class UserPreferences {
	
	// This file stores all user preferences, could've used a .txt file, but...
	// You know how to use java and it's easier to pull variables from a java file than a .txt file
	
	// Pretty easy to modify, just change the values to the way you want, I've put comments to explain specific ones that aren't self explanatory
	
	public static final int FRAMES_PER_SECOND = 60;
	
	// Size of the window in pixels
	public static final int SCREEN_SIZE_X = 1920;
	public static final int SCREEN_SIZE_Y = 1080;
	
	// Bit of a complicated one, this one chooses all the .obj files to render into the world.
	// If you want to add an object into the world, just find a suitable .obj file, slap it into the objects folder/package
	// Then add its name into this array
	public static final String[] OBJECTS_IN_USE = {"actual.obj"};
	
	
}
