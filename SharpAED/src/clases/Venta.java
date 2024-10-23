package clases;

import clases.Venta;

public class Venta {
	private int codigoVenta = 3001;
	private int codigoCliente;
	private int codigoProducto;
	private int cantidad;
	private double precio;
	private String fecha;

	private static int contador = 3001;
	// constructor
	public Venta(int codigoCliente, int codigoProducto, int cantidad, double precio, String fecha) {
		this.codigoVenta = contador;
		this.precio = precio;
		this.cantidad = cantidad;
		this.codigoCliente = codigoCliente;
		this.codigoProducto = codigoProducto;
		this.fecha = fecha;
		Venta.contador++;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
