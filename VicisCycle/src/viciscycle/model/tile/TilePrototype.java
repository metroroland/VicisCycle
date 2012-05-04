/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.model.tile;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 * Prototype for Each Unique Tile
 * @author Kineslight
 */
public class TilePrototype  {
	
	public TilePrototype( TileSymbol tileSymbol, TileColor tileColor ) {
		symbol = tileSymbol;
		color = tileColor;
	i = new ImageIcon("src/viciscycle/graphics/"+TileSymbol.values()[  symbol.ordinal()]+".png");
		
	}
	
	public ImageIcon getImageIcon(){
		return i;
	}
	public TileSymbol getTileSymbol(){
		return symbol;
	}
	public TileColor getTileColor(){
		return color;
	}
	public final void drawTile( Graphics g, TileOrientation orientation ) {
		symbol.drawSymbolAndShapes( g, orientation );
		color.paintColors( g, orientation );
		// draw tile border
		
	}
	
	private TileSymbol symbol;
	private TileColor color;
	private ImageIcon i;
}
