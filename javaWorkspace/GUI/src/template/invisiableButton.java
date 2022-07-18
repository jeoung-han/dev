package template;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class invisiableButton extends JButton {
	
	public invisiableButton() {
		setBorder(null);
		setContentAreaFilled(false);
		setFocusPainted(false);
	}
	
	public invisiableButton(String s) {
		setIcon(new ImageIcon("D:\\dev\\mydev\\javaWorkspace\\GUI\\img\\"+s+".png"));
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setIcon(new ImageIcon("D:\\dev\\mydev\\javaWorkspace\\GUI\\img\\"+s+"Select.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setIcon(new ImageIcon("D:\\dev\\mydev\\javaWorkspace\\GUI\\img\\"+s+".png"));
			}
		});
		
		setBorder(null);
		setContentAreaFilled(false);
		setFocusPainted(false);
	}
}
