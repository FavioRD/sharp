package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloClientes;
import clases.Cliente;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ListarClientes extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnListar;
	
	
	
	/**
	 * Launch the application.
	 */

	public static void abrirVentana() {
		try {
			ListarClientes dialog = new ListarClientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarClientes() {
		setBounds(100, 100, 584, 379);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 108, 548, 205);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		model = new DefaultTableModel();
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("DNI");
		model.addColumn("Telefono");
		model.addColumn("Email");
		table.setModel(model);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnListar(e);
			}
		});
		btnListar.setBounds(39, 33, 89, 23);
		contentPanel.add(btnListar);
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
		listarClientes();
	}

	private void listarClientes() {
        // TODO Auto-generated method stub
		System.out.println(ArregloClientes.getClientes());
		ArrayList<Cliente> clientes = ArregloClientes.getClientes();
		model.setRowCount(0);
		for (Cliente cliente : clientes) {
            String[] row = {cliente.getNombres(), cliente.getApellidos(), cliente.getDni(), cliente.getTelefono(), cliente.getDireccion()};
            model.addRow (row);
		}
		
	}
}
