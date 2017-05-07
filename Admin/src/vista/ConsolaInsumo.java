package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.border.LineBorder;

import controlador.CargaDatosListaComboBox;
import controlador.ControladorAbrir;
import controlador.ControladorSalir;
import controlador.insumos.ControladorSeleccionIVA;
import controlador.insumos.DatosLista;
import controlador.insumos.ControladorAcutalizarCosto;
import controlador.insumos.ControladorCampoCosto;
import controlador.insumos.ControladorEditar;
import controlador.insumos.ControladorEliminar;
import controlador.insumos.ControladorGuardar;
import controlador.insumos.ControladorNuevo;
import controlador.insumos.ControladorSeleccion;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;

public class ConsolaInsumo {

	private JDialog frmInsumos;
	private JTextField campoID;
	private JTextField campoNombre;
	private JComboBox<String> comboBoxDepartamento;
	private JComboBox<Object> comboBoxUnidad;
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
	private JButton btnAgregarPresentacion;
	private JButton btnVerPresentaciones;
	private JList<String> list;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnHerramientas;
	private JMenuItem mntmDepartamentos;
	private JMenuItem mntmActualizarCosto;

	/**
	 * Create the application.
	 */
	public ConsolaInsumo(JFrame frame, JDialog dialog) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize(frame, dialog);
					frmInsumos.setVisible(true);
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
	public void initialize(JFrame frame, JDialog dialog) {
		//if(frame != null) frmInsumos = new JDialog(frame, true);
		//else frmInsumos = new JDialog(dialog, true);
		frmInsumos = new JDialog();
		frmInsumos.setResizable(false);
		frmInsumos.setTitle("Insumos");
		frmInsumos.setBounds(100, 100, 450, 500);
		frmInsumos.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		CargaDatosListaComboBox datosBox = new CargaDatosListaComboBox(this);
		frmInsumos.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				comboBoxDepartamento.setModel(new DefaultComboBoxModel<>(datosBox.getVector()));
			}
			
		});
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setPreferredSize(new Dimension(450, 225));
		panelPrincipal.setMinimumSize(new Dimension(450, 225));
		panelPrincipal.setMaximumSize(new Dimension(450, 225));
		panelPrincipal.setSize(new Dimension(450, 250));
		frmInsumos.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("Arial", Font.PLAIN, 12));
		lblId.setBounds(10, 10, 85, 20);
		panelPrincipal.add(lblId);
		
		campoID = new JTextField();
		campoID.setEnabled(false);
		campoID.setBounds(100, 10, 80, 20);
		panelPrincipal.add(campoID);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre.setBounds(10, 40, 85, 20);
		panelPrincipal.add(lblNombre);
		
		campoNombre = new JTextField();
		campoNombre.setEnabled(false);
		campoNombre.setBounds(100, 40, 150, 20);
		panelPrincipal.add(campoNombre);
		campoNombre.setColumns(10);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDepartamento.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDepartamento.setBounds(10, 70, 85, 20);
		panelPrincipal.add(lblDepartamento);
		
		comboBoxDepartamento = new JComboBox<String>();
		comboBoxDepartamento.setEnabled(false);
		comboBoxDepartamento.setBounds(100, 70, 150, 20);
		comboBoxDepartamento.setModel(new DefaultComboBoxModel<>(datosBox.getVector()));
		panelPrincipal.add(comboBoxDepartamento);
		
		JLabel lblUnidad = new JLabel("Unidad");
		lblUnidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUnidad.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUnidad.setBounds(260, 70, 50, 20);
		panelPrincipal.add(lblUnidad);
		
		comboBoxUnidad = new JComboBox<Object>();
		comboBoxUnidad.setEnabled(false);
		comboBoxUnidad.setModel(new DefaultComboBoxModel<Object>(new String[] {"KILOS", "LITROS", "PIEZAS"}));
		comboBoxUnidad.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxUnidad.setBounds(320, 70, 100, 20);
		panelPrincipal.add(comboBoxUnidad);
		
		JLabel lblCostoSiva = new JLabel("Costo s/IVA $");
		lblCostoSiva.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCostoSiva.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCostoSiva.setBounds(10, 100, 85, 20);
		panelPrincipal.add(lblCostoSiva);
		
		
		campoCostosIVA = new JTextField();
		campoCostosIVA.setToolTipText("Ingresa unicamente n\u00FAmeros.");
		campoCostosIVA.setEnabled(false);
		campoCostosIVA.setText("0.00");
		campoCostosIVA.setBounds(100, 100, 90, 20);
		campoCostosIVA.setColumns(10);
		campoCostosIVA.setName("campoCostosIVA");
		campoCostosIVA.addFocusListener(new ControladorCampoCosto(this));
		panelPrincipal.add(campoCostosIVA);
		
		JLabel lbltieneIva = new JLabel("\u00BFTiene IVA?");
		lbltieneIva.setHorizontalAlignment(SwingConstants.RIGHT);
		lbltieneIva.setFont(new Font("Arial", Font.PLAIN, 12));
		lbltieneIva.setBounds(210, 100, 100, 20);
		panelPrincipal.add(lbltieneIva);
		
		ButtonGroup group = new ButtonGroup();
		
		rdbtnSi = new JRadioButton("S\u00ED");
		rdbtnSi.setEnabled(false);
		rdbtnSi.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtnSi.setBounds(320, 100, 50, 20);
		panelPrincipal.add(rdbtnSi);
		rdbtnSi.addActionListener(new ControladorSeleccionIVA(this));
		group.add(rdbtnSi);
		
		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setEnabled(false);
		rdbtnNo.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtnNo.setBounds(380, 100, 50, 20);
		rdbtnNo.setSelected(true);
		rdbtnNo.addActionListener(new ControladorSeleccionIVA(this));
		panelPrincipal.add(rdbtnNo);
		group.add(rdbtnNo);
		
		JLabel lblCostoCiva = new JLabel("Costo c/IVA $");
		lblCostoCiva.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCostoCiva.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCostoCiva.setBounds(10, 130, 85, 20);
		panelPrincipal.add(lblCostoCiva);
		
		campoCostocIVA = new JTextField();
		campoCostocIVA.setToolTipText("Ingresa unicamente n\u00FAmeros.");
		campoCostocIVA.setEnabled(false);
		campoCostocIVA.setFont(new Font("Arial", Font.PLAIN, 12));
		campoCostocIVA.setBounds(100, 130, 90, 20);
		campoCostocIVA.setColumns(10);
		campoCostocIVA.setText("0.00");
		campoCostocIVA.setColumns(10);
		campoCostocIVA.setName("campoCostocIVA");
		campoCostocIVA.addFocusListener(new ControladorCampoCosto(this));
		panelPrincipal.add(campoCostocIVA);
		
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
		campoIVAPorc.setColumns(10);
		
		panelPrincipal.add(campoIVAPorc);
		
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
		campoIVA.setColumns(10);
		panelPrincipal.add(campoIVA);
		
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNuevo.setBounds(20, 160, 90, 25);
		btnNuevo.addActionListener(new ControladorNuevo(this));
		panelPrincipal.add(btnNuevo);
		
		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEditar.setBounds(120, 160, 90, 25);
		btnEditar.addActionListener(new ControladorEditar(this));
		panelPrincipal.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEliminar.setBounds(220, 160, 90, 25);
		btnEliminar.addActionListener(new ControladorEliminar(this));
		panelPrincipal.add(btnEliminar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnGuardar.setBounds(320, 160, 90, 25);
		btnGuardar.addActionListener(new ControladorGuardar(this));
		panelPrincipal.add(btnGuardar);
		
		btnAgregarPresentacion = new JButton("Agregar Presentaci\u00F3n");
		btnAgregarPresentacion.setEnabled(false);
		btnAgregarPresentacion.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgregarPresentacion.setBounds(30, 190, 180, 25);
		ControladorAbrir abrir = new ControladorAbrir(null, this.frmInsumos);
		abrir.pasarVentanaInsumo(this);
		btnAgregarPresentacion.addActionListener(abrir);
		panelPrincipal.add(btnAgregarPresentacion);
		
		btnVerPresentaciones = new JButton("Ver Presentaciones");
		btnVerPresentaciones.setEnabled(false);
		btnVerPresentaciones.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVerPresentaciones.setBounds(220, 190, 180, 25);
		btnVerPresentaciones.addActionListener(abrir);
		panelPrincipal.add(btnVerPresentaciones);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setMinimumSize(new Dimension(0, 0));
		scrollPane.setMaximumSize(new Dimension(0, 0));
		scrollPane.setPreferredSize(new Dimension(450, 225));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frmInsumos.getContentPane().add(scrollPane, BorderLayout.SOUTH);
		
		list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setPreferredSize(new Dimension(400, 200));
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setListData(new DatosLista().dameDatos());
		list.addListSelectionListener(new ControladorSeleccion(this));
		scrollPane.setViewportView(list);
		
		JLabel lblInsumos = new JLabel("Insumos");
		lblInsumos.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblInsumos.setPreferredSize(new Dimension(40, 20));
		lblInsumos.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblInsumos.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsumos.setFont(new Font("Arial", Font.BOLD, 12));
		scrollPane.setColumnHeaderView(lblInsumos);
		
		menuBar = new JMenuBar();
		frmInsumos.setJMenuBar(menuBar);
		
		setMnArchivo(new JMenu("Archivo"));
		menuBar.add(getMnArchivo());
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ControladorSalir(this));
		getMnArchivo().add(mntmSalir);
		
		mnHerramientas = new JMenu("Herramientas");
		menuBar.add(mnHerramientas);
		
		setMntmDepartamentos(new JMenuItem("Departamentos"));
		mntmDepartamentos.addActionListener(new ControladorAbrir(null, this.frmInsumos));
		mnHerramientas.add(getMntmDepartamentos());
		
		mntmActualizarCosto = new JMenuItem("Actualizar Costo");
		mntmActualizarCosto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		mntmActualizarCosto.setToolTipText("Actualiza el costo del insumo basado en las presentaciones");
		mntmActualizarCosto.setEnabled(false);
		mntmActualizarCosto.setIcon(new ImageIcon(ConsolaInsumo.class.getResource("/imagenes/arrow_refresh.png")));
		mntmActualizarCosto.addActionListener(new ControladorAcutalizarCosto(this));
		mnHerramientas.add(mntmActualizarCosto);
	}

	/**
	 * @return the frmInsumos
	 */
	public JDialog getFrmInsumos() {
		return frmInsumos;
	}

	/**
	 * @param frmInsumos the frmInsumos to set
	 */
	public void setFrmInsumos(JDialog frmInsumos) {
		this.frmInsumos = frmInsumos;
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
	 * @return the comboBoxDepartamento
	 */
	public JComboBox<String> getComboBoxDepartamento() {
		return comboBoxDepartamento;
	}

	/**
	 * @param comboBoxDepartamento the comboBoxDepartamento to set
	 */
	public void setComboBoxDepartamento(JComboBox<String> comboBoxDepartamento) {
		this.comboBoxDepartamento = comboBoxDepartamento;
	}

	/**
	 * @return the comboBoxUnidad
	 */
	public JComboBox<Object> getComboBoxUnidad() {
		return comboBoxUnidad;
	}

	/**
	 * @param comboBoxUnidad the comboBoxUnidad to set
	 */
	public void setComboBoxUnidad(JComboBox<Object> comboBoxUnidad) {
		this.comboBoxUnidad = comboBoxUnidad;
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
	 * @return the btnAgregarPresentacin
	 */
	public JButton getBtnAgregarPresentacin() {
		return btnAgregarPresentacion;
	}

	/**
	 * @param btnAgregarPresentacin the btnAgregarPresentacin to set
	 */
	public void setBtnAgregarPresentacin(JButton btnAgregarPresentacin) {
		this.btnAgregarPresentacion = btnAgregarPresentacin;
	}

	/**
	 * @return the btnVerPresentaciones
	 */
	public JButton getBtnVerPresentaciones() {
		return btnVerPresentaciones;
	}

	/**
	 * @param btnVerPresentaciones the btnVerPresentaciones to set
	 */
	public void setBtnVerPresentaciones(JButton btnVerPresentaciones) {
		this.btnVerPresentaciones = btnVerPresentaciones;
	}

	/**
	 * @return the list
	 */
	
	public JList<String> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(JList<String> list) {
		this.list = list;
	}

	/**
	 * @return the mnArchivo
	 */
	public JMenu getMnArchivo() {
		return mnArchivo;
	}

	/**
	 * @param mnArchivo the mnArchivo to set
	 */
	public void setMnArchivo(JMenu mnArchivo) {
		this.mnArchivo = mnArchivo;
	}

	/**
	 * @return the mntmDepartamentos
	 */
	public JMenuItem getMntmDepartamentos() {
		return mntmDepartamentos;
	}

	/**
	 * @param mntmDepartamentos the mntmDepartamentos to set
	 */
	public void setMntmDepartamentos(JMenuItem mntmDepartamentos) {
		this.mntmDepartamentos = mntmDepartamentos;
	}

	/**
	 * @return the mntmActualizarCosto
	 */
	public JMenuItem getMntmActualizarCosto() {
		return mntmActualizarCosto;
	}

	/**
	 * @param mntmActualizarCosto the mntmActualizarCosto to set
	 */
	public void setMntmActualizarCosto(JMenuItem mntmActualizarCosto) {
		this.mntmActualizarCosto = mntmActualizarCosto;
	}
}
