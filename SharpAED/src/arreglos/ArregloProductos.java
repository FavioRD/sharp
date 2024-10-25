package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import clases.Archivo;
import clases.Producto;

public class ArregloProductos {
	private static ArrayList<Producto> productos = new ArrayList<Producto>();
	private static int nroProducto;

	static Archivo archivo = new Archivo("productos.txt");

//	Hacer que el constructor de la clase ArregloProductos cargue los productos del archivo productos.txt y si no existe o esta vacio, cree 4 productos y los guarde en el archivo.
	public ArregloProductos() {

		if (!archivo.archivoExiste() || archivo.archivoVacio()) {

			if (productos.isEmpty()) {
				Producto producto1 = new Producto("mouse", 15.00, 60, 25, 100, 0);
				Producto producto2 = new Producto("case", 240.5, 34, 17, 60, 0);
				Producto producto3 = new Producto("monitor", 340.70, 70, 46, 120, 0);
				Producto producto4 = new Producto("teclado", 120, 56, 19, 70, 0);

				agregarProducto(producto1);
				agregarProducto(producto2);
				agregarProducto(producto3);
				agregarProducto(producto4);
				archivo.crearArchivo();
				guardarProductos();
			}

			System.out.println(getNroProducto());
			System.out.println(getProductos());
		}

		cargarProductos();
		nroProducto = productos.size();
	}

	public static int getNroProducto() {
		return nroProducto;
	}

	public static ArrayList<Producto> getProductos() {
		return productos;
	}

	public static int tamano() {
		return productos.size();
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

	public static void eliminarProducto(int i) {
		productos.remove(i);
		nroProducto--;
	}

//	Insertar productos en el archivo de texto
	public static void guardarProductos() {
		try {
//			La clase archivo tiene la logica que permite crear un archivo si no existe y escribir en el

			String linea = "";
			for (int i = 0; i < productos.size(); i++) {
				Producto x = productos.get(i);
				linea = x.getCodigoProducto() + ";" + x.getNombre() + ";" + x.getPrecio() + ";" + x.getStockActual()
						+ ";" + x.getStockMinimo() + ";" + x.getStockMaximo() + ";" + x.getTotalAcumulado();

				archivo.escribirArchivo(linea);
			}

		} catch (Exception e) {
			System.out.println("Error al guardar productos");
		}
	}

	public static void actualizarProductos() {
		try {
			archivo.limpiarContenido();
			guardarProductos();

		} catch (Exception e) {
			System.out.println("Error al actualizar productos");
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
				System.out.println(fila[6]);
				double totalAcumulado = Double.parseDouble(fila[6]);
				Producto producto = new Producto(nombre, precio, stockActual, stockMinimo, stockMaximo, totalAcumulado);

				agregarProducto(producto);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al cargar productos");
		}
	}
}
