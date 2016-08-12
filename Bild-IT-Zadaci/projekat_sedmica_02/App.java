/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package projekat_sedmica_02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import java.awt.TextField;
import java.awt.Label;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.TextArea;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App {
	public static java.util.Scanner userInput = new java.util.Scanner(System.in);
	private JFrame frmCheckCreditCard;
	private JTextField textField;

	public static void closeUserInput() {
		userInput.close();
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
		frmCheckCreditCard = new JFrame();
		frmCheckCreditCard.getContentPane().setBackground(UIManager.getColor("Button.background"));
		frmCheckCreditCard.setTitle("Check Credit Card Number");
		frmCheckCreditCard.setBackground(Color.WHITE);
		frmCheckCreditCard.setBounds(100, 100, 450, 170);
		frmCheckCreditCard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCheckCreditCard.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(10, 100, 226, 20);
		textField.setBorder(null);
		frmCheckCreditCard.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("Enter credit card number into text field.");
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.PLAIN, 11));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 11, 414, 78);
		frmCheckCreditCard.getContentPane().add(lblNewLabel);
		
		FlatButton btnStatusButton = new FlatButton("Valid", Color.WHITE, Color.WHITE);
		btnStatusButton.setBounds(246, 100, 55, 20);
		frmCheckCreditCard.getContentPane().add(btnStatusButton);
		
		FlatButton btnCheck = new FlatButton("Check", Color.WHITE, Color.LIGHT_GRAY);
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCheck.setBounds(311, 100, 113, 20);
		frmCheckCreditCard.getContentPane().add(btnCheck);
	}
}
