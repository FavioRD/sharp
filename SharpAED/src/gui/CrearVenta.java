package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.management.modelmbean.ModelMBean;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloClientes;
import arreglos.ArregloProductos;
import clases.Cliente;
import clases.Producto;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CrearVenta extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JComboBox<Producto> cboProductos;
	private JComboBox<Cliente> cboClientes;
	private JLabel txtPrecio;
	private JLabel lblNewLabel_3;
	private JTextField txtIGV;
	private JLabel lblNewLabel_5;
	private JTextField txtCantidad;
	private JTextArea txtDesc;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnCrearVenta;
	private JButton btnNewButton_1;

	private String cantidad = "0";

	/**
	 * Launch the application.
	 */

	public static void abrirVentana() {
		try {
			CrearVenta dialog = new CrearVenta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearVenta() {
		setTitle("Crear Venta");
		setBounds(100, 100, 645, 699);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 362, 609, 214);
		contentPanel.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nombre", "Cantidad",
				"Precio Unitario", "Subtotal", "IGV", "Descuento", "Total" }));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);

		panel = new JPanel();
		panel.setBounds(10, 11, 352, 214);
		contentPanel.add(panel);
		panel.setLayout(new GridLayout(0, 2, 6, 12));

		lblNewLabel = new JLabel("Producto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblNewLabel);

		cboProductos = new JComboBox();
		for (Producto producto : ArregloProductos.getProductos()) {
			cboProductos.addItem(producto);
		}
		cboProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedCboProductos(e);
			}
		});
		panel.add(cboProductos);

		lblNewLabel_1 = new JLabel("Cliente");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblNewLabel_1);

		cboClientes = new JComboBox<Cliente>();
		for (Cliente cliente : ArregloClientes.getClientes()) {
			cboClientes.addItem(cliente);
		}
		panel.add(cboClientes);

		lblNewLabel_5 = new JLabel("Cantidad");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblNewLabel_5);

		txtCantidad = new JTextField();

		panel.add(txtCantidad);
		txtCantidad.setColumns(10);

		lblNewLabel_2 = new JLabel("Precio unitario");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblNewLabel_2);

		txtPrecio = new JLabel("S/ 0.00");
		panel.add(txtPrecio);

		lblNewLabel_3 = new JLabel("IGV");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblNewLabel_3);

		txtIGV = new JTextField();
		txtIGV.setText("3");
		txtIGV.setEnabled(false);
		txtIGV.setEditable(false);
		panel.add(txtIGV);
		txtIGV.setColumns(10);

		txtDesc = new JTextArea();
		txtDesc.setEditable(false);
		txtDesc.setBounds(10, 246, 609, 118);
		contentPanel.add(txtDesc);

		btnCrearVenta = new JButton("Crear");
		btnCrearVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnCrearVenta(e);
			}
		});
		btnCrearVenta.setBounds(463, 11, 89, 23);
		contentPanel.add(btnCrearVenta);

		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(463, 45, 89, 23);
		contentPanel.add(btnNewButton_1);
	}

	protected void actionPerformedCboProductos(ActionEvent e) {
		Producto producto = (Producto) cboProductos.getSelectedItem();
		txtPrecio.setText("S/ " + producto.getPrecio());
	}

	protected void actionPerformedBtnCrearVenta(ActionEvent e) {
		listarTabla();

	}

	protected Cliente getCliente() {
		return (Cliente) cboClientes.getSelectedItem();
	}

	protected Producto getProducto() {
		return (Producto) cboProductos.getSelectedItem();
	}

	protected void listarTabla() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		if (table.getRowCount() > 0) {
			model.setRowCount(0);
		}

		Producto prod = getProducto();
		int cantidad = Integer.parseInt(txtCantidad.getText());
		double precio = prod.getPrecio();
		double subtotal = cantidad * precio;
		double igv = Double.parseDouble(txtIGV.getText());
		double igvTotal = subtotal * (igv / 100);
		double total = subtotal + igvTotal;

		model.addRow(new Object[] { prod.getCodigoProducto(), prod.getNombre(), cantidad, precio, subtotal, igvTotal,
				total });

	}

}
