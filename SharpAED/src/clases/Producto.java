package clases;

public class Producto {
	private int codigoProducto = 2001; // Auto-Generado y correlativo a partir de 2001
	private String nombre;
	private double precio;
	private int stockActual;
	private int stockMinimo;
	private int stockMaximo;

	private double totalAcumulado;
	private int cantidadVendida;
	private static int contador = 2001;

	public Producto(String nombre, double precio, int stockActual, int stockMinimo, int stockMaximo,
			double totalAcumulado, int cantidadVendida) {

		this.codigoProducto = contador;
		this.nombre = nombre;
		this.precio = precio;
		this.stockActual = stockActual;
		this.stockMinimo = stockMinimo;
		this.stockMaximo = stockMaximo;
		this.totalAcumulado = totalAcumulado;
		this.cantidadVendida = cantidadVendida;
		
		Producto.contador++;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStockActual() {
		return stockActual;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public int getStockMaximo() {
		return stockMaximo;
	}

	public void setStockMaximo(int stockMaximo) {
		this.stockMaximo = stockMaximo;
	}

	public double getTotalAcumulado() {
		return totalAcumulado;
	}

	public void setTotalAcumulado(double totalAcomulado) {
		this.totalAcumulado = totalAcomulado;
	}

	public int getCantidadVendida() {
		return cantidadVendida;
	}

	public void setCantidadVendida(int cantidadVendida) {
		this.cantidadVendida = cantidadVendida;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombre;
	}

}
