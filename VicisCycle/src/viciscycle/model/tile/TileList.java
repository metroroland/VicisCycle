/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viciscycle.model.tile;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

/**
 *
 * @author roland
 */
public class TileList extends JList {
	private DefaultListModel listModel ;
	public TileList(DefaultListModel dm){
		setModel(dm);
		listModel = dm;
		setVisibleRowCount(0);
		setLayoutOrientation(JList.HORIZONTAL_WRAP);
		setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		setDragEnabled(true);

		setDropMode(DropMode.INSERT);
		
		
		setFixedCellHeight(94);
		setFixedCellWidth(90);
		addMouseListener(new MouseListener() {

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
							Tile t = (Tile) listModel.getElementAt(locationToIndex(e.getPoint()));
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
}
