package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import models.Image;

public class JPanelImages extends JPanel{

	private static final long serialVersionUID = 1L;
	private int rows;
	
	public JPanelImages(ArrayList<Image> images) {
		setBackground(Color.WHITE);
		setRows(images.size() / 5);
		setLayout(new GridLayout(4, rows));
		for (Image image : images) {
			add(new JPanelImage(image));
		}
	}

	public void setRows(int rows){
		this.rows = rows;
	}
}