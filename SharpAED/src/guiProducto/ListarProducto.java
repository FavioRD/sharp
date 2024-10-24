package guiProducto;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import arreglos.ArregloProductos;
import clases.Producto;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class ListarProducto extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JTable table;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void abrirVentana() {
		try {
			ListarProducto frame = new ListarProducto();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public ListarProducto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 592, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Listar");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(10, 44, 89, 23);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 78, 556, 172);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		scrollPane.setViewportView(table);
		
		model = new DefaultTableModel();
		model.addColumn("Nombre");
		model.addColumn("Precio");
		model.addColumn("Stock Actual");
		model.addColumn("Stock Minimo");
		model.addColumn("Stock Maximo");
		table.setModel(model);
		
		lblNewLabel = new JLabel("Lista de Productos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(196, 11, 217, 29);
		contentPane.add(lblNewLabel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
	listarProductos();	
	}
	
	
	private void listarProductos() {
	    ArrayList<Producto> productos = ArregloProductos.getProductos();
	    model.setRowCount(0);
	
	    for (Producto producto : productos) {
	        String[] row = {
	            producto.getNombre(),
	            String.valueOf(producto.getPrecio()), 
	            String.valueOf(producto.getStockActual()), 
	            String.valueOf(producto.getStockMinimo()), 
	            String.valueOf(producto.getStockMaximo())};
	        model.addRow(row);
	    }
	}
		}

