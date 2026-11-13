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
	private int saldo;
	private int credito;
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
	 */
	
	public TarjetaCredito(String nombre, String numeroTarjeta, String fechaExpiracion, int cvc, int saldo, int credito, boolean bloqueada) {
		this.nombre = nombre;
		this.numeroTarjeta = numeroTarjeta;
		this.fechaExpiracion = fechaExpiracion;
		this.cvc = cvc;
		this.saldo = saldo;
		this.credito = credito;
		this.bloqueada = bloqueada;		
	}
}
