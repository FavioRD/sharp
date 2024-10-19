package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloClientes;
import arreglos.ArregloProductos;
import clases.Cliente;
import clases.Producto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearVenta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JComboBox<Cliente> cboClientes;
	private JPanel panel;
	private JComboBox<Producto> cboProductos;
	private JTextField txtPrecio;
	private JTextField txtIGV;
	private JLabel lblNewLabel_5;
	private JTextField txtDescuentoCantidad;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblNewLabel_6;
	private JTextField txtCantidad;

	/**
	 * Launch the application.
	 */
	
	public static void abrirVentana() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearVenta frame = new CrearVenta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public CrearVenta() {
	    setResizable(false);
	    setTitle("Crear Venta");
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setBounds(100, 100, 648, 700);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	    setContentPane(contentPane);
	    contentPane.setLayout(null);

	    lblNewLabel = new JLabel("Crear Venta");
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
	    lblNewLabel.setBounds(10, 11, 112, 23);
	    contentPane.add(lblNewLabel);

	    panel = new JPanel();
	    panel.setBounds(10, 45, 352, 191);
	    contentPane.add(panel);
	    panel.setLayout(new GridLayout(0, 2, 20, 7));

	    lblNewLabel_1 = new JLabel("Cliente");
	    panel.add(lblNewLabel_1);
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

	    cboClientes = new JComboBox<Cliente>();
	    for (int i = 0; i < ArregloClientes.getNroClientes(); i++) {
	        cboClientes.addItem(ArregloClientes.getCliente(i));
	    }
	    panel.add(cboClientes);

	    lblNewLabel_2 = new JLabel("Producto");
	    panel.add(lblNewLabel_2);
	    lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));

	    cboProductos = new JComboBox<Producto>();
	    cboProductos.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            actionPerformedCboProductos(e);
	        }
	    });
	    for (int i = 0; i < ArregloProductos.getNroProducto(); i++) {
	        cboProductos.addItem(ArregloProductos.getProducto(i));
	    }
	    panel.add(cboProductos);

	    lblNewLabel_6 = new JLabel("Cantidad");
	    lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
	    panel.add(lblNewLabel_6);

	    txtCantidad = new JTextField();
	    panel.add(txtCantidad);
	    txtCantidad.setColumns(10);

	    lblNewLabel_4 = new JLabel("Precio Unitario");
	    panel.add(lblNewLabel_4);
	    lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));

	    txtPrecio = new JTextField();
	    panel.add(txtPrecio);
	    txtPrecio.setColumns(10);
	    
	    // Asegúrate de que no estés estableciendo el texto a un espacio en blanco
	    txtPrecio.setText(""); 

	    lblNewLabel_5 = new JLabel("% Descuento por cantidad");
	    lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
	    panel.add(lblNewLabel_5);

	    txtDescuentoCantidad = new JTextField();
	    panel.add(txtDescuentoCantidad);
	    txtDescuentoCantidad.setColumns(10);

	    lblNewLabel_3 = new JLabel("% IGV");
	    panel.add(lblNewLabel_3);
	    lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));

	    txtIGV = new JTextField();
	    panel.add(txtIGV);
	    txtIGV.setColumns(10);

	    // Código adicional para el JTextArea y JTable...
	}
	protected void actionPerformedCboProductos(ActionEvent e) {
		Producto productoSeleccionado = (Producto) cboProductos.getSelectedItem();
	}
}
