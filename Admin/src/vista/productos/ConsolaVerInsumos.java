package vista.productos;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controlador.insumos.DatosLista;
import controlador.productos.ControladorRetornoDeSeleccion;
import controlador.productos.ControladorSeleccionProducto;

public class ConsolaVerInsumos {

	private JDialog frmInsumos;
	private JList<String> list;
	private JPanel panel;
	private JButton btnSeleccionar;
	private TablaModelo tablaModelo;
	private int row;

	/**
	 * Create the application.
	 */
	public ConsolaVerInsumos(JFrame frame, JDialog dialog) {
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
		frmInsumos.setTitle("Buscar Insumos");
		frmInsumos.setBounds(100, 100, 550, 350);
		frmInsumos.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setMinimumSize(new Dimension(0, 0));
		scrollPane.setMaximumSize(new Dimension(0, 0));
		scrollPane.setPreferredSize(new Dimension(450, 300));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frmInsumos.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setPreferredSize(new Dimension(400, 200));
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setListData(new DatosLista().dameDatos());
		list.addListSelectionListener(new ControladorSeleccionProducto(this));
		scrollPane.setViewportView(list);
		
		JLabel lblInsumos = new JLabel("Insumos");
		lblInsumos.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblInsumos.setPreferredSize(new Dimension(40, 20));
		lblInsumos.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblInsumos.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsumos.setFont(new Font("Arial", Font.BOLD, 12));
		scrollPane.setColumnHeaderView(lblInsumos);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(450, 50));
		frmInsumos.getContentPane().add(panel, BorderLayout.SOUTH);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setEnabled(false);
		btnSeleccionar.addActionListener(new ControladorRetornoDeSeleccion(this,tablaModelo,row));
		panel.add(btnSeleccionar);
	}

	public JDialog getFrmInsumos() {
		return frmInsumos;
	}

	public void setFrmInsumos(JDialog frmInsumos) {
		this.frmInsumos = frmInsumos;
	}

	public JList<String> getList() {
		return list;
	}

	public void setList(JList<String> list) {
		this.list = list;
	}

	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}

	public void setBtnSeleccionar(JButton btnSeleccionar) {
		this.btnSeleccionar = btnSeleccionar;
	}

	public void pasarDatosCelda(TablaModelo tablaModelo, int row) {
		this.tablaModelo = tablaModelo;
		this.row = row;
		
	}
}
