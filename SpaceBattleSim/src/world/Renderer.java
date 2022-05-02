package world;
import javax.swing.*;
import java.awt.*;

public class Renderer extends JFrame{
	
	// Render model specifies a few different things
	// 0: Simple render | 1: Basic Shading, not recommended, slow | 2: Shading with highlights and transparency
	private byte renderModel = 0;
	
	private static final long serialVersionUID = 5110994671381635202L;
	private JFrame frame = null;
	private JPanel panel = new JPanel();
	
	public void createScreen(String name, int width, int height) {
		Font serif = new Font(Font.SERIF, Font.PLAIN, 10);
		frame = new JFrame(name);
		panel.setBackground(Color.BLACK);
		frame.add(panel);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
	
	public void setUIFont(javax.swing.plaf.FontUIResource font) {
		
	}
}
