/* 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 *
 * Grupo: Davi RM:551605, Rui RM:98436 e Luan RM:98290
 * Autores: 
 *      - Davi Passanha     -   rm551605@fiap.com.br
 *      - Rui Siqueira     -   rm98436@fiap.com.br
 *      - Luan Macea    -   rm98290@fiap.com.br
 */

package br.com.fiap.twoespwx.libunclepresser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App 
{
    // Função para comprimir o input string
    private static String comprimir(String input){
        //String de output vazia
        String output="";
        //int para contagem de repetições
        int contagem=1;
        //iteração principal para comprimir input
        for (int i = 1; i < input.length(); i++) {
            //Armazena os caracteres
            char char_anterior = input.charAt(i-1);
            char char_atual = input.charAt(i);
            // Verifica se o char atual é igual ao anterior
            if (char_anterior==char_atual){
                //Adiciona 1 à contagem
                contagem++;
                //Verifica se é o último caractere
                if(i==input.length()-1){
                    output += char_atual + String.valueOf(contagem);
                }
            }
            else{
                //Adiciona ao output o caracter e sua respectiva contagem
                output += char_anterior + String.valueOf(contagem);
                contagem=1;
                //Verifica se é o último caractere
                if(i==input.length()-1){
                    output += char_atual + "1";
                }
            }
        }    
        return output;
    }
    
    // Função para processar um arquvio .txt e escrever um novo .txt
    private static void processarInput(String caminhoInput, String caminhoOutput){
        // Leitura do arquivo de entrada e processamento
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoInput));
             BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoOutput))) {
            
            //Variavel para armazenar valor da linha atual
            String linha;
            
            // Lê cada linha do arquivo de entrada
            while ((linha = reader.readLine()) != null) {
                //Aplica processamento da linha
                String linhaProcessada = comprimir(linha);
                
                // Escreve a linha processada no arquivo de saída
                writer.write(linhaProcessada);
                writer.newLine();  // Pula para a próxima linha no arquivo de saída
            }
            
            System.out.println("Processamento completo!");
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {   
        // Verificar se os argumentos foram fornecidos
        if (args.length < 2) {
            System.out.println("Uso correto: java <caminho_javafile> <caminho_entrada> <caminho_saida>");
            return;
        }

        System.out.println("LIB UNCLE PRESSER - GRUPO Davi RM:551605, Rui RM:98436 e Luan RM:98290");
        processarInput(args[0],args[1]);
    }
}
