package ejercicio2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ejercicio2Test {

	@Test
	void testFact() {
		int esperado=6;
		int test = Ejercicio2.fact(3);
		assertEquals(esperado,test);
	}

	@Test
	void testMain() {
		fail("Not yet implemented");
	}

}
