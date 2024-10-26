package guiReportes;

import java.awt.EventQueue;
import java.util.Iterator;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloProductos;
import clases.Producto;
import utilidades.Colores;

import javax.swing.JLabel;
import java.awt.Font;

public class CantidadAcumulada extends JDialog {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel modelo;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	
	public static void abrirVentana() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CantidadAcumulada dialog = new CantidadAcumulada();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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
	public CantidadAcumulada() {
		setTitle("Cantidad de unidades acumuladas");
		setBounds(100, 100, 634, 503);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 71, 598, 382);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Codido Producto");
		modelo.addColumn("Producto");
		modelo.addColumn("Cantidad acumulada");
		
		table.setModel(modelo);
		modelo.setRowCount(0);
		for (Producto p : ArregloProductos.getProductos()) {
			Object[] fila = { p.getCodigoProducto(), p.getNombre(), p.getCantidadVendida() };
			modelo.addRow(fila);
		}
		
		table.setFillsViewportHeight(true);
		scrollPane.setColumnHeaderView(table);
		
		lblNewLabel = new JLabel("Listado de productos por unidades vendidas acumuladas");
		lblNewLabel.setForeground(Colores.AZUL);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 25, 520, 35);
		getContentPane().add(lblNewLabel);

	}
}
