import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * This program demonstrates drag and drop in an image list.
 * @version 1.00 2007-09-20
 * @author Cay Horstmann
 */
public class ImageListDnDTest
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new ImageListDnDFrame();
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

class ImageListDnDFrame extends JFrame
{
   public ImageListDnDFrame()
   {
      setTitle("ImageListDnDTest");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      list1 = new ImageList(new File("tiles").listFiles());
      list2 = new ImageList(new File("images2").listFiles());
      setLayout(new GridLayout(2, 1));
      add(new JScrollPane(list1));
      add(new JScrollPane(list2));
	  
	  
	  list1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				switch (e.getButton()){
					case MouseEvent.BUTTON1:
						break;
					case MouseEvent.BUTTON3:
						try{
							TileIcon t = ((TileIcon)list1.getModel().getElementAt(list1.locationToIndex(e.getPoint())));
							t.switchState();
							list1.repaint();
						}catch(Exception ex){
							
						}				
						break;							
				}}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
	  list2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				switch (e.getButton()){
					case MouseEvent.BUTTON1:
						break;
					case MouseEvent.BUTTON3:
						try{
							TileIcon t = ((TileIcon)list2.getModel().getElementAt(list2.locationToIndex(e.getPoint())));
							t.switchState();
							list2.repaint();
						}catch(Exception ex){
							
						}					
						break;						
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
		});
   }

   private ImageList list1;
   private ImageList list2;
   private static final int DEFAULT_WIDTH = 600;
   private static final int DEFAULT_HEIGHT = 500;
}

class ImageList extends JList
{
   public ImageList(File[] imageFiles)
   {
      DefaultListModel model = new DefaultListModel();
      for (File f : imageFiles)
         model.addElement(new TileIcon(f.getPath()));

      setModel(model);
      setVisibleRowCount(0);
      setLayoutOrientation(JList.HORIZONTAL_WRAP);
      setDragEnabled(true);
      setDropMode(DropMode.INSERT);
      setTransferHandler(new ImageListTransferHandler());
   }
}
class TileIcon extends ImageIcon
{
	private Rotate state;
	public enum Rotate
	{
		CLOCKWISE,
		UP_RIGHT;
	}
	TileIcon(Image image) {
		super(image);
		state = Rotate.UP_RIGHT;
	}
	TileIcon(Image image,Rotate r) {
		super(image);
		state = r;
	}
	TileIcon(String path) {
		super(path);
		state = Rotate.UP_RIGHT;
	}
	public Rotate getState(){
		return state;
	}
	public void switchState(){
		if(this.state == Rotate.CLOCKWISE){
			this.state =Rotate.UP_RIGHT ;
		}else{
			this.state = Rotate.CLOCKWISE;
		}
	}
@Override
 public void paintIcon(Component c, Graphics g, int x, int y) {
	
	Graphics2D g2d = (Graphics2D)g.create();
	if (this.state == Rotate.CLOCKWISE){
		g2d.rotate(Math.PI/2);
		g2d.drawImage(this.getImage(), 0, -98, c);
	}else{
		g2d.drawImage(this.getImage(), 0, 0, c);
	}
	
	
	
}

}
class ImageListTransferHandler extends TransferHandler
{
   // Support for drag

   public int getSourceActions(JComponent source)
   {
      return COPY_OR_MOVE;
   }

   protected Transferable createTransferable(JComponent source)
   {
      JList list = (JList) source;
      int index = list.getSelectedIndex();
      if (index < 0) return null;
      TileIcon icon = (TileIcon) list.getModel().getElementAt(index);
      return new ImageTransferable(icon.getImage());
   }

   protected void exportDone(JComponent source, Transferable data, int action)
   {
      if (action == MOVE)
      {
         JList list = (JList) source;
         int index = list.getSelectedIndex();
         if (index < 0) return;
         DefaultListModel model = (DefaultListModel) list.getModel();
         model.remove(index);
      }
   }

   // Support for drop

   public boolean canImport(TransferSupport support)
   {
      if (support.isDataFlavorSupported(DataFlavor.javaFileListFlavor))
      {
         if (support.getUserDropAction() == MOVE) support.setDropAction(COPY);
         return true;
      }
      else return support.isDataFlavorSupported(DataFlavor.imageFlavor);
   }

   public boolean importData(TransferSupport support)
   {
      JList list = (JList) support.getComponent();
      DefaultListModel model = (DefaultListModel) list.getModel();

      Transferable transferable = support.getTransferable();
      List<DataFlavor> flavors = Arrays.asList(transferable.getTransferDataFlavors());

      List<Image> images = new ArrayList<Image>();

      try
      {
         if (flavors.contains(DataFlavor.javaFileListFlavor))
         {
            List<File> fileList = (List<File>) transferable
                  .getTransferData(DataFlavor.javaFileListFlavor);
            for (File f : fileList)
            {
               try
               {
                  images.add(ImageIO.read(f));
               }
               catch (IOException ex)
               {
                  // couldn't read image--skip
               }
            }
         }
         else if (flavors.contains(DataFlavor.imageFlavor))
         {
            images.add((Image) transferable.getTransferData(DataFlavor.imageFlavor));
         }

         int index;
		 TileIcon.Rotate r;
         if (support.isDrop())
         {
            JList.DropLocation location = (JList.DropLocation) support.getDropLocation();
            index = location.getIndex();
			//r = ((TileIcon)model.getElementAt(index)).getState();
            if (!location.isInsert()) model.remove(index); // replace location
			
         }
         else {
			 index = model.size();
			 r = TileIcon.Rotate.UP_RIGHT;
		 }
         for (Image image : images)
         {
            model.add(index, new TileIcon(image));
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
