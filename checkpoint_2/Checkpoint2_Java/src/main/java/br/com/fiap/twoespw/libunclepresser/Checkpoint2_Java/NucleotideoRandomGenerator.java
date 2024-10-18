package br.com.fiap.twoespw.libunclepresser.Checkpoint2_Java;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fiap.twoespw.libunclepresser.Checkpoint2_Java.funcoes.Funcoes;

import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class NucleotideoRandomGenerator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sequenceSize = 0;
		boolean validInput = false;
		while (!validInput) {
			System.out.print("Digite o tamanho da sequência: ");
			try {
				sequenceSize = scanner.nextInt();
				if (sequenceSize <= 0) {
					System.out.println("Por favor, digite um número positivo.");
				} else {
					validInput = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Valor provido foi inválido. Tente novamente.");
				scanner.next();
			}
		}

		String generatedString = Funcoes.generate(sequenceSize);

		System.out.print("Senha gerada: " + generatedString);

		scanner.close();
	}
}
