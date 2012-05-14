/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle;

import viciscycle.gui.BackdropFrame;

import java.awt.EventQueue;


/**
 *
 * @author roland
 */
public class VicisCycle {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater( new Runnable() {

			public void run() {
				( new BackdropFrame() ).setVisible( true );
			}
		} );
	}
}
