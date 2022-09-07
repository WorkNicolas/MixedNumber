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


/** 
 * @author Banez, Roxanne
 * @author Solano, Ralph
 * @author San Juan, Jean Carlo
 * @version 9/7/2022
 */
public class MixedCalculator extends JFrame {

	private Input fraction1Whole;
	private Input fraction1Num;
	private Input fraction1Den;
	private Input fraction2Whole;
	private Input fraction2Num;
	private Input fraction2Den;
	private JTextField outputText;
	private JButton buttonSubtract;
	private JButton buttonMultiply;
	private JButton buttonDivide;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private enum OPS {
		ADD,
		SUBTRACT,
		DIVIDE,
		MULTIPLY
	}
	private OPS op = OPS.ADD;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MixedCalculator window = new MixedCalculator();
					window.setVisible(true);
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
		setAutoRequestFocus(false);
		setBounds(100, 100, 451, 249);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		var pane = getContentPane();
		pane.setLayout(null);
		fraction1Whole = new Input(25,52, 50, 50);
		pane.add(fraction1Whole);
		
		fraction1Num = new Input(84, 32, 50, 50);
		pane.add(fraction1Num);
		
		fraction1Den = new Input(85, 91, 50, 50);
		pane.add(fraction1Den);
		
		fraction2Whole = new Input(164, 52, 50, 50);
		pane.add(fraction2Whole);
		
		fraction2Num = new Input(223, 32, 50, 50);
		pane.add(fraction2Num);
	
		fraction2Den = new Input(224, 91, 50, 50);
		pane.add(fraction2Den);

		JToggleButton calculate = new JToggleButton("CALCULATE");
		calculate.setBounds(311, 122, 114, 29);
		pane.add(calculate);
		calculate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MixedNumber a =  new MixedNumber(fraction1Whole.getNumber(), fraction1Num.getNumber(), fraction1Den.getNumber());
				MixedNumber b =  new MixedNumber(fraction2Whole.getNumber(), fraction2Num.getNumber(), fraction2Den.getNumber());
				MixedNumber c;
				switch (op) {
					case ADD:
						c = a.add(b);
					break;
					case SUBTRACT:
						c =  a.subtract(b);
					break;
					case MULTIPLY:
						c =  a.multiply(b);
					break;
					default:
						c =  a.divide(b);
					break;
				}

				outputText.setText(c.toString());
			}
		});
		
		JLabel lblNewLabel = new JLabel("=");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(289, 74, 26, 37);
		pane.add(lblNewLabel);
		
		outputText = new JTextField();
		outputText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		outputText.setHorizontalAlignment(SwingConstants.CENTER);
		outputText.setBounds(318, 66, 107, 50);
		pane.add(outputText);
		outputText.setColumns(10);
		
		JButton buttonAdd = new JButton("+");
		buttonAdd.setFont(new Font("Tahoma", Font.PLAIN, 36));
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonAdd.setBounds(10, 152, 68, 50);
		pane.add(buttonAdd);
		buttonAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				op = OPS.ADD;
			}
		});
		buttonSubtract = new JButton("-");
		buttonSubtract.setFont(new Font("Tahoma", Font.PLAIN, 36));
		buttonSubtract.setBounds(80, 152, 68, 50);
		pane.add(buttonSubtract);
		buttonSubtract.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				op = OPS.SUBTRACT;
			}
		});
		buttonMultiply = new JButton("*");
		buttonMultiply.setFont(new Font("Tahoma", Font.PLAIN, 36));
		buttonMultiply.setBounds(150, 152, 68, 50);
		pane.add(buttonMultiply);
		buttonMultiply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				op = OPS.MULTIPLY;
			}
		});
		buttonDivide = new JButton("/");
		buttonDivide.setFont(new Font("Tahoma", Font.PLAIN, 36));
		buttonDivide.setBounds(220, 152, 68, 50);
		pane.add(buttonDivide);
		buttonDivide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				op = OPS.DIVIDE;
			}
		});
		lblNewLabel_1 = new JLabel("First Fraction:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(25, 11, 109, 23);
		pane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Second Fraction:");
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(160, 11, 128, 23);
		pane.add(lblNewLabel_2);
	}
}
