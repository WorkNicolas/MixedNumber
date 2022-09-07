import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.JToggleButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MixedCalculator {

	private JFrame frame;
	private JTextField fraction1text1;
	private JTextField fraction1text2;
	private JTextField fraction1text3;
	private JTextField fraction2text1;
	private JTextField fraction2text2;
	private JTextField fraction2text3;
	private JTextField outputText;
	private JButton buttonSubtract;
	private JButton buttonMultiply;
	private JButton buttonDivide;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MixedCalculator window = new MixedCalculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MixedCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.setBounds(100, 100, 451, 249);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		fraction1text1 = new JTextField();
		fraction1text1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fraction1text1.setHorizontalAlignment(SwingConstants.CENTER);
		fraction1text1.setBounds(25, 52, 50, 50);
		frame.getContentPane().add(fraction1text1);
		fraction1text1.setColumns(10);
		
		fraction1text2 = new JTextField();
		fraction1text2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fraction1text2.setHorizontalAlignment(SwingConstants.CENTER);
		fraction1text2.setColumns(10);
		fraction1text2.setBounds(84, 32, 50, 50);
		frame.getContentPane().add(fraction1text2);
		
		fraction1text3 = new JTextField();
		fraction1text3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fraction1text3.setHorizontalAlignment(SwingConstants.CENTER);
		fraction1text3.setColumns(10);
		fraction1text3.setBounds(85, 91, 50, 50);
		frame.getContentPane().add(fraction1text3);
		
		JToggleButton buttonCalculate = new JToggleButton("CALCULATE");
		buttonCalculate.setBounds(311, 122, 114, 29);
		frame.getContentPane().add(buttonCalculate);
		
		fraction2text1 = new JTextField();
		fraction2text1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fraction2text1.setHorizontalAlignment(SwingConstants.CENTER);
		fraction2text1.setColumns(10);
		fraction2text1.setBounds(164, 52, 50, 50);
		frame.getContentPane().add(fraction2text1);
		
		fraction2text2 = new JTextField();
		fraction2text2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fraction2text2.setHorizontalAlignment(SwingConstants.CENTER);
		fraction2text2.setColumns(10);
		fraction2text2.setBounds(223, 32, 50, 50);
		frame.getContentPane().add(fraction2text2);
		
		fraction2text3 = new JTextField();
		fraction2text3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fraction2text3.setHorizontalAlignment(SwingConstants.CENTER);
		fraction2text3.setColumns(10);
		fraction2text3.setBounds(224, 91, 50, 50);
		frame.getContentPane().add(fraction2text3);
		
		JLabel lblNewLabel = new JLabel("=");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(289, 74, 26, 37);
		frame.getContentPane().add(lblNewLabel);
		
		outputText = new JTextField();
		outputText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		outputText.setHorizontalAlignment(SwingConstants.CENTER);
		outputText.setBounds(318, 66, 107, 50);
		frame.getContentPane().add(outputText);
		outputText.setColumns(10);
		
		JButton buttonAdd = new JButton("+");
		buttonAdd.setFont(new Font("Tahoma", Font.PLAIN, 36));
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonAdd.setBounds(10, 152, 68, 50);
		frame.getContentPane().add(buttonAdd);
		
		buttonSubtract = new JButton("-");
		buttonSubtract.setFont(new Font("Tahoma", Font.PLAIN, 36));
		buttonSubtract.setBounds(80, 152, 68, 50);
		frame.getContentPane().add(buttonSubtract);
		
		buttonMultiply = new JButton("*");
		buttonMultiply.setFont(new Font("Tahoma", Font.PLAIN, 36));
		buttonMultiply.setBounds(150, 152, 68, 50);
		frame.getContentPane().add(buttonMultiply);
		
		buttonDivide = new JButton("/");
		buttonDivide.setFont(new Font("Tahoma", Font.PLAIN, 36));
		buttonDivide.setBounds(220, 152, 68, 50);
		frame.getContentPane().add(buttonDivide);
		
		lblNewLabel_1 = new JLabel("First Fraction:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(25, 11, 109, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Second Fraction:");
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(160, 11, 128, 23);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
