package vista.productos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controlador.CargaDatosListaComboBox;
import controlador.ControladorAbrir;
import controlador.ControladorCampoID;
import controlador.productos.ControladorAgregarFila;
import controlador.productos.ControladorCampoPrecioProductos;
import controlador.productos.ControladorDatosTabla;
import controlador.productos.ControladorEditarProducto;
import controlador.productos.ControladorEliminarFila;
import controlador.productos.ControladorEliminarProducto;
import controlador.productos.ControladorGuardarProducto;
import controlador.productos.ControladorNuevoProducto;
import controlador.productos.ControladorSeleccionIVAProductos;
import controlador.productos.ControladorSeleccionProducto;
import modelo.Productos;

public class ConsolaProductos {

	private JDialog frmProductos;
	private JTextField campoID;
	private JTextField campoNombre;
	private JTextField campoPreciosIVA;
	private JTextField campoPreciocIVA;
	private JTextField campoIVAPorc;
	private JTextField campoIVA;
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;
	private final JTable table = new JTable();
	private JTextField campoPrecioActual;
	private JTextField campoPrecioSugerido;
	private JTextField campoCostoVal;
	private JButton btnMas;
	private JTextField campoCostoPor;
	private JButton btnMenos;
	private JButton btnNuevo;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnGuardar;
	private JMenuItem mntmSalir;
	private JMenuItem mntmAbrirInsumos;
	private JMenuItem mntmAbrirGrupos;
	private TablaModelo miModelo;
	private JButton btnBuscar;
	private JComboBox<?> comboBoxGrupo;
	private JList<String> list;

	/**
	 * Create the application.
	 * 
	 * @param mainFrame
	 */
	public ConsolaProductos(JFrame frame, JDialog dialog) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize(frame, dialog);
					frmProductos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Initialize the contents of the frmProductos.
	 * 
	 * @param mainFrame
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize(JFrame frame, JDialog dialog) {
		if(frame != null)frmProductos = new JDialog(frame, true);
		else frmProductos = new JDialog(dialog, true);
		//frmProductos = new JDialog();
		frmProductos.setName("Recetas");
		frmProductos.setTitle("ConsolaProductos");
		frmProductos.setBounds(100, 100, 650, 450);
		frmProductos.setResizable(true);
		frmProductos.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		CargaDatosListaComboBox datosBox = new CargaDatosListaComboBox(this);
		frmProductos.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				comboBoxGrupo.setModel(new DefaultComboBoxModel<>(datosBox.getVector()));
			}
		});

		JPanel panelCentral = new JPanel();
		panelCentral.setPreferredSize(new Dimension(400, 80));
		frmProductos.getContentPane().add(panelCentral, BorderLayout.NORTH);
		panelCentral.setLayout(null);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Arial", Font.PLAIN, 12));
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(10, 10, 60, 20);
		panelCentral.add(lblId);

		campoID = new JTextField();
		campoID.setEditable(false);
		campoID.setBounds(80, 10, 90, 20);
		campoID.setColumns(10);
		campoID.addFocusListener(new ControladorCampoID(campoID));
		panelCentral.add(campoID);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre.setBounds(10, 40, 60, 20);
		panelCentral.add(lblNombre);

		campoNombre = new JTextField();
		campoNombre.setEditable(false);
		campoNombre.setBounds(80, 40, 150, 20);
		campoNombre.setColumns(10);
		panelCentral.add(campoNombre);

		JLabel lblGrupo = new JLabel("Grupo");
		lblGrupo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGrupo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblGrupo.setBounds(180, 10, 60, 20);
		panelCentral.add(lblGrupo);

		comboBoxGrupo = new JComboBox<Object>();
		comboBoxGrupo.setEnabled(false);
		comboBoxGrupo.setBounds(250, 10, 120, 20);
		comboBoxGrupo.setModel(new DefaultComboBoxModel<>(datosBox.getVector()));
		panelCentral.add(comboBoxGrupo);

		JTabbedPane panelConfiguracion = new JTabbedPane(JTabbedPane.TOP);
		panelConfiguracion.setPreferredSize(new Dimension(300, 200));
		frmProductos.getContentPane().add(panelConfiguracion, BorderLayout.CENTER);

		JPanel panelGeneral = new JPanel();
		panelGeneral.setLayout(new BorderLayout(0, 0));
		panelConfiguracion.addTab("General", null, panelGeneral, null);

		JPanel panelInformacion = new JPanel();
		panelInformacion.setPreferredSize(new Dimension(450, 100));
		panelInformacion.setLayout(null);
		panelGeneral.add(panelInformacion, BorderLayout.NORTH);

		JLabel lblPrecioSinIva = new JLabel("Precio sin IVA");
		lblPrecioSinIva.setBounds(10, 10, 90, 20);
		lblPrecioSinIva.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecioSinIva.setFont(new Font("Arial", Font.PLAIN, 12));
		panelInformacion.add(lblPrecioSinIva);

		campoPreciosIVA = new JTextField();
		campoPreciosIVA.setEditable(false);
		campoPreciosIVA.setToolTipText("Ingresa unicamente n\u00FAmeros.");
		campoPreciosIVA.setBounds(110, 10, 60, 20);
		campoPreciosIVA.setText("0.00");
		campoPreciosIVA.setName("campoPreciosIVA");
		campoPreciosIVA.addFocusListener(new ControladorCampoPrecioProductos(campoPreciosIVA,rdbtnSi,null));
		panelInformacion.add(campoPreciosIVA);

		JLabel lbltieneIva = new JLabel("\u00BFTiene IVA?");
		lbltieneIva.setBounds(180, 10, 90, 20);
		lbltieneIva.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInformacion.add(lbltieneIva);
		lbltieneIva.setFont(new Font("Arial", Font.PLAIN, 12));
		
		ButtonGroup group = new ButtonGroup();

		rdbtnSi = new JRadioButton("S\u00ED");
		rdbtnSi.setBounds(280, 10, 40, 20);
		rdbtnSi.setEnabled(false);
		rdbtnSi.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtnSi.addActionListener(new ControladorSeleccionIVAProductos(this));
		group.add(rdbtnSi);
		panelInformacion.add(rdbtnSi);

		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(330, 10, 50, 20);
		rdbtnNo.setEnabled(false);
		rdbtnNo.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtnNo.setSelected(true);
		rdbtnNo.addActionListener(new ControladorSeleccionIVAProductos(this));
		group.add(rdbtnNo);
		panelInformacion.add(rdbtnNo);

		JLabel lblPrecioCiva = new JLabel("Precio c/IVA $");
		lblPrecioCiva.setBounds(10, 40, 90, 20);
		lblPrecioCiva.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPrecioCiva.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInformacion.add(lblPrecioCiva);

		campoPreciocIVA = new JTextField();
		campoPreciocIVA.setEditable(false);
		campoPreciocIVA.setBounds(110, 40, 60, 20);
		campoPreciocIVA.setToolTipText("Ingresa unicamente n\u00FAmeros.");
		campoPreciocIVA.setFont(new Font("Arial", Font.PLAIN, 12));
		campoPreciocIVA.setColumns(10);
		campoPreciocIVA.setText("0.00");
		campoPreciocIVA.setColumns(10);
		campoPreciocIVA.setName("campoPreciocIVA");
		campoPreciocIVA.addFocusListener(new ControladorCampoPrecioProductos(this));
		panelInformacion.add(campoPreciocIVA);

		JLabel lblIvaPorc = new JLabel("I.V.A. %");
		lblIvaPorc.setBounds(180, 40, 65, 20);
		panelInformacion.add(lblIvaPorc);
		lblIvaPorc.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIvaPorc.setHorizontalAlignment(SwingConstants.RIGHT);

		campoIVAPorc = new JTextField();
		campoIVAPorc.setBounds(255, 40, 50, 20);
		panelInformacion.add(campoIVAPorc);
		campoIVAPorc.setEditable(false);
		campoIVAPorc.setText("0.00");
		campoIVAPorc.setFont(new Font("Arial", Font.PLAIN, 12));
		campoIVAPorc.setColumns(10);

		JLabel lblIva = new JLabel("I.V.A. $");
		lblIva.setBounds(315, 40, 50, 20);
		panelInformacion.add(lblIva);
		lblIva.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIva.setFont(new Font("Arial", Font.PLAIN, 12));

		campoIVA = new JTextField();
		campoIVA.setBounds(375, 40, 60, 20);
		panelInformacion.add(campoIVA);
		campoIVA.setEditable(false);
		campoIVA.setText("0.00");
		campoIVA.setFont(new Font("Arial", Font.PLAIN, 12));
		campoIVA.setColumns(10);

		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblProductos.setPreferredSize(new Dimension(40, 20));
		lblProductos.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductos.setFont(new Font("Arial", Font.BOLD, 12));
		
		JScrollPane scrollPaneProductos = new JScrollPane();
		scrollPaneProductos.setColumnHeaderView(lblProductos);
		panelGeneral.add(scrollPaneProductos, BorderLayout.CENTER);

		list = new JList();
		list.setListData(new Productos().dameVectorProductos());
		list.addListSelectionListener(new ControladorSeleccionProducto(this));
		scrollPaneProductos.setViewportView(list);

		JPanel panelReceta = new JPanel();
		panelConfiguracion.addTab("Receta", null, panelReceta, null);
		panelReceta.setLayout(new BorderLayout(0, 0));

		JLabel lblRecetas = new JLabel("Receta");
		lblRecetas.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblRecetas.setPreferredSize(new Dimension(40, 20));
		lblRecetas.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblRecetas.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecetas.setFont(new Font("Arial", Font.BOLD, 12));
		
		JScrollPane scrollPaneReceta = new JScrollPane();
		scrollPaneReceta.setPreferredSize(new Dimension(400, 150));
		scrollPaneReceta.setColumnHeaderView(lblRecetas);
		panelReceta.add(scrollPaneReceta, BorderLayout.CENTER);

		// ---------------------TABLA-----------------------TABLA-----------------------TABLA-----------------------TABLA-----------------------

		btnBuscar = new JButton();
		btnBuscar.setIcon(new ImageIcon(ConsolaProductos.class.getResource("/imagenes/lens.png")));
		Vector<Object> columnNames = new Vector<Object>();
		Vector<Object> fila1 = new Vector<Object>();
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		columnNames.add("ID");
		columnNames.add("Buscar");
		columnNames.add("Nombre");
		columnNames.add("Cantidad");
		columnNames.add("Unidad");
		columnNames.add("Precio U");
		columnNames.add("Total");
		fila1.add("");
		fila1.add(btnBuscar);
		fila1.add("");
		fila1.add("");
		fila1.add("");
		fila1.add("");
		data.add(fila1);
		miModelo = new TablaModelo(data, columnNames);
		miModelo.addTableModelListener(new ControladorDatosTabla(miModelo, this));
		table.setModel(miModelo);
		table.setRowHeight(20);
		table.setDefaultRenderer(JButton.class, new ButtonCellRenderer());
		table.setDefaultEditor(JButton.class, new ButtonCellEditor());
		scrollPaneReceta.setViewportView(table);

		// ---------------------TABLAFIN--------------------TABLAFIN--------------------TABLAFIN--------------------TABLAFIN------------------

		JPanel subpanelReceta = new JPanel();
		subpanelReceta.setPreferredSize(new Dimension(400, 70));
		panelReceta.add(subpanelReceta, BorderLayout.NORTH);
		subpanelReceta.setLayout(null);

		JLabel lblPrecioActual = new JLabel("Precio Actual");
		lblPrecioActual.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecioActual.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPrecioActual.setBounds(10, 10, 80, 20);
		subpanelReceta.add(lblPrecioActual);

		campoPrecioActual = new JTextField();
		campoPrecioActual.setEditable(false);
		campoPrecioActual.setBounds(100, 10, 60, 20);
		campoPrecioActual.setColumns(10);
		campoPrecioActual.setText(campoPreciosIVA.getText());
		subpanelReceta.add(campoPrecioActual);

		JLabel lblPrecioSugerido = new JLabel("Precio Sugerido");
		lblPrecioSugerido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecioSugerido.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPrecioSugerido.setBounds(170, 10, 100, 20);
		subpanelReceta.add(lblPrecioSugerido);

		campoPrecioSugerido = new JTextField();
		campoPrecioSugerido.setBounds(280, 10, 80, 20);
		campoPrecioSugerido.setEditable(false);
		campoPrecioSugerido.setFont(new Font("Arial", Font.PLAIN, 12));
		campoPrecioSugerido.setColumns(10);
		subpanelReceta.add(campoPrecioSugerido);

		JLabel lblCosto = new JLabel("Costo $");
		lblCosto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCosto.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCosto.setBounds(10, 40, 80, 20);
		subpanelReceta.add(lblCosto);

		JLabel lblCostoP = new JLabel("Costo %");
		lblCostoP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCostoP.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCostoP.setBounds(170, 40, 100, 20);
		subpanelReceta.add(lblCostoP);

		campoCostoVal = new JTextField();
		campoCostoVal.setEditable(false);
		campoCostoVal.setBounds(100, 40, 60, 20);
		subpanelReceta.add(campoCostoVal);
		campoCostoVal.setColumns(10);

		campoCostoPor = new JTextField();
		campoCostoPor.setEditable(false);
		campoCostoPor.setBounds(280, 40, 80, 20);
		subpanelReceta.add(campoCostoPor);
		campoCostoPor.setColumns(10);

		JPanel panelBotones = new JPanel();
		panelBotones.setPreferredSize(new Dimension(400, 50));
		panelReceta.add(panelBotones, BorderLayout.SOUTH);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNuevo.setBounds(10, 70, 90, 25);
		btnNuevo.addActionListener(new ControladorNuevoProducto(this));
		panelInformacion.add(btnNuevo);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEliminar.setBounds(210, 70, 90, 25);
		btnEliminar.addActionListener(new ControladorEliminarProducto(this));
		panelInformacion.add(btnEliminar);

		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEditar.setBounds(110, 70, 90, 25);
		btnEditar.addActionListener(new ControladorEditarProducto(this));
		panelInformacion.add(btnEditar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnGuardar.setBounds(310, 70, 90, 25);
		btnGuardar.addActionListener(new ControladorGuardarProducto(this));
		panelInformacion.add(btnGuardar);

		btnMas = new JButton();
		btnMas.setIcon(new ImageIcon(ConsolaProductos.class.getResource("/imagenes/icono_mas.gif")));
		btnMas.addActionListener(new ControladorAgregarFila(this));
		panelBotones.add(btnMas);

		btnMenos = new JButton();
		btnMenos.setIcon(new ImageIcon(ConsolaProductos.class.getResource("/imagenes/icono_menos.gif")));
		btnMenos.addActionListener(new ControladorEliminarFila(this));
		panelBotones.add(btnMenos);

		JMenuBar menuBar = new JMenuBar();
		frmProductos.setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmCerrarVentana = new JMenuItem("Cerrar Ventana");
		mnArchivo.add(mntmCerrarVentana);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);

		JMenu mnHerramientas = new JMenu("Herramientas");
		menuBar.add(mnHerramientas);

		mntmAbrirInsumos = new JMenuItem("Abrir Insumos");
		mnHerramientas.add(mntmAbrirInsumos);

		mntmAbrirGrupos = new JMenuItem("Abrir Grupos");
		mntmAbrirGrupos.addActionListener(new ControladorAbrir(null, this.frmProductos));
		mnHerramientas.add(mntmAbrirGrupos);

	}

	/**
	 * @return the frmProductos
	 */
	public JDialog getFrmProductos() {
		return frmProductos;
	}

	/**
	 * @param frmProductos
	 *            the frmProductos to set
	 */
	public void setFrmProductos(JDialog frmProductos) {
		this.frmProductos = frmProductos;
	}

	/**
	 * @return the campoID
	 */
	public JTextField getCampoID() {
		return campoID;
	}

	/**
	 * @param campoID
	 *            the campoID to set
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
	 * @param campoNombre
	 *            the campoNombre to set
	 */
	public void setCampoNombre(JTextField campoNombre) {
		this.campoNombre = campoNombre;
	}

	/**
	 * @return the campoPreciosIVA
	 */
	public JTextField getCampoPreciosIVA() {
		return campoPreciosIVA;
	}

	/**
	 * @param campoPreciosIVA
	 *            the campoPreciosIVA to set
	 */
	public void setCampoPreciosIVA(JTextField campoPreciosIVA) {
		this.campoPreciosIVA = campoPreciosIVA;
	}

	/**
	 * @return the campoPreciocIVA
	 */
	public JTextField getCampoPreciocIVA() {
		return campoPreciocIVA;
	}

	/**
	 * @param campoPreciocIVA
	 *            the campoPreciocIVA to set
	 */
	public void setCampoPreciocIVA(JTextField campoPreciocIVA) {
		this.campoPreciocIVA = campoPreciocIVA;
	}

	/**
	 * @return the campoIVAPorc
	 */
	public JTextField getCampoIVAPorc() {
		return campoIVAPorc;
	}

	/**
	 * @param campoIVAPorc
	 *            the campoIVAPorc to set
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
	 * @param campoIVA
	 *            the campoIVA to set
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
	 * @param rdbtnSi
	 *            the rdbtnSi to set
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
	 * @param rdbtnNo
	 *            the rdbtnNo to set
	 */
	public void setRdbtnNo(JRadioButton rdbtnNo) {
		this.rdbtnNo = rdbtnNo;
	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * @param table
	 *            the table to set
	 */
	/*
	 * public void setTable(JTable table) { this.table = table; }
	 */

	/**
	 * @return the campoPrecioActual
	 */
	public JTextField getCampoPrecioActual() {
		return campoPrecioActual;
	}

	/**
	 * @param campoPrecioActual
	 *            the campoPrecioActual to set
	 */
	public void setCampoPrecioActual(JTextField campoPrecioActual) {
		this.campoPrecioActual = campoPrecioActual;
	}

	/**
	 * @return the campoPrecioSugerido
	 */
	public JTextField getCampoPrecioSugerido() {
		return campoPrecioSugerido;
	}

	/**
	 * @param campoPrecioSugerido
	 *            the campoPrecioSugerido to set
	 */
	public void setCampoPrecioSugerido(JTextField campoPrecioSugerido) {
		this.campoPrecioSugerido = campoPrecioSugerido;
	}

	/**
	 * @return the campoCostoVal
	 */
	public JTextField getCampoCostoVal() {
		return campoCostoVal;
	}

	/**
	 * @param campoCostoVal
	 *            the campoCostoVal to set
	 */
	public void setCampoCostoVal(JTextField campoCostoVal) {
		this.campoCostoVal = campoCostoVal;
	}

	/**
	 * @return the btnMas
	 */
	public JButton getBtnMas() {
		return btnMas;
	}

	/**
	 * @param btnMas
	 *            the btnMas to set
	 */
	public void setBtnMas(JButton btnMas) {
		this.btnMas = btnMas;
	}

	/**
	 * @return the campoCostoPor
	 */
	public JTextField getCampoCostoPor() {
		return campoCostoPor;
	}

	/**
	 * @param campoCostoPor
	 *            the campoCostoPor to set
	 */
	public void setCampoCostoPor(JTextField campoCostoPor) {
		this.campoCostoPor = campoCostoPor;
	}

	/**
	 * @return the btnMenos
	 */
	public JButton getBtnMenos() {
		return btnMenos;
	}

	/**
	 * @param btnMenos
	 *            the btnMenos to set
	 */
	public void setBtnMenos(JButton btnMenos) {
		this.btnMenos = btnMenos;
	}

	/**
	 * @return the btnNuevo
	 */
	public JButton getBtnNuevo() {
		return btnNuevo;
	}

	/**
	 * @param btnNuevo
	 *            the btnNuevo to set
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
	 * @param btnEditar
	 *            the btnEditar to set
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
	 * @param btnEliminar
	 *            the btnEliminar to set
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
	 * @param btnGuardar
	 *            the btnGuardar to set
	 */
	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	/**
	 * @return the mntmSalir
	 */
	public JMenuItem getMntmSalir() {
		return mntmSalir;
	}

	/**
	 * @param mntmSalir
	 *            the mntmSalir to set
	 */
	public void setMntmSalir(JMenuItem mntmSalir) {
		this.mntmSalir = mntmSalir;
	}

	/**
	 * @return the mntmAbrirInsumos
	 */
	public JMenuItem getMntmAbrirInsumos() {
		return mntmAbrirInsumos;
	}

	/**
	 * @param mntmAbrirInsumos
	 *            the mntmAbrirInsumos to set
	 */
	public void setMntmAbrirInsumos(JMenuItem mntmAbrirInsumos) {
		this.mntmAbrirInsumos = mntmAbrirInsumos;
	}

	/**
	 * @return the mntmAbrirGrupos
	 */
	public JMenuItem getMntmAbrirGrupos() {
		return mntmAbrirGrupos;
	}

	/**
	 * @param mntmAbrirGrupos
	 *            the mntmAbrirGrupos to set
	 */
	public void setMntmAbrirGrupos(JMenuItem mntmAbrirGrupos) {
		this.mntmAbrirGrupos = mntmAbrirGrupos;
	}

	/**
	 * @return the miModelo
	 */
	public TablaModelo getMiModelo() {
		return miModelo;
	}

	/**
	 * @param miModelo
	 *            the miModelo to set
	 */
	public void setMiModelo(TablaModelo miModelo) {
		this.miModelo = miModelo;
	}

	/**
	 * @return the btnPrueba
	 */
	public JButton getBtnPrueba() {
		return btnBuscar;
	}

	/**
	 * @param btnPrueba
	 *            the btnPrueba to set
	 */
	public void setBtnPrueba(JButton btnPrueba) {
		this.btnBuscar = btnPrueba;
	}

	/**
	 * @return the comboBoxGrupo
	 */
	public JComboBox<?> getComboBoxGrupo() {
		return comboBoxGrupo;
	}

	/**
	 * @param comboBoxGrupo
	 *            the comboBoxGrupo to set
	 */
	public void setComboBoxGrupo(JComboBox<?> comboBoxGrupo) {
		this.comboBoxGrupo = comboBoxGrupo;
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
}
