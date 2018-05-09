package persistence;

import java.io.BufferedInputStream;
import java.io.File;
import java.net.InetSocketAddress;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class FileManager {

	public static final String URL_PAGE = "https://www.pexels.com/search/";
	public static final String FOLDER = "src/files";
	public static final File FILE = new File("src/files/file.txt");

	public void readFile(String search) throws IOException {
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.73", 8080));
//		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.73", 8080));
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
	}

	public static void main(String[] args) {
		FileManager fileManager = new FileManager();
		try {
			fileManager.readFile("internet");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
