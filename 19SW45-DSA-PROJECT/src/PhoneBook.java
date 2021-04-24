import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.MenuElement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextPane;

public class PhoneBook extends BST {

	private JFrame frame;
	private JPanel ShowAllNumbersPanel;
	private JButton btnAddNumber;
	private JButton btnSearch;
	private JButton btnDelete;
	private JButton ShowAllContactsButton;
	private JPanel EnterNumberPanel;
	private JTextField textFeildNameEnterNumber;
	private JTextField textFieldPhoneEnterNumber;
	private JButton btnMenuEnterNumber;
	private JButton btnClearEnterNumber;
	private JPanel SearchNumberpanel;
	private JTextField textFieldSearchNumber;
	private JLabel lblSearchNumberLabel;
	private JButton btnSearchButton;
	private JButton btnSearchMenu;
	private JPanel DeletePanel;
	private JTextField DeleteNumberTextFeild;
	private JTextPane textPaneShowAllNumbers;
	private JLabel lblDeleteNumberLabel;
	private JButton DeletNumberButton;
	private JButton DeleteMenu;
	private String name;
	private String number;
	private int count = 0;
	private BST b1;

	/**
	 * Create the application.
	 */
	public PhoneBook() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhoneBook window = new PhoneBook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 625, 398);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel MenuPanel = new JPanel();
		MenuPanel.setBackground(new Color(47, 79, 79));
		frame.getContentPane().add(MenuPanel, "name_158657418007735");
		MenuPanel.setLayout(null);

		btnAddNumber = new JButton("Add New Number");
		btnAddNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPanel.setVisible(false);
				EnterNumberPanel.setVisible(true);

			}
		});
		btnAddNumber.setForeground(new Color(0, 0, 0));
		btnAddNumber.setBackground(new Color(255, 255, 224));
		btnAddNumber.setBounds(232, 33, 145, 48);
		MenuPanel.add(btnAddNumber);

		btnSearch = new JButton("search");
		btnSearch.setForeground(new Color(0, 0, 0));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPanel.setVisible(false);
				SearchNumberpanel.setVisible(true);

			}
		});
		btnSearch.setBounds(232, 114, 145, 48);
		MenuPanel.add(btnSearch);

		btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(0, 0, 0));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPanel.setVisible(false);
				DeletePanel.setVisible(true);
			}
		});
		btnDelete.setBounds(232, 195, 145, 48);
		MenuPanel.add(btnDelete);

		ShowAllContactsButton = new JButton("Show All contacts");
		ShowAllContactsButton.setForeground(new Color(0, 0, 0));
		ShowAllContactsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(b1!=null) {
				textPaneShowAllNumbers.setText( b1.preorder() );
				MenuPanel.setVisible(false);
				ShowAllNumbersPanel.setVisible(true);}
				else {
					JOptionPane.showMessageDialog(ShowAllContactsButton, "No contacts to show", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		ShowAllContactsButton.setBounds(232, 276, 145, 48);
		MenuPanel.add(ShowAllContactsButton);

		EnterNumberPanel = new JPanel();
		frame.getContentPane().add(EnterNumberPanel, "name_158660797902875");
		EnterNumberPanel.setLayout(null);

		textFeildNameEnterNumber = new JTextField();
		textFeildNameEnterNumber.setForeground(new Color(0, 0, 0));
		textFeildNameEnterNumber.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		textFeildNameEnterNumber.setBounds(251, 75, 187, 40);
		EnterNumberPanel.add(textFeildNameEnterNumber);
		textFeildNameEnterNumber.setColumns(10);

		textFieldPhoneEnterNumber = new JTextField();
		textFieldPhoneEnterNumber.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		textFieldPhoneEnterNumber.setForeground(new Color(0, 0, 0));
		textFieldPhoneEnterNumber.setBounds(251, 142, 187, 45);
		EnterNumberPanel.add(textFieldPhoneEnterNumber);
		textFieldPhoneEnterNumber.setColumns(10);

		JLabel lblNameLabel = new JLabel("Name");
		lblNameLabel.setForeground(new Color(0, 0, 0));
		lblNameLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNameLabel.setBounds(123, 75, 118, 36);
		EnterNumberPanel.add(lblNameLabel);

		JLabel lblNumberLabel = new JLabel("Phone Number");
		lblNumberLabel.setForeground(new Color(0, 0, 0));
		lblNumberLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNumberLabel.setBounds(123, 144, 118, 36);
		EnterNumberPanel.add(lblNumberLabel);

		JButton btnDoneEnterNumber = new JButton("Done");
		btnDoneEnterNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFeildNameEnterNumber.getText().equals("")) {
					JOptionPane.showMessageDialog(btnDoneEnterNumber, "Please Enter A Name");
				}
				if (textFieldPhoneEnterNumber.getText().equals("")) {
					JOptionPane.showMessageDialog(btnDoneEnterNumber, "Please Enter A Number");
				}
				if (textFieldPhoneEnterNumber.getText().equals("")) {
					
				}
				else {
					
					if (count == 0) {
						b1 = new BST(textFeildNameEnterNumber.getText(), textFieldPhoneEnterNumber.getText() );
						count++;
						JOptionPane.showMessageDialog(btnDoneEnterNumber, "Number Added succesfully");
					} else if (count != 0) {
						b1.insert(textFeildNameEnterNumber.getText(), textFieldPhoneEnterNumber.getText());
						count++;
						JOptionPane.showMessageDialog(btnDoneEnterNumber, "Number Added Succesfully");
					} else {
						JOptionPane.showMessageDialog(btnDoneEnterNumber, "Operation Failed");
					}
				}
			}
		});
		btnDoneEnterNumber.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnDoneEnterNumber.setForeground(new Color(0, 0, 0));
		btnDoneEnterNumber.setBounds(86, 275, 107, 40);
		EnterNumberPanel.add(btnDoneEnterNumber);

		btnMenuEnterNumber = new JButton("Menu");
		btnMenuEnterNumber.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnMenuEnterNumber.setForeground(new Color(0, 0, 0));
		btnMenuEnterNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnterNumberPanel.setVisible(false);
				MenuPanel.setVisible(true);
			}
		});
		btnMenuEnterNumber.setBounds(234, 275, 107, 40);
		EnterNumberPanel.add(btnMenuEnterNumber);

		btnClearEnterNumber = new JButton("Clear");
		btnClearEnterNumber.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnClearEnterNumber.setForeground(new Color(0, 0, 0));
		btnClearEnterNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFeildNameEnterNumber.setText("");
				textFieldPhoneEnterNumber.setText("");
			}
		});
		btnClearEnterNumber.setBounds(382, 275, 107, 40);
		EnterNumberPanel.add(btnClearEnterNumber);

		ShowAllNumbersPanel = new JPanel();
		ShowAllNumbersPanel.setBackground(new Color(128, 0, 128));
		frame.getContentPane().add(ShowAllNumbersPanel, "name_158717348615256");
		ShowAllNumbersPanel.setLayout(null);

		textPaneShowAllNumbers = new JTextPane();
		textPaneShowAllNumbers.setBounds(122, 11, 275, 321);
		ShowAllNumbersPanel.add(textPaneShowAllNumbers);

		JButton btnShowAllMenuButton = new JButton("Menu");
		btnShowAllMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowAllNumbersPanel.setVisible(false);
				MenuPanel.setVisible(true);
			}
		});
		btnShowAllMenuButton.setBounds(401, 266, 97, 44);
		ShowAllNumbersPanel.add(btnShowAllMenuButton);

		SearchNumberpanel = new JPanel();
		frame.getContentPane().add(SearchNumberpanel, "name_167425660391544");
		SearchNumberpanel.setLayout(null);

		textFieldSearchNumber = new JTextField();
		textFieldSearchNumber.setBounds(179, 97, 225, 38);
		SearchNumberpanel.add(textFieldSearchNumber);
		textFieldSearchNumber.setColumns(10);

		lblSearchNumberLabel = new JLabel("Enter Name");
		lblSearchNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSearchNumberLabel.setBounds(23, 97, 131, 38);
		SearchNumberpanel.add(lblSearchNumberLabel);

		btnSearchButton = new JButton("Search");
		btnSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (b1 != null) {
					if (b1.contains( textFeildNameEnterNumber.getText() )) {
						name = (String) b1.retrieve(b1,  textFeildNameEnterNumber.getText() ).value;
						number = textFieldSearchNumber.getText();
						JOptionPane.showMessageDialog(btnSearch, "Name: " + number + "\nNumber:" + name, "Entry Found!",
								0);
					} else {
						JOptionPane.showMessageDialog(btnSearch, "Entry not found");
					}
				} else {
					JOptionPane.showMessageDialog(btnSearch, "Entry not Found");
				}

			}
		});
		btnSearchButton.setBounds(111, 182, 131, 45);
		SearchNumberpanel.add(btnSearchButton);

		btnSearchMenu = new JButton("Menu");
		btnSearchMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchNumberpanel.setVisible(false);
				MenuPanel.setVisible(true);
			}
		});
		btnSearchMenu.setBounds(273, 182, 131, 45);
		SearchNumberpanel.add(btnSearchMenu);

		DeletePanel = new JPanel();
		frame.getContentPane().add(DeletePanel, "name_170532127165812");
		DeletePanel.setLayout(null);

		DeleteNumberTextFeild = new JTextField();
		DeleteNumberTextFeild.setColumns(10);
		DeleteNumberTextFeild.setBounds(211, 80, 225, 38);
		DeletePanel.add(DeleteNumberTextFeild);

		lblDeleteNumberLabel = new JLabel("Enter Name");
		lblDeleteNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDeleteNumberLabel.setBounds(55, 80, 131, 38);
		DeletePanel.add(lblDeleteNumberLabel);

		DeletNumberButton = new JButton("Delete");
		DeletNumberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(b1!=null) {
				if( b1.delete(b1, textFeildNameEnterNumber.getText() )  )
					JOptionPane.showMessageDialog(DeletNumberButton, "Operation Succesfull");
				else
					JOptionPane.showMessageDialog(DeletNumberButton, "Operation Failed");
				}
				else {
					JOptionPane.showMessageDialog(DeletNumberButton, DeleteNumberTextFeild.getText()+" Doesnt Exist", "Operation failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		DeletNumberButton.setBounds(143, 165, 131, 45);
		DeletePanel.add(DeletNumberButton);

		DeleteMenu = new JButton("Menu");
		DeleteMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeletePanel.setVisible(false);
				MenuPanel.setVisible(true);
			}
		});
		DeleteMenu.setBounds(305, 165, 131, 45);
		DeletePanel.add(DeleteMenu);
	}
}
