/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.model.tile;

import java.util.EnumMap;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;

/**
 * Enumeration of Tile Colors
 * @author Kineslight
 */
public enum TileColor {

	RED( Color.red ),
	ORANGE( Color.orange ),
	YELLOW( Color.yellow ),
	GREEN( Color.green ),
	BLUE( Color.blue ),
	INDIGO( new Color( 75, 0, 130 ) ),
	VIOLET( new Color( 128, 0,128 ) );
	
	private TileColor( Color tileColor ) {
		color = tileColor;
	}
	
	public final TileColor getPreviousTileColor() {
		return previousTileColors.get( this );
	}
	
	public final TileColor getNextTileColor() {
		return nextTileColors.get( this );
	}
	
	public final void paintColors( Graphics2D g, TileOrientation orientation ) {
		// paint the center and margin colors
		// g.setPaint(new GradientPaint(49, 49, color, 0, 0, Color.WHITE));
		// g.drawImage(, null, 0, 0);
	}
	
	private final Color color;
	
	private static final EnumMap<TileColor, TileColor> previousTileColors;
	private static final EnumMap<TileColor, TileColor> nextTileColors;
	
	static {
		// precalculate tile color order mapping
		previousTileColors = new EnumMap<TileColor, TileColor>( TileColor.class );
		for ( TileColor tileColor : TileColor.values() ) {
			final TileColor previousTileColor = TileColor.values()[ ( tileColor.ordinal() + TileColor.values().length - 1 ) % TileColor.values().length ];
			previousTileColors.put( tileColor, previousTileColor );
		}

		nextTileColors = new EnumMap<TileColor, TileColor>( TileColor.class );
		for ( TileColor tileColor : TileColor.values() ) {
			final TileColor nextTileColor = TileColor.values()[ ( tileColor.ordinal() + 1 ) % TileColor.values().length ];
			nextTileColors.put( tileColor, nextTileColor );
		}
	}
}
