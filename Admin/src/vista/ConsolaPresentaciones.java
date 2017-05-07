package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controlador.ControladorCampoID;
import controlador.ControladorSalir;
import controlador.presentaciones.CargaDatosListaInsumos;
import controlador.presentaciones.ControladorCambioInsumo;
import controlador.presentaciones.ControladorCampoCostoPresentaciones;
import controlador.presentaciones.ControladorEditarPresentaciones;
import controlador.presentaciones.ControladorEliminarPresentacion;
import controlador.presentaciones.ControladorGuardarPresentaciones;
import controlador.presentaciones.ControladorNuevoPresentaciones;
import controlador.presentaciones.ControladorSeleccionIVAPresentaciones;
import controlador.presentaciones.ControladorSeleccionPresentaciones;
import controlador.presentaciones.DatosLista;

public class ConsolaPresentaciones {

	private JDialog frmPresentaciones;
	@SuppressWarnings("rawtypes")
	private JList list;
	private JTextField campoID;
	private JTextField campoNombre;
	private JTextField campoVolumen;
	private JTextField campoUnidad;
	private JTextField campoCostosIVA;
	private JTextField campoCostocIVA;
	private JTextField campoIVAPorc;
	private JTextField campoIVA;
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;
	private JButton btnNuevo;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnGuardar;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxInsumo;
	private JMenuItem mntmSalir;
	private ConsolaInsumo consolaInsumo;

	/**
	 * Create the application.
	 */
	public ConsolaPresentaciones(JFrame frame, JDialog dialog) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize(frame, dialog);
					frmPresentaciones.setVisible(true);
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize(JFrame frame, JDialog dialog) {
		if(frame != null) frmPresentaciones = new JDialog(frame, true);
		else frmPresentaciones = new JDialog(dialog, true);
		frmPresentaciones.setTitle("Presentaciones");
		frmPresentaciones.setName("Presentaciones");
		frmPresentaciones.setBounds(100, 100, 500, 500);
		frmPresentaciones.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPresentaciones.setResizable(false);
		frmPresentaciones.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {}
			
			@Override
			public void windowIconified(WindowEvent e) {}
			
			@Override
			public void windowDeiconified(WindowEvent e) {}
			
			@Override
			public void windowDeactivated(WindowEvent e) {}
			
			@Override
			public void windowClosing(WindowEvent e) {}
			
			@Override
			public void windowClosed(WindowEvent e) {}
			
			@Override
			public void windowActivated(WindowEvent e) {
				getCampoUnidad().setText(consolaInsumo.getComboBoxUnidad().getSelectedItem().toString());
				getCampoCostosIVA().setText(consolaInsumo.getCampoCostosIVA().getText());
				getCampoCostocIVA().setText(consolaInsumo.getCampoCostocIVA().getText());
				getCampoIVA().setText(consolaInsumo.getCampoIVA().getText());
				getCampoIVAPorc().setText(consolaInsumo.getCampoIVAPorc().getText());
				if (consolaInsumo.getRdbtnSi().isSelected()) {
					getRdbtnSi().setSelected(true);
				}else{
					getRdbtnNo().setSelected(true);
				}
			}
		});
		
		JPanel panelPrincipal = new JPanel();
		frmPresentaciones.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("Arial", Font.PLAIN, 12));
		lblId.setBounds(10, 10, 60, 20);
		panelPrincipal.add(lblId);
		
		campoID = new JTextField();
		campoID.setFont(new Font("Arial", Font.PLAIN, 12));
		campoID.setBounds(80, 10, 90, 20);
		campoID.setColumns(10);
		campoID.addFocusListener(new ControladorCampoID(campoID));
		panelPrincipal.add(campoID);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre.setBounds(10, 40, 60, 20);
		panelPrincipal.add(lblNombre);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(80, 40, 150, 20);
		panelPrincipal.add(campoNombre);
		campoNombre.setColumns(10);
		
		JLabel lblInsumo = new JLabel("Insumo");
		lblInsumo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInsumo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblInsumo.setBounds(240, 40, 50, 20);
		panelPrincipal.add(lblInsumo);
		
		comboBoxInsumo = new JComboBox();
		comboBoxInsumo.setBounds(300, 40, 150, 20);
		comboBoxInsumo.setModel(new DefaultComboBoxModel<>(new CargaDatosListaInsumos().dameVectorInsumos()));
		comboBoxInsumo.setSelectedItem(consolaInsumo.getCampoNombre().getText());
		comboBoxInsumo.addItemListener(new ControladorCambioInsumo(this));
		panelPrincipal.add(comboBoxInsumo);
		
		JLabel lblVolumen = new JLabel("Volumen");
		lblVolumen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVolumen.setFont(new Font("Arial", Font.PLAIN, 12));
		lblVolumen.setBounds(10, 70, 60, 20);
		panelPrincipal.add(lblVolumen);
		
		campoVolumen = new JTextField();
		campoVolumen.setFont(new Font("Arial", Font.PLAIN, 12));
		campoVolumen.setBounds(80, 70, 90, 20);
		campoVolumen.setText("0.00");
		campoVolumen.setName("campoVolumen");
		campoVolumen.addFocusListener(new ControladorCampoCostoPresentaciones(this));
		panelPrincipal.add(campoVolumen);
		campoVolumen.setColumns(10);
		
		campoUnidad = new JTextField();
		campoUnidad.setText("KILOS");
		campoUnidad.setEditable(false);
		campoUnidad.setFont(new Font("Arial", Font.PLAIN, 12));
		campoUnidad.setBounds(180, 70, 50, 20);
		panelPrincipal.add(campoUnidad);
		campoUnidad.setColumns(10);
		
		JLabel lblCostoSiva = new JLabel("Costo s/IVA $");
		lblCostoSiva.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCostoSiva.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCostoSiva.setBounds(10, 100, 85, 20);
		panelPrincipal.add(lblCostoSiva);
		
		campoCostosIVA = new JTextField();
		campoCostosIVA.setBounds(100, 100, 90, 20);
		campoCostosIVA.setName("campoCostosIVA");
		campoCostosIVA.addFocusListener(new ControladorCampoCostoPresentaciones(this));
		panelPrincipal.add(campoCostosIVA);
		campoCostosIVA.setColumns(10);
		
		JLabel lbltieneIva = new JLabel("\u00BFTiene IVA?");
		lbltieneIva.setHorizontalAlignment(SwingConstants.RIGHT);
		lbltieneIva.setFont(new Font("Arial", Font.PLAIN, 12));
		lbltieneIva.setBounds(210, 100, 100, 20);
		panelPrincipal.add(lbltieneIva);
		
		ButtonGroup group = new ButtonGroup();
		
		rdbtnSi = new JRadioButton("S\u00ED");
		rdbtnSi.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtnSi.setBounds(320, 100, 50, 20);
		rdbtnSi.addActionListener(new ControladorSeleccionIVAPresentaciones(this));
		panelPrincipal.add(rdbtnSi);
		group.add(rdbtnSi);
		
		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtnNo.setBounds(380, 100, 50, 20);
		rdbtnNo.addActionListener(new ControladorSeleccionIVAPresentaciones(this));
		panelPrincipal.add(rdbtnNo);
		group.add(rdbtnNo);
		
		JLabel lblCostoCiva = new JLabel("Costo c/IVA $");
		lblCostoCiva.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCostoCiva.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCostoCiva.setBounds(10, 130, 85, 20);
		panelPrincipal.add(lblCostoCiva);
		
		campoCostocIVA = new JTextField();
		campoCostocIVA.setName("campoCostocIVA");
		campoCostocIVA.setFont(new Font("Arial", Font.PLAIN, 12));
		campoCostocIVA.setBounds(100, 130, 90, 20);
		campoCostocIVA.addFocusListener(new ControladorCampoCostoPresentaciones(this));
		panelPrincipal.add(campoCostocIVA);
		campoCostocIVA.setColumns(10);
		
		JLabel lblIvaPorc = new JLabel("I.V.A. %");
		lblIvaPorc.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIvaPorc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIvaPorc.setBounds(200, 130, 40, 20);
		panelPrincipal.add(lblIvaPorc);
		
		campoIVAPorc = new JTextField();
		campoIVAPorc.setEditable(false);
		campoIVAPorc.setText("0.00");
		campoIVAPorc.setFont(new Font("Arial", Font.PLAIN, 12));
		campoIVAPorc.setBounds(250, 130, 50, 20);
		panelPrincipal.add(campoIVAPorc);
		campoIVAPorc.setColumns(10);
		
		JLabel lblIva = new JLabel("I.V.A. $");
		lblIva.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIva.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIva.setBounds(310, 130, 40, 20);
		panelPrincipal.add(lblIva);
		
		campoIVA = new JTextField();
		campoIVA.setEditable(false);
		campoIVA.setText("0.00");
		campoIVA.setFont(new Font("Arial", Font.PLAIN, 12));
		campoIVA.setBounds(360, 130, 60, 20);
		panelPrincipal.add(campoIVA);
		campoIVA.setColumns(10);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setEnabled(false);
		btnNuevo.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNuevo.setBounds(20, 160, 90, 25);
		btnNuevo.addActionListener(new ControladorNuevoPresentaciones(this));
		panelPrincipal.add(btnNuevo);
		
		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEditar.setBounds(120, 160, 90, 25);
		btnEditar.addActionListener(new ControladorEditarPresentaciones(this));
		panelPrincipal.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEliminar.setBounds(220, 160, 90, 25);
		btnEliminar.addActionListener(new ControladorEliminarPresentacion(this));
		panelPrincipal.add(btnEliminar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnGuardar.setBounds(320, 160, 90, 25);
		btnGuardar.addActionListener(new ControladorGuardarPresentaciones(this));
		panelPrincipal.add(btnGuardar);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(500, 225));
		frmPresentaciones.getContentPane().add(scrollPane, BorderLayout.SOUTH);
		
		list = new JList();
		list.setPreferredSize(new Dimension(450, 200));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setListData(new DatosLista(this).dameDatos());
		list.addListSelectionListener(new ControladorSeleccionPresentaciones(this));
		scrollPane.setViewportView(list);
		
		JLabel lblPresentaciones = new JLabel("Presentaciones");
		lblPresentaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPresentaciones.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPresentaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblPresentaciones.setFont(new Font("Arial", Font.BOLD, 12));
		scrollPane.setColumnHeaderView(lblPresentaciones);
		
		JMenuBar menuBar = new JMenuBar();
		frmPresentaciones.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		setMntmSalir(new JMenuItem("Salir"));
		getMntmSalir().addActionListener(new ControladorSalir(this));
		mnArchivo.add(getMntmSalir());
	}

	/**
	 * @return the frmPresentaciones
	 */
	public JDialog getFrmPresentaciones() {
		return frmPresentaciones;
	}

	/**
	 * @param frmPresentaciones the frmPresentaciones to set
	 */
	public void setFrmPresentaciones(JDialog frmPresentaciones) {
		this.frmPresentaciones = frmPresentaciones;
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
	 * @return the campoID
	 */
	public JTextField getCampoID() {
		return campoID;
	}

	/**
	 * @param campoID the campoID to set
	 */
	public void setCampoID(JTextField campoID) {
		this.campoID = campoID;
	}

	/**
	 * @return the campoNombre
	 */
	public JTextField getCampoNombre() {
		return campoNombre;
	}

	/**
	 * @param campoNombre the campoNombre to set
	 */
	public void setCampoNombre(JTextField campoNombre) {
		this.campoNombre = campoNombre;
	}

	/**
	 * @return the campoVolumen
	 */
	public JTextField getCampoVolumen() {
		return campoVolumen;
	}

	/**
	 * @param campoVolumen the campoVolumen to set
	 */
	public void setCampoVolumen(JTextField campoVolumen) {
		this.campoVolumen = campoVolumen;
	}

	/**
	 * @return the campoUnidad
	 */
	public JTextField getCampoUnidad() {
		return campoUnidad;
	}

	/**
	 * @param campoUnidad the campoUnidad to set
	 */
	public void setCampoUnidad(JTextField campoUnidad) {
		this.campoUnidad = campoUnidad;
	}

	/**
	 * @return the campoCostosIVA
	 */
	public JTextField getCampoCostosIVA() {
		return campoCostosIVA;
	}

	/**
	 * @param campoCostosIVA the campoCostosIVA to set
	 */
	public void setCampoCostosIVA(JTextField campoCostosIVA) {
		this.campoCostosIVA = campoCostosIVA;
	}

	/**
	 * @return the campoCostocIVA
	 */
	public JTextField getCampoCostocIVA() {
		return campoCostocIVA;
	}

	/**
	 * @param campoCostocIVA the campoCostocIVA to set
	 */
	public void setCampoCostocIVA(JTextField campoCostocIVA) {
		this.campoCostocIVA = campoCostocIVA;
	}

	/**
	 * @return the campoIVAPorc
	 */
	public JTextField getCampoIVAPorc() {
		return campoIVAPorc;
	}

	/**
	 * @param campoIVAPorc the campoIVAPorc to set
	 */
	public void setCampoIVAPorc(JTextField campoIVAPorc) {
		this.campoIVAPorc = campoIVAPorc;
	}

	/**
	 * @return the campoIVA
	 */
	public JTextField getCampoIVA() {
		return campoIVA;
	}

	/**
	 * @param campoIVA the campoIVA to set
	 */
	public void setCampoIVA(JTextField campoIVA) {
		this.campoIVA = campoIVA;
	}

	/**
	 * @return the rdbtnSi
	 */
	public JRadioButton getRdbtnSi() {
		return rdbtnSi;
	}

	/**
	 * @param rdbtnSi the rdbtnSi to set
	 */
	public void setRdbtnSi(JRadioButton rdbtnSi) {
		this.rdbtnSi = rdbtnSi;
	}

	/**
	 * @return the rdbtnNo
	 */
	public JRadioButton getRdbtnNo() {
		return rdbtnNo;
	}

	/**
	 * @param rdbtnNo the rdbtnNo to set
	 */
	public void setRdbtnNo(JRadioButton rdbtnNo) {
		this.rdbtnNo = rdbtnNo;
	}

	/**
	 * @return the btnNuevo
	 */
	public JButton getBtnNuevo() {
		return btnNuevo;
	}

	/**
	 * @param btnNuevo the btnNuevo to set
	 */
	public void setBtnNuevo(JButton btnNuevo) {
		this.btnNuevo = btnNuevo;
	}

	/**
	 * @return the btnEditar
	 */
	public JButton getBtnEditar() {
		return btnEditar;
	}

	/**
	 * @param btnEditar the btnEditar to set
	 */
	public void setBtnEditar(JButton btnEditar) {
		this.btnEditar = btnEditar;
	}

	/**
	 * @return the btnEliminar
	 */
	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	/**
	 * @param btnEliminar the btnEliminar to set
	 */
	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	/**
	 * @return the btnGuardar
	 */
	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	/**
	 * @param btnGuardar the btnGuardar to set
	 */
	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
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
	@SuppressWarnings("rawtypes")
	public void setComboBoxInsumo(JComboBox comboBoxInsumo) {
		this.comboBoxInsumo = comboBoxInsumo;
		
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
