package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import clases.Venta;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Window.Type;

public class CrearVenta extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel txt_titulo;
	private JLabel txt_cliente;
	private JLabel txt_producto;
	private JLabel txt_cantidad;
	private JLabel txt_precioUni;
	private JComboBox cbo_producto;
	private JTextField txtCantidad;
	private JTextField cbo_precio;
	private JButton btn_crear;
	private JButton btn_cancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearVenta frame = new CrearVenta();
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
	public CrearVenta() {
		setType(Type.UTILITY);
		setTitle("SharpStore-Ventas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 302);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 53, 53));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_titulo = new JLabel("Generar Venta");
		txt_titulo.setFont(new Font("Segoe UI Variable", Font.BOLD, 17));
		txt_titulo.setBounds(172, 11, 136, 23);
		contentPane.add(txt_titulo);
		
		txt_cliente = new JLabel("Cliente");
		txt_cliente.setForeground(new Color(255, 255, 255));
		txt_cliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_cliente.setBounds(20, 43, 89, 14);
		contentPane.add(txt_cliente);
		
		txt_producto = new JLabel("Producto");
		txt_producto.setForeground(new Color(255, 255, 255));
		txt_producto.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_producto.setBounds(20, 82, 89, 14);
		contentPane.add(txt_producto);
		
		txt_cantidad = new JLabel("Cantidad");
		txt_cantidad.setForeground(new Color(255, 255, 255));
		txt_cantidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_cantidad.setBounds(20, 118, 89, 14);
		contentPane.add(txt_cantidad);
		
		txt_precioUni = new JLabel("Precio Uni.");
		txt_precioUni.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_precioUni.setForeground(new Color(255, 255, 255));
		txt_precioUni.setBounds(20, 157, 89, 14);
		contentPane.add(txt_precioUni);
		
		cbo_producto = new JComboBox();
		cbo_producto.setToolTipText("");
		cbo_producto.setModel(new DefaultComboBoxModel(new String[] {"Leche", "Arroz ", "Cereal", "Pepe", "Fideo", "Papa", "Pollo"}));
		cbo_producto.setBounds(109, 79, 122, 23);
		contentPane.add(cbo_producto);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(109, 116, 122, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		cbo_precio = new JTextField();
		cbo_precio.setEditable(false);
		cbo_precio.setBounds(109, 155, 122, 20);
		contentPane.add(cbo_precio);
		cbo_precio.setColumns(10);
		
		btn_crear = new JButton("Crear");
		btn_crear.addActionListener(this);
		btn_crear.setBorderPainted(false);
		btn_crear.setBackground(new Color(128, 255, 128));
		btn_crear.setForeground(new Color(0, 0, 0));
		btn_crear.setBounds(32, 205, 89, 23);
		contentPane.add(btn_crear);
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.addActionListener(this);
		btn_cancelar.setBorderPainted(false);
		btn_cancelar.setBackground(new Color(255, 128, 128));
		btn_cancelar.setBounds(131, 205, 89, 23);
		contentPane.add(btn_cancelar);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(109, 41, 122, 20);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(261, 41, 197, 187);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_cancelar) {
			actionPerformedBtn_cancelar(e);
		}
		if (e.getSource() == btn_crear) {
			actionPerformedBtn_crear(e);
		}
	}
	private JTextField txtCliente;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	
	Venta a=new Venta("leche",1,1);
	Venta b=new Venta("arroz",2,1);
	Venta c=new Venta("cereal",3,1);		
	Venta d=new Venta("pepe",4,1);
	Venta e=new Venta("fideos",5,1);
	Venta f=new Venta("papa",6,1);
	Venta g=new Venta("pollo",7,1);
	protected void actionPerformedBtn_crear(ActionEvent e) {
		
		cliente();
		cantidad();
		producto();
		
	}

	void  imprimir_a() {
		imprimir("Producto : "+a.getProducto());
		imprimir("Precio Unitario : " +a.getPrecio());
		imprimir("Cantidad : "+a.getCantidad());
		imprimir("SubTotal : "+a.subTotal());
		imprimir("Descuento : "+a.descuento());
		imprimir("Total a Pagar : "+a.total());
	}
	
	void imprimir_b() {
		imprimir("Producto : "+b.getProducto());
		imprimir("Precio Unitario : " +b.getPrecio());
		imprimir("Cantidad : "+b.getCantidad());
		imprimir("SubTotal : "+b.subTotal());
		imprimir("Descuento : "+b.descuento());
		imprimir("Total a Pagar : "+b.total());
	}
	
	void imprimir_c() {
		imprimir("Producto : "+c.getProducto());
		imprimir("Precio Unitario : " +c.getPrecio());
		imprimir("Cantidad : "+c.getCantidad());
		imprimir("SubTotal : "+c.subTotal());
		imprimir("Descuento : "+c.descuento());
		imprimir("Total a Pagar : "+c.total());
	}
    void imprimir_d() {
    	imprimir("Producto : "+d.getProducto());
		imprimir("Precio Unitario : " +d.getPrecio());
		imprimir("Cantidad : "+d.getCantidad());
		imprimir("SubTotal : "+d.subTotal());
		imprimir("Descuento : "+d.descuento());
		imprimir("Total a Pagar : "+d.total());
	}
    void imprimir_e() {
    	imprimir("Producto : "+e.getProducto());
		imprimir("Precio Unitario : " +e.getPrecio());
		imprimir("Cantidad : "+e.getCantidad());
		imprimir("SubTotal : "+e.subTotal());
		imprimir("Descuento : "+e.descuento());
		imprimir("Total a Pagar : "+e.total());
     }
    void  imprimir_f() {
		imprimir("Producto : "+f.getProducto());
		imprimir("Precio Unitario : " +f.getPrecio());
		imprimir("Cantidad : "+f.getCantidad());
		imprimir("SubTotal : "+f.subTotal());
		imprimir("Descuento : "+f.descuento());
		imprimir("Total a Pagar : "+f.total());
	}
    void  imprimir_g() {
		imprimir("Producto : "+g.getProducto());
		imprimir("Precio Unitario : " +g.getPrecio());
		imprimir("Cantidad : "+g.getCantidad());
		imprimir("SubTotal : "+g.subTotal());
		imprimir("Descuento : "+g.descuento());
		imprimir("Total a Pagar : "+g.total());
	}
	
	void cliente() {
		String nomClie;
		nomClie=txtCliente.getText();
		
		imprimir("Cliente : "+nomClie);
		imprimir("-----------------------------------------");
		
		
	}
	void producto() {
		int producto;
		
		
		producto=cbo_producto.getSelectedIndex();
		
		switch(producto) {
		
		case 0:
			imprimir_a();
			break;
		case 1:
			imprimir_b();
			break;
		case 2:
			imprimir_c();
			break;
		case 3:
			imprimir_d();
			break;
		case 4:
			imprimir_e();
			break;	
		case 5:
			imprimir_f();
			break;
		case 6:
			imprimir_g();
			break;
		}
		
	}
	void cantidad() {
		 int cantidad;
		    cantidad=Integer.parseInt(txtCantidad.getText());
		    
		    cantidad=a.setCantidad(cantidad);
		    cantidad=b.setCantidad(cantidad);
		    cantidad=c.setCantidad(cantidad);
		    cantidad=d.setCantidad(cantidad);
		    cantidad=e.setCantidad(cantidad);
		    cantidad=f.setCantidad(cantidad);
		    cantidad=g.setCantidad(cantidad);
		
	}
	void imprimir(String s) {
		txtS.append(s+"\n");
	}
	protected void actionPerformedBtn_cancelar(ActionEvent e) {
		txtS.setText("");
	}
}

