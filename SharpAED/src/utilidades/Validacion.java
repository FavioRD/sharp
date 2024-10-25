package utilidades;

import javax.swing.JOptionPane;

import gui.Home;
import gui.Login;

public class Validacion {
	private static boolean validarUsuario(String usuario) {
		return usuario.length() > 0;
	}

	private static boolean validarContrasena(String contrasena) {
		return contrasena.length() > 0;
	}

	public static boolean validarCredenciales(String usuario, String contrasena, Login login) {
		if (validarUsuario(usuario) && validarContrasena(contrasena)) {
			if (usuario.equals("admin") && contrasena.equals("admin")) {
				Home.abrirVentana(1);
				login.dispose();
				return true;
			} else if (usuario.equals("user") && contrasena.equals("user")) {
				Home.abrirVentana(0);
				login.dispose();
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	public static boolean validarPrecio(double precio) {
		return precio > 0;
	}

	public static boolean validarInteger(String valor) {
	    try {
	        int num = Integer.parseInt(valor);
	        if (num < 0) {
	            System.out.println("Error: El número es negativo.");
	            return false;
	        }
	        return true;
	    } catch (NumberFormatException e) {
	        System.out.println("Error: El valor ingresado no es un número entero válido.");
	        return false;
	    }
	}
	public static boolean validarStock(int stock) {
		return stock > 0;
	}

	public static boolean validarTelefono(String telefono) {
		if (telefono.length() == 9) {
			return telefono.matches("[0-9]+");
		}
		return false;
	}

	public static boolean validarDni(String dni) {
		if (dni.length() == 8) {
			return dni.matches("[0-9]+");
		}
		return false;
	}

	public static boolean validarString(String nombre) {
		// Verifica que no sea nulo ni vacío
		if (nombre == null || nombre.trim().isEmpty()) {
			return false;
		}

		// Verifica que contenga solo letras
		return nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
	}

	public static boolean validarCodigo(String codigo) {
		return codigo.length() > 0;
	}

	public static boolean validarStockMinimo(int stockMinimo) {
		return stockMinimo > 0;
	}

	public static boolean validarStockMaximo(int stockMaximo) {
		return stockMaximo > 0;
	}

	public static boolean validarStockMinMax(int stockMinimo, int stockMaximo) {
		return stockMinimo < stockMaximo;
	}

	public static boolean validarStockActual(int stockActual, int stockMinimo, int stockMaximo) {
		return stockActual >= stockMinimo && stockActual <= stockMaximo;
	}
}
