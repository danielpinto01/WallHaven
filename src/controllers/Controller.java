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
	@SuppressWarnings("unused")
	private MainWindow mainWindow;

	public Controller() {
		String image = JOptionPane.showInputDialog(null, "Search", "WallpapersDownload v1.0", JOptionPane.DEFAULT_OPTION);
		fileManager = new FileManager();
		try {
			fileManager.downloadFile(image);
			manager = new Manager(fileManager.readPlayer());
			fileManager.addImageFilter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mainWindow = new MainWindow(this, manager.getImageList());
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