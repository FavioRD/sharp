package clases;

public class Cliente {

	private int codigoCliente;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String telefono;
	private String dni;

	private static int contador = 1001;

	// constructor
	public Cliente(String nombres, String apellidos, String direccion, String telefono, String dni) {

		this.codigoCliente = contador++;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.dni = dni;
	}

	// set
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	// get

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public String getNombres() {
		return nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getDni() {
		return dni;
	}


}
