package controllers;

import views.MainWindow;

public class Controller {
	
	private MainWindow mainWindow;
	
	public Controller() {
		mainWindow = new MainWindow(this);
	}
}