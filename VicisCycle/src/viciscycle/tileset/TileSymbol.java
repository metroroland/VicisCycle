/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.tileset;

import java.awt.Image;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Enumeration of Tile Symbols
 * @author Kineslight
 */
public enum TileSymbol {
	
	SUN( "Sun.gif", TileShape.CIRCLE ),
	MOON( "Moon.gif", TileShape.TRIANGLE ),
	MARS( "Mars.gif", TileShape.DIAMOND ),
	MERCURY( "Mercury.gif", TileShape.SQUARE ),
	JUPITER( "Jupiter.gif", TileShape.PENTAGON ),
	VENUS( "Venus.gif", TileShape.HEXAGON ),
	SATURN( "Saturn.gif", TileShape.OCTAGON );
	
	private TileSymbol( String imageFileName, TileShape tileShape ) {
		Image image = null;
		try {
			image = ImageIO.read( new File( imageFileName ) );;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		symbol = image;
		shape = tileShape;
	}
	
	public final TileSymbol getPreviousTileSymbol() {
		return TileSymbol.values()[ ( this.ordinal() + TileSymbol.values().length - 1 ) % TileSymbol.values().length ];
	}
	
	public final TileSymbol getNextTileSymbol() {
		return TileSymbol.values()[ ( this.ordinal() + 1 ) % TileSymbol.values().length ];
	}
	
	public final void drawSymbolAndShapes( Graphics g, TileOrientation orientation ) {
		// draw the central symbol image
		
		// draw the marginal shapes
		shape.drawShape( g, orientation, TileMargin.LEFT );
		this.getNextTileSymbol().shape.drawShape( g, orientation, TileMargin.RIGHT );
	}
	
	private final Image symbol;
	private final TileShape shape;
	
	private enum TileShape {

		CIRCLE {
			@Override public void drawShape( Graphics g, TileOrientation orientation, TileMargin margin ) {
				// draw circle
			}
		},
		TRIANGLE {
			@Override public void drawShape( Graphics g, TileOrientation orientation, TileMargin margin ) {
				// draw triangle
			}
		},
		DIAMOND {
			@Override public void drawShape( Graphics g, TileOrientation orientation, TileMargin margin ) {
				// draw diamond
			}
		},
		SQUARE {
			@Override public void drawShape( Graphics g, TileOrientation orientation, TileMargin margin ) {
				// draw square
			}
		},
		PENTAGON {
			@Override public void drawShape( Graphics g, TileOrientation orientation, TileMargin margin ) {
				// draw pentagon
			}
		},
		HEXAGON {
			@Override public void drawShape( Graphics g, TileOrientation orientation, TileMargin margin ) {
				// draw hexagon
			}
		},
		OCTAGON {
			@Override public void drawShape( Graphics g, TileOrientation orientation, TileMargin margin ) {
				// draw octagon
			}
		};
		
		public abstract void drawShape( Graphics g, TileOrientation orientation, TileMargin margin );
	}
	
	private enum TileMargin {
		LEFT,
		RIGHT;
	}
}
