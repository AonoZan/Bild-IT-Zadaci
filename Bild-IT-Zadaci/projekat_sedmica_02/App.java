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

public class App {
	private JFrame frmCheckCreditCard;
	private JTextField textField;
	/**
	 * Method to filter all non digit inputs.
	 * @param input
	 * @return
	 */
	private String cleanInput(String input) {
		if (input == null || input.length() < 1) return "";
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
		CardValidator validator = new CardValidator("");
		
		frmCheckCreditCard = new JFrame();
		frmCheckCreditCard.getContentPane().setBackground(UIManager.getColor("Button.background"));
		frmCheckCreditCard.setTitle("Check Credit Card Number");
		frmCheckCreditCard.setBackground(Color.WHITE);
		frmCheckCreditCard.setBounds(100, 100, 450, 265);
		frmCheckCreditCard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCheckCreditCard.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(10, 195, 226, 20);
		textField.setBorder(null);
		frmCheckCreditCard.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblStatus = new JLabel("Enter credit card number into text field.");
		lblStatus.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		lblStatus.setVerticalAlignment(SwingConstants.TOP);
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setBounds(10, 11, 414, 109);
		frmCheckCreditCard.getContentPane().add(lblStatus);
		
		JLabel lblCalc = new JLabel("");
		lblStatus.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		lblStatus.setVerticalAlignment(SwingConstants.TOP);
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblCalc.setBounds(10, 131, 414, 53);
		frmCheckCreditCard.getContentPane().add(lblCalc);
		
		FlatButton btnStatusButton = new FlatButton("", Color.WHITE, Color.WHITE);
		btnStatusButton.setEnabled(false);
		btnStatusButton.setBounds(246, 195, 55, 20);
		frmCheckCreditCard.getContentPane().add(btnStatusButton);
		
		FlatButton btnCheck = new FlatButton("Check", Color.WHITE, Color.LIGHT_GRAY);
		btnCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				update(textField.getText(), validator, lblStatus, lblCalc, btnStatusButton);
			}
		});
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCheck.setBounds(311, 195, 113, 20);
		frmCheckCreditCard.getContentPane().add(btnCheck);
		
		
		
	}
	public void update(String input, CardValidator validator, JLabel label, JLabel calc, FlatButton status) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				textField.setText(cleanInput(input));
				validator.updateStatus(textField.getText());
				label.setText("<html>" + validator.getTable().replace("\n", "<br/>") + "</html>");
				calc.setText("<html>" + validator.getCalculations().replace("\n", "<br/>") + "</html>");
				if (validator.isStatus()) {
					status.backgroundColor = Color.GREEN;
					status.setBackground(Color.GREEN);
					status.hoverColor = Color.GREEN;
				} else {
					status.backgroundColor = Color.RED;
					status.setBackground(Color.RED);
					status.hoverColor = Color.RED;
				}
			}
		});
	}
}
