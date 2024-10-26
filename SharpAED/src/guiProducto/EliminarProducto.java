package guiProducto;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import arreglos.ArregloProductos;
import clases.Producto;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class EliminarProducto extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<Producto> cboProducto;
	private JButton btnEliminar;
	private JButton btnCancelar;
	private JLabel lblTitulo;
	private JLabel lblAdvertencia;

	/**
	 * Método para abrir la ventana.
	 */
	public static void abrirVentana() {
		try {
			EliminarProducto frame = new EliminarProducto();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Constructor que crea la ventana.
	 */
	public EliminarProducto() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cboProducto = new JComboBox<Producto>();
		cboProducto.setBounds(52, 64, 312, 34);
		contentPane.add(cboProducto);
		cargarProductos();

		btnEliminar = new JButton("Eliminar Producto");
		btnEliminar.setBorderPainted(false);
		btnEliminar.setBackground(new Color(128, 255, 128));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(52, 208, 150, 23);
		contentPane.add(btnEliminar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBackground(new Color(255, 128, 128));
		btnCancelar.addActionListener(e -> dispose());
		btnCancelar.setBounds(243, 208, 150, 23);
		contentPane.add(btnCancelar);

		lblTitulo = new JLabel("Eliminar Productos");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setBounds(112, 11, 203, 22);
		contentPane.add(lblTitulo);

		lblAdvertencia = new JLabel("Esta acción no se podrá deshacer");
		lblAdvertencia.setForeground(new Color(255, 0, 0));
		lblAdvertencia.setFont(new Font("Segoe UI Symbol", Font.BOLD, 13));
		lblAdvertencia.setBounds(93, 123, 226, 34);
		contentPane.add(lblAdvertencia);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			eliminarProducto();
		}
	}

	private void eliminarProducto() {
		int i = cboProducto.getSelectedIndex();

		if (i != -1 && ArregloProductos.getNroProducto() > 0) {
			ArregloProductos.eliminarProducto(i);
			ArregloProductos.actualizarProductos();
			JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
			actualizarProductos();
		} else {
			JOptionPane.showMessageDialog(null, "No hay productos disponibles o no se seleccionó ninguno.");
		}
	}

	private void cargarProductos() {
		cboProducto.removeAllItems();
		if (ArregloProductos.getNroProducto() > 0) {
			for (int i = 0; i < ArregloProductos.getNroProducto(); i++) {
				cboProducto.addItem(ArregloProductos.getProducto(i));
			}
		} else {
			JOptionPane.showMessageDialog(null, "No hay productos disponibles.");
		}
	}

	private void actualizarProductos() {
		cargarProductos();
	}
}
