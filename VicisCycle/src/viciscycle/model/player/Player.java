/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.model.player;

import java.net.Socket;

/**
 * Enumeration of All Players
 * @author Kineslight
 */
public enum Player {
	
	PLAYER_1,
	PLAYER_2,
	PLAYER_3,
	PLAYER_4,
	PLAYER_5,
	PLAYER_6,
	PLAYER_7,
	PLAYER_8;
	
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
	
	@Override
	public String toString() {
		return super.toString() + "[ " + name + ", " + socket.getInetAddress() + ":" + socket.getPort() + " ]";
	}
	
	public final void reset() {
		setName( null );
		setSocket( null );
	}
	
	public static void resetAllPlayers() {
		for ( Player player : Player.values() ) {
			player.reset();
		}
	}
	
	private String name = null;
	private Socket socket = null;
}
