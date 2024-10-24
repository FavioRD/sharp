package clases;

import clases.Venta;

public class Venta {
	private int codigoVenta;
	private int codigoCliente;
	private int codigoProducto;
	private int cantidad;
	private double subtotal;
	private double igv;
	private double total;

	private String fecha;

	private static int contador = 3001;

	// constructor
	public Venta(int codigoCliente, int codigoProducto, int cantidad, double subtotal, double igv, double total,
			String fecha) {
		this.codigoVenta = contador;
		this.total = total;
		this.cantidad = cantidad;
		this.codigoCliente = codigoCliente;
		this.codigoProducto = codigoProducto;
		this.fecha = fecha;
		this.subtotal = subtotal;
		this.igv = igv;
		Venta.contador++;
	}

	public double getPrecio() {
		return total;
	}

	public void setPrecio(double precio) {
		this.total = precio;
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

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getIgv() {
		return igv;
	}

	public void setIgv(double igv) {
		this.igv = igv;
	}
}
