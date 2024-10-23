package arreglos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import clases.Archivo;
import clases.Venta;

public class ArregloVentas {

	private static ArrayList<Venta> ventas = new ArrayList<>();

	private static int ultimoCodigoVenta = 0;

	static Archivo archivo = new Archivo("ventas.txt");

	public ArregloVentas() {
		if (!archivo.archivoExiste() || archivo.archivoVacio()) {
			Venta venta1 = new Venta(1001, 2001, 5, 150.00, "2021-08-01");
			Venta venta2 = new Venta(1002, 2002, 3, 200.00, "2021-08-02");
			Venta venta3 = new Venta(1003, 2003, 2, 300.00, "2021-08-03");
			Venta venta4 = new Venta(1004, 2004, 1, 100.00, "2021-08-04");

			if (ventas.isEmpty()) {
				agregarVenta(venta1);
				agregarVenta(venta2);
				agregarVenta(venta3);
				agregarVenta(venta4);
				guardarVentas();
			}

			System.out.println("Ventas cargadas");
			System.out.println("Cantidad de ventas: " + ventas.size());
			System.out.println("Ventas: ");
			System.out.println(ventas);
		}

		cargarVentas();

	}

	public ArrayList<Venta> getVentas() {
		return ventas;
	}

	public static void agregarVenta(Venta venta) {
		ventas.add(venta);
	}

	public static void escribirVenta(Venta venta) {
		agregarVenta(venta);
		archivo.agregarLinea(venta.getCodigoVenta() + ";" + venta.getCodigoCliente() + ";" + venta.getCodigoProducto()
				+ ";" + venta.getCantidad() + ";" + venta.getPrecio() + ";" + venta.getFecha());
	}

	public void guardarVentas() {
		try {
			archivo.crearArchivo();
			String linea = "";
			for (Venta venta : ventas) {
				linea = venta.getCodigoVenta() + ";" + venta.getCodigoCliente() + ";" + venta.getCodigoProducto() + ";"
						+ venta.getCantidad() + ";" + venta.getPrecio() + ";" + venta.getFecha();
				archivo.escribirArchivo(linea);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cargarVentas() {

		try {
			String linea, fila[];
			BufferedReader lector = new BufferedReader(new FileReader(archivo.getRuta()));
			while ((linea = lector.readLine()) != null) {
				fila = linea.split(";");
				int codigoVenta = Integer.parseInt(fila[0]);
				int codigoCliente = Integer.parseInt(fila[1]);
				int codigoProducto = Integer.parseInt(fila[2]);
				int cantidad = Integer.parseInt(fila[3]);
				double precio = Double.parseDouble(fila[4]);
				String fecha = fila[5];
				Venta venta = new Venta(codigoCliente, codigoProducto, cantidad, precio, fecha);
				ventas.add(venta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
