package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Component;
import javax.swing.border.LineBorder;

import controlador.ControladorAbrir;
import controlador.ControladorSalir;
import controlador.presentaciones.CargaDatosListaInsumos;
import controlador.presentaciones.ControladorCambioInsumo;
import controlador.presentaciones.ControladorEliminarPresentacion;
import controlador.presentaciones.DatosLista;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;

public class ConsolaVerPresentaciones {

	private JDialog frameVerPresentaciones;
	private JTextField campoDepartamento;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxInsumo;
	private JButton btnAgregarPresentacion;
	private JButton btnEliminarPresentaciones;
	@SuppressWarnings("rawtypes")
	private JList list;
	private JMenuItem mntmSalir;
	private ConsolaInsumo consolaInsumo;
		
	/**
	 * Create the application.
	 */
	public ConsolaVerPresentaciones(JFrame frame, JDialog dialog) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize(frame, dialog);
					frameVerPresentaciones.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Initialize the contents of the frame.
	 * @param dialog 
	 * @param frame 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize(JFrame frame, JDialog dialog) {
		if(frame != null)frameVerPresentaciones = new JDialog(frame, true);
		else frameVerPresentaciones = new JDialog(dialog, true);
		frameVerPresentaciones.setTitle("Presentaciones por Insumo");
		frameVerPresentaciones.setName("Ver Presentaciones");
		frameVerPresentaciones.setResizable(false);
		frameVerPresentaciones.setBounds(100, 100, 450, 300);
		frameVerPresentaciones.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameVerPresentaciones.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frameVerPresentaciones.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblInsumo = new JLabel("Insumo");
		lblInsumo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInsumo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblInsumo.setBounds(10, 10, 60, 20);
		panel.add(lblInsumo);
		
		comboBoxInsumo = new JComboBox();
		comboBoxInsumo.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxInsumo.setBounds(80, 10, 100, 20);
		comboBoxInsumo.setModel(new DefaultComboBoxModel<>(new CargaDatosListaInsumos().dameVectorInsumos()));
		comboBoxInsumo.setSelectedItem(consolaInsumo.getCampoNombre().getText());
		comboBoxInsumo.addItemListener(new ControladorCambioInsumo(this));
		panel.add(comboBoxInsumo);
		
		campoDepartamento = new JTextField();
		campoDepartamento.setFont(new Font("Arial", Font.PLAIN, 12));
		campoDepartamento.setEditable(false);
		campoDepartamento.setBounds(190, 10, 180, 20);
		campoDepartamento.setText(consolaInsumo.getComboBoxDepartamento().getSelectedItem().toString());
		panel.add(campoDepartamento);
		campoDepartamento.setColumns(10);
		
		btnAgregarPresentacion = new JButton("Agregar Presentaci\u00F3n");
		btnAgregarPresentacion.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgregarPresentacion.setBounds(10, 40, 170, 25);
		ControladorAbrir abrir = new ControladorAbrir(null,this.frameVerPresentaciones);
		btnAgregarPresentacion.addActionListener(abrir);
		abrir.pasarVentanaInsumo(consolaInsumo);
		panel.add(btnAgregarPresentacion);
		
		btnEliminarPresentaciones = new JButton("Eliminar Presentacion(es)");
		btnEliminarPresentaciones.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEliminarPresentaciones.setBounds(190, 40, 180, 25);
		btnEliminarPresentaciones.addActionListener(new ControladorEliminarPresentacion(this));
		panel.add(btnEliminarPresentaciones);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(450, 180));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frameVerPresentaciones.getContentPane().add(scrollPane, BorderLayout.SOUTH);
		
		list = new JList();
		list.setListData(new DatosLista(this).dameDatos());
		scrollPane.setViewportView(list);
		
		JLabel lblPresentaciones = new JLabel("PRESENTACIONES");
		lblPresentaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPresentaciones.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPresentaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblPresentaciones.setFont(new Font("Arial", Font.BOLD, 12));
		scrollPane.setColumnHeaderView(lblPresentaciones);
		
		JMenuBar menuBar = new JMenuBar();
		frameVerPresentaciones.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		setMntmSalir(new JMenuItem("Salir"));
		getMntmSalir().addActionListener(new ControladorSalir(this));
		mnArchivo.add(getMntmSalir());
	}

	/**
	 * @return the frameVerPresentaciones
	 */
	public JDialog getFrameVerPresentaciones() {
		return frameVerPresentaciones;
	}

	/**
	 * @param frameVerPresentaciones the frameVerPresentaciones to set
	 */
	public void setFrameVerPresentaciones(JDialog frameVerPresentaciones) {
		this.frameVerPresentaciones = frameVerPresentaciones;
	}

	/**
	 * @return the campoDepartamento
	 */
	public JTextField getCampoDepartamento() {
		return campoDepartamento;
	}

	/**
	 * @param campoDepartamento the campoDepartamento to set
	 */
	public void setCampoDepartamento(JTextField campoDepartamento) {
		this.campoDepartamento = campoDepartamento;
	}

	/**
	 * @return the comboBoxInsumo
	 */
	@SuppressWarnings("rawtypes")
	public JComboBox getComboBoxInsumo() {
		return comboBoxInsumo;
	}

	/**
	 * @param comboBoxInsumo the comboBoxInsumo to set
	 */
	public void setComboBoxInsumo(@SuppressWarnings("rawtypes") JComboBox comboBoxInsumo) {
		this.comboBoxInsumo = comboBoxInsumo;
	}

	/**
	 * @return the btnAgregarPresentacion
	 */
	public JButton getBtnAgregarPresentacion() {
		return btnAgregarPresentacion;
	}

	/**
	 * @param btnAgregarPresentacion the btnAgregarPresentacion to set
	 */
	public void setBtnAgregarPresentacion(JButton btnAgregarPresentacion) {
		this.btnAgregarPresentacion = btnAgregarPresentacion;
	}

	/**
	 * @return the btnEliminarPresentaciones
	 */
	public JButton getBtnEliminarPresentaciones() {
		return btnEliminarPresentaciones;
	}

	/**
	 * @param btnEliminarPresentaciones the btnEliminarPresentaciones to set
	 */
	public void setBtnEliminarPresentaciones(JButton btnEliminarPresentaciones) {
		this.btnEliminarPresentaciones = btnEliminarPresentaciones;
	}

	/**
	 * @return the list
	 */
	@SuppressWarnings("rawtypes")
	public JList getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	@SuppressWarnings("rawtypes")
	public void setList(JList list) {
		this.list = list;
	}

	/**
	 * @return the mntmSalir
	 */
	public JMenuItem getMntmSalir() {
		return mntmSalir;
	}

	/**
	 * @param mntmSalir the mntmSalir to set
	 */
	public void setMntmSalir(JMenuItem mntmSalir) {
		this.mntmSalir = mntmSalir;
	}

	public void pasarVentana(ConsolaInsumo consolaInsumo) {
		this.consolaInsumo = consolaInsumo;
		
	}
}
