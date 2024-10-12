package arreglos;

import java.util.ArrayList;

import clases.Cliente;

public class ArregloClientes {

	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static int nroClientes;
	
	
	

	public ArregloClientes() {
		Cliente cliente1 = new Cliente("Juan Perez", "12345678", "Av. Los Alamos 123", "12345678", "13131235");
		Cliente cliente2 = new Cliente("Maria Lopez", "87654321", "Av. Los Pinos 456", "87654321", "13151234");
		Cliente cliente3 = new Cliente("Carlos", "12345678", "Av. Los Alamos 123", "12345678", "888124991");
		Cliente cliente4 = new Cliente("Pedro", "87654321", "Av. Los Pinos 456", "87654321", "949194191");

		if (clientes.isEmpty()) {
			agregarCliente(cliente1);
			agregarCliente(cliente2);
			agregarCliente(cliente3);
			agregarCliente(cliente4);
		}
		nroClientes = clientes.size();
	}
	
	public static int getNroClientes() {
		return nroClientes;
	}
	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	public static Cliente getCliente(int i) {
		return clientes.get(i);
	}
	
	public void modificarCliente(int i, Cliente cliente) {
		clientes.set(i, cliente);
	}
	
	public void agregarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	
	
}
