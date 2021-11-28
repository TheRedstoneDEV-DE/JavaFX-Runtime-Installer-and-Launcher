package tk.thereddeveloper.JavaFXInstaller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class HelpUI {

	private JFrame frmHelp;

	/**
	 * Launch the application.
	 */
	public static void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpUI window = new HelpUI();
					window.frmHelp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HelpUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHelp = new JFrame();
		frmHelp.setTitle("Help");
		frmHelp.setBounds(100, 100, 450, 180);
		frmHelp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("<html><center>The Java Runtime in usually located in:<br>\nOn Linux: /usr/lib/jvm/java-11-openjdk-amd64/bin/java<br>\nOn Windows: C:\\Programs\\jvm\\jdk-11\\bin\\java.exe<br>\nIf you are not sure, then just leave it as default!</center></html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmHelp.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
	}

}
