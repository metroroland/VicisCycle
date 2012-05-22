/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.gui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.swing.*;
import viciscycle.model.tile.*;

/**
 *
 * @author roland
 */
public class GameRoomFrame extends JInternalFrame{
	public GameRoomFrame(){
		super("15", false, false, false, false);
		ResourceBundle currentRes = ResourceBundle.getBundle("viciscycle.translation.lang" /* ,Locale.CHINESE*/);
		
		setTitle(currentRes.getString("viciscycle.gui.gameTitle") + " - " + currentRes.getString("viciscycle.gui.gameRoom"));
		setBounds(0, 0, 1060, 700);
		setLocation((800 - 330) / 2, (600 - 310) / 2);
		JPanel gp = new JPanel();
		gp.setSize(1060, 600);

		/**control code**/

		stage = new JList<>();
		 stageModel = new DefaultListModel();
		 playerRackModel = new DefaultListModel();

		Tile data = new Tile( TileBaseSet.getTilePrototype( TileSymbol.SUN, TileColor.RED ), TileOrientation.UPRIGHT );
		Tile data2 = new Tile( TileBaseSet.getTilePrototype( TileSymbol.MERCURY, TileColor.ORANGE), TileOrientation.UPRIGHT );
		Tile data3 = new Tile( TileBaseSet.getTilePrototype( TileSymbol.MOON, TileColor.YELLOW), TileOrientation.UPRIGHT );
		Tile data4 = new Tile( TileBaseSet.getTilePrototype( TileSymbol.SATURN, TileColor.GREEN),TileOrientation.UPRIGHT );
		Tile data5 = new Tile( TileBaseSet.getTilePrototype( TileSymbol.JUPITER, TileColor.BLUE), TileOrientation.UPRIGHT );
		Tile data6 = new Tile( TileBaseSet.getTilePrototype( TileSymbol.MARS, TileColor.INDIGO), TileOrientation.UPRIGHT );
		Tile data7 = new Tile( TileBaseSet.getTilePrototype( TileSymbol.VENUS, TileColor.VIOLET), TileOrientation.UPRIGHT );
		
		Tile[] dataIcons = {data,data2};
		
		
		for(int i= 0; i<4;i++){
			stageModel.addElement(dataIcons[1]);
			stageModel.addElement(dataIcons[0]);
			stageModel.addElement(data3);
			stageModel.addElement(data2);
			stageModel.addElement(data4);
			stageModel.addElement(data5);
			stageModel.addElement(data6);
			stageModel.addElement(data7);
			stageModel.addElement( new Tile( TileBaseSet.getTilePrototype( TileSymbol.MERCURY, TileColor.RED), TileOrientation.UPRIGHT ));
			playerRackModel.addElement(dataIcons[1]);
		}
		
		
		
		
		stage.setModel(stageModel);
		stage.setVisibleRowCount(0);
		stage.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		stage.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		stage.setDragEnabled(true);
		stage.setDropMode(DropMode.INSERT);
        stage.setTransferHandler(new TileTransferHandler());
       
		stage.setFixedCellHeight(94);
 	    stage.setFixedCellWidth(90);
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
							Tile t = (Tile)stageModel.getElementAt(stage.locationToIndex(e.getPoint()));
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
		rack.setModel(playerRackModel);
		rack.setVisibleRowCount(0);
		rack.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		rack.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		rack.setDragEnabled(true);
		rack.setDropMode(DropMode.INSERT);
        rack.setTransferHandler(new TileTransferHandler());
		
		//stage.setSize(816, 340);
		//rack.setSize(1016,180);
		JScrollPane rackScrollPane = new JScrollPane(rack);
		JScrollPane stageScrollPane= new JScrollPane(stage);
		//rackScrollPane.setSize(1016, 180);
				
		JLabel tileLeftJLabel = new JLabel(currentRes.getString("viciscycle.gui.tilesRemaining") + ":");
		
		drawTileButton = new JButton(currentRes.getString("viciscycle.gui.drawTile"));
		confirmMovesButton = new JButton(currentRes.getString("viciscycle.gui.confirmMoves"));
		revertMovesButton = new JButton(currentRes.getString("viciscycle.gui.revertMoves"));
		abandonGameButton = new JButton(currentRes.getString("viciscycle.gui.abandonGame"));
		
		try {
			File HanWangFile = new File("font/WCL-07.ttf");
			Font HanWangFont = Font.createFont(Font.TRUETYPE_FONT, HanWangFile).deriveFont(Font.PLAIN, 18);
			
			revertMovesButton.setFont(HanWangFont);
			drawTileButton.setFont(HanWangFont);
			confirmMovesButton.setFont(HanWangFont);
			abandonGameButton.setFont(HanWangFont);
		} catch (FontFormatException|IOException e) {
		}
		
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
	JList<ImageIcon> stage;
	DefaultListModel stageModel,playerRackModel;
}
