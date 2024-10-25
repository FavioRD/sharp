package arreglos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import clases.Archivo;
import clases.Venta;

public class ArregloVentas {

	private static double totalAcumulado;
	
	private static ArrayList<Venta> ventas = new ArrayList<>();

	private static int ultimoCodigoVenta = 0;

	static Archivo archivo = new Archivo("ventas.txt");

	public ArregloVentas() {
		
		if (!archivo.archivoExiste() || archivo.archivoVacio()) {
			Venta venta1 = new Venta(2001, 1001, 1, 131, 341, 100, "2021/07/01");
			Venta venta2 = new Venta(2002, 1002, 2, 262, 682, 200, "2021/07/02");
			Venta venta3 = new Venta(2003, 1003, 3, 393, 1023, 300, "2021/07/03");
			Venta venta4 = new Venta(2004, 1004, 4, 524, 1364, 400, "2021/07/04");
			if (ventas.isEmpty()) {
				agregarVenta(venta1);
				agregarVenta(venta2);
				agregarVenta(venta3);
				agregarVenta(venta4);
				guardarVentas();
			}

		}

		cargarVentas();

	}

	public static ArrayList<Venta> getVentas() {
		return ventas;
	}

	public static void agregarVenta(Venta venta) {
		totalAcumulado += venta.getPrecio();	
		ventas.add(venta);
	}

	public static void escribirVenta(Venta venta) {
		agregarVenta(venta);
		archivo.agregarLinea(venta.getCodigoVenta() + ";" + venta.getCodigoCliente() + ";" + venta.getCodigoProducto()
				+ ";" + venta.getCantidad() + ";" + venta.getSubtotal()+ ";" + venta.getIgv() + ";" + venta.getPrecio() + ";" + venta.getFecha());
	}

	public void guardarVentas() {
		try {
			archivo.crearArchivo();
			String linea = "";
			for (Venta venta : ventas) {
				linea = venta.getCodigoVenta() + ";" + venta.getCodigoCliente() + ";" + venta.getCodigoProducto() + ";"
						+ venta.getCantidad() + ";" + venta.getSubtotal() + ";" + venta.getIgv() + ";" + venta.getPrecio() + ";"
						+ venta.getFecha();
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
				double subtotal = Double.parseDouble(fila[4]);
				double igv = Double.parseDouble(fila[5]);
				double total = Double.parseDouble(fila[6]);
				String fecha = fila[7];
				
				Venta venta = new Venta(codigoCliente, codigoProducto, cantidad, subtotal, igv, total, fecha);
				ventas.add(venta);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static double getTotalAcumulado() {
		return totalAcumulado;
	}

}
