package tk.thereddeveloper.JavaFXInstaller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class ErrorUI {

	private JFrame frmAnErrorOccured;

	/**
	 * Launch the application.
	 */
	public static void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErrorUI window = new ErrorUI();
					window.frmAnErrorOccured.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ErrorUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAnErrorOccured = new JFrame();
		frmAnErrorOccured.setTitle("An Error Occured!");
		frmAnErrorOccured.setBounds(100, 100, 450, 289);
		frmAnErrorOccured.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		frmAnErrorOccured.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblAnErrorOccured = new JLabel("An Error Occured while executing the JavaFX application!");
		GridBagConstraints gbc_lblAnErrorOccured = new GridBagConstraints();
		gbc_lblAnErrorOccured.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnErrorOccured.gridx = 2;
		gbc_lblAnErrorOccured.gridy = 0;
		frmAnErrorOccured.getContentPane().add(lblAnErrorOccured, gbc_lblAnErrorOccured);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 2;
		frmAnErrorOccured.getContentPane().add(scrollPane, gbc_scrollPane);
		
		JTextPane txtpnT = new JTextPane();
		txtpnT.setEditable(false);
		txtpnT.setText("<html>"+Runner.outputerr+"</html>");
		txtpnT.setContentType("text/html");
		scrollPane.setViewportView(txtpnT);
	}

}
