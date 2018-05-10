package views;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelImage extends JPanel{

	private static final long serialVersionUID = 1L;

	public JPanelImage(ImageIcon image) {
		setLayout(new GridLayout(1, 1));
		setBackground(Color.WHITE);

		add(new JLabel(image));
	}
}