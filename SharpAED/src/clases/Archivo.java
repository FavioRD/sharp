package clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Archivo {

	private String ruta;

	public Archivo(String ruta) {
		this.ruta = ruta;
	}

	// Método para crear un archivo
	public boolean crearArchivo() {
		try {
			File archivo = new File(ruta);
			if (archivo.createNewFile()) {
				System.out.println("Archivo creado: " + archivo.getName());
				return true;
			} else {
				System.out.println("El archivo ya existe.");
				return false;
			}
		} catch (IOException e) {
			System.out.println("Ocurrió un error al crear el archivo.");
			e.printStackTrace();
			return false;
		}
	}

	// Método para escribir en el archivo
	public boolean escribirArchivo(String contenido) {
		try {
			PrintWriter escritor = new PrintWriter(new FileWriter(ruta, true));
			escritor.println(contenido);
			escritor.close();
			System.out.println("Se escribió en el archivo.");
			return true;
		} catch (IOException e) {
			System.out.println("Ocurrió un error al escribir en el archivo.");
			e.printStackTrace();
			return false;
		}
	}

	// Método para borrar un archivo
	public boolean borrarArchivo() {
		File archivo = new File(ruta);
		if (archivo.delete()) {
			System.out.println("Archivo borrado: " + archivo.getName());
			return true;
		} else {
			System.out.println("Fallo al borrar el archivo.");
			return false;
		}
	}

	// Método para verificar si el archivo existe
	public boolean archivoExiste() {
		File archivo = new File(ruta);
		return archivo.exists();
	}

	// Método para modificar el archivo (sobreescribe el contenido)
	public boolean modificarArchivo(String nuevoContenido) {
		return escribirArchivo(nuevoContenido);
	}

	public boolean archivoVacio() {
		File archivo = new File(ruta);
		return archivo.length() == 0;
	}

	public String getRuta() {
		return ruta;
	}
	
	public void agregarLinea(String contenido) {
		try {
			PrintWriter escritor = new PrintWriter(new FileWriter(ruta, true));
			escritor.println(contenido);
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
