package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	
// ------------------- incremento -------------------	
	
	@DisplayName("Subtração de dois numeros")
	@Test
	public void testSubtrairNumeros() {
		int sub = calc.subtracao(4, 5);		
		Assertions.assertEquals(-1, sub);		
	}
	
	@DisplayName("Somatorio de um número")
	@Test
	public void somatorio() {
		int somatorio = calc.somatoria(4);		
		Assertions.assertTrue(somatorio == 10);		
	}
	
	@DisplayName("Comparação de dois números")
	@Test
	public void compara() {
		int compara = calc.compara(1 , 2);		
		Assertions.assertTrue(compara == -1);		
	}
	
	@DisplayName("Inteiro Positivo")
	@Test
	public void intPositivo() {
		boolean intPositivo = calc.ehPositivo(10);	
		Assertions.assertTrue(intPositivo);		
		boolean intNegativo = calc.ehPositivo(-10);
		Assertions.assertFalse(intNegativo);		
	}
	
	

}