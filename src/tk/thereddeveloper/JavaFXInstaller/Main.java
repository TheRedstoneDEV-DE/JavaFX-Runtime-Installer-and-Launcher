package tk.thereddeveloper.JavaFXInstaller;

import java.io.File;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		File config = new File("config/javafx-launcher.properties");
		File configDir = new File("config");
		if (!config.exists()) {
			StatusUI.main();
			configDir.mkdirs();
			try {
				config.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			if (args.length > 0) {
				if(args[0].equals("--reconfigure")) {
				ConfigurationUI.open();
				}
			} else {
				Runner.run(ConfigManager.get("FileToRun"), ConfigManager.get("JavaRuntime"));

				if (ConfigManager.get("ViewLog").equals("true")) {
					LogUI.open();
				} else if (Runner.outputerr != "") {
					ErrorUI.open();
				}
			}
		}
	}
}
