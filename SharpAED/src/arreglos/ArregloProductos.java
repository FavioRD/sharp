package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Producto;

public class ArregloProductos {
	private static ArrayList<Producto> productos = new ArrayList<Producto>();
	private static int nroProducto;

	public ArregloProductos() {
//		Producto producto1 = new Producto("mouse", 15.00, 60, 25, 100);
//		Producto producto2 = new Producto("case", 240.5, 34, 17, 60);
//		Producto producto3 = new Producto("monitor", 340.70, 70, 46, 120);
//		Producto producto4 = new Producto("teclado", 120, 56, 19, 70);
//
//		
//		if (productos.isEmpty()) {
//			agregarProducto(producto1);
//			agregarProducto(producto2);
//			agregarProducto(producto3);
//			agregarProducto(producto4);
//			guardarProductos();
//
//		}
		cargarProductos();
		nroProducto = productos.size();
	}

	public static int getNroProducto() {
		return nroProducto;
	}

	public static ArrayList<Producto> getProductos() {
		return productos;
	}

	public static Producto getProducto(int i) {
		return productos.get(i);
	}

	public static void modificarProducto(int i, Producto producto) {
		productos.set(i, producto);
	}

	public void agregarProducto(Producto producto) {
		productos.add(producto);
	}

	public Producto buscar(int codigoProducto) {
		for (int i = 0; i < nroProducto; i++) {
			Producto x = productos.get(i);
			if (codigoProducto == x.getCodigoProducto()) {
				return x;
			}
		}
		return null;
	}

	public void guardarProductos() {
		try {
			String linea = "";
			PrintWriter pw = new PrintWriter(new FileWriter("productos.txt", true));
			for (int i = 0; i < productos.size(); i++) {
				Producto x = productos.get(i);
				linea = x.getCodigoProducto() + ";" + x.getNombre() + ";" + x.getPrecio() + ";" + x.getStockActual()
						+ ";" + x.getStockMinimo() + ";" + x.getStockMaximo();
				pw.println(linea);

			}
			pw.close();

		} catch (Exception e) {
			System.out.println("Error al guardar productos");
		}
	}

	public void cargarProductos() {
		try {
			String linea, fila[];
			BufferedReader br = new BufferedReader(new FileReader("productos.txt"));
			while ((linea = br.readLine()) != null) {
				fila = linea.split(";");
				String nombre = fila[1];
				double precio = Double.parseDouble(fila[2]);
				int stockActual = Integer.parseInt(fila[3]);
				int stockMinimo = Integer.parseInt(fila[4]);
				int stockMaximo = Integer.parseInt(fila[5]);
				Producto producto = new Producto(nombre, precio, stockActual, stockMinimo, stockMaximo);

				agregarProducto(producto);
			}
		} catch (Exception e) {
			System.out.println("Error al cargar productos");
		}
	}
}
