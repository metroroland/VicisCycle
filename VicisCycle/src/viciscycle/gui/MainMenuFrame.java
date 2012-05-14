/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.gui;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;


/**
 *
 * @author roland
 */
public class MainMenuFrame extends JInternalFrame {
	
	/**
	 * Creates new form MainMenuFrame
	 */
	public MainMenuFrame() {
		
		super( Resource.getString( "viciscycle.gui.gameTitle" ) + " - " + Resource.getString( "viciscycle.gui.mainMenu"),
				false, false, false, false);
		setBounds(0, 0, 320, 300);
		setLocation((760 - 320) / 2, (560 - 300) / 2);
		JPanel gp = new JPanel();
		gp.setSize(320, 300);
		
		hostGameButton = new JButton( Resource.getString( "viciscycle.gui.hostGame" ) );
		hostGameButton.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed( ActionEvent e ) {
				( new HostGameFrame() ).setVisible( true );
			}
		} );
		
		joinGameButton = new JButton( Resource.getString( "viciscycle.gui.joinGame" ) );
		showCreditsButton = new JButton( Resource.getString( "viciscycle.gui.creditsList" ) );
		exitGameButton = new JButton( Resource.getString( "viciscycle.gui.exitGame" ) );
		
		Font font = Resource.getFont( Font.PLAIN, 18 );
		setFont( font );
		hostGameButton.setFont( font );
		joinGameButton.setFont( font );
		showCreditsButton.setFont( font );
		exitGameButton.setFont( font );
		
		
		JLabel titleLabel = new JLabel();
		titleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viciscycle/graphics/logo.jpg"))); // NOI18N

		
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.CENTER)
					//.addGap(100,100,100)
					.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup()
							.addGap(100,100,100))
						.addGroup(layout.createParallelGroup()
							.addComponent(titleLabel,180,180,180)
							.addComponent(hostGameButton,180,180,180)
							.addComponent(joinGameButton,180,180,180)
							.addComponent(showCreditsButton,180,180,180)
							.addComponent(exitGameButton,180,180,180)
						)
						.addGroup(layout.createParallelGroup()
							.addGap(100,100,100))
					)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
						.addContainerGap(50, Short.MAX_VALUE)
						.addComponent(titleLabel)
						.addGap(20,20,20)
						.addComponent(hostGameButton)
						.addGap(20,20,20)
						.addComponent(joinGameButton)
						.addGap(20,20,20)
						.addComponent(showCreditsButton)
						.addGap(20,20,20)
						.addComponent(exitGameButton)
						.addContainerGap(50, Short.MAX_VALUE)
					)

				);
		pack();
	}
	
	private JButton hostGameButton;
	private JButton joinGameButton;
	private JButton showCreditsButton;
	private JButton exitGameButton;
}
