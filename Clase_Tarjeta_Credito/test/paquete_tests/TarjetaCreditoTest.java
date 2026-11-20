package paquete_tests;

import paquete_tarjeta_credito.TarjetaCredito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

	/**
	 * - Sólo debemos hacer tests de los métodos públicos. En este caso, como los setters son 
	 * privados, no debemos hacer test de ellos.
	 * - el error admisible sólo se pone para double/float
	 * - en los "assertEquals()" siempre va primero el valor esperado y después el valor que devuelve el método
	 * - está bien añadir test de casos límites
	 */

/**
 * Pruebas de caja negra para la clase TarjetaCredito
 * 
 * @author Ian Andrés Zapatero
 */

	

public class TarjetaCreditoTest {
	
	private static final double ERROR_ADMISIBLE = 0.001;
	
	// <--- casos válidos --->
	
	@Test
	public void testConstructorValido() {
		TarjetaCredito tarjeta = new TarjetaCredito("Ian", "12345", "11/03", 123, 23.5, 10.0, false);
		assertEquals("Ian", tarjeta.getNombre());
		assertEquals("12345", tarjeta.getNumeroTarjeta());
		assertEquals("11/03", tarjeta.getFechaExpiracion());
		assertEquals(123, tarjeta.getCvc());
		assertEquals(23.5, tarjeta.getSaldo(), ERROR_ADMISIBLE);
		assertEquals(10.0, tarjeta.getCredito(), ERROR_ADMISIBLE);
		assertFalse(tarjeta.isBloqueada());
	}
	
	@Test
	public void testConstructorValorLimiteCvc0() {
		TarjetaCredito tarjeta = new TarjetaCredito("Ian", "12345", "11/03", 0, 23.5, 10.0, false);
		assertEquals(0, tarjeta.getCvc());
	}
	
	@Test
	public void testConstructorValorLimiteCvc999() {
		TarjetaCredito tarjeta = new TarjetaCredito("Ian", "12345", "11/03", 999, 23.5, 10.0, false);
		assertEquals(999, tarjeta.getCvc());
	}
	
	@Test
	public void testConstructorValorLimiteSaldo0() {
		TarjetaCredito tarjeta = new TarjetaCredito("Ian", "12345", "11/03", 999, 0.0, 10.0, false);
		assertEquals(0.0, tarjeta.getSaldo(), ERROR_ADMISIBLE);
	}
	
	@Test
	public void testConstructorPorCopia() {
		TarjetaCredito tarjeta1 = new TarjetaCredito("Ian", "12345", "11/03", 123, 23.5, 10.0, false);
		TarjetaCredito tarjeta2 = new TarjetaCredito(tarjeta1);
		assertEquals(tarjeta2, tarjeta1);
	}
	
	@Test
	public void testGetNombre() {
		TarjetaCredito tarjeta = new TarjetaCredito("Ian", "12345", "11/03", 123, 23.5, 10.0, false);
		assertEquals("Ian", tarjeta.getNombre());
	}
	
	@Test
	public void testGetNumeroTarjeta() {
		TarjetaCredito tarjeta = new TarjetaCredito("Ian", "12345", "11/03", 123, 23.5, 10.0, false);
		assertEquals("12345", tarjeta.getNumeroTarjeta());
	}
	
	@Test
	public void testGetFechaExpiracion() {
		TarjetaCredito tarjeta = new TarjetaCredito("Ian", "12345", "11/03", 123, 23.5, 10.0, false);
		assertEquals("11/03", tarjeta.getFechaExpiracion());
	}
	
	@Test
	public void testGetCvc() {
		TarjetaCredito tarjeta = new TarjetaCredito("Ian", "12345", "11/03", 123, 23.5, 10.0, false);
		assertEquals(123, tarjeta.getCvc());
	}
	
	@Test
	public void testGetSaldo() {
		TarjetaCredito tarjeta = new TarjetaCredito("Ian", "12345", "11/03", 123, 23.5, 10.0, false);
		assertEquals(23.5, tarjeta.getSaldo(), ERROR_ADMISIBLE);
	}
	
	@Test
	public void testGetCredito() {
		TarjetaCredito tarjeta = new TarjetaCredito("Ian", "12345", "11/03", 123, 23.5, 10.0, false);
		assertEquals(10.0, tarjeta.getCredito(), ERROR_ADMISIBLE);
	}
	
	@Test 
	public void testIsBloqueada() {
		TarjetaCredito tarjeta = new TarjetaCredito("Ian", "12345", "11/03", 123, 23.5, 10.0, false);
		assertFalse(tarjeta.isBloqueada());
	}
	
	@Test
	public void testEquals() {
		TarjetaCredito tarjeta1 = new TarjetaCredito("Ian", "12345", "11/03", 123, 23.5, 10.0, false);
		TarjetaCredito tarjeta2 = new TarjetaCredito("Ian", "12345", "11/03", 123, 23.5, 10.0, false);
		assertTrue(tarjeta1.equals(tarjeta2));
	}
	
	@Test
	public void testToString() {
		TarjetaCredito tarjeta = new TarjetaCredito("Ian", "12345", "11/03", 123, 23.5, 10.0, false);
		assertEquals("TarjetaCredito [nombre = Ian, numero de tarjeta = 12345, fecha expiracion = 11/03, cvc = 123, saldo = 23.5, credito = 10.0, bloqueada = false]", tarjeta.toString());
	}	
	
	@Test
	public void testRetirarDineroMenorQueSaldo() {
		TarjetaCredito tarjeta = new TarjetaCredito("Ian", "12345", "11/03", 999, 23.5, 10.0, false);
		tarjeta.retirarDinero(3.5);
		assertEquals(20.0, tarjeta.getSaldo(), ERROR_ADMISIBLE);
	}
	
	@Test
	public void testRetirarDineroIgualQueSaldo() {
		TarjetaCredito tarjeta = new TarjetaCredito("Ian", "12345", "11/03", 999, 23.5, 30.0, false);
		tarjeta.retirarDinero(23.5);
		assertEquals(0.0, tarjeta.getSaldo(), ERROR_ADMISIBLE);
	}
	
	@Test
	public void testRetirarDineroIgualQueCredito() {
		TarjetaCredito tarjeta = new TarjetaCredito("Ian", "12345", "11/03", 999, 23.5, 10.0, false);
		tarjeta.retirarDinero(10.0);
		assertEquals(13.5, tarjeta.getSaldo(), ERROR_ADMISIBLE);
	}
	
	// <--- Casos no válidos --->
	
	@Test (expected=IllegalArgumentException.class)
	public void testConstructorInvalidoNombreNulo() {
		new TarjetaCredito(null, "12345", "11/03", 999, 23.5, 10.0, false);
	}
	
	@Test (expected=IllegalArgumentException.class) 
	public void testConstructorInvalidoNombreVacio() {
		new TarjetaCredito("", "12345", "11/03", 999, 23.5, 10.0, false);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testConstructorNumeroNulo() {
		new TarjetaCredito("Ian", null, "11/03", 999, 23.5, 10.0, false);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testConstructorNumeroVacio() {
		new TarjetaCredito("Ian", "", "11/03", 999, 23.5, 10.0, false);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testConstructorInvalidoFechaNula() {
		new TarjetaCredito("Ian", "12345", null, 999, 23.5, 10.0, false);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testConstructorInvalidoFechaVacia() {
		new TarjetaCredito("Ian", "12345", "", 999, 23.5, 10.0, false);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testConstructorInvalidoCvcNegativo() {
		new TarjetaCredito("Ian", "12345", "11/03", -1, 23.5, 10.0, false);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testConstructorInvalidoCvcMayorQue999() {
		new TarjetaCredito("Ian", "12345", "11/03", 1000, 23.5, 10.0, false);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testConstructorInvalidoSaldoNegativo() {
		new TarjetaCredito("Ian", "12345", "11/03", 999, -1.0, 10.0, false);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testConstructorInvalidoCreditoNulo() {
		new TarjetaCredito("Ian", "12345", "11/03", 999, 23.5, 0.0, false);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testConstructorInvalidoCreditoNegativo() {
		new TarjetaCredito("Ian", "12345", "11/03", 999, 23.5, -1.0, false);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testRetirarDineroNegativo() {
		TarjetaCredito tarjeta = new TarjetaCredito("Ian", "12345", "11/03", 999, 23.5, 10.0, false);
		tarjeta.retirarDinero(-1.0);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testRetirarDineroMayorQueCredito() {
		TarjetaCredito tarjeta = new TarjetaCredito("Ian", "12345", "11/03", 999, 23.5, 10.0, false);
		tarjeta.retirarDinero(11.0);
	}
	
	@Test (expected=IllegalStateException.class)
	public void testRetirarDineroConTarjetaBloqueada() {
		TarjetaCredito tarjeta = new TarjetaCredito("Ian", "12345", "11/03", 999, 23.5, 10.0, true);
		tarjeta.retirarDinero(1.0);
	}
	
	@Test (expected=IllegalStateException.class)
	public void retirarDineroMasDelQueTieneTarjeta() {
		TarjetaCredito tarjeta = new TarjetaCredito("Ian", "12345", "11/03", 999, 1.0, 10.0, false);
		tarjeta.retirarDinero(2.0);
	}
}
