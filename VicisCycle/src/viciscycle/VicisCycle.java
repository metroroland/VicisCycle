/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle;

/**
 *
 * @author roland
 */
public class VicisCycle {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new viciscycle.gui.VicisCycleGUI().setVisible(true);
			}
		});
	}
}
