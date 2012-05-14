/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
/**
 * TO-DOs 1. add background to main window
 *        2. set internal window's size and
 * layout 
 */
package viciscycle.gui;

import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

/**
 *
 * @author roland
 */
public class BackdropFrame extends JFrame {

	/**
	 * Creates new form BackdropFrame
	 *
	 */
	public BackdropFrame() {
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setSize(1100, 940);
		setResizable(false);
		mainDesktopPane = new JDesktopPane();

		add(mainDesktopPane);
		MainMenuFrame gameFrame = new MainMenuFrame();
		mainDesktopPane.add(gameFrame, BorderLayout.CENTER);
		gameFrame.setVisible(true);
		
		GameRoomFrame game2Frame = new GameRoomFrame();
		mainDesktopPane.add(game2Frame, BorderLayout.CENTER);
		game2Frame.setVisible(true);
	}

	private JDesktopPane mainDesktopPane;

}
