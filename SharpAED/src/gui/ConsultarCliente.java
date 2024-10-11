package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarCliente extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox cboCodigo;
	private JLabel lblNewLabel;
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
	private JButton btnConsultarCliente;
	private JButton btnCancelar;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		cboCodigo = new JComboBox();
		cboCodigo.setBounds(115, 43, 137, 22);
		contentPane.add(cboCodigo);
		
		lblNewLabel = new JLabel("Código Cliente");
		lblNewLabel.setBounds(32, 47, 96, 14);
		contentPane.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(86, 90, 191, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(86, 121, 191, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(86, 152, 191, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(86, 183, 191, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(86, 214, 191, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(32, 93, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(32, 124, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Direccion");
		lblNewLabel_3.setBounds(32, 155, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Teléfono");
		lblNewLabel_4.setBounds(30, 186, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("DNI");
		lblNewLabel_5.setBounds(30, 217, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		btnConsultarCliente = new JButton("Consultar");
		btnConsultarCliente.addActionListener(this);
		btnConsultarCliente.setBounds(382, 43, 89, 23);
		contentPane.add(btnConsultarCliente);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(382, 77, 89, 23);
		contentPane.add(btnCancelar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultarCliente) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
	}
}
