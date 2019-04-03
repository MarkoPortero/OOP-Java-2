import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JFrame implements ActionListener{
	private JMenuBar jmb;
	private JMenu gameMenu, reportsMenu, systemMenu;
	private JMenuItem newGame, highestScore, exit, rules, about;
	private BufferedImage img;
	private JLabel lblBackground;
	public Menu(){
		jmb = new JMenuBar();
		//Declare Menus
		gameMenu = new JMenu("GAME");
		reportsMenu = new JMenu("REPORTS");
		systemMenu = new JMenu("SYSTEM");
		//Declare Menu Items
		newGame = new JMenuItem("New Game");
		newGame.addActionListener(this);
		highestScore = new JMenuItem("Highest Score");
		highestScore.addActionListener(this);
		exit = new JMenuItem("Exit");
		exit.addActionListener(this);
		rules = new JMenuItem("Rules");
		rules.addActionListener(this);
		about = new JMenuItem("About");
		about.addActionListener(this);
		//Add Items to menus
		gameMenu.add(newGame);
		gameMenu.add(exit);
		reportsMenu.add(highestScore);
		systemMenu.add(rules);
		systemMenu.add(about);
		//Add Menus to menu bar
		jmb.add(gameMenu);
		jmb.add(reportsMenu);
		jmb.add(systemMenu);
		//Set menu bar..
		setJMenuBar(jmb);
		
		//SetContentPane
		Container cn = getContentPane();
		
		//Try+catch for reading in img
		try {
			img = ImageIO.read(new File("hangmanlogo.jpg"));
		} catch (IOException e) {
			System.out.println("ERROR: Could not find logo");
		}
		lblBackground = new JLabel(new ImageIcon(img));
		getContentPane().setLayout(new GridBagLayout());
		addComp(lblBackground, 0, 0, 5, 5, 1, 1);

		
	}
	private void addComp(Component c, int gridx, int gridy, int width, int height,
			 int weightx, int weighty)
	{
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.fill = GridBagConstraints.BOTH;
		gc.insets = new Insets(5,5,5,5);
		gc.gridx = gridx;
		gc.gridy = gridy;
		gc.gridwidth = width;
		gc.gridheight = height;
		gc.weightx = weightx;
		gc.weighty = weighty;
		
		getContentPane().add(c, gc);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newGame){
			PlayerChoice newPlayer = new PlayerChoice();
			newPlayer.setVisible(true);
			newPlayer.setSize(300,150);
			newPlayer.setTitle("Choose players:");
			newPlayer.setLocationRelativeTo(null);
		}
		else if(e.getSource() == rules){
			Rules showRules = new Rules();
			showRules.setVisible(true);
			showRules.setExtendedState(showRules.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			showRules.setTitle("HANGMAN RULES");
		}
		
	}

}
