package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Prueba extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtPrecio;
	private JButton btnNewButton;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Prueba dialog = new Prueba();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Prueba() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(109, 75, 86, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnNewButton(e);
			}
		});
		btnNewButton.setBounds(106, 106, 89, 23);
		contentPanel.add(btnNewButton);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedComboBox(e);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"jere", "amador", "ponce", "asfda"}));
		comboBox.setBounds(84, 42, 111, 22);
		contentPanel.add(comboBox);
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		txtPrecio.setText("Hola");
	}
	protected void actionPerformedComboBox(ActionEvent e) {
		txtPrecio.setText(comboBox.getSelectedItem().toString());
	}
}
