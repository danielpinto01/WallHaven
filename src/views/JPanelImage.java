package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Image;

public class JPanelImage extends JPanel{

	private static final long serialVersionUID = 1L;

	public JPanelImage(Image image) {
		setLayout(new GridLayout(1, 1));
		setBackground(Color.WHITE);

		try {
			ImageIcon icon = new ImageIcon(new URL(image.getPathImage()));
			add(new JLabel(icon));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}