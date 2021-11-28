package tk.thereddeveloper.JavaFXInstaller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigurationUI {

	private JFrame frmConfigurator;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurationUI window = new ConfigurationUI();
					window.frmConfigurator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConfigurationUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		String FileToRun = ConfigManager.get("FileToRun");
		String ViewLog = ConfigManager.get("ViewLog");
		String JavaRuntime = ConfigManager.get("JavaRuntime");
		
		frmConfigurator = new JFrame();
		frmConfigurator.setTitle("Configurator");
		frmConfigurator.setBounds(100, 100, 450, 344);
		frmConfigurator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmConfigurator.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblShouldTheLog = new JLabel("<html>Should the Log GUI defaultly open after<br> the JavaFX application has finished?</html>");
		GridBagConstraints gbc_lblShouldTheLog = new GridBagConstraints();
		gbc_lblShouldTheLog.insets = new Insets(0, 0, 5, 5);
		gbc_lblShouldTheLog.gridx = 1;
		gbc_lblShouldTheLog.gridy = 1;
		frmConfigurator.getContentPane().add(lblShouldTheLog, gbc_lblShouldTheLog);
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"false", "true"}));
		if(ViewLog != null) {
			if (ViewLog.equals("true")) {
				comboBox.setSelectedIndex(1);
			}else if(ViewLog.equals("false")) {
				comboBox.setSelectedIndex(0);
			}
		}
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 1;
		frmConfigurator.getContentPane().add(comboBox, gbc_comboBox);
		
		
		
		JLabel lblNewLabel = new JLabel("<html>Type in the path of the file, <br>which should be executed:</html>");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		frmConfigurator.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 3;
		frmConfigurator.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		if (FileToRun != null) {
			textField.setText(FileToRun);
		}
		
		JLabel lbltypeInThe = new JLabel("<html>Type in the Path to the <br>  Java 11 runtime Binary:<br>Get help here:</html>");
		GridBagConstraints gbc_lbltypeInThe = new GridBagConstraints();
		gbc_lbltypeInThe.insets = new Insets(0, 0, 5, 5);
		gbc_lbltypeInThe.gridx = 1;
		gbc_lbltypeInThe.gridy = 5;
		frmConfigurator.getContentPane().add(lbltypeInThe, gbc_lbltypeInThe);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 5;
		frmConfigurator.getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		textField_1.setText("java");
		if (JavaRuntime != null) {
			textField_1.setText(JavaRuntime);
		}
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HelpUI.open();
			}
		});
		GridBagConstraints gbc_btnHelp = new GridBagConstraints();
		gbc_btnHelp.insets = new Insets(0, 0, 5, 5);
		gbc_btnHelp.gridx = 1;
		gbc_btnHelp.gridy = 6;
		frmConfigurator.getContentPane().add(btnHelp, gbc_btnHelp);
		
		JButton btnSaveAndQuit = new JButton("Save and Launch");
		btnSaveAndQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 0) {
					ConfigManager.set("ViewLog", "false");
				}else if (comboBox.getSelectedIndex() == 1) {
					ConfigManager.set("ViewLog", "true");
				}
				ConfigManager.set("FileToRun", textField.getText());
				ConfigManager.set("JavaRuntime", textField_1.getText());
				frmConfigurator.dispose();
				Runner.run(textField.getText(),textField_1.getText());
			}
		});
		GridBagConstraints gbc_btnSaveAndQuit = new GridBagConstraints();
		gbc_btnSaveAndQuit.gridx = 3;
		gbc_btnSaveAndQuit.gridy = 7;
		frmConfigurator.getContentPane().add(btnSaveAndQuit, gbc_btnSaveAndQuit);
	}

}
