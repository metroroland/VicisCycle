/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.model.tile;

/**
 * Enumeration of Tile Orientation
 * @author Kineslight
 */
public enum TileOrientation {

	UPRIGHT,
	SIDEWAYS;
	
	public final TileOrientation getNextTileOrientation() {
		return TileOrientation.values()[ ( this.ordinal() + 1 ) % TileOrientation.values().length ];
	}
}
