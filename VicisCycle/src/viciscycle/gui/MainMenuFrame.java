/*
 * VicisCycle 2012
 * Released under GNU GPL License v2
 */
package viciscycle.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author roland
 */
public class MainMenuFrame extends javax.swing.JInternalFrame {
	
	/**
	 * Creates new form MainMenuFrame
	 */
	public MainMenuFrame()  {
		super("15", false, false, false, false);
		ResourceBundle currentRes = ResourceBundle.getBundle("viciscycle.translation.lang"
		  /*,Locale.CHINESE*/
		 );
		setTitle(currentRes.getString("viciscycle.gui.gameTitle") + " - " + currentRes.getString("viciscycle.gui.mainMenu"));
		setBounds(0, 0, 320, 300);
		setLocation((760 - 320) / 2, (560 - 300) / 2);
		JPanel gp = new JPanel();
		gp.setSize(320, 300);
		
		JButton startServerButton = new  JButton(currentRes.getString("viciscycle.gui.hostGame"));
		JButton joinGameButton = new JButton(currentRes.getString("viciscycle.gui.joinGame"));
		JButton creditsButton = new JButton(currentRes.getString("viciscycle.gui.creditsList"));
		JButton exitButton = new JButton(currentRes.getString("viciscycle.gui.exitGame"));
		
		try {
			File HanWangFile = new File("font/WCL-07.ttf");
			Font HanWangFont = Font.createFont(Font.TRUETYPE_FONT, HanWangFile).deriveFont(Font.PLAIN, 18);
			
			startServerButton.setFont(HanWangFont);
			joinGameButton.setFont(HanWangFont);
			creditsButton.setFont(HanWangFont);
			exitButton.setFont(HanWangFont);
		} catch (FontFormatException|IOException e) {
		}
		
		
		
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
							.addComponent(startServerButton,180,180,180)
							.addComponent(joinGameButton,180,180,180)
							.addComponent(creditsButton,180,180,180)
							.addComponent(exitButton,180,180,180)
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
						.addComponent(startServerButton)
						.addGap(20,20,20)
						.addComponent(joinGameButton)
						.addGap(20,20,20)
						.addComponent(creditsButton)
						.addGap(20,20,20)
						.addComponent(exitButton)
						.addContainerGap(50, Short.MAX_VALUE)
					)

				);
		/*JButton b = new JButton(currentRes.getString("viciscycle.startServer"));
		 * gp.add(b);
		 * b = new JButton(currentRes.getString("viciscycle.joinGame"));
		 * gp.add(b);
		 * b = new JButton(currentRes.getString("viciscycle.credits"));
		 * gp.add(b);
		 * b = new JButton(currentRes.getString("viciscycle.exit"));
		 * gp.add(b);
		 * add(gp, BorderLayout.CENTER);*/
		pack();
		//initComponents();
	}
	
}
