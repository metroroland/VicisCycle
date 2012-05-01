/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.model.tile;

import java.awt.Graphics;

/**
 * Prototype for Each Unique Tile
 * @author Kineslight
 */
public class TilePrototype {
	
	TilePrototype( TileSymbol tileSymbol, TileColor tileColor ) {
		symbol = tileSymbol;
		color = tileColor;
	}
	
	public final void drawTile( Graphics g, TileOrientation orientation ) {
		symbol.drawSymbolAndShapes( g, orientation );
		color.paintColors( g, orientation );
		// draw tile border
		
	}
	
	private TileSymbol symbol;
	private TileColor color;
}
