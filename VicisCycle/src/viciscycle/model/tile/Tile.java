/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.model.tile;

import java.awt.*;
import java.awt.geom.Point2D;
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
		 shape2 = new Rectangle2D.Double(0, 0, 78, 98);
		 shape1 = new Rectangle2D.Double(78, 0, 20, 98);
	}
	
	@Override
	public void paintIcon(Component c,Graphics g,int x,int y){
		Graphics2D g2d = (Graphics2D)g;
		
		
		//code to migrate
		BufferedImage image = new BufferedImage(98, 98, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gImage = image.createGraphics();
		
		//draw background
		Point2D center =new Point2D.Float(48, 48);
		float radius = 76;
		float dist[] = {0.4f,1.0f};
		Color colors[] = {Color.RED,Color.WHITE};
		gImage.setPaint(new RadialGradientPaint(center, radius, dist, colors));
		gImage.fill(shape2);
		Color colors2[] = {Color.ORANGE,Color.WHITE};
		gImage.setPaint(new RadialGradientPaint(center, radius, dist, colors2));
		gImage.fill(shape1);
		gImage.drawImage(this.getImage(),0,0,null);
		AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.DST_ATOP, 1f);
		gImage.setComposite(composite);
		
		//draw shape
		
		
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
	private Shape shape1;
}
