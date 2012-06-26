/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.model.tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.Icon;

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
	public void paintIcon(Component c,Graphics g,int x,int y) {
		Graphics2D g2d = (Graphics2D)g;
		
		
		//code to migrate
		BufferedImage image = new BufferedImage(91, 90, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gImage = image.createGraphics();
		gImage.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//draw background
		/*Point2D center =new Point2D.Float(48, 48);
		 * float radius = 76;
		 * float dist[] = {0.4f,1.0f};
		 * Color colors[] = {Color.RED,Color.WHITE};*/
	
		
		if (this.orientation == TileOrientation.SIDEWAYS){
			gImage.rotate(-90*Math.PI/180);
			gImage.translate(-90,0 );
		}
		prototype.drawTile(gImage,this.orientation);
		gImage.drawImage(tileImage,0,0,null);
		g2d.drawImage(image, 0, 0, c);
		
	}
	
	public TilePrototype getTilePrototype() {
		return prototype;
	}
	
	public final void rotateTile() {
		
		orientation = orientation.getNextTileOrientation();
		
	}
	public void setPosition(TilePosition tp){
		this.position = tp;
	}
	public TilePosition getPosition(){
		return this.position;
	}
	public TileOrientation getOrientation(){
		return this.orientation;
	}
	public void setHighlight(boolean b){
		this.highlight = b;
	}
	public boolean isHigtlight(){
		return  this.highlight;
	}
	public enum TilePosition{
		FRONT,IN_BETWEEN,BACK
	}
	private final TilePrototype prototype;
	private TileOrientation orientation;
	private Image tileImage;
	private TilePosition position;
	private boolean highlight;
}
