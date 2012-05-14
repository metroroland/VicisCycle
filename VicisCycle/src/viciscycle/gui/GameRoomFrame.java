/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.gui;

import viciscycle.model.tile.Tile;
import viciscycle.model.tile.TileSymbol;
import viciscycle.model.tile.TileColor;
import viciscycle.model.tile.TileOrientation;
import viciscycle.model.tile.TileBaseSet;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.GroupLayout;


/**
 *
 * @author roland
 */
public class GameRoomFrame extends JInternalFrame {
	
	public GameRoomFrame(){
		super( Resource.getString( "viciscycle.gui.gameTitle" ) + " - " + Resource.getString( "viciscycle.gui.gameRoom" ),
				false, false, false, false);
		setBounds(0, 0, 1060, 700);
		setLocation((800 - 330) / 2, (600 - 310) / 2);
		JPanel gp = new JPanel();
		gp.setSize(1060, 600);

		/**control code**/

		stage = new JList<>();
		 model = new DefaultListModel();

		Tile data = new Tile( TileBaseSet.getTilePrototype( TileSymbol.SUN, TileColor.RED ), TileOrientation.UPRIGHT );
		Tile data2 = new Tile( TileBaseSet.getTilePrototype( TileSymbol.MERCURY, TileColor.ORANGE), TileOrientation.UPRIGHT );
		Tile data3 = new Tile( TileBaseSet.getTilePrototype( TileSymbol.MOON, TileColor.YELLOW), TileOrientation.UPRIGHT );
		Tile data4 = new Tile( TileBaseSet.getTilePrototype( TileSymbol.SATURN, TileColor.GREEN),TileOrientation.UPRIGHT );
		Tile data5 = new Tile( TileBaseSet.getTilePrototype( TileSymbol.JUPITER, TileColor.BLUE), TileOrientation.UPRIGHT );
		Tile data6 = new Tile( TileBaseSet.getTilePrototype( TileSymbol.MARS, TileColor.INDIGO), TileOrientation.UPRIGHT );
		Tile data7 = new Tile( TileBaseSet.getTilePrototype( TileSymbol.VENUS, TileColor.VIOLET), TileOrientation.UPRIGHT );
		
		Tile[] dataIcons = {data,data2};
		
		
		for(int i= 0; i<4;i++){
			model.addElement(dataIcons[1]);
			model.addElement(dataIcons[0]);
			model.addElement(data3);
			model.addElement(data2);
			model.addElement(data4);
			model.addElement(data5);
			model.addElement(data6);
			model.addElement(data7);
			model.addElement( new Tile( TileBaseSet.getTilePrototype( TileSymbol.MERCURY, TileColor.RED), TileOrientation.UPRIGHT ));
		}
		
		
		
		
		stage.setModel(model);
		stage.setVisibleRowCount(0);
		stage.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		stage.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		stage.setDragEnabled(true);

		stage.setFixedCellHeight(94);
 	    stage.setFixedCellWidth(94);
		stage.addMouseListener(new MouseListener() {

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
							Tile t = (Tile)model.getElementAt(stage.locationToIndex(e.getPoint()));
							t.rotateTile();
							stage.repaint();
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
		
		JList<Tile> rack = new JList<Tile>();
		rack.setModel(model);
		rack.setVisibleRowCount(0);
		rack.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		rack.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		rack.setDragEnabled(true);
		
		
		//stage.setSize(816, 340);
		//rack.setSize(1016,180);
		JScrollPane rackScrollPane = new JScrollPane(rack);
		JScrollPane stageScrollPane= new JScrollPane(stage);
		//rackScrollPane.setSize(1016, 180);
				
		JLabel tileLeftJLabel = new JLabel( Resource.getString( "viciscycle.gui.tilesRemaining" ) + " : ");
		
		drawTileButton = new JButton( Resource.getString( "viciscycle.gui.drawTile" ) );
		confirmMovesButton = new JButton( Resource.getString( "viciscycle.gui.confirmMoves" ) );
		revertMovesButton = new JButton( Resource.getString( "viciscycle.gui.revertMoves" ) );
		abandonGameButton = new JButton( Resource.getString( "viciscycle.gui.abandonGame" ) );
		
		Font font = Resource.getFont( Font.PLAIN, 18 );
		setFont( font );
		revertMovesButton.setFont( font );
		drawTileButton.setFont( font );
		confirmMovesButton.setFont( font );
		abandonGameButton.setFont( font );
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.CENTER)
					.addComponent(stageScrollPane,GroupLayout.Alignment.LEADING, 800, 800, 800)
					.addGroup(layout.createSequentialGroup()
						.addComponent(tileLeftJLabel)
						.addComponent(drawTileButton)
						.addComponent(confirmMovesButton)
						.addComponent(revertMovesButton)
						.addComponent(abandonGameButton)
						.addGap(10,10,10)
					).addComponent(rackScrollPane)
				);
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addComponent(stageScrollPane,340,340,340)
					.addGap(10,10,10)
					.addGroup(layout.createParallelGroup()
						.addComponent(tileLeftJLabel,GroupLayout.Alignment.LEADING)
						.addComponent(drawTileButton)
						.addComponent(confirmMovesButton)
						.addComponent(revertMovesButton)
						.addComponent(abandonGameButton))
					.addGap(10,10,10)
					.addComponent(rackScrollPane)
					.addGap(10,10,10)
				);
		

	}
	
	private JButton drawTileButton;
	private JButton confirmMovesButton;
	private JButton revertMovesButton;
	private JButton abandonGameButton;
	private JList<ImageIcon> stage;
	private DefaultListModel model;
}
