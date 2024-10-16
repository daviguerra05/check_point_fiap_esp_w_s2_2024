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
import br.com.fiap.twoespwx.libunclepresser.Funcoes.Funcoes;

public class App 
{
        public static void main(String[] args)
    {   
        // Verificar se os argumentos foram fornecidos
        if (args.length < 2) {
            System.out.println("Uso correto: java <caminho_javafile> <caminho_entrada> <caminho_saida>");
            return;
        }

        Funcoes.processarInput(args[0],args[1]);
        Funcoes.relatorio(args[0],args[1]);
    }
}
