package world;
import javax.swing.*;
import world.GameWorld.DrawGraphics;
import java.awt.*;

public class Renderer extends JFrame {
	
	private static final long serialVersionUID = 5110994671381635202L;
	private JFrame frame = null;
	private JButton button = new JButton("Exit");
	
	public void createScreen(String name, int width, int height) {
		frame = new JFrame(name);
		button.setBounds(130, 100, 100, 40);
		frame.add(button);
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void refresh() {
	}
	
	public void setUIFont(javax.swing.plaf.FontUIResource font) {
		
	}
}
