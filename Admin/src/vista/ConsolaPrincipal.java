package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;

import javax.swing.JPanel;
import controlador.ControladorAbrir;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.Insets;
public class ConsolaPrincipal {

	private JFrame mainFrame;
	private JPanel panel;

	/**
	 * Create the application.
	 */
	public ConsolaPrincipal() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
					
					//ConsolaProductos cpro = new ConsolaProductos(mainFrame, null);
					//ConsolaGrupos cg = new ConsolaGrupos();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setBounds(new Rectangle(25, 25, 450, 150));
		mainFrame.setVisible(true);
		mainFrame.setSize(450, 150);
		mainFrame.setTitle("AdminSoft V. 1.3");
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		mainFrame.getContentPane().add(panel, BorderLayout.CENTER);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.CENTER, 5, 5);
		fl_panel.setAlignOnBaseline(true);
		panel.setLayout(fl_panel);
		
		JButton btnInsumos = new JButton("");
		btnInsumos.setActionCommand("Abrir Insumos");
		btnInsumos.setRolloverIcon(new ImageIcon(ConsolaPrincipal.class.getResource("/imagenes/btnIsumos_activo_over.png")));
		btnInsumos.setPressedIcon(new ImageIcon(ConsolaPrincipal.class.getResource("/imagenes/btnIsumos_activo_click.png")));
		btnInsumos.setDisabledIcon(new ImageIcon(ConsolaPrincipal.class.getResource("/imagenes/btnIsumos_desactivado.png")));
		btnInsumos.setIcon(new ImageIcon(ConsolaPrincipal.class.getResource("/imagenes/btnIsumos_activo.png")));
		btnInsumos.setBorder(null);
		btnInsumos.setContentAreaFilled(false);
		btnInsumos.setBorderPainted(false);
		btnInsumos.setOpaque(false);
		btnInsumos.setMargin(new Insets(0, 0, 0, 0));
		btnInsumos.addActionListener(new ControladorAbrir(this.mainFrame, null));
		panel.add(btnInsumos);
		
		JButton btnDeptos = new JButton("");
		btnDeptos.setActionCommand("Abrir Departamentos");
		btnDeptos.setRolloverIcon(new ImageIcon(ConsolaPrincipal.class.getResource("/imagenes/btnDeptos_activo_over.png")));
		btnDeptos.setPressedIcon(new ImageIcon(ConsolaPrincipal.class.getResource("/imagenes/btnDeptos_activo_click.png")));
		btnDeptos.setDisabledIcon(new ImageIcon(ConsolaPrincipal.class.getResource("/imagenes/btnDeptos_desactivado.png")));
		btnDeptos.setIcon(new ImageIcon(ConsolaPrincipal.class.getResource("/imagenes/btnDeptos_activo.png")));
		btnDeptos.setBorder(null);
		btnDeptos.setContentAreaFilled(false);
		btnDeptos.setBorderPainted(false);
		btnDeptos.setOpaque(false);
		btnDeptos.setMargin(new Insets(0, 0, 0, 0));
		btnDeptos.addActionListener(new ControladorAbrir(this.mainFrame, null));
		panel.add(btnDeptos);
		
		JButton btnProductos = new JButton("");
		btnProductos.setActionCommand("Abrir Productos");
		btnProductos.setRolloverIcon(new ImageIcon(ConsolaPrincipal.class.getResource("/imagenes/btnProductos_activo_over.png")));
		btnProductos.setPressedIcon(new ImageIcon(ConsolaPrincipal.class.getResource("/imagenes/btnProductos_activo_click.png")));
		btnProductos.setDisabledIcon(new ImageIcon(ConsolaPrincipal.class.getResource("/imagenes/btnProductos_desactivado.png")));
		btnProductos.setIcon(new ImageIcon(ConsolaPrincipal.class.getResource("/imagenes/btnProductos_activo.png")));
		btnProductos.setBorder(null);
		btnProductos.setContentAreaFilled(false);
		btnProductos.setBorderPainted(false);
		btnProductos.setOpaque(false);
		btnProductos.setMargin(new Insets(0, 0, 0, 0));
		btnProductos.addActionListener(new ControladorAbrir(this.mainFrame, null));
		panel.add(btnProductos);
		
		
	}

	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return mainFrame;
	}

	/**
	 * @param frame the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.mainFrame = frame;
	}

	/**
	 * @return the panel
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * @param panel the panel to set
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
}


