package tk.thereddeveloper.JavaFXInstaller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;

public class ConfigManager {
	 static Properties prop =  new Properties();
	 static void set(String Pname, String content) {
		
			try {
				load();
				OutputStream out = new FileOutputStream("config/javafx-launcher.properties");
				
				prop.setProperty(Pname, content);
				prop.store(out, "");
				System.out.println(prop);
				} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 static String get(String Pname) {
		 load();
		 return prop.getProperty(Pname);
	 }
	 static void load() {
		 try {
		 InputStream in = new FileInputStream("config/javafx-launcher.properties");
		 prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 static String getCfgEntryFromURL(String url, String entry) {
		 Properties prop2 =  new Properties();
		 try {
		 BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
		 prop2.load(in);
		 
		 }catch(IOException ioe) {
			 
		 }
		 return prop2.getProperty(entry);
	 }
}
