/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.gui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.geom.Area;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.swing.*;

/**
 *
 * @author roland
 */
public class GameInternalFrame extends JInternalFrame{
	public GameInternalFrame(){
		super("15", false, false, false, false);
		ResourceBundle currentRes = ResourceBundle.getBundle("viciscycle.translation.lang"/*
		 * ,Locale.CHINESE
		 */);
		
		setTitle(currentRes.getString("viciscycle.gamePage"));
		setBounds(0, 0, 1010, 570);
		setLocation((800 - 330) / 2, (600 - 310) / 2);
		JPanel gp = new JPanel();
		gp.setSize(1010, 570);
		
		JList<ImageIcon> arena = new JList<ImageIcon>();
		JList<ImageIcon> rack = new JList<ImageIcon>();
		
		arena.setSize(800, 340);
		rack.setSize(1000,180);
		
		JLabel tileLeftJLabel = new JLabel(currentRes.getString("viciscycle.tileLeft"));
		
		JButton undoButton = new JButton(currentRes.getString("viciscycle.undo"));
		JButton drawTileButton = new JButton(currentRes.getString("viciscycle.drawTile"));
		JButton acceptButton = new JButton(currentRes.getString("viciscycle.accept"));
		JButton exitButton = new JButton(currentRes.getString("viciscycle.exit"));
		
		try {
			File HanWangFile = new File("font/WCL-07.ttf");
			Font HanWangFont = Font.createFont(Font.TRUETYPE_FONT, HanWangFile).deriveFont(Font.PLAIN, 18);
			
			undoButton.setFont(HanWangFont);
			drawTileButton.setFont(HanWangFont);
			acceptButton.setFont(HanWangFont);
			exitButton.setFont(HanWangFont);
		} catch (FontFormatException|IOException e) {
		}
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		/*layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.CENTER)
					.addComponent(arena, 800, 800, 800)
					.addGroup(layout.createParallelGroup())
				);*/
	}
}
