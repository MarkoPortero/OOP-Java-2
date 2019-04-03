import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Rules extends JFrame {
	private JLabel lblTitle;
	private JTextArea txtArea;
	private JScrollPane jsp;
	private Container cn;
	Scanner file;
	String words;

	public Rules() {
		

		cn = getContentPane();
		cn.setLayout(null); // Absolute Layout Manager

		lblTitle = new JLabel("Hangman Rules");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
		lblTitle.setBounds(10, 20, 300, 50);
		cn.add(lblTitle);

		txtArea = new JTextArea(200, 1000);
		txtArea.setFont(new Font("Lucida Console", Font.PLAIN, 12));

		jsp = new JScrollPane(txtArea);
		jsp.setBounds(10, 120, 1000,800);

		cn.add(jsp);
		txtArea.setEditable(false);
		display();
	}

	public void display() {

		try (BufferedReader br = new BufferedReader(new FileReader(new File("rules.txt")))) {
			txtArea.read(br, "File");
		} catch (IOException exp) {
			exp.printStackTrace();
		}
	}
}
