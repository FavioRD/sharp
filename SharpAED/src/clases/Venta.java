package clases;

import clases.Venta;

public class Venta {	
	public String producto;
	public double precio;
	private int cantidad;
	//constructor
	public Venta(String producto, double precio, int cantidad) {
		super();
		this.producto = producto;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	//metodos clasicos
	public String getProducto() {
		return producto;
	}
	public String setProducto(String producto) {
		return this.producto = producto;
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
	public int setCantidad(int cantidad) {
		return this.cantidad = cantidad;
	}
	
	//metodos generales
	public double subTotal() {
		return cantidad*precio;
	}
	
	public double descuento() {
		if(cantidad>=5) 
			return precio*0.4;
		return 0;
		}
	
	public double total() {
		return subTotal()-descuento();
	}
}
