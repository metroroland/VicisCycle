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
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 *
 * @author roland
 */
public class BackdropFrame extends javax.swing.JFrame {

	private JDesktopPane mainDesktopPane;

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
		//initComponents();
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException |
				IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(BackdropFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		MainMenuFrame gameFrame = new MainMenuFrame();
		mainDesktopPane.add(gameFrame, BorderLayout.CENTER);
		gameFrame.setVisible(true);
		
		GameRoomFrame game2Frame = new GameRoomFrame();
		mainDesktopPane.add(game2Frame, BorderLayout.CENTER);
		game2Frame.setVisible(true);
	}


	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/*
		 * Set the Nimbus look and feel
		 */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(BackdropFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(BackdropFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(BackdropFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(BackdropFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/*
		 * Create and display the form
		 */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new BackdropFrame().setVisible(true);
			}
		});
	}

}
