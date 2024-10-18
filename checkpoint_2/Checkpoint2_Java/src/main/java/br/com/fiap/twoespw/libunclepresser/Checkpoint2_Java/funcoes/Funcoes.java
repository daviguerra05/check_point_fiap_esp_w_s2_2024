package br.com.fiap.twoespw.libunclepresser.Checkpoint2_Java.funcoes;

import java.util.Random;

public class Funcoes {
    private static final String CHARACTERS = "ACTG";

    public static String generate(Integer quantidade) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < quantidade; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }

        return sb.toString();
    }
}
