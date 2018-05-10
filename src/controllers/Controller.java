package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import models.Manager;
import persistence.FileManager;
import views.MainWindow;

public class Controller implements ActionListener{

	private FileManager fileManager;
	private Manager manager;
	private MainWindow mainWindow;

	public Controller() throws IOException {
		String image = JOptionPane.showInputDialog(null, "Search", "WallpapersDownload v1.0", JOptionPane.DEFAULT_OPTION);
		fileManager = new FileManager();
		fileManager.downloadFile(image);
		
		fileManager.readPlayer();
		fileManager.addImageFilter();
		System.out.println("cargar");
		mainWindow = new MainWindow(this);
		System.out.println("main");
//		mainWindow.setImages(fileManager.getImageList());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case FILTER:
			System.out.println("Filter");
			break;
		default:
			break;
		}
	}
}