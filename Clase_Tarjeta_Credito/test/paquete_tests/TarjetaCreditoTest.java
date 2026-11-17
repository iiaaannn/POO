package paquete_tests;

import paquete_tarjeta_credito.TarjetaCredito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

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
		assertEquals(tarjeta.getNombre(), "Ian");
		assertEquals(tarjeta.getNumeroTarjeta(), "12345");
		assertEquals(tarjeta.getFechaExpiracion(), "11/03");
		assertEquals(tarjeta.getCvc(), 123);
		assertEquals(tarjeta.getSaldo(), 23.5, ERROR_ADMISIBLE);
		assertEquals(tarjeta.getCredito(), 10.0, ERROR_ADMISIBLE);
		assertFalse(tarjeta.isBloqueada());
	}
	
}
