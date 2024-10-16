package br.com.fiap.twoespwx.libunclepresser.Funcoes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Funcoes {
    // Função para gerar o relatório
    public static void relatorio(){
        //Variáveis do relatório
        String input_filename = "INPUT1.TXT";
        String output_filename = "OUTPUT1.TXT";
        String input_filesize = "1024KB";
        String total_input_chars = "1.048.576";
        double freq_a = 25;
        double freq_c = 50;
        double freq_t = 12.50;
        double freq_g = 12.50;
        double compression_rate = 70;
        String output_filesize =  "314,572.8 BYTES";
        String score =  "WELL-DONE";

        //Print do relatório
        System.out.println(" ----------------------------------------------------------- ");
        System.out.println("|           LIB UNCLE PRESSER - DAVI, RUI E LUAN            |");
        System.out.println(" ----------------------------------------------------------- ");
        System.out.println("|                                                           |");
        System.out.println(String.format("| INPUT  FILENAME: %s                               |", input_filename));
        System.out.println(String.format("| OUTPUT FILENAME: %s                              |", output_filename));
        System.out.println("|                                                           |");
        System.out.println(" ----------------------------------------------------------- ");
        System.out.println("|                                                           |");
        System.out.println(String.format("| INPUT FILE SIZE: %s                                   |",input_filesize));
        System.out.println("|                                                           |");
        System.out.println(String.format("| TOTAL INPUT CHARACTERS: %s                         |",total_input_chars));
        System.out.println("|                                                           |");
        System.out.println("| FREQUENCIES:                                              |");
        System.out.println(String.format("| A: 262_144.0  (%.2f )                                    |", freq_a));
        System.out.println(String.format("| C: 524_288.0  (%.2f )                                    |", freq_c));
        System.out.println(String.format("| T: 131_072.0  (%.2f )                                    |", freq_t));
        System.out.println(String.format("| G: 131_072.0  (%.2f )                                    |", freq_g));
        System.out.println("|                                                           |");
        System.out.println("| OPTIONS:                                                  |");
        System.out.println("|                                                           |");
        System.out.println("| ALGORITHM: Run-Length Encoding (RLE)                      |");
        System.out.println("| TEXT-CODIFICATION: UTF-8                                  |");
        System.out.println(String.format("| COMPRESSION RATE: =~ %.2f                                |", compression_rate));
        System.out.println("|                                                           |");
        System.out.println(String.format("| OUTPUT FILE SIZE: %s                         |", output_filesize));
        System.out.println("|                                                           |");
        System.out.println(" ----------------------------------------------------------- ");
        System.out.println("|                                                           |");
        System.out.println(String.format("| SCORE: %s                                          |",score));
        System.out.println("|                                                           |");
        System.out.println(" ----------------------------------------------------------- ");
    } 

    // Função para comprimir o input string
    public static String comprimir(String input){
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
    public static void processarInput(String caminhoInput, String caminhoOutput){
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

    public static void main(String... args){
        relatorio();
    }

}