/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.model.player;

import viciscycle.model.arena.Arena;
import viciscycle.model.arena.Arena.ArenaType;
import viciscycle.model.arena.Arena.ArenaState;

import java.net.Socket;
import java.util.ArrayList;
import java.util.EnumMap;


/**
 * Class Representing Each Player
 * @author Kineslight
 */
public final class Player {
	
	public Player() {
		
		racks = new EnumMap<ArenaState, Arena>( ArenaState.class );
		racks.put( ArenaState.CURRENT, new Arena( ArenaType.RACK ));
		racks.put( ArenaState.REPLICA, new Arena( ArenaType.RACK ));
	}
	
	public final String getName() {
		
		return name;
	}
	
	public final void setName( String playerName ) {
		
		name = playerName;
	}
	
	public final Socket getSocket() {
		
		return socket;
	}
	
	public final void setSocket( Socket playerSocket ) {
		
		socket = playerSocket;
	}
	
	public final int getScore( int gameRound ) {
		
		if ( gameRound >= 0 && gameRound < scores.size() ) {
			return scores.get( gameRound );
		}
		else {
			// indicates invalid game round supplied
			return -Integer.MIN_VALUE;
		}
	}
	
	public final void addScore( int playerScore ) {
		
		// always append to the end of the score list
		scores.add( playerScore );
	}
	
	public final void clearScores() {
		
		scores.clear();
	}
	
	public final Arena getRack( ArenaState state ) {
		
		return racks.get( state );
	}
	
	@Override
	public String toString() {
		
		return super.toString() + "[ " + name + ", " + socket.getInetAddress() + ":" + socket.getPort() + " ]";
	}
	
	private String name = null;
	private Socket socket = null;
	private final ArrayList<Integer> scores = new ArrayList<Integer>(16);
	private final EnumMap<ArenaState, Arena> racks;
}
