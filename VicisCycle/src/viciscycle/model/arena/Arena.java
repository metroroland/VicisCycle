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
 * Class Representing Stage along with Respective Backup,
 * as well as Player Racks along with Respective Backups
 * @author Kineslight
 */
public final class Arena implements Cloneable {
	
	public enum ArenaType {
		
		STAGE( 256 ),
		RACK( 32 );
		
		public final int getSize() {
			return size;
		}
		
		private ArenaType( int arenaSize ) {
			size = arenaSize;
		}
		
		private final int size;
	}
	
	public enum ArenaState {
		
		CURRENT,
		REPLICA;
	}
	
	public Arena( ArenaType arenaType ) {
		
		type = arenaType;
		arena = new ArrayList<Tile>( arenaType.getSize() );
	}
	public void appendTile(Tile tl){
		arena.add(tl);
	}
	public Tile getTile(int i){
		return arena.get(i);
	}
	public Tile removeTile(int i){
		return arena.remove(i);
	}
	public int getSize(){
		return arena.size();
	}
	@Override
	public Arena clone() {
		
		// call Object.clone()
		Arena clone = null;
		try {
			clone = (Arena) super.clone();
		}
		catch ( CloneNotSupportedException e ) {
			// would not actually happen
			return null;
		}
		
		// clone arena-specific data
		clone.type = type;
		clone.arena = new ArrayList<Tile>( type.getSize() );
		for ( Tile tile : arena ) {
			clone.arena.add( tile );
		}
		
		return clone;
	}
	
	public void clear() {
		
		arena.clear();
	}
	
	private ArenaType type;
	private ArrayList<Tile> arena;
}
