package tk.thereddeveloper.JavaFXInstaller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JProgressBar;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;

public class StatusUI {

	public static JFrame frmJavafxAutoinstall;
	public static JProgressBar progressBar = new JProgressBar();
	public static JLabel lblNewLabel = new JLabel("Installer is ready to start...");

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatusUI window = new StatusUI();
					window.frmJavafxAutoinstall.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StatusUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJavafxAutoinstall = new JFrame();
		frmJavafxAutoinstall.setTitle("JavaFX Autoinstall");
		frmJavafxAutoinstall.setBounds(100, 100, 450, 174);
		frmJavafxAutoinstall.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJavafxAutoinstall.getContentPane().setLayout(new BorderLayout(0, 0));

		JLabel lblSoftwaredependencies = new JLabel("<html><u>JavaFX automated Installer</u></html>");
		lblSoftwaredependencies.setFont(new Font("Arial", Font.BOLD, 16));
		lblSoftwaredependencies.setHorizontalAlignment(SwingConstants.CENTER);
		frmJavafxAutoinstall.getContentPane().add(lblSoftwaredependencies, BorderLayout.NORTH);

		progressBar.setStringPainted(true);
		frmJavafxAutoinstall.getContentPane().add(progressBar, BorderLayout.SOUTH);

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmJavafxAutoinstall.getContentPane().add(lblNewLabel, BorderLayout.CENTER);

		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNewButton.setVisible(false);
				lblNewLabel.setText("<html><center>Getting OS and architecture...</center></html>");
				String url = "";
				// String
				// url="http://localhost:8080/openjfx-17.0.1_linux-x64_bin-sdk.zip?type=resource";
				if (System.getProperty("os.name").equals("Linux")) {
					if (System.getProperty("os.arch").equals("amd64")) {
						url = "https://download2.gluonhq.com/openjfx/17.0.1/openjfx-17.0.1_linux-x64_bin-sdk.zip";
					} else if (System.getProperty("os.arch").equals("arm64")) {
						// Comming Soon!
					} else if (System.getProperty("os.arch").equals("arm32")) {
						url = "https://download2.gluonhq.com/openjfx/17.0.1/openjfx-17.0.1_linux-arm32_bin-sdk.zip";
					} else if (System.getProperty("os.arch").equals("i386")) {
						// Comming Soon!
					} else if (System.getProperty("os.arch").equals("aarch64")) {
						url = "https://download2.gluonhq.com/openjfx/17.0.1/openjfx-17.0.1_linux-arm32_bin-sdk.zip";
					}

				} else if (System.getProperty("os.name").equals("Windows 10")) {
					if (System.getProperty("os.arch").equals("amd64")) {
						url = "https://download2.gluonhq.com/openjfx/17.0.1/openjfx-17.0.1_windows-x64_bin-sdk.zip";
						System.out.println("BP-1");
					} else if (System.getProperty("os.arch").equals("arm64")) {
						// Comming Soon!
					} else if (System.getProperty("os.arch").equals("arm32")) {
						// Comming Soon!
					} else if (System.getProperty("os.arch").equals("i386")) {
						url = "https://download2.gluonhq.com/openjfx/17.0.1/openjfx-17.0.1_windows-x86_bin-sdk.zip";

					}
					progressBar.setValue(10);
				}
				lblNewLabel.setText(
						"<html><center>Getting OS and architecture...<br>Downloading JavaFX-SDK...</center></html>");
				TempThread tmpthr = new TempThread();
				tmpthr.url = url;
				Thread thr = new Thread(tmpthr);
				thr.start();
			}
		});
		frmJavafxAutoinstall.getContentPane().add(btnNewButton, BorderLayout.EAST);
	}

}
