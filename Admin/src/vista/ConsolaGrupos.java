package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controlador.departamentos_grupos.ControladorEditar;
import controlador.departamentos_grupos.ControladorEliminar;
import controlador.departamentos_grupos.ControladorGuardar;
import controlador.departamentos_grupos.ControladorNuevo;
import controlador.departamentos_grupos.ControladorSeleccionList;
import controlador.departamentos_grupos.DatosLista;
import controlador.departamentos_grupos.InterfaceDepartamentosGrupos;


public class ConsolaGrupos {

	private JDialog frmGrupos;
	private JTextField campoID;
	private JTextField campoNombre;
	private JButton btnNuevo;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnGuardar;
	private JList<?> list;
	private JMenuItem mntmSalir;

	/**
	 * Create the application.
	 * @param object 
	 */
	public ConsolaGrupos(JFrame frame, JDialog dialog) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize(frame, dialog);
					frmGrupos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @param object 
	 */
	@SuppressWarnings("unchecked")
	private void initialize(JFrame frame, JDialog dialog) {
		if(frame != null)frmGrupos = new JDialog(frame, true);
		else frmGrupos = new JDialog(dialog, true);
		frmGrupos.setTitle("Grupos");
		frmGrupos.setResizable(false);
		frmGrupos.setBounds(100, 100, 450, 300);
		frmGrupos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//frmGrupos.addWindowListener(new ControladorVentana(frameProductos));

		JPanel panelCentral = new JPanel();
		panelCentral.setMinimumSize(new Dimension(450, 150));
		frmGrupos.getContentPane().add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("Arial", Font.PLAIN, 12));
		lblId.setBounds(10, 10, 60, 20);
		panelCentral.add(lblId);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre.setBounds(10, 40, 60, 20);
		panelCentral.add(lblNombre);

		campoID = new JTextField();
		campoID.setEnabled(false);
		campoID.setFont(new Font("Arial", Font.PLAIN, 12));
		campoID.setBounds(80, 10, 80, 20);
		panelCentral.add(campoID);
		campoID.setColumns(10);

		campoNombre = new JTextField();
		campoNombre.setEnabled(false);
		campoNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		campoNombre.setBounds(80, 40, 150, 20);
		panelCentral.add(campoNombre);
		campoNombre.setColumns(10);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNuevo.setBounds(10, 70, 90, 25);
		panelCentral.add(btnNuevo);
		btnNuevo.addActionListener(new ControladorNuevo(this));

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEliminar.setBounds(210, 70, 90, 25);
		btnEliminar.addActionListener(new ControladorEliminar(this));
		panelCentral.add(btnEliminar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEditar.setBounds(110, 70, 90, 25);
		btnEditar.addActionListener(new ControladorEditar(this));
		panelCentral.add(btnEditar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnGuardar.setBounds(310, 70, 90, 25);
		panelCentral.add(btnGuardar);
		btnGuardar.addActionListener(new ControladorGuardar(this));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(450, 150));
		scrollPane.setMaximumSize(new Dimension(450, 150));
		scrollPane.setMinimumSize(new Dimension(450, 150));
		frmGrupos.getContentPane().add(scrollPane, BorderLayout.SOUTH);

		list = new JList<Object>();
		list.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		list.setListData(new DatosLista().getVector(InterfaceDepartamentosGrupos.GPO));
		list.addListSelectionListener(new ControladorSeleccionList(this));
		scrollPane.setViewportView(list);

		JLabel lblDepartamentos = new JLabel("GRUPOS");
		lblDepartamentos.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblDepartamentos.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblDepartamentos.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepartamentos.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setColumnHeaderView(lblDepartamentos);
		
		JMenuBar menuBar = new JMenuBar();
		frmGrupos.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		//mntmSalir.addActionListener(new ControladorSalir(this));
		mnArchivo.add(mntmSalir);
	}

	/**
	 * @return the frmGrupos
	 */
	public JDialog getFrmGrupos() {
		return frmGrupos;
	}

	/**
	 * @param frmGrupos the frmGrupos to set
	 */
	public void setFrmGrupos(JDialog frmGrupos) {
		this.frmGrupos = frmGrupos;
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
	 * @return the list
	 */
	public JList<?> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(JList<?> list) {
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

}
