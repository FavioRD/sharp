package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import guiReportes.ListadoVentas;
import guiReportes.TotalAcumulado;
import guiReportes.ProductosStockMin;

import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeleccionarReporte extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JButton btnListarVentas;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */

	public static void abrirVentana() {
		try {
			SeleccionarReporte dialog = new SeleccionarReporte();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SeleccionarReporte() {
		setLocationRelativeTo(null);
		setTitle("Seleccionar Reporte");
		setBounds(100, 100, 363, 470);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 327, 409);
		contentPanel.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 20));
		
		btnListarVentas = new JButton("Listar ventas");
		btnListarVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnListarVentas(e);
			}
		});
		panel.add(btnListarVentas);
		
		btnNewButton_2 = new JButton("Listar productos con stock minimo");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductosStockMin.abrirVentana();
			}
		});
		panel.add(btnNewButton_2);
		
		btnNewButton_1 = new JButton("Cantidad de unidades vendidas acumuladas");
		panel.add(btnNewButton_1);
		
		btnNewButton_3 = new JButton("Listado de productos por total acumulado");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnNewButton_3(e);
			}
		});
		panel.add(btnNewButton_3);
	}
	protected void actionPerformedBtnListarVentas(ActionEvent e) {
		ListadoVentas.abrirVentana();
	}
	protected void actionPerformedBtnNewButton_3(ActionEvent e) {
		TotalAcumulado.abrirVentana();
	}

	protected void actionPerformedBtnNewButton_2(ActionEvent e) {
		ProductosStockMin.abrirVentana();
	}
}
