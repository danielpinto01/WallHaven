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

	public MainWindow(Controller controller) {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		setTitle("WallpapersDownload v1.0");
		setIconImage(new ImageIcon("src/images/icon.png").getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);		
		setLocationRelativeTo(null);
		
		jPanelImages = new JPanelImages();
		add(jPanelImages, BorderLayout.CENTER);
		
		btnFilter = new JButton("Filter");
		btnFilter.setActionCommand(Events.FILTER.toString());
		btnFilter.addActionListener(controller);
		add(btnFilter, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public void setImages(ArrayList<ImageIcon> imagesFilter) {
		System.out.println("11111");
		jPanelImages.addArrayImageList(imagesFilter);
		revalidate();
	}
	
}