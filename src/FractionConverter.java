import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * @author Mariano, Charimel
 */
public class FractionConverter extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtNumerator;
	private JTextField txtDenominator;
	private JLabel lblResult;
	private JLabel lblNumerator;
	private JLabel lblDenominator;
	private JButton btnNewButton;
	private JLabel lblSlash;
	
	Fraction F = new Fraction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FractionConverter frame = new FractionConverter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FractionConverter() {
		setResizable(false);
		setTitle("Mixed Fraction Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 147);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtNumerator = new JTextField("");
		txtNumerator.setMargin(new Insets(5, 5, 5, 5));
		txtNumerator.setColumns(10);
		contentPane.add(txtNumerator);
		
		lblNewLabel = new JLabel("/");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblNewLabel);
		
		txtDenominator = new JTextField();
		txtDenominator.setMargin(new Insets(5, 5, 5, 5));
		txtDenominator.setColumns(10);
		contentPane.add(txtDenominator);
		
		btnNewButton = new JButton("Convert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MixedNumber mn = new MixedNumber(Double.parseDouble(txtNumerator.getText()),
							Double.parseDouble(txtDenominator.getText()));
					lblNumerator.setText(mn.toString());
				} catch (NullPointerException npe) {
					lblNumerator.setText("");
				} catch (NumberFormatException nfe) {
					lblNumerator.setText("");
				} catch (ArithmeticException ae) {
					lblNumerator.setText("");
				}
			}
		});
		contentPane.add(btnNewButton);
		
		lblResult = new JLabel("Result:");
		lblResult.setPreferredSize(new Dimension(40, 20));
		contentPane.add(lblResult);
		
		lblNumerator = new JLabel("");
		contentPane.add(lblNumerator);
		
		lblSlash = new JLabel("/");
		contentPane.add(lblSlash);
		lblSlash.setVisible(false);
		
		
		lblDenominator = new JLabel("");
		contentPane.add(lblDenominator);
	}

}
