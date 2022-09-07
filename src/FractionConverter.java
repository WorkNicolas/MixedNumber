import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Mariano, Charimel
 * @author Mendoza, Carl Nicolas
 */
public class FractionConverter extends JFrame implements ActionListener {

	private JPanel lower = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
	private JPanel upper = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
	private JLabel lblNewLabel = new JLabel("/");
	private JTextField txtNumerator = new JTextField("");
	private JTextField txtDenominator = new JTextField();
	private String resultText = "Result:";
	private JLabel lblFraction = new JLabel("");
	private JLabel lblResult = new JLabel(resultText);
	private JButton convertNumber = new JButton("Convert");
	private JButton convertImproper = new JButton("Convert");
	private JTextField number = new JTextField();;
	private JLabel lblNumber = new JLabel("Number:");

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
		setBounds(100, 100, 400, 170);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		add(upper);
		add(lower);
		lower.setBorder(new EmptyBorder(5, 5, 5, 5));
		number.setMargin(new Insets(5, 5, 5, 5));
		number.setColumns(10);
		upper.add(lblNumber);
		upper.add(number);
		convertNumber.addActionListener(this);
		upper.add(convertNumber);
		txtNumerator.setMargin(new Insets(5, 5, 5, 5));
		txtNumerator.setColumns(10);
		lower.add(txtNumerator);

		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lower.add(lblNewLabel);

		txtDenominator.setMargin(new Insets(5, 5, 5, 5));
		txtDenominator.setColumns(10);
		lower.add(txtDenominator);

		convertImproper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MixedNumber mn = new MixedNumber(Double.parseDouble(txtNumerator.getText()),
							Double.parseDouble(txtDenominator.getText()));
					lblFraction.setText(mn.toString());
				} catch (NullPointerException npe) {
					lblFraction.setText("");
				} catch (NumberFormatException nfe) {
					lblFraction.setText("");
				} catch (ArithmeticException ae) {
					lblFraction.setText("");
				}
			}
		});
		lower.add(convertImproper);
		lblFraction.setPreferredSize(new Dimension(40, 20));
		lower.add(lblResult);
		lower.add(lblFraction);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double d = 0;
		try {
			d = Double.parseDouble(number.getText());

		} catch (Exception ex) {
			return;
		}
		var m = new MixedNumber(d);
		lblFraction.setText(m.toString());
	}
}
