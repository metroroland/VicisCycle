/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.model.tile;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 *
 * @author roland
 */
public class TileTransferable implements Transferable {
	Tile[] t ;
	  DataFlavor dataFlavor = new DataFlavor(Tile.class,Tile.class.getSimpleName());
	public TileTransferable(Tile[] tile){
		t=tile;
		
	}
	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return new DataFlavor[]{dataFlavor};
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return flavor.equals(dataFlavor);
	}

	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		  if (flavor.equals(dataFlavor))
      {
         return t;
      }
	  else 
      {
         throw new UnsupportedFlavorException(flavor);
      }
	}
	
}
