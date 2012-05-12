/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.model.tile;



import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;

/**
 * Prototype for Each Unique Tile
 * @author Kineslight
 */
public class TilePrototype 
{
	
	TilePrototype( TileSymbol tileSymbol, TileColor tileColor )
	{
		symbol = tileSymbol;
		color = tileColor;
		//this.
	
		
	}
	
	public ImageIcon getImageIcon()
	{
		return new ImageIcon();
	}
	public TileSymbol getTileSymbol()
	{
		return symbol;
	}
	public TileColor getTileColor()
	{
		return color;
	}
	
	public final void drawTile( Graphics2D g,TileOrientation orientaion) 
	{
		color.paintColors( g);
		symbol.drawSymbolAndShapes( g);		

		// draw tile border
		if(orientaion == TileOrientation.UPRIGHT)
			border = new Rectangle2D.Double(0, 0, 89, 89);
		else
			border = new Rectangle2D.Double(1, 0, 89, 89);
		g.setStroke(new BasicStroke(1));
		g.setPaint( Color.BLACK);
		g.draw(border);
	}
	
	private TileSymbol symbol;
	private TileColor color;

	private Shape border;
}
