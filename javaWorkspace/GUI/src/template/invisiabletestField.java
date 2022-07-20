package template;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class invisiabletestField extends JTextField {
	
	public invisiabletestField(String s) {
		super(s);
		setFont(new Font("굴림", Font.PLAIN, 15));
		setOpaque(false);
		setBorder(null);
	}
	
	public invisiabletestField(LineBorder b) {
		setFont(new Font("굴림", Font.PLAIN, 15));
		setBorder(b);
		setOpaque(false);
	}
	

}
