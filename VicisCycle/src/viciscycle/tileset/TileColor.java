/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.tileset;

import java.awt.Color;
import java.awt.Graphics;

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
	
	public final TileColor getNextTileColor() {
		return TileColor.values()[ ( this.ordinal() + 1 ) % TileColor.values().length ];
	}
	
	public final void paintColors( Graphics g, TileOrientation orientation ) {
		// paint the center and margin colors
	}
	
	private final Color color;
}
