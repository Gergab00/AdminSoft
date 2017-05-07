package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class ConsolaBBDD {

	private JDialog frmBBDD;
	private JTextField campoUsuario;
	private JPasswordField campoPassword;

	/**
	 * Create the application.
	 */
	public ConsolaBBDD(JFrame frame, JDialog dialog) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize(frame, dialog);
					frmBBDD.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frmBBDD.
	 * @param dialog 
	 * @param frame2 
	 */
	private void initialize(JFrame frame, JDialog dialog) {
		//if(frame != null)frmBBDD = new JDialog(frame, true);
		//else frmBBDD = new JDialog(dialog, true);
		frmBBDD = new JDialog();
		frmBBDD.setBounds(100, 100, 450, 300);
		frmBBDD.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmBBDD.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmConectar = new JMenuItem("Conectar...");
		mnArchivo.add(mntmConectar);
		
		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);
		
		JButton btnSalir = new JButton("Salir");
		mnArchivo.add(btnSalir);
		
		JPanel panel = new JPanel();
		frmBBDD.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblBaseDeDatos = new JLabel("Base de Datos:");
		lblBaseDeDatos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBaseDeDatos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblBaseDeDatos.setBounds(10, 10, 90, 20);
		panel.add(lblBaseDeDatos);
		
		JComboBox comboBox_BBDD = new JComboBox();
		comboBox_BBDD.setEditable(true);
		comboBox_BBDD.setBounds(105, 10, 90, 20);
		panel.add(comboBox_BBDD);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUsuario.setBounds(10, 40, 90, 20);
		panel.add(lblUsuario);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(105, 40, 90, 20);
		panel.add(campoUsuario);
		campoUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setFont(new Font("Arial", Font.PLAIN, 12));
		lblContrasea.setBounds(10, 70, 90, 20);
		panel.add(lblContrasea);
		
		campoPassword = new JPasswordField();
		campoPassword.setBounds(105, 70, 90, 20);
		panel.add(campoPassword);
	}
}
