/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.model.tile;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 * Prototype for Each Unique Tile
 * @author Kineslight
 */
public class TilePrototype {
	
	public TilePrototype( TileSymbol tileSymbol, TileColor tileColor ) {
		symbol = tileSymbol;
		color = tileColor;
		//this.
	
		
	}
	
	public ImageIcon getImageIcon(){
		return new ImageIcon();
	}
	public TileSymbol getTileSymbol(){
		return symbol;
	}
	public TileColor getTileColor(){
		return color;
	}
	
	public final void drawTile( Graphics2D g, TileOrientation orientation ) {
		symbol.drawSymbolAndShapes( g, orientation );
		color.paintColors( g, orientation );
		// draw tile border
		
	}
	
	private TileSymbol symbol;
	private TileColor color;
	
}
