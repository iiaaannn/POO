package paquete_tarjeta_credito;

/**
 * Implementación de la clase Tarjeta de Credito para practicar POO (introduccion y Tests)
 * 
 * @author Ian Andrés Zapatero
 */


	/*
	 * Pasos para crear una clase (buena) en POO (primer ejercicio) : 
	 * 
	 * 1º : definir los atributos del objetos
	 * 2º : hacer los getters y setter (los getters sólo para los atributos que se puedan modificar, los getters tienen que estar en todos los atributos)
	 * 3º : toString() e equals() con un override
	 * 4º : NUNCA USAS THIS FUERA DEL CONSTRUCTOR (a no ser que el atributo y el parámetro se llamen igual)
	 * 5º : Javadoc 
	 * 
	 * Cosas importantes :
	 * 
	 * - La palabra reservada "static" SÓLO se usa en atributos (que no queremos que cambien en tiempo de ejecución, como constantes). En métodos nunca se usan
	 * - Está prohibido usar "getClass()". Hay que craftearnos nuestro propio "equals()" a mano, mirando atributo por atributo.
	 * - usar "this" cuando no hace falta resta bastante
	 * - NUNCA acceder a un atributo privado con un this.atributo. Siempre hay que usar un método get (sobretodo en la clase de la práctica, que había un método donde ocurría eso)
	 * - en los métodos "getters" se devuelve una COPIA del atributo privado, no el atributo como tal
	 * - TODOS los atributos son privados en POO
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
	
	/**
	 * Constructor por copia de la clase TarjetaCredito
	 * 
	 * @param tarjeta : objeto de tipo TarjetaCredito de donde se obtendrán los atributos
	 */
	
	public TarjetaCredito(TarjetaCredito tarjeta) {
		nombre = tarjeta.getNombre();
		numeroTarjeta = tarjeta.getNumeroTarjeta();
		fechaExpiracion = tarjeta.getFechaExpiracion();
		cvc = tarjeta.getCvc();
		saldo = tarjeta.getSaldo();
		credito = tarjeta.getCredito();
		bloqueada = tarjeta.isBloqueada();
	}
	
	// <--- Getters --->
	
	/**
	 * Permite acceder al atributo nombre del titular de la tarjeta
	 * 
	 * @return el nombre del titular de la tarjeta
	 */
	
	public String getNombre() {
		String copiaNombre = nombre;
		return copiaNombre;
	}
	
	/**
	 * Permite acceder al atributo numero de la tarjeta
	 * 
	 * @return el numero de la tarjeta
	 */
	
	public String getNumeroTarjeta() {
		String copiaNum = numeroTarjeta;
		return copiaNum;
	}
	
	/**
	 * Permite acceder al atributo fecha de expiración de la tarjeta
	 * 
	 * @return la fecha en la que expira la tarjeta
	 */
	
	public String getFechaExpiracion() {
		String copiaFecha = fechaExpiracion;
		return copiaFecha;
	}
	
	/**
	 * Permite acceder al atributo cvc de la tarjeta
	 * 
	 * @return el cvc de la tarjeta
	 */
	
	public int getCvc() {
		int copiaCvc = cvc;
		return copiaCvc;
	}
	
	/**
	 * Permite acceder al atributo saldo de la tarjeta
	 * 
	 * @return el saldo de la tarjeta
	 */
	
	public double getSaldo() {
		double copiaSaldo = saldo;
		return copiaSaldo;
	}
	
	/**
	 * Permite acceder al atributo crédito de la tarjeta
	 * 
	 * @return el credito de la tarjeta
	 */
	
	public double getCredito() {
		double copiaCredito = credito;
		return copiaCredito;
	}
	
	/**
	 * Permite acceder al atributo estado de la tarjeta
	 * 
	 * @return el estado de la tarjeta. {@code true} si está bloqueada y {@code false} si no lo está
	 */
	
	public boolean isBloqueada() {
		boolean copiaEstado = bloqueada;
		return copiaEstado;
	}
	
	// <--- Setters --->
	
	private void setSaldo(double saldo) {
		if (saldo < 0) {
			throw new IllegalArgumentException("El saldo no puede ser negativo");
		}
		this.saldo = saldo;
	}
	
	private void setCredito(double credito) {
		if (credito <= 0) {
			throw new IllegalArgumentException("El crédito no puede ser ni negativo ni nulo");
		}
		this.credito = credito;
	}
	
	private void setBloqueada(boolean estado) {
		bloqueada = estado;
	}
	
	/**
	 * Implementación del método 'equals()' (sobreescrito) para la clase Tarjeta de Crédito
	 * 
	 * Nota : una tarjeta de crédito se considera igual a otra si tienen el mismo número de tarjeta
	 * @param obj el objeto que se va a comparar
	 * @return {@code true} si son iguales y {@code false} si no lo son
	 */
	@Override
	public boolean equals(Object obj) {
		TarjetaCredito tarjeta = (TarjetaCredito) obj;
		if (tarjeta == null) {
			return false;
		}
		if (getNombre() == tarjeta.getNombre() && getNumeroTarjeta() == tarjeta.getNumeroTarjeta() && getFechaExpiracion() == tarjeta.getFechaExpiracion() && getCvc() == tarjeta.getCvc() && getSaldo() == tarjeta.getSaldo() && getCredito() == tarjeta.getCredito() && isBloqueada() == tarjeta.isBloqueada()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Método que devuelve una representación de la tarjeta de crédito en una cadena de texto
	 * 
	 * @return la cadena de texto con la representación de la tarjeta
	 */
	@Override
	public String toString() {
		return "TarjetaCredito [nombre = " + getNombre() + ", numero de tarjeta = " + getNumeroTarjeta() + ", fecha expiracion = " + getFechaExpiracion() + ", cvc = " + getCvc() + ", saldo = " + getSaldo() + ", credito = " + getCredito() + ", bloqueada = " + isBloqueada() + "]";
	}
	
	/**
	 * Método que permite retirar dinero de la tarjeta de crédito
	 * 
	 * @param dinero que se va a retirar
	 * @throws {@code IllegalArgumentException} si el dinero es menor que 0.0 o supera el límite de crédito
	 * @throws {@code IllegalStateException} si la tarjeta está bloqueada o el dinero supera el dinero que tiene la tarjeta
	 */
	
	public void retirarDinero(double dinero) {
		if (dinero <= 0.0) {
			throw new IllegalArgumentException("El dinero no puede ser negativo ni nulo");
		}
		if (isBloqueada()) {
			throw new IllegalStateException("La tarjeta está bloqueada, no se puede retirar dinero");
		}
		if (getCredito() < dinero) {
			throw new IllegalArgumentException("El dinero de la operación es superior al crédito máximo que puedes gastar");
		}
		if (getSaldo() - dinero < 0.0) {
			throw new IllegalStateException("El dinero queda en negativo");
		}
		setSaldo(getSaldo() - dinero);
	}
}
