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
	
	public static void resetAllPlayers() {

		PLAYER_1.setName( null );
		PLAYER_1.setSocket( null );

		PLAYER_2.setName( null );
		PLAYER_2.setSocket( null );

		PLAYER_3.setName( null );
		PLAYER_3.setSocket( null );

		PLAYER_4.setName( null );
		PLAYER_4.setSocket( null );

		PLAYER_5.setName( null );
		PLAYER_5.setSocket( null );

		PLAYER_6.setName( null );
		PLAYER_6.setSocket( null );

		PLAYER_7.setName( null );
		PLAYER_7.setSocket( null );

		PLAYER_8.setName( null );
		PLAYER_8.setSocket( null );
	}
	
	private String name = null;
	private Socket socket = null;
}
