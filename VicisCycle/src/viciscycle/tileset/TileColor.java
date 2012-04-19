/*
 * VicisCycle 2012
 * Released under GNU GPL License
 */
package viciscycle.tileset;

import java.awt.*;		// for Color

/**
 * Enumeration of Tile Colors
 * @author Kineslight
 */
public enum TileColor {
	RED( Color.red, Color.orange ),
	ORANGE( Color.orange, Color.yellow ),
	YELLOW( Color.yellow, Color.green ),
	GREEN( Color.green, Color.blue ),
	BLUE( Color.blue, new Color( 75, 0, 130 ) ),
	INDIGO( new Color( 75, 0, 130 ), new Color( 128, 0,128 ) ),
	VIOLET( new Color( 128, 0,128 ), Color.red );
	
	private TileColor( Color center, Color margin ) {
		centerColor = center;
		marginColor = margin;
	}
	
	public final void paintColors( Graphics g, TileOrientation orientation ) {
		// paint the center and margin colors
	}
	
	private final Color centerColor;
	private final Color marginColor;
}
