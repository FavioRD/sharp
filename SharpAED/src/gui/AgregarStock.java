package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import arreglos.ArregloProductos;
import clases.Producto;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;

public class AgregarStock extends JDialog {

	private static final long serialVersionUID = 1L;
	private JButton btnProcesar;
	private JButton btnCancelar;
	private JLabel lblNewLabel;
	private JComboBox<Producto> cboProductos;
	private JLabel lblNuevoStock;
	private JTextField txtNuevoStock;

	/**
	 * Launch the application.
	 */

	public static void abrirVentana() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarStock dialog = new AgregarStock();
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public AgregarStock() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Agregar Stock");
		setBounds(100, 100, 369, 442);
		getContentPane().setLayout(null);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnProcesar(e);
			}
		});
		btnProcesar.setBounds(56, 237, 89, 23);

		getContentPane().add(btnProcesar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(205, 237, 89, 23);
		getContentPane().add(btnCancelar);

		lblNewLabel = new JLabel("Producto");
		lblNewLabel.setBounds(45, 38, 89, 14);
		getContentPane().add(lblNewLabel);

		cboProductos = new JComboBox();
		cboProductos.setBounds(144, 34, 150, 23);
		for (int i = 0; i < ArregloProductos.getNroProducto(); i++) {
			cboProductos.addItem(ArregloProductos.getProducto(i));
		}
		getContentPane().add(cboProductos);

		lblNuevoStock = new JLabel("Nuevo Stock");
		lblNuevoStock.setBounds(45, 77, 89, 14);
		getContentPane().add(lblNuevoStock);

		txtNuevoStock = new JTextField();
		txtNuevoStock.setBounds(144, 74, 86, 20);
		getContentPane().add(txtNuevoStock);
		txtNuevoStock.setColumns(10);

	}

	protected void actionPerformedBtnProcesar(ActionEvent e) {
		int pos = cboProductos.getSelectedIndex();
		Producto prod = ArregloProductos.getProducto(pos);
		boolean stockValido = nuevoStockValido(ArregloProductos.getProducto(pos));

		if (stockValido) {
			actualizarStock(prod, pos);
		}
	}

	public int getNuevoStock() {
		return Integer.parseInt(txtNuevoStock.getText());
	}

	private void actualizarStock(Producto prod, int pos) {
		ArregloProductos.modificarProducto(pos, new Producto(prod.getNombre(), prod.getPrecio(),
				prod.getStockActual() + getNuevoStock(), prod.getStockMinimo(), prod.getStockMaximo(), prod.getTotalAcumulado()));
		ArregloProductos.actualizarProductos();
		JOptionPane.showMessageDialog(this, "Stock actualizado");

	}

	public boolean nuevoStockValido(Producto prod) {
		if (getNuevoStock() > prod.getStockMaximo() || getNuevoStock() < prod.getStockMinimo()) {
			JOptionPane.showMessageDialog(this,
					"El stock debe ser mayor a: " + prod.getStockMinimo() + " y menor a: " + prod.getStockMaximo());
			return false;
		}

		return true;
	}
}
