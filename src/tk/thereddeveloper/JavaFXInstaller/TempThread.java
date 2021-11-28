package tk.thereddeveloper.JavaFXInstaller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.swing.JLabel;

public class TempThread implements Runnable {
	public static String url;

	@Override
	public void run() {
		StatusUI.progressBar.setValue(11);
		try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
				FileOutputStream fileOutputStream = new FileOutputStream("javafx.zip")) {
			byte dataBuffer[] = new byte[1024];
			int bytesRead;
			while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
				fileOutputStream.write(dataBuffer, 0, bytesRead);
			}
		} catch (IOException e) {
			// handle exception
		}
		StatusUI.progressBar.setValue(50);
		StatusUI.lblNewLabel.setText("<html><center>Getting OS and architecture...<br>Downloading JavaFX-SDK...<br>Unpacking JavaFX SDK...</center></html>");
		Zipper.unzip("javafx.zip");
		StatusUI.progressBar.setValue(70);
		StatusUI.lblNewLabel.setText("<html><center>Getting OS and architecture...<br>Downloading JavaFX-SDK...<br>Unpacking JavaFX SDK...<br>Deleting Unnessary Files...</center></html>");
		File oldZip = new File("javafx.zip");
		File sources = new File("libs/javafx-sdk-17.0.1/src.zip");
		oldZip.delete();
		sources.delete();
		StatusUI.lblNewLabel.setText("<html><center>Getting OS and architecture...<br>Downloading JavaFX-SDK...<br>Unpacking JavaFX SDK...<br>Deleting Unnessary Files...<br>Done.</center></html>");
		StatusUI.progressBar.setValue(100);
		StatusUI.frmJavafxAutoinstall.dispose();
		ConfigurationUI.open();
		
	}

}
