package guiClientes;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import arreglos.ArregloClientes;
import clases.Cliente;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtEliminarEliminarCliente;
	private JTextField txtEstasSeguroDe;
	private JComboBox<Cliente> cboCliente;
		
	public static void abrirVentana() {
		try {
			EliminarCliente dialog = new EliminarCliente();
			dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public EliminarCliente() {
		setTitle("Eliminar Cliente");

		setBounds(100, 100, 612, 465);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// Crear un JLayeredPane con fondo blanco
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 596, 426);
		layeredPane.setBackground(Color.WHITE);
		layeredPane.setOpaque(true);
		getContentPane().add(layeredPane);

		// Configuración del JComboBox con borde negro
		
		
		cboCliente = new JComboBox<Cliente>();
		for (int i = 0; i < ArregloClientes.getNroClientes(); i++) {
			cboCliente.addItem(ArregloClientes.getCliente(i));
		}
		cboCliente.setBounds(141, 154, 310, 34);
		cboCliente.setOpaque(false);
		cboCliente.setForeground(Color.BLACK); // Texto en negro
		cboCliente.setBorder(new LineBorder(Color.BLACK, 2)); // Borde negro
		layeredPane.add(cboCliente, Integer.valueOf(2));

		// Botón Aceptar con letras negras y borde verde
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnAceptar(e);
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAceptar.setBounds(121, 301, 164, 52);
		btnAceptar.setForeground(Color.BLACK); // Texto negro
		btnAceptar.setBackground(UIManager.getColor("Button.background"));
		btnAceptar.setBorder(new LineBorder(new Color(0, 255, 0), 2)); // Borde verde
		btnAceptar.setOpaque(false);
		btnAceptar.setContentAreaFilled(false);
		layeredPane.add(btnAceptar, Integer.valueOf(2));

		btnAceptar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				btnAceptar.setForeground(Color.DARK_GRAY);
			}

			public void mouseReleased(MouseEvent e) {
				btnAceptar.setForeground(Color.BLACK);
			}
		});

		// Botón Cancelar con letras negras y borde rojo
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnCancelar(e);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCancelar.setBounds(295, 301, 164, 52);
		btnCancelar.setForeground(Color.BLACK); // Texto negro
		btnCancelar.setBackground(UIManager.getColor("Button.background"));
		btnCancelar.setBorder(new LineBorder(new Color(255, 0, 0), 2)); // Borde rojo
		btnCancelar.setOpaque(false);
		btnCancelar.setContentAreaFilled(false);
		layeredPane.add(btnCancelar, Integer.valueOf(2));

	

		txtEliminarEliminarCliente = new JTextField();
		txtEliminarEliminarCliente.setText("Eliminar Cliente");
		txtEliminarEliminarCliente.setFont(new Font("Tahoma", Font.BOLD, 29));
		txtEliminarEliminarCliente.setBounds(121, 40, 350, 50);
		txtEliminarEliminarCliente.setHorizontalAlignment(JTextField.CENTER);
		txtEliminarEliminarCliente.setEditable(false);
		txtEliminarEliminarCliente.setOpaque(false);
		txtEliminarEliminarCliente.setBorder(null);
		txtEliminarEliminarCliente.setForeground(new Color(255, 102, 102));
		layeredPane.add(txtEliminarEliminarCliente, Integer.valueOf(3));

		txtEstasSeguroDe = new JTextField();
		txtEstasSeguroDe.setText("Esta acción no se puede restaurar");
		txtEstasSeguroDe.setFont(new Font("Arial", Font.PLAIN, 18));
		txtEstasSeguroDe.setBounds(159, 221, 275, 22);
		txtEstasSeguroDe.setHorizontalAlignment(JTextField.CENTER);
		txtEstasSeguroDe.setEditable(false);
		txtEstasSeguroDe.setOpaque(false);
		txtEstasSeguroDe.setBorder(null);
		txtEstasSeguroDe.setForeground(new Color(255, 102, 102));
		layeredPane.add(txtEstasSeguroDe, Integer.valueOf(3));
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		eliminarCliente();
	}
	
	private void eliminarCliente() {
		int i = cboCliente.getSelectedIndex();
		ArregloClientes.eliminarCliente(i);
		JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente");
		dispose();
	}
}
