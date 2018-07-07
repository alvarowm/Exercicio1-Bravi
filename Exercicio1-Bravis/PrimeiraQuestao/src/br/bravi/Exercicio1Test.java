package br.bravi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Exercicio1Test {

	String[] acertos = { "exercicioDaBravi", "exercicioDaBravi()", "{{{[{()}]}}}", "(){}[]", "[{()}](){}", "[({})]",
			"()", "[]", "()(()){{}}", "{}" };

	String[] erros = { "((exercicioDaBravi)", "(", ")", "[]{)}", "{{}", "[[]]]]]]", "{{]}}", "[[]", "]" };

	@Test
	public void testeStringCorretas() {
		Exercicio1 ex1 = new Exercicio1();
		for (int i = 0; i < acertos.length; i++) {
			assertTrue(ex1.seEstaBalanceada(acertos[i]));
		}

	}

	@Test
	public void testeStringErradas() {
		Exercicio1 ex1 = new Exercicio1();
		for (int i = 0; i < erros.length; i++) {
			assertFalse(ex1.seEstaBalanceada(erros[i]));
		}

	}

}
