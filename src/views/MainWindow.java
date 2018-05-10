package views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controllers.Controller;

public class MainWindow extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public MainWindow(Controller controller) {
		setLayout(new BorderLayout());
		setBackground(Color.BLUE);
		setTitle("WallpapersDownload v1.0");
		setIconImage(new ImageIcon("src/images/icon.png").getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);		
		setLocationRelativeTo(null);
		setFocusable(true);
		setVisible(true);
	}
}