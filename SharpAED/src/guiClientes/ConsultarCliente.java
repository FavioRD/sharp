package guiClientes;

import java.awt.EventQueue;

import arreglos.ArregloClientes;
import clases.Cliente;
import utilidades.Colores;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class ConsultarCliente extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtCodigo;
	private JScrollPane scrollPane;
	private JTable tblCliente;
	private JButton btnConsultar;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void abrirVentana() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarCliente frame = new ConsultarCliente();
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
	public ConsultarCliente() {
		setTitle("Consultar Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 687, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 168, 671, 321);
		contentPane.add(scrollPane);
		
		tblCliente = new JTable();
		tblCliente.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCliente);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Direccion");
		modelo.addColumn("Telefono");
		modelo.addColumn("DNI");
		tblCliente.setModel(modelo);
		ajustarAnchoColumnas();
		listar();
		
		panel = new JPanel();
		panel.setBounds(0, 0, 671, 169);
		panel.setBackground(getForeground());
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Código:");
		lblNewLabel.setBounds(35, 37, 80, 19);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(112, 38, 122, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCerrar.setBorderPainted(false);
		btnCerrar.setBackground(Colores.ROJO);
		btnCerrar.setForeground(Color.WHITE);
		btnCerrar.setBounds(511, 82, 122, 34);
		panel.add(btnCerrar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultar.setForeground(new Color(255, 255, 255));
		btnConsultar.setBorderPainted(false);
		btnConsultar.setBackground(Colores.VERDE);
		btnConsultar.setBounds(511, 37, 122, 34);
		panel.add(btnConsultar);
		btnConsultar.addActionListener(this);
		btnCerrar.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
	}
	
	private JButton btnCerrar;
	private JPanel panel;
	
	
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		
		String codigoIngresadoStr = txtCodigo.getText().trim(); 
	    int codigoIngresado = -1;
	    
	    try {
	        codigoIngresado = Integer.parseInt(codigoIngresadoStr); 
	    } catch (NumberFormatException ex) {
	        mensaje("Porfavor ingrese un codigo valido");
	        txtCodigo.setText("");
	        return;
	    }

	    Cliente clienteEncontrado = null;
	    
	    
	    for (int i = 0; i < ArregloClientes.getNroClientes(); i++) {
	        Cliente x = ArregloClientes.getCliente(i);
	        if (x.getCodigoCliente() == codigoIngresado) { 
	            clienteEncontrado = x;
	            break;
	        }
	    }
	    
	    if (clienteEncontrado != null) {
	        mensaje("      Cliente Encontrado\n" +
	                "Codigo       : " + clienteEncontrado.getCodigoCliente() + "\n" +
	                "Nombre     : " + clienteEncontrado.getNombres() + "\n" +
	                "Apellido     : " + clienteEncontrado.getApellidos() + "\n" +
	                "Direccion  : " + clienteEncontrado.getDireccion() + "\n" +
	                "Telefono    : " + clienteEncontrado.getTelefono() + "\n" +
	                "DNI              : " + clienteEncontrado.getDni());
	        txtCodigo.setText("");
	    } else {
	        mensaje("El código ingresado no existe");
	        txtCodigo.setText("");
	    }
	}

	
   void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < ArregloClientes.getNroClientes(); i++) {
			Cliente x = ArregloClientes.getCliente(i);
			Object[] fila = { x.getCodigoCliente(), x.getNombres(), x.getApellidos(), x.getDireccion(), x.getTelefono(),
					x.getDni() };
			modelo.addRow(fila);
		}
	}

	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblCliente.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(50);
		tcm.getColumn(1).setPreferredWidth(100);
		tcm.getColumn(2).setPreferredWidth(100);
		tcm.getColumn(3).setPreferredWidth(150);
		tcm.getColumn(4).setPreferredWidth(100);
		tcm.getColumn(5).setPreferredWidth(100);
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s,"Cliente",JOptionPane.INFORMATION_MESSAGE);
	}	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
