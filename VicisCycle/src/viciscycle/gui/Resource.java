/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.gui;

import java.util.ResourceBundle;
import java.util.TreeMap;
import java.io.File;
import java.io.IOException;
import java.awt.Font;
import java.awt.FontFormatException;
import javax.swing.UnsupportedLookAndFeelException;


/**
 * Class for wrapping shared GUI resources
 * @author Kineslight
 */
public class Resource {
	
	public static String getString( String key ) {
		
		return translations.getString( key );
	}
	
	public static Font getFont( int fontStyle, int fontSize ) {
		
		TreeMap<Integer, Font> style = fonts.get( fontStyle );
		
		if ( style == null ) {
			style = new TreeMap<Integer, Font>();
			fonts.put( fontStyle, style );
		}
		
		Font derivedFont = style.get( fontSize );
		
		if ( derivedFont == null ) {
			derivedFont = font.deriveFont( fontStyle, (float)fontSize );
			style.put( fontSize, derivedFont );
		}
		
		return derivedFont;
	}
	
	private static ResourceBundle translations;
	private static Font font;
	private static TreeMap< Integer, TreeMap<Integer, Font> > fonts;
	
	static {

		// Set the Nimbus look and feel
		try {
			
			for ( javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels() ) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}
		catch ( ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex ) {
			
			java.util.logging.Logger.getLogger( BackdropFrame.class.getName() ).log( java.util.logging.Level.SEVERE, null, ex );
		}
		

		translations = ResourceBundle.getBundle( "viciscycle.translation.lang" /* , Locale.CHINESE */ );
		
		font = null;
		try {
			font = Font.createFont( Font.TRUETYPE_FONT, new File( "font/WCL-07.ttf" ) );
		}
		catch ( IOException | FontFormatException e ) {
			e.printStackTrace();
		}
		
		fonts = new TreeMap< Integer, TreeMap<Integer, Font> >();
	}
}
