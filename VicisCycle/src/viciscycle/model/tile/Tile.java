/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.model.tile;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 * Actual Instance of a Tile
 * @author Kineslight
 */
public class Tile  {
	
	public Tile( TilePrototype tilePrototype, TileOrientation tileOrientation ) {
		prototype = tilePrototype;
		orientation = tileOrientation;
		 
	}
	
	
	public TilePrototype getTilePrototype(){
		return prototype;
	}
	private final TilePrototype prototype;
	private final TileOrientation orientation;
	
}
