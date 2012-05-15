/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.gui;

import javax.swing.JInternalFrame;
import java.util.ResourceBundle;

/**
 * 
 * @author Kineslight
 */
public class HostGameFrame extends JInternalFrame {
	
	public HostGameFrame() {
		
		super( Resource.getString( "viciscycle.gui.gameTitle" ) + " - " + Resource.getString( "viciscycle.gui.hostGame" ),
				false, false, false, false );
		setSize( 200, 200 );
		setLocation( 0, 0 );
		
	}
}
