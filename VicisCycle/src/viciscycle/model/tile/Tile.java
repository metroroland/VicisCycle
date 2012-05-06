/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.model.tile;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 * Actual Instance of a Tile
 * @author Kineslight
 */
public class Tile extends ImageIcon {
	
	public Tile( TilePrototype tilePrototype, TileOrientation tileOrientation ) {
		prototype = tilePrototype;
		orientation = tileOrientation;
		 Image image = Toolkit.getDefaultToolkit().getImage("src/viciscycle/graphics/"+TileSymbol.values()[  prototype.getTileSymbol().ordinal()]+".png");
		this.setImage(image);
		 shape2 = new Rectangle2D.Double(0, 0, 98, 98);
	}
	
	@Override
	public void paintIcon(Component c,Graphics g,int x,int y){
		Graphics2D g2d = (Graphics2D)g;
		
		
		//code to migrate
		BufferedImage image = new BufferedImage(98, 98, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gImage = image.createGraphics();
		
		
		gImage.setPaint(new GradientPaint(49, 49, Color.RED, 0, 0, Color.WHITE));
		gImage.fill(shape2);
		gImage.drawImage(this.getImage(),0,0,null);
		AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.DST_ATOP, 1f);
		gImage.setComposite(composite);
		
		if (this.orientation == TileOrientation.SIDEWAYS){
		g2d.rotate(Math.PI/2);
		g2d.drawImage(this.getImage(), 0, -98, c);
		}else{
			
		//	AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
			//this.getImage().setComposite(composite);
			prototype.drawTile(g, orientation);
			g2d.drawImage(image, 0, 0, c);
			
			
		}
	}
	public TilePrototype getTilePrototype(){
		return prototype;
	}
	private final TilePrototype prototype;
	private final TileOrientation orientation;
	private Shape shape2;
	
}
