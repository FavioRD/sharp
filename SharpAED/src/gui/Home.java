package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_3;
	private JMenu mnNewMenu_4;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;

	/**
	 * Launch the application.
	 */
	
	public static void abrirVentana() {
		try {
			Home dialog = new Home();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Create the dialog.
	 */
	public Home() {
		setBounds(100, 100, 823, 509);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(109, 71, 588, 306);
		contentPanel.add(panel);
		panel.setLayout(new GridLayout(0, 3, 10, 10));
		
		btnNewButton = new JButton("Registrar Venta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnNewButton(e);
			}
		});
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Agregar Cliente");
		panel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Listar Productos");
		panel.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Agregar Producto");
		panel.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Generar Reporte");
		panel.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("Configuración");
		panel.add(btnNewButton_5);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Mantenimiento");
		menuBar.add(mnNewMenu);
		
		mnNewMenu_1 = new JMenu("Ventas");
		menuBar.add(mnNewMenu_1);
		
		mnNewMenu_2 = new JMenu("Almacen");
		menuBar.add(mnNewMenu_2);
		
		mnNewMenu_3 = new JMenu("Reportes");
		menuBar.add(mnNewMenu_3);
		
		mnNewMenu_4 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_4);
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
	}
}
