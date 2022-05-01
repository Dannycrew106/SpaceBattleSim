package world;
import javax.swing.*;
import java.awt.*;

public class Renderer extends JFrame{
	
	private static final long serialVersionUID = 5110994671381635202L;
	private JFrame frame = null;
	private JPanel panel = new JPanel();
	
	public void createScreen(String name, int width, int height) {
		frame = new JFrame(name);
		panel.setBackground(Color.BLACK);
		frame.add(panel);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
	
	public void setUIFont(javax.swing.plaf.FontUIResource font) {
		
	}
}
