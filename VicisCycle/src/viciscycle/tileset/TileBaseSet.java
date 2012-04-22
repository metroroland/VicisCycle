/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.tileset;

import java.util.EnumMap;

/**
 * Look-Up Table for the Base Set of Unique Tiles
 * @author Kineslight
 */
public class TileBaseSet {
	
	public static TilePrototype getTilePrototype( TileSymbol tileSymbol, TileColor tileColor ) {
		return prototypes.get( tileSymbol ).get( tileColor );
	}
	
	private static final EnumMap<TileSymbol, EnumMap<TileColor, TilePrototype>> prototypes;
	
	static {
		prototypes = new EnumMap<TileSymbol, EnumMap<TileColor, TilePrototype>>( TileSymbol.class );
		for ( TileSymbol symbol : TileSymbol.values() ) {
			prototypes.put( symbol, new EnumMap<TileColor, TilePrototype>( TileColor.class ) );
			for ( TileColor color : TileColor.values() ) {
				prototypes.get( symbol ).put( color, new TilePrototype( symbol, color ) );
			}
		}
	}
}
