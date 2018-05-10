package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import models.Image;

public class JPanelImages extends JPanel{

	private static final long serialVersionUID = 1L;
	private int rows;
	
	public JPanelImages() {
		setBackground(Color.WHITE);
	}
	
	public void addArrayImageList(ArrayList<ImageIcon> images) {
		System.out.println("2222");
		setRows(images.size() / 5);
		setLayout(new GridLayout(4, rows));
		for (ImageIcon image : images) {
			add(new JPanelImage(image));
		}
		revalidate();
	}

	public void setRows(int rows){
		this.rows = rows;
	}
}