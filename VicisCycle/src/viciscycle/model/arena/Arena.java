/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.model.arena;

import viciscycle.model.tile.Tile;
import viciscycle.model.player.Player;

import java.util.ArrayList;
import java.util.EnumMap;

/**
 * Arena for Stage, Stage Backup, and Player Racks
 * @author Kineslight
 */
public enum Arena {
	
	STAGE( 256 ),
	STAGE_BACKUP( 256 ),
	PLAYER_RACK_1( 32 ),
	PLAYER_RACK_2( 32 ),
	PLAYER_RACK_3( 32 ),
	PLAYER_RACK_4( 32 ),
	PLAYER_RACK_5( 32 ),
	PLAYER_RACK_6( 32 ),
	PLAYER_RACK_7( 32 ),
	PLAYER_RACK_8( 32 );
	
	public void clear() {
		arena.clear();
	}
	
	private Arena( int initialSize ) {
		arena = new ArrayList<Tile>( initialSize );
	}
	
	private final ArrayList<Tile> arena;
	
	public static Arena getPlayerRack( Player player ) {
		return playerRacks.get( player );
	}
	
	public static void resetAllArenas() {
		for ( Arena _arena : Arena.values() ) {
			_arena.clear();
		}
	}
			
	private static final EnumMap<Player, Arena> playerRacks;
	
	static {
		
		// create mapping between players and their respective player racks
		playerRacks = new EnumMap<Player, Arena>( Player.class );
		for ( Player player : Player.values() ) {
			final Arena rack = Arena.valueOf( player.toString().replace( "PLAYER", "PLAYER_RACK" ) );
			playerRacks.put( player, rack );
		}
	}
}
