package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 664, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(261, 94, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(261, 125, 86, 20);
		contentPane.add(txtContrasena);
		
		btnLogin = new JButton("New button");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnLogin(e);
			}
		});
		btnLogin.setBounds(258, 173, 89, 23);
		contentPane.add(btnLogin);
	}
	protected void actionPerformedBtnLogin(ActionEvent e) {
		String usuario = txtUsuario.getText();
		String contrasena = new String(txtContrasena.getPassword());
		verificarCredenciales(usuario, contrasena);
		
		
	}

	private void cerrarVentana() {
        dispose();
        Home.abrirVentana();
	}

	private void verificarCredenciales(String usuario, String contrasena) {
		if (usuario.equals("admin") && contrasena.equals("admin")) {
			System.out.println("Credenciales correctas");
			cerrarVentana();
		} else if (usuario.equals("user") && contrasena.equals("user")) {
			System.out.println("Credenciales correctas");
			cerrarVentana();
		} else {
			System.out.println("Credenciales incorrectas");
		}
	}
}
