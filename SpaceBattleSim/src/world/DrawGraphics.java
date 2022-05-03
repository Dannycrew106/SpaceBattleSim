package world;

import java.awt.*;

public class DrawGraphics extends Canvas {
	private static final long serialVersionUID = -963524664888441777L;
	int[] xPoints = {100, 400, 200};
	int[] yPoints = {300, 600, 100};
	
	public void paint(Graphics g) {
		g.setColor(new Color(90, 129, 191));
		g.fillPolygon(xPoints, yPoints, 3);
	}
}

