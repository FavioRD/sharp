package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Archivo;
import clases.Cliente;
import clases.Producto;

public class ArregloClientes {

	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static int nroClientes;

	static Archivo archivo = new Archivo("clientes.txt");

	public ArregloClientes() {
		if (!archivo.archivoExiste() || archivo.archivoVacio()) {

			if (clientes.isEmpty()) {
				Cliente cliente1 = new Cliente("Juan", "Perez", "Av. Los Alamos 123", "123456788", "93932139");
				Cliente cliente2 = new Cliente("Maria", "Carmos", "Av. Los Pinos 456", "987654321", "12312312");
				Cliente cliente3 = new Cliente("Miguel", "Duran", "Av. Siempre Viva 31", "727245628", "32132132");
				Cliente cliente4 = new Cliente("Lionel", "Messi", "Av. Los Marcianos 313", "934313127", "77777777");

				agregarCliente(cliente1);
				agregarCliente(cliente2);
				agregarCliente(cliente3);
				agregarCliente(cliente4);
				guardarClientes();
			}
		}
		cargarClientes();
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

	public int tamano() {
		return clientes.size();
	}
	

	public void agregarCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public static void eliminarCliente(int i) {
		clientes.remove(i);
	}

	public Cliente buscar(int codigoCliente) {
		for (int i = 0; i < nroClientes; i++) {
			Cliente x = clientes.get(i);
			if (codigoCliente == x.getCodigoCliente()) {
				return x;
			}
		}
		return null;
	}

	public static void guardarClientes() {
		try {
			String linea = "";

			for (Cliente cliente : clientes) {
				linea  = cliente.getCodigoCliente() + ";" + cliente.getNombres() + ";" + cliente.getApellidos() + ";" + cliente.getDireccion() + ";" + cliente.getTelefono() + ";" + cliente.getDni();

				archivo.escribirArchivo(linea);
			}

		} catch (Exception e) {
			System.out.println("Error al guardar productos");
		}
	}

	public static void actualizarClientes() {
		try {
			archivo.limpiarContenido();
			guardarClientes();
		} catch (Exception e) {
			System.out.println("Error al actualizar productos");
		}
	}
	
	public void cargarClientes() {
		try {
			String linea, fila[];
			BufferedReader br = new BufferedReader(new FileReader("clientes.txt"));
			while ((linea = br.readLine()) != null) {
				fila = linea.split(";");
				String nombres = fila[1];
				String apellidos = fila[2];
				String direccion = fila[3];
				String telefono = fila[4];
				String dni = fila[5];
				Cliente cliente = new Cliente(nombres, apellidos, direccion, telefono, dni);
				agregarCliente(cliente);

			}
		} catch (Exception e) {
			System.out.println("Error al cargar productos");
		}
	}

}
