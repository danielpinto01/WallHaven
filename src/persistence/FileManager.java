package persistence;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
//import java.io.PrintWriter;
//import java.net.InetSocketAddress;
//import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import models.Image;
import models.Manager;

public class FileManager {

	public static final String URL_PAGE = "http://wallpaperswide.com/search.html?q=";
	public static final String FOLDER = "src/files";
	public static final File FILE = new File("src/files/file.txt");
	public static final String READ_FILE = "src/files/file.txt";
	private static final String REGULAR_PHRASE = "http://([\\w\\\\.\\d\\/\\-])+.jpg";

	private BufferedReader bufferedReader;

	/*public void downloadFileTwo(String image) throws IOException {
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.73", 8080));
		URL url = new URL(URL_PAGE + image); 
		URLConnection connection = url.openConnection(proxy);
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
		BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
		int ch;
		PrintWriter printWriter = new PrintWriter(FILE);
		while ((ch = in.read()) != -1) {
			printWriter.append((char) ch);
		}
		printWriter.close();
	}*/

	public void downloadFile(String image) throws IOException {
		URLConnection website = new URL(URL_PAGE + image).openConnection();
		website.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
		try (InputStream in = website.getInputStream()) {
			Files.copy(in, Paths.get("src/files/file.txt"), StandardCopyOption.REPLACE_EXISTING);
		}
	}

	public ArrayList<Image> readPlayer() throws IOException {
		ArrayList<Image> imageList = new ArrayList<>();
		File file = new File ("src/files/file.txt");
		FileReader fileReader = new FileReader (file);
		bufferedReader = new BufferedReader(fileReader);

		String line = bufferedReader.readLine();
		int count = 0;

		String pattern = REGULAR_PHRASE;
		String pathImage = "";

		while((line=bufferedReader.readLine())!=null) {
			count++;
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(line);
			if (m.find()) {
				pathImage = m.group();
				System.out.println(count + " - " + m.group());
				imageList.add(Manager.createImage(pathImage));
				downloadsImages(imageList);
			}
		}
		return imageList;
	}



	public void downloadsImages(ArrayList<Image> list) throws IOException {
		int count = 0;
		for (Image image : list) {
			count++;
			URL url = new URL(image.getPathImage());
			InputStream in = new BufferedInputStream(url.openStream());
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int n = 0;
			while (-1!=(n=in.read(buf))){
				out.write(buf, 0, n);
			}
			out.close();
			in.close();
			byte[] response = out.toByteArray();

			FileOutputStream fos = new FileOutputStream("images/"  +count + ".jpg");
			fos.write(response);
			fos.close();
		}
	}

	public void addImageFilter() throws IOException {
		File[] imgFiles = new File("images/").listFiles();
		for (File file : imgFiles) {
			System.out.println(file.getPath());
			addFilterToImage(file, ImageIO.read(file));
		}
	}

	public void addFilterToImage(File file, BufferedImage bufferedImage) throws IOException {
		for (int i = 0; i < bufferedImage.getWidth(); i++) {
			for (int j = 0; j < bufferedImage.getHeight(); j++) {
				Color c1=new Color(bufferedImage.getRGB(i, j));
				int med=(c1.getRed()+c1.getGreen()+c1.getBlue())/3;
				bufferedImage.setRGB(i, j, new Color(med,med,med).getRGB());
			}
		}
		ImageIO.write(bufferedImage, "jpg", new File("imagesFilter/" + file.getName()));
	}

	/*public static void main(String[] args) {
		FileManager fileManager = new FileManager();

		try {
			FileManager.downloadFile("love");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			fileManager.readPlayer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
}