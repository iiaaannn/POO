package paquete_tarjeta_credito;

/**
 * Implementación de la clase Tarjeta de Credito para practicar POO (introduccion y Tests)
 * 
 * @author Ian Andrés Zapatero
 */

public class TarjetaCredito {
	private String nombre;
	private String numeroTarjeta;
	private String fechaExpiracion;
	private int cvc;
	private double saldo;
	private double credito;
	private boolean bloqueada;
	
	/**
	 * Constructor general de la clase Tarjeta de Credito
	 * 
	 * @param nombre : nombre del titular de la tarjeta
	 * @param numeroTarjeta : el numero asociado a la tarjeta
	 * @param fechaExpiracion : fecha de expiracion de la tarjeta
	 * @param cvc : cvc de la tarjeta
	 * @param saldo : saldo disponible de la tarjeta
	 * @param credito : cantidad que puedes gastar en un pago
	 * @param bloqueada : estado de la tarjeta
	 * @throws IllegalArgumentException si {@code nombre}, {@code numeroTarjeta} o {@code fechaExpiracion} es nulo o vacío.
	 * @throws IllegalArgumentException si {@code cvc} no está entre 0 y 999
	 * @throws IllegalArgumentException si {@code saldo} es menor que 0 o {@code credito} no es mayor que 0
	 */
	
	public TarjetaCredito(String nombre, String numeroTarjeta, String fechaExpiracion, int cvc, double saldo, double credito, boolean bloqueada) {
		if (nombre == null || nombre.trim().isEmpty()) {
			throw new IllegalArgumentException("El nombre no puede ser nulo ni vacío");
		}
		
		if (numeroTarjeta == null || numeroTarjeta.trim().isEmpty()) {
			throw new IllegalArgumentException("El número de la tarjeta no puede ser nulo ni vacío");
		}
		
		if (fechaExpiracion == null || fechaExpiracion.trim().isEmpty()) {
			throw new IllegalArgumentException("La fecha de expiración no puede ser nula ni vacía");
		}
		
		if (cvc < 0 || cvc > 999) {
			throw new IllegalArgumentException("El cvc tiene que estar entre 0 y 999");
		}
		
		if (saldo < 0) {
			throw new IllegalArgumentException("El saldo no puede ser negativo");
		}
		
		if (credito <= 0) {
			throw new IllegalArgumentException("El credito tiene que ser mayor que 0");
		}
		
		this.nombre = nombre;
		this.numeroTarjeta = numeroTarjeta;
		this.fechaExpiracion = fechaExpiracion;
		this.cvc = cvc;
		this.saldo = saldo;
		this.credito = credito;
		this.bloqueada = bloqueada;		
	}
	
	// Falta implementar el constructor por copia
	
	// <--- Getters --->
	
	/**
	 * Permite acceder al atributo nombre del titular de la tarjeta
	 * 
	 * @return el nombre del titular de la tarjeta
	 */
	
	public String getNombre() {
		String copiaNombre = this.nombre;
		return copiaNombre;
	}
	
	/**
	 * Permite acceder al atributo numero de la tarjeta
	 * 
	 * @return el numero de la tarjeta
	 */
	
	public String getNumeroTarjeta() {
		String copiaNum = this.numeroTarjeta;
		return copiaNum;
	}
	
	/**
	 * Permite acceder al atributo fecha de expiración de la tarjeta
	 * 
	 * @return la fecha en la que expira la tarjeta
	 */
	
	public String getFechaExpiracion() {
		String copiaFecha = this.fechaExpiracion;
		return copiaFecha;
	}
	
	/**
	 * Permite acceder al atributo cvc de la tarjeta
	 * 
	 * @return el cvc de la tarjeta
	 */
	
	public int getCvc() {
		int copiaCvc = this.cvc;
		return copiaCvc;
	}
	
	/**
	 * Permite acceder al atributo saldo de la tarjeta
	 * 
	 * @return el saldo de la tarjeta
	 */
	
	public double getSaldo() {
		double copiaSaldo = this.saldo;
		return copiaSaldo;
	}
	
	/**
	 * Permite acceder al atributo crédito de la tarjeta
	 * 
	 * @return el credito de la tarjeta
	 */
	
	public double getCredito() {
		double copiaCredito = this.credito;
		return copiaCredito;
	}
	
	/**
	 * Permite acceder al atributo estado de la tarjeta
	 * 
	 * @return el estado de la tarjeta. {@code true} si está bloqueada y {@code false} si no lo está
	 */
	
	public boolean estaBloqueada() {
		boolean copiaEstado = this.bloqueada;
		return copiaEstado;
	}
	
	// <--- Setters --->
	
	private void setSaldo(int saldo) {
		if (saldo < 0) {
			throw new IllegalArgumentException("El saldo no puede ser negativo");
		}
		this.saldo = saldo;
	}
	
	private void setCredito(int credito) {
		if (credito <= 0) {
			throw new IllegalArgumentException("El crédito no puede ser ni negativo ni nulo");
		}
		this.credito = credito;
	}
	
	private void setBloqueada(boolean estado) {
		this.bloqueada = estado;
	}
}
