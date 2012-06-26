/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.model.tile;

import java.awt.*;
import java.util.EnumMap;
import java.awt.geom.Rectangle2D;

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
	VIOLET( new Color( 128, 0,128 ) ),
	WILDCARD(new Color (130,255,239)),
	EMPTY(new Color(255,255,255));
	
	private TileColor( Color tileColor ) {
		color = tileColor;
	}
	
	public final TileColor getPreviousTileColor() {
		return previousTileColors.get( this );
	}
	
	public final TileColor getNextTileColor() {
		return nextTileColors.get( this );
	}
	public final TileColor getTileColor(){
		return this;
	}
	public final void paintColors( Graphics2D g) {
		// paint the center and margin colors
		shape2 = new Rectangle2D.Double(0, 0, 90, 70);
		shape1 = new Rectangle2D.Double(0, 70, 90, 20);
		
		g.setPaint(new GradientPaint(0,0,Color.WHITE, 34, 34, this.color));
		g.fill(shape2);
		//Color colors2[] = {Color.ORANGE,Color.WHITE};
		g.setPaint(new GradientPaint(0,0,Color.WHITE, 34, 34, this.getNextTileColor().color));
		g.fill(shape1);
		// g.setPaint(new GradientPaint(49, 49, color, 0, 0, Color.WHITE));
		// g.drawImage(, null, 0, 0);
	}
	
	private final Color color;
	private Shape shape2;
	private Shape shape1;
	public final static int ReservedSymbol = 2;
	
	private static final EnumMap<TileColor, TileColor> previousTileColors;
	private static final EnumMap<TileColor, TileColor> nextTileColors;
	
	static {
		// precalculate tile color order mapping
		previousTileColors = new EnumMap<TileColor, TileColor>( TileColor.class );
		for ( TileColor tileColor : TileColor.values() ) {
			final TileColor previousTileColor;
			if(tileColor==TileColor.values()[TileColor.values().length-1]||
					tileColor == TileColor.values()[TileColor.values().length-ReservedSymbol])	{
				previousTileColor = tileColor;
			}else{
				previousTileColor = TileColor.values()[ ( tileColor.ordinal() + TileColor.values().length - 1 ) %( TileColor.values().length-ReservedSymbol) ];
			}
			previousTileColors.put( tileColor, previousTileColor );
		}
		
		nextTileColors = new EnumMap<TileColor, TileColor>( TileColor.class );
		for ( TileColor tileColor : TileColor.values() ) {
			final TileColor nextTileColor;
			if(tileColor==TileColor.values()[TileColor.values().length-1]||
					tileColor == TileColor.values()[TileColor.values().length-ReservedSymbol])	{
				nextTileColor = tileColor;
			}else{
				nextTileColor = TileColor.values()[ ( tileColor.ordinal() + 1 ) %( TileColor.values().length-ReservedSymbol) ];
			}
			nextTileColors.put( tileColor, nextTileColor );
		}
	}
}
