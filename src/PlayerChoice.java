import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PlayerChoice extends JFrame implements ActionListener {
	private JButton OnePlayer, TwoPlayers;
	private Container cn;
	private JFrame frame;

	public PlayerChoice() {
		String labelText = "Please choose how many players:\n";
		
		JLabel label = new JLabel(labelText);
		OnePlayer = new JButton("One Player");
		TwoPlayers = new JButton("Two Players");

		OnePlayer.addActionListener(this);
		TwoPlayers.addActionListener(this);

		cn = getContentPane();
		cn.setLayout(new BoxLayout(cn, BoxLayout.Y_AXIS));
		
		cn.add(label);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		OnePlayer.setAlignmentX(Component.CENTER_ALIGNMENT);
		cn.add(OnePlayer);

		TwoPlayers.setAlignmentX(Component.CENTER_ALIGNMENT);
		cn.add(TwoPlayers);

		frame = new JFrame("Player Choice");

	}

	private static void add(String text, Container container) {
		JButton button = new JButton(text);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		container.add(button);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == OnePlayer) {
			String PlayerOne = JOptionPane.showInputDialog(frame, "Enter Player Ones name:");
			String PlayerTwo = "COMPUTER";
			String Temp = ("hello world");
			String Word = Temp;
			
		
			GameScreen newGame = new GameScreen(PlayerOne, PlayerTwo, Word);
			newGame.setVisible(true);
			newGame.setSize(800,950);
			newGame.setTitle("New Game");
			newGame.setLocationRelativeTo(null);
			this.dispose();
		} else if (e.getSource() == TwoPlayers) {
			String PlayerOne = JOptionPane.showInputDialog(frame, "Enter Player Ones name:");
			String PlayerTwo = JOptionPane.showInputDialog(frame, "Enter Player Twos name:");			
			String Word = JOptionPane.showInputDialog(frame, PlayerOne +" will guess first. " + PlayerTwo + " enter a word for them to guess:");
			GameScreen newGame = new GameScreen(PlayerOne, PlayerTwo, Word);
			newGame.setVisible(true);
			newGame.setSize(800,950);
			newGame.setTitle("New Game");
			newGame.setLocationRelativeTo(null);
			this.dispose();
		}
	}

}
