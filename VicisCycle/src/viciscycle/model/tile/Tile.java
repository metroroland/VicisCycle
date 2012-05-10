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
 * @author Kineslight/Roland
 */
public class Tile implements Icon {
	
	public Tile( TilePrototype tilePrototype, TileOrientation tileOrientation ) {
		prototype = tilePrototype;
		orientation = tileOrientation;

		tileImage = Toolkit.getDefaultToolkit().getImage("src/viciscycle/graphics/" + prototype.getTileSymbol() + ".png");

	}

	@Override
	public int getIconHeight() {
		return tileImage.getHeight(null);

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
		gImage.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//draw background
		/*Point2D center =new Point2D.Float(48, 48);
		 * float radius = 76;
		 * float dist[] = {0.4f,1.0f};
		 * Color colors[] = {Color.RED,Color.WHITE};*/
	
		
		if (this.orientation == TileOrientation.SIDEWAYS){
			gImage.rotate(-Math.PI/2);
			gImage.translate(-92,0 );
		}
		prototype.drawTile(gImage);
		gImage.drawImage(tileImage,0,0,null);
		g2d.drawImage(image, 0, 0, c);
		
	}
	public TilePrototype getTilePrototype(){
		return prototype;
	}
	private final TilePrototype prototype;
	private final TileOrientation orientation;

	private Image tileImage;
}
