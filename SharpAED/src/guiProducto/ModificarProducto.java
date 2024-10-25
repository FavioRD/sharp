package guiProducto;

import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import clases.Producto;
import utilidades.Validacion;
import arreglos.ArregloProductos;

public class ModificarProducto extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtStockAct;
	private JTextField txtStockMin;
	private JTextField txtStockMax;
	private JComboBox<Producto> cboProducto;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private ArregloProductos arregloProducto; // Aquí estará el arreglo de productos

	/**
	 * Launch the application.
	 */
	public static void abrirVentana() {
		try {
			ModificarProducto dialog = new ModificarProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModificarProducto() {

		setBounds(100, 100, 579, 359);
		getContentPane().setLayout(null);

		JTextArea txtS = new JTextArea();
		txtS.setText("MODIFICAR PRODUCTO");
		txtS.setBounds(280, 0, 283, 320);
		getContentPane().add(txtS);

		
		cboProducto = new JComboBox<Producto>();
		cboProducto.setBounds(41, 30, 188, 22);
		getContentPane().add(cboProducto);

	
		cargarProductosEnCombo();

	
		cboProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedcboProducto(e);
			}
		});

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(10, 107, 109, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Precio ");
		lblNewLabel_2.setBounds(10, 143, 46, 14);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Stock actual");
		lblNewLabel_3.setBounds(10, 181, 82, 14);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Stock minimo");
		lblNewLabel_4.setBounds(10, 220, 82, 14);
		getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Stock maximo");
		lblNewLabel_5.setBounds(10, 263, 82, 14);
		getContentPane().add(lblNewLabel_5);

		txtNombre = new JTextField();
		txtNombre.setBounds(143, 104, 86, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(145, 140, 86, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);

		txtStockAct = new JTextField();
		txtStockAct.setBounds(145, 178, 86, 20);
		getContentPane().add(txtStockAct);
		txtStockAct.setColumns(10);

		txtStockMin = new JTextField();
		txtStockMin.setBounds(143, 217, 86, 20);
		getContentPane().add(txtStockMin);
		txtStockMin.setColumns(10);

		txtStockMax = new JTextField();
		txtStockMax.setBounds(145, 260, 86, 20);
		getContentPane().add(txtStockMax);
		txtStockMax.setColumns(10);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnRegistrar(e);
			}
		});
		btnRegistrar.setBounds(20, 288, 89, 23);
		getContentPane().add(btnRegistrar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(130, 288, 89, 23);
		getContentPane().add(btnCancelar);
	}


	private void cargarProductosEnCombo() {
		for (int i = 0; i < ArregloProductos.tamano(); i++) {
			Producto producto = ArregloProductos.getProducto(i);
			cboProducto.addItem(producto);
		}
	}

	protected void actionPerformedcboProducto(ActionEvent e) {
		Producto productoSeleccionado = (Producto) cboProducto.getSelectedItem();

		if (productoSeleccionado != null) {
			txtNombre.setText(productoSeleccionado.getNombre());
			txtPrecio.setText("" + productoSeleccionado.getPrecio());
			txtStockAct.setText("" + productoSeleccionado.getStockActual());
			txtStockMin.setText("" + productoSeleccionado.getStockMinimo());
			txtStockMax.setText("" + productoSeleccionado.getStockMaximo());
		}
	}

	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		validarCampos();
	}

	private void validarCampos() {
		boolean nombreValido = Validacion.validarString(txtNombre.getText());
		boolean precioValido = Validacion.validarPrecio(Double.parseDouble(txtPrecio.getText()));
		boolean stockActualValido = Validacion.validarStock(Integer.parseInt(txtStockAct.getText()));
		boolean stockMinimoValido = Validacion.validarStockMinimo(Integer.parseInt(txtStockMin.getText()));
		boolean stockMaximoValido = Validacion.validarStockMaximo(Integer.parseInt(txtStockMax.getText()));

		if (nombreValido && precioValido && stockActualValido && stockMinimoValido && stockMaximoValido) {
			modificarProducto();
		} else {
			JOptionPane.showMessageDialog(null, "Datos incorrectos");
		}
	}

	private void modificarProducto() {
		int i = cboProducto.getSelectedIndex();
		
		Producto producto = new Producto(txtNombre.getText(), Double.parseDouble(txtPrecio.getText()),
				Integer.parseInt(txtStockAct.getText()), Integer.parseInt(txtStockMin.getText()),
				Integer.parseInt(txtStockMax.getText()), ArregloProductos.getProducto(i).getTotalAcumulado(), ArregloProductos.getProducto(i).getCantidadVendida());

		ArregloProductos.modificarProducto(i, producto);

		JOptionPane.showMessageDialog(null, "Producto modificado");
		this.dispose();
	}
}
