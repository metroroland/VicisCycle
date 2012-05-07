/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.model.tile;

import java.util.EnumMap;
import java.awt.Image;
import java.awt.Graphics2D;
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
			//e.printStackTrace();
		}
		symbol = image;
		shape = tileShape;
	}
	
	public final TileSymbol getPreviousTileSymbol() {
		return previousTileSymbols.get( this );
	}
	
	public final TileSymbol getNextTileSymbol() {
		return nextTileSymbols.get( this );
	}
	
	public final void drawSymbolAndShapes( Graphics2D g, TileOrientation orientation ) {
		// draw the central symbol image
		
		// draw the marginal shapes
		shape.drawShape( g, orientation, TileMargin.LEFT );
		this.getNextTileSymbol().shape.drawShape( g, orientation, TileMargin.RIGHT );
	}
	
	private final Image symbol;
	private final TileShape shape;
	
	private enum TileShape {

		CIRCLE {
			@Override public void drawShape( Graphics2D g, TileOrientation orientation, TileMargin margin ) {
				// draw circle
				
			}
		},
		TRIANGLE {
			@Override public void drawShape( Graphics2D g, TileOrientation orientation, TileMargin margin ) {
				// draw triangle
			}
		},
		DIAMOND {
			@Override public void drawShape( Graphics2D g, TileOrientation orientation, TileMargin margin ) {
				// draw diamond
			}
		},
		SQUARE {
			@Override public void drawShape( Graphics2D g, TileOrientation orientation, TileMargin margin ) {
				// draw square
			}
		},
		PENTAGON {
			@Override public void drawShape( Graphics2D g, TileOrientation orientation, TileMargin margin ) {
				// draw pentagon
			}
		},
		HEXAGON {
			@Override public void drawShape( Graphics2D g, TileOrientation orientation, TileMargin margin ) {
				// draw hexagon
			}
		},
		OCTAGON {
			@Override public void drawShape( Graphics2D g, TileOrientation orientation, TileMargin margin ) {
				// draw octagon
			}
		};
		
		public abstract void drawShape( Graphics2D g, TileOrientation orientation, TileMargin margin );
	}
	
	private enum TileMargin {
		LEFT,
		RIGHT;
	}
	
	private static final EnumMap<TileSymbol, TileSymbol> previousTileSymbols;
	private static final EnumMap<TileSymbol, TileSymbol> nextTileSymbols;
	
	static {
		// precalculate tile symbol order mapping
		previousTileSymbols = new EnumMap<TileSymbol, TileSymbol>( TileSymbol.class );
		for ( TileSymbol tileSymbol : TileSymbol.values() ) {
			final TileSymbol previousTileSymbol = TileSymbol.values()[ ( tileSymbol.ordinal() + TileSymbol.values().length - 1 ) % TileSymbol.values().length ];
			previousTileSymbols.put( tileSymbol, previousTileSymbol );
		}
		
		nextTileSymbols = new EnumMap<TileSymbol, TileSymbol>( TileSymbol.class );
		for ( TileSymbol tileSymbol : TileSymbol.values() ) {
			final TileSymbol nextTileSymbol = TileSymbol.values()[ ( tileSymbol.ordinal() + 1 ) % TileSymbol.values().length ];
			nextTileSymbols.put( tileSymbol, nextTileSymbol );
		}
	}
}
