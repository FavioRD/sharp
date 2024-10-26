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
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

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
	private JPanel panel;
	private JLabel lblModificarProducto;

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

		setBounds(100, 100, 319, 423);
		getContentPane().setLayout(null);

		
		cboProducto = new JComboBox<Producto>();
		cboProducto.setBounds(57, 64, 188, 22);
		getContentPane().add(cboProducto);

	
		cargarProductosEnCombo();

	
		cboProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedcboProducto(e);
			}
		});
		
		panel = new JPanel();
		panel.setBounds(41, 109, 221, 176);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 10));

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		panel.add(lblNewLabel_1);

		txtNombre = new JTextField();
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
				JLabel lblNewLabel_2 = new JLabel("Precio ");
				panel.add(lblNewLabel_2);

		txtPrecio = new JTextField();
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
				JLabel lblNewLabel_3 = new JLabel("Stock actual");
				panel.add(lblNewLabel_3);

		txtStockAct = new JTextField();
		panel.add(txtStockAct);
		txtStockAct.setColumns(10);
		
				JLabel lblNewLabel_4 = new JLabel("Stock minimo");
				panel.add(lblNewLabel_4);

		txtStockMin = new JTextField();
		panel.add(txtStockMin);
		txtStockMin.setColumns(10);
		
				JLabel lblNewLabel_5 = new JLabel("Stock maximo");
				panel.add(lblNewLabel_5);

		txtStockMax = new JTextField();
		panel.add(txtStockMax);
		txtStockMax.setColumns(10);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnRegistrar(e);
			}
		});
		btnRegistrar.setBounds(42, 311, 89, 23);
		getContentPane().add(btnRegistrar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(172, 311, 89, 23);
		getContentPane().add(btnCancelar);
		
		lblModificarProducto = new JLabel("Modificar Producto");
		lblModificarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarProducto.setForeground(new Color(0, 153, 255));
		lblModificarProducto.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblModificarProducto.setBounds(42, 33, 218, 20);
		getContentPane().add(lblModificarProducto);
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
		ArregloProductos.actualizarProductos();
		JOptionPane.showMessageDialog(null, "Producto modificado");
		this.dispose();
	}
}
