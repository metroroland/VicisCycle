/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.model.tile;

import java.util.EnumMap;

/**
 * Enumeration of Tile Orientation
 * @author Kineslight
 */
public enum TileOrientation {

	UPRIGHT,
	SIDEWAYS;
	
	public final TileOrientation getNextTileOrientation() {
		return nextTileOrientations.get( this );
	}
	
	private static final EnumMap<TileOrientation, TileOrientation> nextTileOrientations;
	
	static {
		nextTileOrientations = new EnumMap<TileOrientation, TileOrientation>( TileOrientation.class );
		for ( TileOrientation tileOrientation : TileOrientation.values()  ) {
			final TileOrientation nextTileOrientation = TileOrientation.values()[ ( tileOrientation.ordinal() + 1 ) % TileOrientation.values().length ];
			nextTileOrientations.put( tileOrientation, nextTileOrientation );
		}
	}
}
