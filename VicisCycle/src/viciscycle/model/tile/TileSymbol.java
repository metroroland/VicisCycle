/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.model.tile;

import java.awt.*;
import java.util.EnumMap;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
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
	
	public final void drawSymbolAndShapes( Graphics2D g) {
		// draw the central symbol image
			//draw shape
		AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.3f);
		g.setComposite(composite);
		g.setPaint( Color.BLACK);
		g.setStroke(new BasicStroke(2));	
		
		// draw the marginal shapes
		shape.drawShape( g, TileMargin.LEFT );
		this.getNextTileSymbol().shape.drawShape( g, TileMargin.RIGHT );
		composite = AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1f);
		g.setComposite(composite);
	}
	
	private final Image symbol;
	private final TileShape shape;
	
	private enum TileShape {

		CIRCLE {
			@Override public void drawShape( Graphics2D g, TileMargin margin) {
				// draw circle
				int p =0;
				if(margin == TileMargin.RIGHT){
					p = 90;
				}
				Ellipse2D e = new Ellipse2D.Double(p-10, 35, 20, 20);
				g.draw(e);
			}
		},
		TRIANGLE {
			@Override public void drawShape( Graphics2D g, TileMargin margin) {
				// draw triangle
				int p =0;
				if(margin == TileMargin.RIGHT){
					p = 90;
				}
				GeneralPath r = new GeneralPath();
				r.moveTo(p, 35);
				r.lineTo(p-10, 55);
				r.lineTo(p+10, 55);
				r.lineTo(p, 35);
				g.draw(r);
			}
		},
		DIAMOND {
			@Override public void drawShape( Graphics2D g, TileMargin margin) {
				// draw diamond
				Rectangle2D r = new Rectangle2D.Double(80, 35, 20, 20);
				g.draw(r);
			}
		},
		SQUARE {
			@Override public void drawShape( Graphics2D g, TileMargin margin) {
				// draw square
				int p =0;
				if(margin == TileMargin.RIGHT){
					p = 90;
				}
				Rectangle2D r = new Rectangle2D.Double(p-10, 35, 20, 20);
				g.draw(r);
			}
		},
		PENTAGON {
			@Override public void drawShape( Graphics2D g, TileMargin margin) {
				// draw pentagon
			}
		},
		HEXAGON {
			@Override public void drawShape( Graphics2D g, TileMargin margin) {
				// draw hexagon
			}
		},
		OCTAGON {
			@Override public void drawShape( Graphics2D g, TileMargin margin) {
				// draw octagon
			}
		};
		
		public abstract void drawShape( Graphics2D g, TileMargin margin);
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
