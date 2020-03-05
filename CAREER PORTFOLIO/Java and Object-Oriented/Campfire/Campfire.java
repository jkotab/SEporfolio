package draw;

import java.awt.Color;
import java.awt.Graphics2D;

public class Campfire extends LandscapeObject{
	//attributes
	private Color logColor;
	private Color flameColor;
	private int logWidth = 60;
	private int logHeight = 20;
	
	public Campfire (Graphics2D g2, int x, int y, double scale, float logburntness, float flamebrightness) {
		//logburntness is between 0.0f (ashen) and 1.0f (new log)
		//we recommend a brightness between 0.6f and 1.0f
		//logHeight is modified according to how "burnt up" the log is 
		//because the log will be noticably smaller once its all burnt
		//and the limited amount of fuel (log) left will naturally lower the flames height
		//we build the flame shapes off a reference to logheight to achieve this effect
		
		super(g2, x, y, scale);
		logColor = Color.getHSBColor(0.12f, logburntness, 0.4f);
		flameColor = Color.getHSBColor(0.05f, 1.0f, flamebrightness);
		logHeight = (int) (logHeight*Math.sqrt(Math.sqrt(logburntness)));
		
	}

	public void draw() {
		applyScale();
		drawlog();
		drawflame();
	}

	public void applyScale() {
		logWidth = (int) (logWidth*getScale());
		logHeight = (int) (logHeight*getScale());
	}
	
	public void drawlog() {
		g2.setColor(logColor);
		g2.drawRect(getStartX(), getStartY(), logWidth, logHeight);
		g2.fillRect(getStartX(), getStartY(), logWidth, logHeight);
	}
	
	public void drawflame() {
		//This helps us shorten yPoints line
		int flames = getStartY() - (int)(logHeight*1.25);
	
		g2.setColor(flameColor);
		
		//Base of fire
		g2.fillArc(getStartX(), getStartY()-(int)(logHeight*2.75), logWidth, logHeight*3, 180, 180);
		
		//Pinnacles of fire (flames)
		int[] yPoints = {flames, flames, flames-(int)(logHeight*1.2)};
		
		int[] xPoints1 = {getStartX(), (int)(getStartX()+logWidth/3), (int)(getStartX()+logWidth/6)};
				g2.fillPolygon(xPoints1, yPoints, 3);
				g2.drawPolygon(xPoints1, yPoints, 3);
		int[] xPoints2 = {getStartX()+(int)(logWidth/3), getStartX() + (int)(2*logWidth/3), getStartX()+(int)(logWidth/2)};
				g2.fillPolygon(xPoints2, yPoints, 3);
				g2.drawPolygon(xPoints2, yPoints, 3);
		int[] xPoints3 = {getStartX()+(int)(2*logWidth/3), getStartX()+logWidth, getStartX()+(int)(5*logWidth/6)};
				g2.fillPolygon(xPoints3, yPoints, 3);
				g2.drawPolygon(xPoints3, yPoints, 3);
	}
}
