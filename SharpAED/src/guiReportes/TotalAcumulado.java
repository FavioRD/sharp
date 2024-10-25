package guiReportes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import arreglos.ArregloProductos;
import clases.Producto;
public class TotalAcumulado extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JButton btnProcesar;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void abrirVentana() {
		try {
			TotalAcumulado dialog = new TotalAcumulado();
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
	public TotalAcumulado() {
		setTitle("Reporte total acumulado");
		setBounds(100, 100, 596, 410);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 82, 560, 278);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		
		model = new DefaultTableModel();
		model.addColumn("Codigo Producto");
		model.addColumn("Nombre Producto");
		model.addColumn("Total Acumulado");
		table.setModel(model);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnProcesar(e);
			}
		});
		btnProcesar.setBounds(245, 27, 89, 23);
		contentPanel.add(btnProcesar);
	}
	
	
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		model.setRowCount(0);
        for (Producto p : ArregloProductos.getProductos()) {
            model.addRow(new Object[] {p.getCodigoProducto(), p.getNombre(), p.getTotalAcumulado()});
        }
        
	}
}
