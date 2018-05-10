package models;

import java.util.ArrayList;

public class Manager {
	
	private ArrayList<Image> images;

	public Manager(ArrayList<Image> images) {
		this.images = images;
	}
	
	public static Image createImage(String pathImage) {
		return new Image(pathImage);
	}
	
	public void addImage(Image image){
		images.add(image);
	}
	
	public ArrayList<Image> getImageList(){
		return images;
	}
}