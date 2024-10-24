package guiReportes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloVentas;
import clases.Venta;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ListadoVentas extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnProcesar;

	/**
	 * Launch the application.
	 */

	public static void abrirVentana() {
		try {
			ListadoVentas dialog = new ListadoVentas();
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
	public ListadoVentas() {
		setBounds(100, 100, 539, 387);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 136, 503, 201);
		contentPanel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		model = new DefaultTableModel();
		String[] columnas = { "Codigo Venta", "Codigo Cliente", "Codigo Producto", "Cantidad", "Subtotal", "IGV",
				"Precio", "Fecha" };
		model.setColumnIdentifiers(columnas);
		table.setModel(model);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnProcesar(e);
			}
		});
		btnProcesar.setBounds(10, 75, 89, 23);
		contentPanel.add(btnProcesar);
	}

	protected void actionPerformedBtnProcesar(ActionEvent e) {
		listarTablaVentas();
	}

	private void listarTablaVentas() {
		ArrayList<Venta> ventas = ArregloVentas.getVentas();
		model.setRowCount(0);

		for (Venta venta : ventas) {
			Object[] fila = { venta.getCodigoVenta(), venta.getCodigoCliente(), venta.getCodigoProducto(),
					venta.getCantidad(), venta.getSubtotal(), venta.getIgv(), venta.getPrecio(), venta.getFecha() };
			model.addRow(fila);
		}
	}

}
