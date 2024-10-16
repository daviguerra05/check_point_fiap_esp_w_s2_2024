package br.com.fiap.twoespwx.libunclepresser.Funcoes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Funcoes {
    private static long ler_tamanho_arquivo(String file_path){
        File file = new File(file_path);
        return file.length(); // Tamanho em bytes
    }
    
    private static String ler_nome_arquivo(String file_path){
        File file = new File(file_path);
        return file.getName();
    }

    private static int ler_total_chars(String txt_path){
        int total = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(txt_path))) {
            int caractere;
            // Lê o arquivo caractere por caractere
            while ((caractere = br.read()) != -1) {
                total++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return total;
    }

    private static double calcular_compression_ratio(long size_i, long size_f){
        double cr = (double) size_f*100/size_i;
        return cr;
    }

    private static double[] calcular_freq(String file_path){
        int num_a = 0;
        int num_c = 0;
        int num_t = 0;
        int num_g = 0;
        int total = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            int caractere;
            // Lê o arquivo caractere por caractere
            while ((caractere = br.read()) != -1) {
                
                if (caractere == 'a' || caractere == 'A'){
                    num_a++;
                    total++;
                }
                else if (caractere == 'c' || caractere == 'C'){
                    num_c++;
                    total++;
                }
                else if (caractere == 't' || caractere == 'T'){
                    num_t++;
                    total++;
                }
                else if (caractere == 'g' || caractere == 'G'){
                    num_g++;
                    total++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        double[] frequencias = {(double) num_a/total*100, (double) num_c/total*100, (double) num_g/total*100, (double) num_t/total*100};
        return frequencias;
    }

    // Função para gerar o relatório
    public static void relatorio(String input_filepath, String output_filepath){
        //Variáveis do relatório
        String input_filename = ler_nome_arquivo(input_filepath);
        String output_filename = ler_nome_arquivo(output_filepath);
        
        long input_filesize = ler_tamanho_arquivo(input_filepath);
        long output_filesize =  ler_tamanho_arquivo(output_filepath);
        String compression_ratio = String.format("%.2f", calcular_compression_ratio(input_filesize, output_filesize)) + "%";

        String total_input_chars = String.valueOf(ler_total_chars(input_filepath));

        double[] frequencias = calcular_freq(input_filepath); 
        String freq_a = frequencias[0] + "%";
        String freq_c = frequencias[1] + "%";
        String freq_t = frequencias[2] + "%";
        String freq_g = frequencias[3] + "%";

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
        System.out.println(String.format("| INPUT FILE SIZE: %d BYTES                               |",input_filesize));
        System.out.println("|                                                           |");
        System.out.println(String.format("| TOTAL INPUT CHARACTERS: %s                              |",total_input_chars));
        System.out.println("|                                                           |");
        System.out.println("| FREQUENCIES:                                              |");
        System.out.println(String.format("| A: %s                                                  |", freq_a));
        System.out.println(String.format("| C: %s                                                  |", freq_c));
        System.out.println(String.format("| T: %s                                                  |", freq_t));
        System.out.println(String.format("| G: %s                                                  |", freq_g));
        System.out.println("|                                                           |");
        System.out.println("| OPTIONS:                                                  |");
        System.out.println("|                                                           |");
        System.out.println("| ALGORITHM: Run-Length Encoding (RLE)                      |");
        System.out.println("| TEXT-CODIFICATION: UTF-8                                  |");
        System.out.println(String.format("| COMPRESSION RATIO: =~ %s from original size           |", compression_ratio));
        System.out.println("|                                                           |");
        System.out.println(String.format("| OUTPUT FILE SIZE: %d BYTES                              |", output_filesize));
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
            
            System.out.println("\nProcessamento completo!\n");
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}