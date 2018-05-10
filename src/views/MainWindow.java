package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import controllers.Controller;
import controllers.Events;
import models.Image;

public class MainWindow extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanelImages jPanelImages;
	private JButton btnFilter;

	public MainWindow(Controller controller, ArrayList<Image> images) {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		setTitle("WallpapersDownload v1.0");
		setIconImage(new ImageIcon("src/images/icon.png").getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);		
		setLocationRelativeTo(null);
		
		jPanelImages = new JPanelImages(images);
		add(jPanelImages, BorderLayout.CENTER);

		btnFilter = new JButton("Filter");
		btnFilter.setActionCommand(Events.FILTER.toString());
		btnFilter.addActionListener(controller);
		btnFilter.setBackground(Color.DARK_GRAY);
		btnFilter.setForeground(Color.WHITE);
		add(btnFilter, BorderLayout.NORTH);
		
		setVisible(true);
	}
	
	public void deleteImages(ArrayList<Image> images) {
		jPanelImages.loadImage(images);
		revalidate();
	}
}