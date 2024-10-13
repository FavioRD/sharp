package arreglos;

import java.util.ArrayList;

import clases.Cliente;

public class ArregloClientes {

	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static int nroClientes;
	
	
	

	public ArregloClientes() {
		Cliente cliente1 = new Cliente("Juan", "Perez", "Av. Los Alamos 123", "123456788", "93932139");
		Cliente cliente2 = new Cliente("Maria", "Carmos", "Av. Los Pinos 456", "987654321", "12312312");
		Cliente cliente3 = new Cliente("Miguel", "Duran", "Av. Siempre Viva 31", "727245628", "32132132");
		Cliente cliente4 = new Cliente("Lionel", "Messi", "Av. Los Marcianos 313", "934313127", "77777777");

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
	
	public static void modificarCliente(int i, Cliente cliente) {
		clientes.set(i, cliente);
	}
	
	public void agregarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	
	
}
