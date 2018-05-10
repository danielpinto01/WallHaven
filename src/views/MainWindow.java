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
		
		init(controller, images);
		
		setVisible(true);
	}
	
	public MainWindow(Controller controller) {
		setLayout(new BorderLayout());
		setBackground(Color.BLUE);
		setTitle("WallpapersDownload v1.0");
		setIconImage(new ImageIcon("src/images/icon.png").getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);		
		setLocationRelativeTo(null);
		
		btnFilter = new JButton("Filter");
		btnFilter.setActionCommand(Events.FILTER.toString());
		btnFilter.addActionListener(controller);
		add(btnFilter, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public void init(Controller controller, ArrayList<Image> images) {
		jPanelImages = new JPanelImages(images);
		add(jPanelImages, BorderLayout.CENTER);
		
		btnFilter = new JButton("Filter");
		btnFilter.setActionCommand(Events.FILTER.toString());
		btnFilter.addActionListener(controller);
		add(btnFilter, BorderLayout.SOUTH);
	}
	
	public void deleteImages() {
		jPanelImages.removeAll();
	}
}