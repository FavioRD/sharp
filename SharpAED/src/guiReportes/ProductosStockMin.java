package guiReportes;

import java.awt.EventQueue;

import arreglos.ArregloProductos;
import clases.Producto;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class ProductosStockMin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable tblStockmin;
	private JButton btnProcesar;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void abrirVentana() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductosStockMin frame = new ProductosStockMin();
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
	public ProductosStockMin() {
		setTitle("Productos con Stock Minimo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 622, 370);
		contentPane.add(scrollPane);

		tblStockmin = new JTable();
		tblStockmin.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblStockmin);

		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Precio");
		modelo.addColumn("Stock Actual");
		modelo.addColumn("Stock Minimo");
		tblStockmin.setModel(modelo);
		ajustarAnchoColumnas();
		listar();

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(269, 11, 89, 23);
		contentPane.add(btnProcesar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}

	arreglos.ArregloProductos ap = new ArregloProductos();

	protected void actionPerformedBtnProcesar(ActionEvent e) {
		for (int i = 0; i < ap.tamano(); i++) {
			Producto x = ap.getProducto(i);

			if (x.getStockActual() < x.getStockMinimo()) {
				Object[] fila = { x.getCodigoProducto(), x.getNombre(), x.getStockActual(), x.getStockMinimo() };
				modelo.addRow(fila);
			}

			if (modelo.getRowCount() == 0) {
				mensaje("No hay productos con stock por debajo del mínimo.");
			}
		}
	}

	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < ap.tamano(); i++) {
			Producto p = ap.getProducto(i);
			Object[] fila = { p.getCodigoProducto(), p.getNombre(), p.getPrecio(), p.getStockActual(),
					p.getStockMinimo(), };
			modelo.addRow(fila);
		}
	}

	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblStockmin.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(50);
		tcm.getColumn(1).setPreferredWidth(200);
		tcm.getColumn(2).setPreferredWidth(50);
		tcm.getColumn(3).setPreferredWidth(50);
		tcm.getColumn(4).setPreferredWidth(50);
	}

	void mensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "StockMin", JOptionPane.INFORMATION_MESSAGE);
	}
}
