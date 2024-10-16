package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloClientes;
import clases.Cliente;
import utilidades.Validacion;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ConsultarCliente extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnConsultar;
	private JTextField txtCodigoCliente;
	private JScrollPane scrollPane;
	private JTable table;

	

	/**
	 * Launch the application.
	 */
	public static void abrirVentana() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarCliente frame = new ConsultarCliente();
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
	public ConsultarCliente() {
		setTitle("Consultar Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Código Cliente");
		lblNewLabel.setBounds(41, 38, 96, 14);
		contentPane.add(lblNewLabel);

		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(435, 34, 89, 23);
		contentPane.add(btnConsultar);

		txtCodigoCliente = new JTextField();
		txtCodigoCliente.setBounds(147, 35, 86, 20);
		contentPane.add(txtCodigoCliente);
		txtCodigoCliente.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 528, 181);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
	}
	
	arreglos.ArregloClientes arregloClientes = new ArregloClientes();

	protected void actionPerformedBtnConsultar(ActionEvent e) {
		int codigoCliente = Integer.parseInt(txtCodigoCliente.getText());
		Cliente x = arregloClientes.buscar(codigoCliente);
		if (x != null) {
			Object[][] datos = { { x.getCodigoCliente(), x.getNombres(), x.getApellidos(), x.getDireccion(),
					x.getTelefono(), x.getDni() } };
			String[] columnas = { "Código Cliente", "Nombres", "Apellidos", "Dirección", "Teléfono", "DNI" };
			table.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
		} else {
			System.out.println("Cliente no encontrado");
		}
	}
}
