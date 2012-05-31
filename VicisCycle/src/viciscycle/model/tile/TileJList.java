/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viciscycle.model.tile;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

/**
 *
 * @author P1Euser
 */
public class TileJList extends JList {
	DefaultListModel<Tile> tileList;
	public TileJList(DefaultListModel dlm){
		tileList = dlm;
		this.setModel(dlm);
		this.setVisibleRowCount(0);
		this.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		this.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.setDragEnabled(true);

		this.setDropMode(DropMode.INSERT);
		this.setTransferHandler(new TileTransferHandler());
		
		this.setFixedCellHeight(94);
		this.setFixedCellWidth(90);
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				switch (e.getButton()){
					case MouseEvent.BUTTON1:
						
						break;
					case MouseEvent.BUTTON3:
						try{
							Tile t = (Tile) tileList.getElementAt(locationToIndex(e.getPoint()));
							t.rotateTile();
							repaint();
						}catch(Exception ex){
							
						}					
						break;						
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
		});
	}
	/*@Override
	public Dimension getPreferredSize() {
 int maxX = 0;
 int maxY = 0;
 Component[] components = this.getComponents();
 for(int i = 0; i < components.length; i++){
   Rectangle bounds = components[i].getBounds();
   maxX = Math.max(maxX, (int)bounds.getMaxX());
   maxY = Math.max(maxY, (int)bounds.getMaxY());
 }	
return new Dimension(maxX,maxY);
}*/
}
