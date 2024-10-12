package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ModificarProducto extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JComboBox cboProductos;
	private JLabel lblNewLabel;
	private JLabel lblPrecio;
	private JLabel lblStockActua;
	private JLabel lblStockMinimo;
	private JLabel lblStockMaximo;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtStockActual;
	private JTextField txtStockMinimo;
	private JTextField txtStockMaximo;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void abrirVentana() {
		try {
			ModificarProducto dialog = new ModificarProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Create the dialog.
	 */
	public ModificarProducto() {
		setTitle("Modificar Producto");
		setResizable(false);
		setBounds(100, 100, 379, 369);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 363, 330);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(77, 43, 208, 246);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		cboProductos = new JComboBox();
		cboProductos.setBounds(0, 0, 208, 22);
		panel_1.add(cboProductos);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(0, 50, 82, 14);
		panel_1.add(lblNewLabel);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(0, 75, 82, 14);
		panel_1.add(lblPrecio);
		
		lblStockActua = new JLabel("Stock Actual");
		lblStockActua.setBounds(0, 100, 82, 14);
		panel_1.add(lblStockActua);
		
		lblStockMinimo = new JLabel("Stock minimo");
		lblStockMinimo.setBounds(0, 125, 82, 14);
		panel_1.add(lblStockMinimo);
		
		lblStockMaximo = new JLabel("Stock maximo");
		lblStockMaximo.setBounds(0, 150, 82, 14);
		panel_1.add(lblStockMaximo);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(92, 47, 116, 20);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(92, 72, 116, 20);
		panel_1.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtStockActual = new JTextField();
		txtStockActual.setBounds(92, 97, 116, 20);
		panel_1.add(txtStockActual);
		txtStockActual.setColumns(10);
		
		txtStockMinimo = new JTextField();
		txtStockMinimo.setBounds(92, 122, 116, 20);
		panel_1.add(txtStockMinimo);
		txtStockMinimo.setColumns(10);
		
		txtStockMaximo = new JTextField();
		txtStockMaximo.setBounds(92, 147, 116, 20);
		panel_1.add(txtStockMaximo);
		txtStockMaximo.setColumns(10);
		
		btnConfirmar = new JButton("New button");
		btnConfirmar.setBounds(0, 223, 89, 23);
		panel_1.add(btnConfirmar);
		
		btnCancelar = new JButton("New button");
		btnCancelar.setBounds(119, 223, 89, 23);
		panel_1.add(btnCancelar);
	}
}
