/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.tileset;

/**
 * Actual Instance of a Tile
 * @author Kineslight
 */
public class Tile {
	
	Tile( TilePrototype tilePrototype, TileOrientation tileOrientation ) {
		prototype = tilePrototype;
		orientation = tileOrientation;
	}
	
	private final TilePrototype prototype;
	private final TileOrientation orientation;
}
