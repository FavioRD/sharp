package guiProducto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloProductos;
import clases.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;


public class AgregarProducto extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtStockAct;
	private JTextField txtStockMin;
	private JTextField txtStockMax;
	private JButton btnAgregar;
	private JButton btnSalir;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblNewLabel_5;
	

	/**
	 * Launch the application.
	 */
	public static void abrirVentana() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarProducto frame = new AgregarProducto();
					frame.setLocationRelativeTo(null);
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
	public AgregarProducto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 564, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 83, 106, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Precio");
		lblNewLabel_1.setBounds(10, 119, 106, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Stock Actual");
		lblNewLabel_2.setBounds(10, 153, 106, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Stock Minimo");
		lblNewLabel_3.setBounds(10, 189, 106, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Stock Maximo");
		lblNewLabel_4.setBounds(10, 228, 106, 14);
		contentPane.add(lblNewLabel_4);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(126, 80, 136, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(126, 116, 136, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtStockAct = new JTextField();
		txtStockAct.setBounds(126, 150, 136, 20);
		contentPane.add(txtStockAct);
		txtStockAct.setColumns(10);
		
		txtStockMin = new JTextField();
		txtStockMin.setBounds(126, 186, 136, 20);
		contentPane.add(txtStockMin);
		txtStockMin.setColumns(10);
		
		txtStockMax = new JTextField();
		txtStockMax.setBounds(126, 225, 136, 20);
		contentPane.add(txtStockMax);
		txtStockMax.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(414, 79, 89, 23);
		contentPane.add(btnAgregar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(414, 115, 89, 23);
		contentPane.add(btnSalir);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 271, 528, 206);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object [][]{},
				new String[] {"Codigo","Nombre","Precio","Stock Actual","Stock Minimo","Stock Maximo"}));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		lblNewLabel_5 = new JLabel("Agregar Productos");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(10, 11, 218, 45);
		contentPane.add(lblNewLabel_5);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
		if (e.getSource() == btnSalir) {
			actionPerformedBtnNewButton_1(e);
		}
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
	}
	private void agregarProducto() {

	    String nombre = txtNombre.getText();
	    String precioTexto = txtPrecio.getText();
	    String stockActualTexto = txtStockAct.getText();
	    String stockMinimoTexto = txtStockMin.getText();
	    String stockMaximoTexto = txtStockMax.getText();
	
	    if (nombre.isEmpty() || precioTexto.isEmpty() || stockActualTexto.isEmpty() || 
	        stockMinimoTexto.isEmpty() || stockMaximoTexto.isEmpty()) {	
	    	JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos", "Falta completar los campos",JOptionPane.WARNING_MESSAGE);
	        return; 
	    }
	    try {
	        double precio = Double.parseDouble(precioTexto);
	        int stockActual = Integer.parseInt(stockActualTexto);
	        int stockMinimo = Integer.parseInt(stockMinimoTexto);
	        int stockMaximo = Integer.parseInt(stockMaximoTexto);

	        Producto producto = new Producto(nombre, precio, stockActual, stockMinimo, stockMaximo, 0, 0);
	        ArregloProductos.agregarProducto(producto);
	        ArregloProductos.actualizarProductos();
	        listar();
	    } catch (NumberFormatException e) {
	    	JOptionPane.showMessageDialog(null, "Agrega valores numericos validos en los campos de Precio y Stock");
	    }
	}

	private void listar() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		for (int i = 0; i < ArregloProductos.tamano(); i++) {
			model.addRow(new Object[] { ArregloProductos.getProducto(i).getCodigoProducto(),
					ArregloProductos.getProducto(i).getNombre(), ArregloProductos.getProducto(i).getPrecio(),
					ArregloProductos.getProducto(i).getStockActual(),
					ArregloProductos.getProducto(i).getStockMinimo(), ArregloProductos.getProducto(i).getStockMaximo() });
		}

	}
	private void limpiar() {
		txtNombre.setText("");
		txtPrecio.setText("");
		txtStockAct.setText("");
		txtStockMin.setText("");
		txtStockMax.setText("");
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		agregarProducto();
		limpiar();
	}
	
}
