/*
 * VicisCycle 2012
 * Released under GNU GPL License
 */
package viciscycle.tileset;

import java.awt.*;			// for Image, Graphics
import java.io.*;			// for File
import javax.imageio.*;		// for ImageIO

/**
 * Enumeration of Tile Symbols
 * @author Kineslight
 */
public enum TileSymbol {
	
	SUN( "Sun.gif" ) {
		@Override public final void drawSymbol( Graphics g, TileOrientation orientation ) {
			// draw the symbol of Sun
		}
	},
	MOON( "Moon.gif" ) {
		@Override public final void drawSymbol( Graphics g, TileOrientation orientation ) {
			// draw the symbol of Moon
		}
	},
	MARS( "Mars.gif" ) {
		@Override public final void drawSymbol( Graphics g, TileOrientation orientation ) {
			// draw the symbol of Mars
		}
	},
	MERCURY( "Mercury.gif" ) {
		@Override public final void drawSymbol( Graphics g, TileOrientation orientation ) {
			// draw the symbol of Mercury
		}
	},
	JUPITER( "Jupiter.gif" ) {
		@Override public final void drawSymbol( Graphics g, TileOrientation orientation ) {
			// draw the symbol of Jupiter
		}
	},
	VENUS( "Venus.gif" ) {
		@Override public final void drawSymbol( Graphics g, TileOrientation orientation ) {
			// draw the symbol of Venus
		}
	},
	SATURN( "Saturn.gif" ) {
		@Override public final void drawSymbol( Graphics g, TileOrientation orientation ) {
			// draw the symbol of Saturn
		}
	};
	
	private TileSymbol( String imageFileName ) {
		Image image = null;
		try {
			image = ImageIO.read( new File( imageFileName ) );;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		symbol = image;
	}
	
	public abstract void drawSymbol( Graphics g, TileOrientation orientation );
		
	private final Image symbol;
}
