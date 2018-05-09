package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager {

	public static final String URL_PAGE = "https://www.pexels.com/search/";
	public static final String FOLDER = "src/files";
	public static final File FILE = new File("src/files/file.txt");
	public static final String READ_FILE = "src/files/file.txt";
	private static final String REGULAR_PHRASE = "https://([\\w\\\\.\\d\\/\\-])+.jpeg";
	
	private BufferedReader bufferedReader;

	/*public void readFile(String search) throws IOException {
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.73", 8080));
		URL url = new URL(URL_PAGE + search + "/"); 
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

	public ArrayList<String> readPlayer() throws IOException {
		ArrayList<String> imageList = new ArrayList<>();
		File file = new File (READ_FILE);
		FileReader fileReader = new FileReader (file);
		bufferedReader = new BufferedReader(fileReader);

		String line = bufferedReader.readLine();
		String pattern = REGULAR_PHRASE;
		String pathImage = "";

		while((line=bufferedReader.readLine())!=null) {
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(line);
			if (m.find()) {
				pathImage = m.group();
				imageList.add(pathImage);
			}
		}
		System.out.println(imageList);
		return imageList;
	}

	public static void main(String[] args) {
		FileManager fileManager = new FileManager();
		try {
			fileManager.readPlayer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
