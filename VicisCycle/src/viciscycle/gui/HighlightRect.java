/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viciscycle.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;

/**
 *
 * @author roland
 */
public class HighlightRect extends JComponent{
	int x,y,i,j;
	public HighlightRect(int x,int y,int i, int j){
		this.x = x;
		this.y = y;
		this.i = i;
		this.j = j;
		repaint();
	}
	
	@Override
	  protected void paintComponent(Graphics g) {
		 Graphics scratchGraphics = (g == null) ? null : g.create();
		Graphics2D g2d = (Graphics2D)scratchGraphics;
		Rectangle2D r = new Rectangle2D.Double(x * 90+0, y*90+3, i*90,j*90);
		g2d.setPaint( Color.RED);
		g2d.setStroke(new BasicStroke(4));
		g2d.draw(r);
		
	}
}
