package guiClientes;

import clases.Cliente;
import utilidades.Colores;
import arreglos.ArregloClientes;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloClientes;
import clases.Cliente;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AgregarCliente extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JPanel panel_1;
	private JButton btnAgregar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */

	public static void abrirVentana() {
		try {
			AgregarCliente dialog = new AgregarCliente();
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
	public AgregarCliente() {
		setTitle("Agregar Cliente");
		setBounds(100, 100, 391, 357);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblNewLabel = new JLabel("Agregar Cliente");
		lblNewLabel.setForeground(Colores.AZUL);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(42, 36, 208, 25);
		contentPanel.add(lblNewLabel);

		panel = new JPanel();
		panel.setBounds(42, 72, 292, 211);
		contentPanel.add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 272, 120);
		panel.add(panel_1);
		panel_1.setLayout(null);

		lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(0, 1, 81, 14);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(0, 26, 81, 14);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));

		lblNewLabel_3 = new JLabel("DNI");
		lblNewLabel_3.setBounds(0, 51, 81, 14);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));

		lblNewLabel_4 = new JLabel("Direccion");
		lblNewLabel_4.setBounds(0, 76, 81, 14);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));

		lblNewLabel_5 = new JLabel("Telefono");
		lblNewLabel_5.setBounds(0, 101, 81, 14);
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtNombre = new JTextField();
		txtNombre.setBounds(149, 1, 123, 20);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(149, 26, 123, 20);
		panel_1.add(txtApellido);
		txtApellido.setColumns(10);

		txtDni = new JTextField();
		txtDni.setBounds(149, 51, 123, 20);
		panel_1.add(txtDni);
		txtDni.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(149, 76, 123, 20);
		panel_1.add(txtDireccion);
		txtDireccion.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(149, 101, 123, 20);
		panel_1.add(txtTelefono);
		txtTelefono.setColumns(10);

		btnAgregar = new JButton("Agregar Cliente");
		btnAgregar.setForeground(new Color(255, 255, 255));
		btnAgregar.setBorder(null);
		btnAgregar.setBorderPainted(false);
		btnAgregar.setBackground(Colores.VERDE);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnAgregar(e);
			}
		});
		btnAgregar.setBounds(10, 150, 127, 33);
		panel.add(btnAgregar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBackground(Colores.ROJO);
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(155, 150, 127, 33);
		panel.add(btnCancelar);
	}

	protected void actionPerformedBtnAgregar(ActionEvent e) {
		String nombres = txtNombre.getText();
		String apellidos = txtApellido.getText();
		String dni = txtDni.getText();
		String direccion = txtDireccion.getText();
		String telefono = txtTelefono.getText();
		Cliente cliente = new Cliente(nombres, apellidos, direccion, telefono, dni);
		ArregloClientes.agregarCliente(cliente);
		ArregloClientes.actualizarClientes();
		dispose();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}

	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
}
