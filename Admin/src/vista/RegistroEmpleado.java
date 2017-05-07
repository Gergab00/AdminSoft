package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;

public class RegistroEmpleado {

	private JDialog frmRegEmpleados;
	private JTextField campoID;
	private JTextField campoMaterno;
	private JTextField campoNombre;
	private JTextField campoPaterno;
	private JTextField campoCalle;
	private JTextField campoNumE;
	private JTextField campoNumI;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;

	/**
	 * Create the application.
	 */
	public RegistroEmpleado(JFrame frame, JDialog dialog) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize(frame, dialog);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frmRegEmpleados.
	 */
	private void initialize(JFrame frame, JDialog dialog) {
		//if(frmRegEmpleados != null)frmRegEmpleados = new JDialog(frame, true);
		//else frmRegEmpleados = new JDialog(dialog, true);
		frmRegEmpleados = new JDialog();
		frmRegEmpleados.setPreferredSize(new Dimension(300, 600));
		frmRegEmpleados.setBounds(100, 100, 600, 401);
		frmRegEmpleados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 2, 5, 5));
		panel.setPreferredSize(new Dimension(200, 200));
		frmRegEmpleados.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Arial", Font.PLAIN, 12));
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblId);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNombre);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno");
		lblApellidoPaterno.setFont(new Font("Arial", Font.PLAIN, 12));
		lblApellidoPaterno.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblApellidoPaterno);
		
		textField_2 = new JTextField();
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setFont(new Font("Arial", Font.PLAIN, 12));
		lblApellidoMaterno.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblApellidoMaterno);
		
		textField_3 = new JTextField();
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCalle.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblCalle);
		
		textField_4 = new JTextField();
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNumeroInterior = new JLabel("N\u00FAmero Interior");
		lblNumeroInterior.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNumeroInterior.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNumeroInterior);
		
		textField_5 = new JTextField();
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNumeroExterior = new JLabel("N\u00FAmero Exterior");
		lblNumeroExterior.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNumeroExterior.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNumeroExterior);
		
		textField_6 = new JTextField();
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblEstado);
		
		textField_7 = new JTextField();
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblMunicipio = new JLabel("Municipio");
		lblMunicipio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMunicipio.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(lblMunicipio);
		
		textField_8 = new JTextField();
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblCp = new JLabel("C.P.");
		lblCp.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCp.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblCp);
		
		textField_9 = new JTextField();
		panel.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEdad.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(lblEdad);
		
		textField_11 = new JTextField();
		panel.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil");
		lblEstadoCivil.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstadoCivil.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(lblEstadoCivil);
		
		textField_12 = new JTextField();
		panel.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSexo.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblSexo);
		
		textField_13 = new JTextField();
		panel.add(textField_13);
		textField_13.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		frmRegEmpleados.getContentPane().add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1, BorderLayout.NORTH);
		panel_1.setPreferredSize(new Dimension(300, 75));
		panel_1.setLayout(new GridLayout(0, 2, 5, 5));
		
		JLabel lblPuesto = new JLabel("Puesto");
		lblPuesto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPuesto.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_1.add(lblPuesto);
		
		textField_10 = new JTextField();
		panel_1.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalario.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_1.add(lblSalario);
		
		textField_14 = new JTextField();
		panel_1.add(textField_14);
		textField_14.setColumns(10);
		
		JLabel lblFechaAlta = new JLabel("Fecha de Alta");
		lblFechaAlta.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFechaAlta.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblFechaAlta);
		
		textField_15 = new JTextField();
		panel_1.add(textField_15);
		textField_15.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(300, 300));
		panel_2.add(panel_3);
		
		JButton btnNuevo = new JButton("Nuevo");
		panel_3.add(btnNuevo);
		
		JButton btnEditar = new JButton("Editar");
		panel_3.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		panel_3.add(btnEliminar);
		
		JButton btnGuardar = new JButton("Guardar");
		panel_3.add(btnGuardar);
		
		JButton btnCrearDocumento = new JButton("Crear Documento");
		panel_3.add(btnCrearDocumento);
		
	}
}
