package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utilidades.Validacion;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Insets;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JButton btnLogin;
	private JPasswordField txtContrasena;
	private JSeparator separator;
	private JSeparator separator_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setLocationRelativeTo(null);	
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
		setResizable(false);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/imagenes/portada.png")));
		lblNewLabel.setBounds(10, 0, 335, 446);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 94, 98));
		panel.setForeground(Color.BLACK);
		panel.setBounds(335, 0, 387, 446);
		contentPane.add(panel);
		panel.setLayout(null);
		
		separator_1 = new JSeparator();
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(34, 268, 269, 2);
		panel.add(separator_1);
		
		separator = new JSeparator();
		separator.setBackground(new Color(255, 255, 255));
		separator.setBounds(34, 175, 269, 2);
		panel.add(separator);
		
		JLabel lblNewLabel_3 = new JLabel("Iniciar Sesión");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_3.setBounds(32, 46, 242, 54);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Usuario");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(32, 114, 109, 27);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Contraseña");
		lblNewLabel_4_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_1.setBounds(32, 206, 109, 27);
		panel.add(lblNewLabel_4_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtUsuario.setBorder(null);
		txtUsuario.setBackground(new Color(255, 94, 98));
		txtUsuario.setForeground(new Color(255, 255, 255));
		txtUsuario.setBounds(34, 143, 275, 32);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(32, 342, 66, 66);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_2 = new JLabel("");
		lblNewLabel_5_2.setBounds(32, 342, 66, 66);
		panel.add(lblNewLabel_5_2);
		
		JButton btnNewButton = new JButton("CONFIRMAR ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnNewButton(e);
			}
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(32, 311, 120, 27);
		panel.add(btnNewButton);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtContrasena.setMargin(new Insets(2, 100, 2, 2));
		txtContrasena.setBorder(null);
		txtContrasena.setForeground(new Color(255, 255, 255));
		txtContrasena.setBackground(new Color(255, 94, 98));
		txtContrasena.setBounds(34, 234, 275, 32);
		panel.add(txtContrasena);
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		String usuario = txtUsuario.getText();
		String contrasena = new String(txtContrasena.getPassword());
		Validacion.validarCredenciales(usuario, contrasena, this);
		
		
	}
}
