package guiProducto;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import arreglos.ArregloProductos;
import clases.Producto;

public class ConsultarProducto extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtCodigoProd;
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
					ConsultarProducto frame = new ConsultarProducto();
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
	public ConsultarProducto() {
		setTitle("Consultar Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Código:");
		lblNewLabel.setBounds(40, 41, 80, 14);
		contentPane.add(lblNewLabel);
		
		txtCodigoProd = new JTextField();
		txtCodigoProd.setBounds(91, 38, 86, 20);
		contentPane.add(txtCodigoProd);
		txtCodigoProd.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 82, 651, 321);
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
		//listar();
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener((ActionListener) this);
		btnConsultar.setBounds(539, 37, 89, 23);
		contentPane.add(btnConsultar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
	}
	
	arreglos.ArregloProductos ArregloProductos = new ArregloProductos();
	
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		
	}
	
   //void listar() {
	  // modelo.setRowCount(0);
		//for (int i = 0; i < ArregloProductos.tamano(); i++) {
		//	Producto x = ArregloProductos.getProducto(i));
		//	Object[] fila = { x.getCodigoProducto(), x.getNombre(), x.getPrecio(), x.getStockActual(), x.getStockMinimo(), x.getStockMaximo() };
		//	modelo.addRow(fila);
		//}
 //  }

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
		JOptionPane.showMessageDialog(this, s,"Cliente",1);
	}	


}
