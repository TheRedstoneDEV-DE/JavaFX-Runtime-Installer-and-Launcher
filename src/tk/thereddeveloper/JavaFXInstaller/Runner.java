package tk.thereddeveloper.JavaFXInstaller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
	public static String output = "";
	public static String outputerr = "";
	public static void run(String filename,String RuntimePath) {
		try {
		ProcessBuilder pb = new ProcessBuilder(RuntimePath,"--module-path","libs/javafx-sdk-17.0.1/lib/","--add-modules","javafx.controls,javafx.fxml","-jar",filename);
		Process p;
		
		p = pb.start();
		
		p.waitFor();
		BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
		BufferedReader berr = new BufferedReader(new InputStreamReader(p.getErrorStream()));

		String line;
		while ((line = b.readLine()) != null) {
			output=output + line +"<br>";
		}
		
		while ((line = berr.readLine()) != null) {
			outputerr=outputerr + line+"<br>";
		}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
