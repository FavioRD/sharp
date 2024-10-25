package guiReportes;

import java.awt.EventQueue;
import java.util.Iterator;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloProductos;
import clases.Producto;

public class CantidadAcumulada extends JDialog {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel modelo;
	/**
	 * Launch the application.
	 */
	
	public static void abrirVentana() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CantidadAcumulada dialog = new CantidadAcumulada();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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
		scrollPane.setViewportView(table);

	}
}
