package br.com.fiap.twoespw.libunclepresser.Checkpoint2_Java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import br.com.fiap.twoespw.libunclepresser.Checkpoint2_Java.funcoes.Funcoes;

public class NucleotideoRandomGeneratorTest {

	@Test
	void contextLoads() {
		// Verifica se o contexto carrega corretamente
	}

	@Test
	void testGenerateRandomString() {
		int sequenceSize = 10; // Tamanho da sequência a ser testado
		String randomString = Funcoes.generate(sequenceSize);

		// Verifica se a string gerada tem o tamanho correto
		assertEquals(sequenceSize, randomString.length(), "A sequência gerada não tem o tamanho esperado.");
		// Verifica se todos os caracteres estão dentro do conjunto permitido
		for (char c : randomString.toCharArray()) {
			assertTrue("ACTG".indexOf(c) != -1, "A sequência contém um caractere inválido: " + c);
		}
	}
}
