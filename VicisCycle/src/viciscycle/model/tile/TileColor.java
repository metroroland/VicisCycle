/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.model.tile;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
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
		return TileColor.values()[ ( this.ordinal() + TileColor.values().length - 1 ) % TileColor.values().length ];
	}
	
	public final TileColor getNextTileColor() {
		return TileColor.values()[ ( this.ordinal() + 1 ) % TileColor.values().length ];
	}
	
	public final void paintColors( Graphics g, TileOrientation orientation ) {
		// paint the center and margin colors
		Graphics2D g2d = (Graphics2D)g;
		//g2d.setPaint(new GradientPaint(49, 49, color, 0, 0, Color.WHITE));
		//g2d.drawImage(, null, 0, 0);
	}
	
	private final Color color;
}
