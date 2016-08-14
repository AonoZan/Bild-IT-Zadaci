/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package projekat_sedmica_02;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
/**
 * Program that takes credit card as input and calculates if number is valid or not.
 * Program shows calculation of the number using "Luhn check or the Mod 10 check".
 * Result of calculations must be 0 in order to card be valid.
 * When number is inserted in text field and check button is pressed table is generated
 * and status light will show if card is valid. Color on status light are:
 * <br>Green: Card is valid
 * <br>Red: Card is not valid or insufficient amount of digits
 * @author AonoZan
 *
 */
public class App {
	private JFrame frmCheckCreditCard;
	private JTextField textField;
	private JLabel lblStatus;
	private JLabel lblCalc;
	private FlatButton btnStatusButton, btnCheck;
	private CardValidator validator;
	/**
	 * Method to filter all non digit inputs.
	 * @param input
	 * @return
	 */
	private String cleanInput(String input) {
		// if input is empty return null
		if (input == null || input.length() < 1) return "";
		// go over input string and cut all non digit characters
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				input = input.substring(0, i) +
						input.substring(i + 1, input.length());
				i--;
			}
		}
		return input;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmCheckCreditCard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// create basic card validator
		validator = new CardValidator("");
		
		// Frame that holds everything
		frmCheckCreditCard = new JFrame();
		frmCheckCreditCard.getContentPane().setBackground(UIManager.getColor("Button.background"));
		frmCheckCreditCard.setTitle("Check Credit Card Number");
		frmCheckCreditCard.setBackground(Color.WHITE);
		frmCheckCreditCard.setBounds(100, 100, 450, 265);
		frmCheckCreditCard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCheckCreditCard.getContentPane().setLayout(null);
		
		// text field that will hold card number
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);					// center teht horizontaly inside text field
		textField.setBackground(Color.LIGHT_GRAY);									// color text field
		textField.setBounds(10, 195, 226, 20);										// position
		textField.setBorder(null);													// destroy border for "flat style"
		frmCheckCreditCard.getContentPane().add(textField);
		
		lblStatus = new JLabel("Enter credit card number into text field.");	// label that will show table and default text
		lblStatus.setFont(new Font("Lucida Console", Font.PLAIN, 11));			// console font so that table can work (every character equal length)
		lblStatus.setVerticalAlignment(SwingConstants.TOP);						// set alignment
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);					//
		lblStatus.setBounds(10, 11, 414, 109);									// position
		frmCheckCreditCard.getContentPane().add(lblStatus);
		
		lblCalc = new JLabel("");												// label that will contain final calculations
		lblStatus.setFont(new Font("Lucida Console", Font.PLAIN, 11));			// console font
		lblStatus.setVerticalAlignment(SwingConstants.TOP);						// alignment
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);					//
		lblCalc.setBounds(10, 131, 414, 53);									// position
		frmCheckCreditCard.getContentPane().add(lblCalc);
		
		btnStatusButton = new FlatButton("", Color.WHITE, Color.WHITE);			// status button for status light
		btnStatusButton.setEnabled(false);										// set non-clickable									// 
		btnStatusButton.setBounds(246, 195, 55, 20);							// position
		frmCheckCreditCard.getContentPane().add(btnStatusButton);
		
		btnCheck = new FlatButton("Check", Color.WHITE, Color.LIGHT_GRAY);		// check button that trigers calculations
		btnCheck.addMouseListener(new MouseAdapter() {							// mouse listener that trigers acton
			@Override
			public void mouseClicked(MouseEvent arg0) {
				update(textField.getText());									// triger update action
			}
		});
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCheck.setBounds(311, 195, 113, 20);
		frmCheckCreditCard.getContentPane().add(btnCheck);
		
		
		
	}
	/**
	 * Update method that updates whole GUI.
	 * @param input
	 */
	public void update(String input) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// clean text inside text field leave only digits
				textField.setText(cleanInput(input));
				// update validator with input number
				validator.updateStatus(textField.getText());
				// set labels (and make it html because that only works)
				lblStatus.setText("<html>" + validator.getTable().replace("\n", "<br/>") + "</html>");
				lblCalc.setText("<html>" + validator.getCalculations().replace("\n", "<br/>") + "</html>");
				// set status light to appropriate light
				if (validator.isStatus()) {
					btnStatusButton.backgroundColor = Color.GREEN;
					btnStatusButton.hoverColor = Color.GREEN;
					btnStatusButton.setBackground(Color.GREEN);
				} else {
					btnStatusButton.backgroundColor = Color.RED;
					btnStatusButton.hoverColor = Color.RED;
					btnStatusButton.setBackground(Color.RED);
				}
			}
		});
	}
}
