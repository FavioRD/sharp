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
import guiReportes.ListadoVentas;

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
	private JMenuItem itemAgregarProducto;
	private JMenuItem itemListarProductos;
	private JMenuItem itemBuscarProductos;
	private JMenuItem itemBorrarProducto;
	private JMenuItem itemModificarProducto;
	private JMenuItem itemAgregarCliente;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem itemListarClientes;
	private JMenuItem itemConsultarCliente;
	private JMenuItem itemModificarCliente;
	private JMenuItem itemBorrarCliente;

	ArregloClientes arregloClientes = new ArregloClientes();
	ArregloProductos arregloProductos = new ArregloProductos();
	ArregloVentas arregloVentas = new ArregloVentas();
	private JMenuItem itemAgregarStock;
	private JMenuItem itemListarVentas;

	/**
	 * Launch the application.
	 */

	public static void abrirVentana(int rol) {
		try {
			Home dialog = new Home();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
			if (rol != 1) {

				dialog.btnAgregarCliente.setEnabled(false);
				dialog.btnAgregarProducto.setEnabled(false);
				dialog.btnConfig.setEnabled(false);
				dialog.itemAgregarCliente.setEnabled(false);
				dialog.itemAgregarProducto.setEnabled(false);
				dialog.itemBorrarProducto.setEnabled(false);
				dialog.itemModificarProducto.setEnabled(false);
				dialog.itemModificarCliente.setEnabled(false);
				dialog.itemBorrarCliente.setEnabled(false);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Home() {
		setResizable(false);
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
		btnGenerarReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnGenerarReporte(e);
			}
		});
		panel.add(btnGenerarReporte);

		btnConfig = new JButton("Configuración");
		panel.add(btnConfig);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnNewMenu = new JMenu("Mantenimiento");
		menuBar.add(mnNewMenu);

		mnNewMenu_5 = new JMenu("Productos");
		mnNewMenu.add(mnNewMenu_5);

		itemAgregarProducto = new JMenuItem("Agregar Producto");
		mnNewMenu_5.add(itemAgregarProducto);

		itemListarProductos = new JMenuItem("Listar Productos");
		mnNewMenu_5.add(itemListarProductos);

		itemBuscarProductos = new JMenuItem("Buscar Producto");
		itemBuscarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmNewMenuItem_2(e);
			}
		});
		mnNewMenu_5.add(itemBuscarProductos);

		itemModificarProducto = new JMenuItem("Modificar Producto");
		itemModificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmNewMenuItem_4(e);
			}
		});
		mnNewMenu_5.add(itemModificarProducto);

		itemBorrarProducto = new JMenuItem("Borrar Producto");
		itemBorrarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmNewMenuItem_3(e);
			}
		});
		mnNewMenu_5.add(itemBorrarProducto);

		mnNewMenu_6 = new JMenu("Clientes");
		mnNewMenu.add(mnNewMenu_6);

		itemAgregarCliente = new JMenuItem("Agregar Cliente");
		mnNewMenu_6.add(itemAgregarCliente);

		itemConsultarCliente = new JMenuItem("Consultar Cliente");
		itemConsultarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedmenuConsultarCliente(e);
			}
		});
		mnNewMenu_6.add(itemConsultarCliente);

		itemListarClientes = new JMenuItem("Listar Clientes");
		itemListarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmNewMenuItem_7(e);
			}
		});
		mnNewMenu_6.add(itemListarClientes);

		itemModificarCliente = new JMenuItem("Modificar Cliente");
		itemModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMenuModificarCliente(e);
			}
		});
		mnNewMenu_6.add(itemModificarCliente);

		itemBorrarCliente = new JMenuItem("Borrar Cliente");
		itemBorrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmNewMenuItem_9(e);
			}
		});
		mnNewMenu_6.add(itemBorrarCliente);

		mnNewMenu_1 = new JMenu("Ventas");
		menuBar.add(mnNewMenu_1);

		mnNewMenu_2 = new JMenu("Almacen");
		menuBar.add(mnNewMenu_2);

		itemAgregarStock = new JMenuItem("Agregar Stock");
		itemAgregarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmNewMenuItem_8(e);
			}
		});
		mnNewMenu_2.add(itemAgregarStock);

		mnNewMenu_3 = new JMenu("Reportes");
		menuBar.add(mnNewMenu_3);

		itemListarVentas = new JMenuItem("Listar Ventas");
		itemListarVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmNewMenuItem_10(e);
			}
		});
		mnNewMenu_3.add(itemListarVentas);

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

	protected void actionPerformedMntmNewMenuItem_8(ActionEvent e) {
		AgregarStock.abrirVentana();
	}

	protected void actionPerformedMntmNewMenuItem_10(ActionEvent e) {
		ListadoVentas.abrirVentana();
	}

	protected void actionPerformedBtnGenerarReporte(ActionEvent e) {
		SeleccionarReporte.abrirVentana();
	}
}
