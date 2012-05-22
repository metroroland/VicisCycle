/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.model;

import viciscycle.model.player.Player;
import viciscycle.model.arena.Arena;
import viciscycle.model.arena.Arena.ArenaType;
import viciscycle.model.arena.Arena.ArenaState;
import viciscycle.model.tile.TileGameSet;

import java.util.ArrayList;
import java.util.EnumMap;


/**
 * Complete Model of the Game
 * @author Kineslight
 */
public class GameModel {

	public GameModel( ArrayList<Player> listOfPlayers ) {
		
		final int playerCount = ( listOfPlayers.size() <= 8 ? listOfPlayers.size() : 8 );
		players = new Player[ playerCount ];
		for ( int i = 0; i < playerCount ; ++i ) {
			players[ i ] = listOfPlayers.get( i );
		}
		
		stages = new EnumMap<ArenaState, Arena>( ArenaState.class );
		stages.put( ArenaState.CURRENT, new Arena( ArenaType.STAGE ));
		stages.put( ArenaState.REPLICA, new Arena( ArenaType.STAGE ));
		
	}
	
	public final Arena getStage( ArenaState state ) {
		
		return stages.get( state );
	}
	
	private final Player[] players;
	private final EnumMap<ArenaState, Arena> stages;
}
