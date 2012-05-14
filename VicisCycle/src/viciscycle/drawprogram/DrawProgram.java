/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viciscycle.drawprogram;

import javax.swing.JPanel;
import viciscycle.drawprogram.*;
import java.awt.geom.GeneralPath;
import javax.swing.JFrame;
/**
 *
 * @author roland
 */
public class DrawProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         DesktopFrame desktopFrame = new DesktopFrame();
            desktopFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            desktopFrame.setSize( 800, 480 ); // set frame size
            desktopFrame.setVisible( true ); // display frame
		ShapeTest st = new ShapeTest();
        
        TileList tl = new drawprogram.TileList();
        JPanel singleTile = new JPanel();
        GeneralPath path = new GeneralPath();
        path.moveTo(10,20);
                path.lineTo(20,30   );
               //singleTile.add(); 
        tl.add(singleTile);
        tl.setVisible(true);
    }
}
