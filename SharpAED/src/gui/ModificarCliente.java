package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cliente;
import clases.Producto;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JComboBox cboClientes;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtDni;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnModificarCliente;
	private JButton btnCancelar;

	Cliente cliente1 = new Cliente("Juan Perez", "12345678", "Av. Los Alamos 123", "12345678", "13131235");
	Cliente cliente2 = new Cliente("Maria Lopez", "87654321", "Av. Los Pinos 456", "87654321", "13151234");
	Cliente cliente3 = new Cliente("Carlos", "12345678", "Av. Los Alamos 123", "12345678", "888124991");
	Cliente cliente4 = new Cliente("Pedro", "87654321", "Av. Los Pinos 456", "87654321", "949194191");

	private Cliente[] codigoClientes = { cliente1, cliente2, cliente3, cliente4 };

	/**
	 * Launch the application.
	 */

	public static void abrirVentana() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarCliente frame = new ModificarCliente();
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
	public ModificarCliente() {
		setTitle("Modificar Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 623, 416);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 264, 377);
		contentPane.add(panel);
		panel.setLayout(null);

		cboClientes = new JComboBox<Cliente>();
		cboClientes.setModel(new DefaultComboBoxModel(codigoClientes));
		cboClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedcboClientes(e);
			}
		});
		cboClientes.setBounds(31, 70, 201, 22);
		panel.add(cboClientes);

		txtNombre = new JTextField();
		txtNombre.setBounds(131, 118, 101, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(131, 149, 101, 20);
		panel.add(txtApellido);

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(131, 180, 101, 20);
		panel.add(txtDireccion);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(131, 211, 101, 20);
		panel.add(txtTelefono);

		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(131, 242, 101, 20);
		panel.add(txtDni);

		lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(31, 121, 46, 14);
		panel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(31, 152, 46, 14);
		panel.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Direccion");
		lblNewLabel_3.setBounds(31, 183, 90, 14);
		panel.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Telefono");
		lblNewLabel_4.setBounds(31, 214, 90, 14);
		panel.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("DNI");
		lblNewLabel_5.setBounds(31, 245, 90, 14);
		panel.add(lblNewLabel_5);

		btnModificarCliente = new JButton("Registrar");
		btnModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnModificarCliente(e);
			}
		});
		btnModificarCliente.setBounds(31, 296, 89, 23);
		panel.add(btnModificarCliente);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(143, 296, 89, 23);
		panel.add(btnCancelar);

		lblNewLabel = new JLabel("Modificar Producto");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(364, 57, 153, 20);
		contentPane.add(lblNewLabel);
	}

	protected void actionPerformedcboClientes(ActionEvent e) {
		Cliente clienteSeleccionado = (Cliente) cboClientes.getSelectedItem();
		txtNombre.setText(clienteSeleccionado.getNombres());
		txtApellido.setText(clienteSeleccionado.getApellidos());
		txtDireccion.setText(clienteSeleccionado.getDireccion());
		txtTelefono.setText(clienteSeleccionado.getTelefono());
		txtDni.setText(clienteSeleccionado.getDni());
	}
	protected void actionPerformedBtnModificarCliente(ActionEvent e) {
		Cliente clienteSeleccionado = (Cliente) cboClientes.getSelectedItem();
		clienteSeleccionado.setNombres(txtNombre.getText());
		clienteSeleccionado.setApellidos(txtApellido.getText());
		clienteSeleccionado.setDireccion(txtDireccion.getText());
		clienteSeleccionado.setTelefono(txtTelefono.getText());
		clienteSeleccionado.setDni(txtDni.getText());
		
//		dispose();
	}
}
