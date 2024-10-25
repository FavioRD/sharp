package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloClientes;
import arreglos.ArregloProductos;
import arreglos.ArregloVentas;
import guiClientes.AgregarCliente;
import guiClientes.ConsultarCliente;
import guiClientes.EliminarCliente;
import guiClientes.ListarClientes;
import guiClientes.ModificarCliente;
import guiProducto.ConsultarProducto;
import guiProducto.EliminarProducto;
import guiProducto.ListarProducto;
import guiProducto.ModificarProducto;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class Home extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_3;
	private JMenu mnNewMenu_4;
	private JPanel panel;
	private JButton btnRegistrarVenta;
	private JButton btnAgregarCliente;
	private JButton btnListarProductos;
	private JButton btnAgregarProducto;
	private JButton btnGenerarReporte;
	private JButton btnConfig;
	private JMenu mnNewMenu_5;
	private JMenu mnNewMenu_6;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmNewMenuItem_7;
	private JMenuItem menuConsultarCliente;
	private JMenuItem menuModificarCliente;
	private JMenuItem mntmNewMenuItem_9;

	ArregloClientes arregloClientes = new ArregloClientes();
	ArregloProductos arregloProductos = new ArregloProductos();
	ArregloVentas arregloVentas = new ArregloVentas();
	/**
	 * Launch the application.
	 */

	public static void abrirVentana() {
		try {
			Home dialog = new Home();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Create the dialog.
	 */
	public Home() {
		setTitle("SharpManager");
		setBounds(100, 100, 823, 509);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		panel = new JPanel();
		panel.setBounds(109, 71, 588, 306);
		contentPanel.add(panel);
		panel.setLayout(new GridLayout(0, 3, 10, 10));

		btnRegistrarVenta = new JButton("Registrar Venta");
		btnRegistrarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnRegistrarVenta(e);
			}
		});
		panel.add(btnRegistrarVenta);

		btnAgregarCliente = new JButton("Agregar Cliente");
		btnAgregarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnAgregarCliente(e);
			}
		});
		panel.add(btnAgregarCliente);

		btnListarProductos = new JButton("Listar Productos");
		btnListarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnListarProductos(e);
			}
		});
		panel.add(btnListarProductos);

		btnAgregarProducto = new JButton("Agregar Producto");
		panel.add(btnAgregarProducto);

		btnGenerarReporte = new JButton("Generar Reporte");
		panel.add(btnGenerarReporte);

		btnConfig = new JButton("Configuración");
		panel.add(btnConfig);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnNewMenu = new JMenu("Mantenimiento");
		menuBar.add(mnNewMenu);

		mnNewMenu_5 = new JMenu("Productos");
		mnNewMenu.add(mnNewMenu_5);

		mntmNewMenuItem = new JMenuItem("Agregar Producto");
		mnNewMenu_5.add(mntmNewMenuItem);

		mntmNewMenuItem_1 = new JMenuItem("Listar Productos");
		mnNewMenu_5.add(mntmNewMenuItem_1);

		mntmNewMenuItem_2 = new JMenuItem("Consultar Producto");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmNewMenuItem_2(e);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_2);

		mntmNewMenuItem_4 = new JMenuItem("Modificar Producto");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmNewMenuItem_4(e);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_4);

		mntmNewMenuItem_3 = new JMenuItem("Borrar Producto");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmNewMenuItem_3(e);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_3);

		mnNewMenu_6 = new JMenu("Clientes");
		mnNewMenu.add(mnNewMenu_6);

		mntmNewMenuItem_5 = new JMenuItem("Agregar Cliente");
		mnNewMenu_6.add(mntmNewMenuItem_5);

		menuConsultarCliente = new JMenuItem("Consultar Cliente");
	    menuConsultarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedmenuConsultarCliente(e);
			}
		});
		mnNewMenu_6.add(menuConsultarCliente);

		mntmNewMenuItem_7 = new JMenuItem("Listar Clientes");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmNewMenuItem_7(e);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_7);

		menuModificarCliente = new JMenuItem("Modificar Cliente");
		menuModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMenuModificarCliente(e);
			}
		});
		mnNewMenu_6.add(menuModificarCliente);

		mntmNewMenuItem_9 = new JMenuItem("Borrar Cliente");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmNewMenuItem_9(e);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_9);

		mnNewMenu_1 = new JMenu("Ventas");
		menuBar.add(mnNewMenu_1);

		mnNewMenu_2 = new JMenu("Almacen");
		menuBar.add(mnNewMenu_2);

		mnNewMenu_3 = new JMenu("Reportes");
		menuBar.add(mnNewMenu_3);

		mnNewMenu_4 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_4);
	}

	protected void actionPerformedBtnRegistrarVenta(ActionEvent e) {
		CrearVenta.abrirVentana();

	}

	protected void actionPerformedMenuModificarCliente(ActionEvent e) {
		ModificarCliente.abrirVentana();
	}

	protected void actionPerformedMntmNewMenuItem_4(ActionEvent e) {
		ModificarProducto.abrirVentana();
	}

	protected void actionPerformedMntmNewMenuItem_7(ActionEvent e) {
		ListarClientes.abrirVentana();
	}

	protected void actionPerformedmenuConsultarCliente(ActionEvent e) {
		ConsultarCliente.abrirVentana();
	}

	protected void actionPerformedBtnAgregarCliente(ActionEvent e) {
		AgregarCliente.abrirVentana();
	}

	protected void actionPerformedMntmNewMenuItem_9(ActionEvent e) {
		EliminarCliente.abrirVentana();
	}

	protected void actionPerformedMntmNewMenuItem_2(ActionEvent e) {
		 ConsultarProducto.abrirVentana();
	}

	protected void actionPerformedMntmNewMenuItem_3(ActionEvent e) {
		EliminarProducto.abrirVentana();
	}

	protected void actionPerformedBtnListarProductos(ActionEvent e) {
		ListarProducto.abrirVentana();
	}

	}
