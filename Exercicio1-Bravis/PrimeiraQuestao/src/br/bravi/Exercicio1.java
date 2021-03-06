package br.bravi;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Exercicio1 {

	private final char ABRE_PARENTESES = '(';
	private final char FECHA_PARENTESES = ')';
	private final char ABRE_COLCHETES = '[';
	private final char FECHA_COLCHETES = ']';
	private final char ABRE_CHAVES = '{';
	private final char FECHA_CHAVES = '}';

	public boolean seEstaBalanceada(String expressao) {
		Stack<Character> pilhaDeCharsProcurados = new Stack<Character>();

		Map<Character, Character> mapDeCharsEsperados = new HashMap<>();

		inicializarMap(mapDeCharsEsperados);

		for (int i = 0; i < expressao.length(); i++) {

			if (mapDeCharsEsperados.get(expressao.charAt(i)) != null) {
				pilhaDeCharsProcurados.push(mapDeCharsEsperados.get(expressao.charAt(i)));
				continue;
			}

			if (!pilhaDeCharsProcurados.isEmpty() && expressao.charAt(i) == pilhaDeCharsProcurados.peek()) {
				pilhaDeCharsProcurados.pop();
				continue;
			}

			// se o char � um fechamento n�o esperado
			if (seCharEhFechamento(expressao, i)) {
				return false;
			}

		}

		return pilhaDeCharsProcurados.isEmpty();
	}

	private boolean seCharEhFechamento(String expressao, int i) {
		return expressao.charAt(i) == FECHA_CHAVES || expressao.charAt(i) == FECHA_COLCHETES
				|| expressao.charAt(i) == FECHA_PARENTESES;
	}

	private void inicializarMap(Map<Character, Character> mapDeCharsEsperados) {
		mapDeCharsEsperados.put(ABRE_PARENTESES, FECHA_PARENTESES);
		mapDeCharsEsperados.put(ABRE_COLCHETES, FECHA_COLCHETES);
		mapDeCharsEsperados.put(ABRE_CHAVES, FECHA_CHAVES);
	}

}
