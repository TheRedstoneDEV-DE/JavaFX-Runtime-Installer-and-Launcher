package tk.thereddeveloper.JavaFXInstaller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class LogUI {

	private JFrame frmLogs;

	/**
	 * Launch the application.
	 */
	public static void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogUI window = new LogUI();
					window.frmLogs.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogs = new JFrame();
		frmLogs.setTitle("Logs");
		frmLogs.setBounds(100, 100, 450, 300);
		frmLogs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frmLogs.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane.setLeftComponent(scrollPane_1);
		
		JTextPane txtpnMessageLog = new JTextPane();
		scrollPane.setViewportView(txtpnMessageLog);
		txtpnMessageLog.setContentType("text/html");
		txtpnMessageLog.setEditable(false);
		txtpnMessageLog.setText("<html>Message Log: <br>"+Runner.output+"</html>");
		
		JTextPane txtpnErrorLog = new JTextPane();
		scrollPane_1.setViewportView(txtpnErrorLog);
		txtpnErrorLog.setContentType("text/html");
		txtpnErrorLog.setEditable(false);
		txtpnErrorLog.setText("<html>Error Log: <br>"+Runner.outputerr+"</html>");
	}

}
