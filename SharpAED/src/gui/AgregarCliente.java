package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarCliente extends JDialog {

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
		setBounds(100, 100, 382, 317);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Agregar Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(117, 11, 132, 21);
		contentPanel.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBounds(37, 43, 292, 211);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 272, 120);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(0, 1, 81, 14);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(0, 26, 81, 14);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblNewLabel_3 = new JLabel("DNI");
		lblNewLabel_3.setBounds(0, 51, 81, 14);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblNewLabel_4 = new JLabel("Direccion");
		lblNewLabel_4.setBounds(0, 76, 81, 14);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblNewLabel_5 = new JLabel("Telefono");
		lblNewLabel_5.setBounds(0, 101, 81, 14);
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
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
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnAgregar(e);
			}
		});
		btnAgregar.setBounds(10, 160, 107, 23);
		panel.add(btnAgregar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(193, 160, 89, 23);
		panel.add(btnCancelar);
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
	}
}
