/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.model.tile;

import java.util.Random;

/**
 * Tile Set for Actual Game Play
 * @author Kineslight
 */
public class TileGameSet {
	
	public TileGameSet( int numberOfPlayers ) {
		
		// determine the total number of tiles, in terms of the number of base sets to use
		final int numberOfBaseSets = ( numberOfPlayers <= 4 ? 2 : ( numberOfPlayers <= 6 ? 3 : 4 ) );
		
		// create the tiles
		tiles = new Tile[ ( TileSymbol.values().length * TileColor.values().length + 1 /* wildcard */ ) * numberOfBaseSets ];
		int currentTilePos = 0;
		for ( TileSymbol symbol : TileSymbol.values() ) {
			for ( TileColor color : TileColor.values() ) {
				final TilePrototype prototype = TileBaseSet.getTilePrototype( symbol, color );
				for ( int i = 0; i < numberOfBaseSets; ++i ) {
					tiles[ currentTilePos++ ] = new Tile( prototype, TileOrientation.UPRIGHT );
				}
			}
		}
		
		// create wildcard tiles
		for ( int i = 0; i < numberOfBaseSets; ++i ) {
			tiles[ currentTilePos++ ] = new Tile( TileBaseSet.getTilePrototype( null, null ), TileOrientation.UPRIGHT );
		}
		
		// shuffle the tiles
		final Random randomizer = new Random();
		currentTilePos = 0;
		while ( currentTilePos < tiles.length - 1 ) {
			final int targetTilePos = currentTilePos + randomizer.nextInt( tiles.length - currentTilePos );
			// swap the tiles at the current and target positions
			final Tile tempTile = tiles[ currentTilePos ];
			tiles[ currentTilePos++ ] = tiles[ targetTilePos ];
			tiles[ targetTilePos ] = tempTile;
		}
		
		// set the next tile to deal to be the last tile
		nextTilePos = tiles.length - 1;
	}
	
	public boolean hasNextTile() {
		return ( nextTilePos >= 0 );
	}

	public Tile getNextTile() {
		return ( hasNextTile() ? tiles[ nextTilePos-- ] : null );
	}
	
	private Tile[] tiles;
	private int nextTilePos;
}
