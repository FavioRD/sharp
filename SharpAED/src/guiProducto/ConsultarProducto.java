package guiProducto;

import java.awt.EventQueue;

import arreglos.ArregloProductos;
import clases.Producto;

import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class ConsultarProducto extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtCodigop;
	private JScrollPane scrollPane;
	private JTable tblProducto;
	private JButton btnConsultar;
	private JButton btnCerrar;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void abrirVentana() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarProducto frame = new ConsultarProducto();
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
	public ConsultarProducto() {
		setTitle("Consultar Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setBounds(40, 41, 80, 14);
		contentPane.add(lblNewLabel);
		
		txtCodigop = new JTextField();
		txtCodigop.setBounds(91, 38, 86, 20);
		contentPane.add(txtCodigop);
		txtCodigop.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 82, 651, 321);
		contentPane.add(scrollPane);
		
		tblProducto = new JTable();
		tblProducto.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblProducto);
		
		modelo= new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Precio");
		modelo.addColumn("Stock Actual");
		modelo.addColumn("Stock Minimo");
		modelo.addColumn("Stock Maximo");
		tblProducto.setModel(modelo);
		ajustarAnchoColumnas();
		listar();
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(543, 11, 89, 23);
		contentPane.add(btnConsultar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(543, 40, 89, 23);
		contentPane.add(btnCerrar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
	}
	
	arreglos.ArregloProductos arregloProductos = new ArregloProductos();
	
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		
		String codigoIngresadoStr = txtCodigop.getText().trim();
	    int codigoIngresado = -1;
	    
	    try {
	        codigoIngresado = Integer.parseInt(codigoIngresadoStr); 
	    } catch (NumberFormatException ex) {
	        mensaje("Porfavor ingrese un codigo valido");
	        txtCodigop.setText(""); 
	        return;
	    }

	    Producto productoEncontrado = null;
	    
	    
	    for (int i = 0; i < arregloProductos.tamano(); i++) {
	        Producto x = arregloProductos.getProducto(i);
	        if (x.getCodigoProducto() == codigoIngresado) { 
	            productoEncontrado = x;
	            break;
	        }
	    }
	    
	    if (productoEncontrado != null) {
	        mensaje("      Producto Encontrado\n" +
	                "Codigo                : " + productoEncontrado.getCodigoProducto() + "\n" +
	                "Nombre              : " + productoEncontrado.getNombre() + "\n" +
	                "Precio                 : " + productoEncontrado.getPrecio() + "\n" +
	                "Stock Actual     : " + productoEncontrado.getStockActual() + "\n" +
	                "Stock Minimo    : " + productoEncontrado.getStockMinimo() + "\n" +
	                "Stock Maximo  : " + productoEncontrado.getStockMaximo());
	    } else {
	        mensaje("El código ingresado no existe");
	        txtCodigop.setText(""); 
	    }
	}


	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}

	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblProducto.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(50);
		tcm.getColumn(1).setPreferredWidth(100);
		tcm.getColumn(2).setPreferredWidth(50);
		tcm.getColumn(3).setPreferredWidth(50);
		tcm.getColumn(4).setPreferredWidth(50);
		tcm.getColumn(5).setPreferredWidth(50);
	}
	
	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < arregloProductos.tamano(); i++) {
            Producto x = arregloProductos.getProducto(i);
            Object[] fila = { x.getCodigoProducto(), x.getNombre(), x.getPrecio(), x.getStockActual(), x.getStockMinimo(), x.getStockMaximo() };
            modelo.addRow(fila);
        }
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s,"Producto",JOptionPane.INFORMATION_MESSAGE);
	}	
}
