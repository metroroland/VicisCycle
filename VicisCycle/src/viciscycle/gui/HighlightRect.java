/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viciscycle.gui;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;

/**
 *
 * @author roland
 */
public class HighlightRect extends JComponent{
	int x,y;
	public HighlightRect(int x,int y){
		this.x = x;
		this.y = y;
		repaint();
	}
	
	@Override
	  protected void paintComponent(Graphics g) {
		 Graphics scratchGraphics = (g == null) ? null : g.create();
		Graphics2D g2d = (Graphics2D)scratchGraphics;
		Rectangle2D r = new Rectangle2D.Double(x * 90, y*90, (x+2)*90, (y+2)*90);
		g2d.setStroke(new BasicStroke(3));
		g2d.draw(r);
		
	}
}
