import java.awt.Container;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GameScreen extends JFrame implements ActionListener {

	ArrayList<String> words = new ArrayList<String>();
	private JLabel lblTitle;
	private static JLabel lblWord;
	private JLabel lblPlayerOne;
	private JLabel lblPlayerName1, lblPlayerName2;
	private JLabel lblPlayerTwo, lblUsed;
	private JLabel lblCurrentPlayer, lblCurrentPlayerName;
	private JLabel lblDisplay;
	JLabel lblCompleteWord;
	private Container cn;
	private static JTextField txtAttempt;
	private JButton btnAttempt;
	private JLabel lblBackground;
	private BufferedImage img, white;
	private JLabel cover1, cover2, cover3, cover4, cover5, cover6;
	static String wordSize = ("");
	char letter;
	int tries = 0;
	boolean found = false;
	Scanner file;
	Random gen = new Random();
	String hello = ("hello world");
	ArrayList<String> enteredLetters = new ArrayList<>();

	public GameScreen(String PlayerOne, String PlayerTwo, String Word) {

		if (Word.contains(hello)) {
			openFile();
			try {
				readFile();
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			}
			Word = getRandom();
		}
		cn = getContentPane();
		cn.setLayout(null);

		lblTitle = new JLabel("Hangman");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
		lblTitle.setBounds(10, 20, 300, 50);

		txtAttempt = new JTextField();
		txtAttempt.setBounds(10, 800, 150, 50);

		btnAttempt = new JButton("Enter Choice");
		btnAttempt.setBounds(175, 800, 150, 50);
		btnAttempt.addActionListener(this);

		try {
			img = ImageIO.read(new File("hangman.gif"));
		} catch (IOException e) {
			System.out.println("ERROR: Could not find hangman");
		}
		try {
			white = ImageIO.read(new File("white.png"));
		} catch (IOException e) {
			System.out.println("ERROR: Could not find cover");
		}

		lblDisplay = new JLabel("Try and guess the word:");
		lblDisplay.setBounds(10, 600, 150, 50);
		lblBackground = new JLabel(new ImageIcon(img));
		lblBackground.setBounds(20, 50, 500, 500);
		// LeftArm
		cover1 = new JLabel(new ImageIcon(white));
		cover1.setBounds(225, 250, 100, 100);
		// RightArm
		cover2 = new JLabel(new ImageIcon(white));
		cover2.setBounds(328, 250, 100, 100);
		// LeftLeg
		cover3 = new JLabel(new ImageIcon(white));
		cover3.setBounds(225, 320, 100, 100);
		// RightLeg
		cover4 = new JLabel(new ImageIcon(white));
		cover4.setBounds(328, 320, 100, 100);
		// Body
		cover5 = new JLabel(new ImageIcon(white));
		cover5.setBounds(275, 250, 100, 100);
		// Head
		cover6 = new JLabel(new ImageIcon(white));
		cover6.setBounds(275, 150, 100, 100);

		cn.add(lblTitle);
		cn.add(txtAttempt);
		cn.add(btnAttempt);
		cn.add(cover1);
		cn.add(cover2);
		cn.add(cover3);
		cn.add(cover4);
		cn.add(cover5);
		cn.add(cover6);
		cn.add(lblBackground);

		if (Word == null) {
			Word = ("Null");
		}

		Word = Word.toLowerCase();
		for (int x = 0; x < Word.length(); x++) {
			wordSize += ("* ");
		}
		System.out.println(Word);

		lblWord = new JLabel(wordSize);
		lblWord.setBounds(200, 600, 150, 50);

		lblUsed = new JLabel();
		lblUsed.setBounds(200, 700, 150, 50);
		lblCompleteWord = new JLabel(Word);

		lblPlayerOne = new JLabel();
		lblPlayerTwo = new JLabel();

		lblPlayerOne.setBounds(100, 50, 150, 50);
		lblPlayerTwo.setBounds(200, 50, 150, 50);

		lblPlayerOne.setText(PlayerOne);
		lblPlayerTwo.setText(PlayerTwo);

		lblPlayerName1 = new JLabel("Player 1:");
		lblPlayerName2 = new JLabel("Player 2:");

		lblPlayerName1.setBounds(100, 40, 150, 50);
		lblPlayerName2.setBounds(200, 40, 150, 50);

		lblCurrentPlayer = new JLabel("The current player is:");
		lblCurrentPlayerName = new JLabel();
		lblCurrentPlayerName.setText(PlayerOne);
		
		lblCurrentPlayer.setBounds(10, 700, 150, 50);
		lblCurrentPlayerName.setBounds(10, 725, 150, 50);
		
		cn.add(lblCurrentPlayer);
		cn.add(lblCurrentPlayerName);
		
		cn.add(lblPlayerName1);
		cn.add(lblPlayerName2);
		cn.add(lblWord);
		cn.add(lblDisplay);
		cn.add(lblUsed);
		cn.add(lblPlayerOne);
		cn.add(lblPlayerTwo);
	}

	public boolean compareWord(String attempt) {
		boolean complete = false;
		String Word = lblCompleteWord.getText();
		String Current = "";
		if (!Word.contains(attempt)) {
			tries++;
			punishment();
		}
		for (int x = 0; x < Word.length(); x++) {
			String test = Character.toString(Word.charAt(x));
			if (enteredLetters.contains(test)) {
				System.out.print(test);
				Current += test;
			} else {
				System.out.print("*");
				Current += "*";
				complete = true;
			}
		}
		lblWord.setText(Current);
		return complete;
	}

	private void openFile() {
		try {
			file = new Scanner(new File("dictionary.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}

	public void readFile() throws FileNotFoundException {
		while (file.hasNext()) {
			words.add(file.nextLine());
		}
	}

	public String getRandom() {
		int index = gen.nextInt(words.size());
		return words.get(index);
	}

	public void punishment() {
		if (tries == 1) {
			cover1.setVisible(false);
		} else if (tries == 2) {
			cover2.setVisible(false);
		} else if (tries == 3) {
			cover3.setVisible(false);
		} else if (tries == 4) {
			cover4.setVisible(false);
		} else if (tries == 5) {
			cover5.setVisible(false);
		} else if (tries == 6) {
			cover6.setVisible(false);
		} else if (tries == 7) {
			String player1 = lblPlayerOne.getText();
			String player2 = lblPlayerTwo.getText();
			JOptionPane.showMessageDialog(null, player1 + " YOU LOSE!" + "\n" + player2 + " wins!");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAttempt) {
			String Attempt = txtAttempt.getText().substring(0, 1);
			Attempt = Attempt.toLowerCase();
			System.out.println(Attempt);
			String used = lblUsed.getText();

			if (enteredLetters.contains(Attempt)) {
				JOptionPane.showMessageDialog(null, "You have already entered that letter before.");
			} else {
				lblUsed.setText(used += " " + Attempt);
				enteredLetters.add(Attempt);
				Boolean winner = compareWord(Attempt);
				if (winner == false) {
					String player1 = lblPlayerOne.getText();
					JOptionPane.showMessageDialog(null, player1 + " wins!");
				}
			}

			txtAttempt.setText("");
			txtAttempt.requestFocus();
		}

	}

}
