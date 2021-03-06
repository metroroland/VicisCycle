/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.model.tile;

import java.util.EnumMap;

/**
 * Look-Up Table for the Base Set of Unique Tiles
 * @author Kineslight
 */
public class TileBaseSet {
	
	public static TilePrototype getTilePrototype( TileSymbol tileSymbol, TileColor tileColor ) {
		return ( tileSymbol == null && tileColor == null ? wildcard : prototypes.get( tileSymbol ).get( tileColor ) );
	}
	
	private static final EnumMap<TileSymbol, EnumMap<TileColor, TilePrototype>> prototypes;
	
	private static final TilePrototype wildcard = new TilePrototype( null, null );
	
	static {
		// enumerate all combinations of tile symbols and tile colors
		prototypes = new EnumMap<TileSymbol, EnumMap<TileColor, TilePrototype>>( TileSymbol.class );
		for ( TileSymbol symbol : TileSymbol.values() ) {
			prototypes.put( symbol, new EnumMap<TileColor, TilePrototype>( TileColor.class ) );
			for ( TileColor color : TileColor.values() ) {
				prototypes.get( symbol ).put( color, new TilePrototype( symbol, color ) );
			}
		}
	}
}
