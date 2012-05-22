/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.model.tile;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.TransferHandler;

/**
 *
 * @author roland
 */
public class TileTransferHandler extends TransferHandler {
	

   // Support for drag
  DataFlavor dataFlavor = new DataFlavor(Tile.class,Tile.class.getSimpleName());
	
   public int getSourceActions(JComponent source)
   {
      return COPY_OR_MOVE;
   }

   protected Transferable createTransferable(JComponent source)
   {
      JList list = (JList) source;
	  
	
	  int[] selectedIndices = list.getSelectedIndices();
	  Tile[]icons = new Tile[selectedIndices.length];
          for (int i = selectedIndices.length-1; i >=0; i--) {
			  icons[i] =(Tile) list.getModel().getElementAt(i);
              //dlm.removeElementAt(selectedIndices[i]);
          } 
     /* int index = list.getSelectedIndex();
      if (index < 0) return null;
      Tile icon = (Tile) list.getModel().getElementAt(index);*/
      return new TileTransferable(icons);
   }

   protected void exportDone(JComponent source, Transferable data, int action)
   {
      if (action == MOVE)
      {
         JList list = (JList) source;
		   int[] selectedIndices = list.getSelectedIndices();
		  Tile[]icons = new Tile[selectedIndices.length];
	      DefaultListModel model = (DefaultListModel) list.getModel();
          for (int i = selectedIndices.length-1; i >=0; i--) {        
			   model.remove(selectedIndices[i]);
          } 
         /*int index = list.getSelectedIndex();
         if (index < 0) return;
         DefaultListModel model = (DefaultListModel) list.getModel();
         model.remove(index);*/
      }
   }

   // Support for drop

   public boolean canImport(TransferHandler.TransferSupport support)
   {
      if (support.isDataFlavorSupported(DataFlavor.javaFileListFlavor))
      {
		  
         if (support.getUserDropAction() == MOVE) support.setDropAction(COPY);
         return true;
      }
	  else{ 
	boolean a =support.isDataFlavorSupported(dataFlavor);
	//System.out.println(a);
	   return a;
	  }
   }

   public boolean importData(TransferHandler.TransferSupport support)
   {
      JList list = (JList) support.getComponent();
      DefaultListModel model = (DefaultListModel) list.getModel();

      Transferable transferable = support.getTransferable();
      List<DataFlavor> flavors = Arrays.asList(transferable.getTransferDataFlavors());

      List<Tile> tileList = new ArrayList<Tile>();
	  
      try
      {
         if (flavors.contains(DataFlavor.javaFileListFlavor))
         {
            List<File> fileList = (List<File>) transferable
                  .getTransferData(DataFlavor.javaFileListFlavor);
            for (File f : fileList)
            {
              /* try
               {
                  images.add(ImageIO.read(f));
               }
               catch (IOException ex)
               {
                  // couldn't read image--skip
               }	*/
            }
         }
         else if (flavors.contains(dataFlavor))
         {
			 Tile[] Tile_array =(Tile[]) transferable.getTransferData(dataFlavor);
			 for (int i = 0; i < Tile_array.length; i++) {
				 tileList.add(Tile_array[i]);
			 }
            
         }

         int index;
		 
         if (support.isDrop())
         {
            JList.DropLocation location = (JList.DropLocation) support.getDropLocation();
            index = location.getIndex();
			//r = ((Tile)model.getElementAt(index)).getState();
            if (!location.isInsert()) model.remove(index); // replace location
			
         }
         else {
			 index = model.size();
		 }
         for (Tile image : tileList)
         {
            model.add(index, image);
            index++;
         }
         return true;
      }
      catch (IOException ex)
      {
         return false;
      }
      catch (UnsupportedFlavorException ex)
      {
         return false;
      }
   }
}