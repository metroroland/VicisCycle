/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.gui;

import java.awt.*;
import viciscycle.model.tile.Tile;
import viciscycle.model.tile.TileSymbol;
import viciscycle.model.tile.TileColor;
import viciscycle.model.tile.TileOrientation;
import viciscycle.model.tile.TileBaseSet;
import viciscycle.model.tile.TileTransferHandler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
import viciscycle.model.tile.*;


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
		
		
		
		stage = new TileJList(stageModel);
		rack = new TileJList(playerRackModel);
		
		
		//JPanel
		JPanel highlightPanel = new JPanel();
		HighlightRect hr = new HighlightRect(0, 1,2,1);
		highlightPanel.add(hr);
		
		
		
		stageLayeredPane = new JLayeredPane();
		LayoutManager overlay = new OverlayLayout(stageLayeredPane);
		stageLayeredPane.setLayout(overlay);
		
		//stageLayeredPane.setLayout(null/*new  BoxLayout(stageLayeredPane, BoxLayout.LINE_AXIS)*/);
		stageLayeredPane.add(stage, new Integer(0));
		stageLayeredPane.add(hr, new Integer(3));
		
		stage.setBounds(0, 0, 720, 340);
		//hr.setBounds(0, 0, 800, 340);
		//stage.setPreferredSize(new Dimension(800, 740));
		JScrollPane rackScrollPane = new JScrollPane(rack);
		JScrollPane stageScrollPane= new JScrollPane(stageLayeredPane);
		//stageScrollPane.setMinimumSize(new Dimension(800,340));
	//	stageScrollPane.setPreferredSize(new Dimension(800,340));
		//rackScrollPane.setSize(1016, 180);
		
		tilesRemainingLabel = new JLabel( Resource.getString( "viciscycle.gui.tilesRemaining" ) + " : ");
		
		drawTileButton = new JButton( Resource.getString( "viciscycle.gui.drawTile" ) );
		confirmMovesButton = new JButton( Resource.getString( "viciscycle.gui.confirmMoves" ) );
		revertMovesButton = new JButton( Resource.getString( "viciscycle.gui.revertMoves" ) );
		abandonGameButton = new JButton( Resource.getString( "viciscycle.gui.abandonGame" ) );
		
		Font font = Resource.getFont( Font.PLAIN, 18 );
		setFont( font );
		tilesRemainingLabel.setFont( font );
		revertMovesButton.setFont( font );
		drawTileButton.setFont( font );
		confirmMovesButton.setFont( font );
		abandonGameButton.setFont( font );
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(stageScrollPane,GroupLayout.Alignment.LEADING, 742, 742, 742)
				
				.addGroup(layout.createSequentialGroup()
				.addComponent(tilesRemainingLabel)
				.addComponent(drawTileButton)
				.addComponent(confirmMovesButton)
				.addComponent(revertMovesButton)
				.addComponent(abandonGameButton)
				.addGap(10,10,10)
				).addComponent(rackScrollPane)
				);
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addComponent(stageScrollPane, 340,340,340)
				
				.addGap(10,10,10)
				.addGroup(layout.createParallelGroup()
				.addComponent(tilesRemainingLabel,GroupLayout.Alignment.CENTER)
				.addComponent(drawTileButton)
				.addComponent(confirmMovesButton)
				.addComponent(revertMovesButton)
				.addComponent(abandonGameButton))
				.addGap(10,10,10)
				.addComponent(rackScrollPane)
				.addGap(10,10,10)
				);
		
		
	}
	public static void mainGame(){
		stage.repaint();
		rack.repaint();
		DefaultListModel m =(DefaultListModel) rack.getModel();
		
		tilesRemainingLabel.setText( Resource.getString( "viciscycle.gui.tilesRemaining" ) + " : "+m.getSize());
		
	}
	
	private JButton drawTileButton;
	private JButton confirmMovesButton;
	private JButton revertMovesButton;
	private JButton abandonGameButton;
	private static JLabel tilesRemainingLabel;
	
	private static TileJList stage;
	private static TileJList rack;
	private JLayeredPane stageLayeredPane;
	
	private DefaultListModel stageModel;
	private DefaultListModel playerRackModel;
}
