/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.model.tile;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Actual Instance of a Tile
 * @author Kineslight
 */
public class Tile implements Icon{
	
	public Tile( TilePrototype tilePrototype, TileOrientation tileOrientation ) {
		prototype = tilePrototype;
		orientation = tileOrientation;
<<<<<<< HEAD
		 this.tileImage = Toolkit.getDefaultToolkit().getImage("src/viciscycle/graphics/"+TileSymbol.values()[  prototype.getTileSymbol().ordinal()]+".png");
		
		 shape2 = new Rectangle2D.Double(0, 0, 90, 70);
		 shape1 = new Rectangle2D.Double(0, 70, 90, 20);
		 border = new Rectangle2D.Double(0, 0, 90, 90);
	}

	@Override
	public int getIconHeight() {
		return tileImage.getHeight(null);
=======
		 Image image = Toolkit.getDefaultToolkit().getImage("src/viciscycle/graphics/"+TileSymbol.values()[  prototype.getTileSymbol().ordinal()]+".png");
		this.setImage(image);
		 shape2 = new Rectangle2D.Double(0, 0, 98, 78);
		 shape1 = new Rectangle2D.Double(0, 78, 98, 20);
		 border = new Rectangle2D.Double(0, 0, 98, 97);
>>>>>>> 341ced63d03444a6c786546caaf1075458b50dd2
	}

	@Override
	public int getIconWidth() {
		return tileImage.getWidth(null);
	}
	
	
	@Override
	public void paintIcon(Component c,Graphics g,int x,int y){
		Graphics2D g2d = (Graphics2D)g;
		
		
		//code to migrate
		BufferedImage image = new BufferedImage(92, 92, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gImage = image.createGraphics();
		gImage.rotate(-Math.PI/2);
		gImage.translate(-92,0 );
		//draw background
		/*Point2D center =new Point2D.Float(48, 48);
		 * float radius = 76;
		 * float dist[] = {0.4f,1.0f};
		 * Color colors[] = {Color.RED,Color.WHITE};*/
		gImage.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gImage.setPaint(new GradientPaint(0,0,Color.WHITE, 34, 34, Color.RED));
		gImage.fill(shape2);
		//Color colors2[] = {Color.ORANGE,Color.WHITE};
		gImage.setPaint(new GradientPaint(0,0,Color.WHITE, 34, 34, Color.ORANGE));
		gImage.fill(shape1);
		gImage.setStroke(new BasicStroke(1));
		gImage.setPaint( Color.BLACK);
		gImage.draw(border);
		gImage.drawImage(tileImage,0,0,null);
		
		
		//draw shape
		AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.3f);
		gImage.setComposite(composite);
		Ellipse2D e = new Ellipse2D.Double(-10, 35, 20, 20);
		gImage.setStroke(new BasicStroke(2));
		gImage.draw(e);
		Rectangle2D r = new Rectangle2D.Double(80, 35, 20, 20);
		gImage.draw(r);
		
		composite = AlphaComposite.getInstance(AlphaComposite.DST_ATOP, 1f);
		gImage.setComposite(composite);
		if (this.orientation == TileOrientation.SIDEWAYS){
			g2d.rotate(Math.PI/2);
			g2d.drawImage(tileImage, 0, -90, c);
		}else{
			
		//	AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
			//this.getImage().setComposite(composite);
			prototype.drawTile(g2d);
			
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
	private Shape border;
	private Image tileImage;
}
