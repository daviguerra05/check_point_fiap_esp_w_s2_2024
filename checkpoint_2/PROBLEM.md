- Problema: Geração aleatória de cadeias de nucletídeos
- Grupo: 2 a 4 pessoas
- Data de publicação: 04/10/2024
- Data limite de entrega: 18/10/2024
- Email de contato: proffellipe.souto@fiap.com.br

Continuando nossa saga trabalhando com cadeias de nucleotídeos, agora precisamos de uma forma prática de gerar cadeias aleatórias de qualquer tamanho que quisermos.

Para fazermos isso, definiremos uma interface comum, que será a seguinte:

public interface NucleotideoRandomGenerator {
    public String generate(int sequenceSize);
}
Você deverá criar um novo projeto Maven, conforme visto em aula, com o nome libunclegerardo. Nesse projeto crie a estrutura necessária para implementar a interface solicitada.

O método generate deverá receber um número inteiro positivo, que é o tamanho da sequência que devemos gerar. Como essa sequência será gerada ficará a cargo do grupo. Queremos exercitar a escrita de diferentes implementações dessa interface, assim estaremos explorando o verdadeiro poder do polimorfismo e contrato entre classes.

Alguns exemplos de geração de cadeias aleatórias:

entrada: 10
saída: AAAAAAAAAA

entrada: 10
saída: ACTGACTGACTG

entrada: 10
saída: TGCATGACTA

entrada: 4
saída: ACTG

entrada: 4
saída: GTCAACTG