import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author San Juan, Jean Carlo
 */
public class Input extends JTextField {
    public Input(int x, int y,int w,int h) {
        setFont(new Font("Tahoma", Font.PLAIN, 15));
		setHorizontalAlignment(SwingConstants.CENTER);
		setBounds(x,y,w,h);
		setColumns(10);
    }

    public Number getNumber() {
        var raw = getText();
        try {
            return Double.parseDouble(raw);
        } catch (Exception e) {

        }
        return 0;
    }
}