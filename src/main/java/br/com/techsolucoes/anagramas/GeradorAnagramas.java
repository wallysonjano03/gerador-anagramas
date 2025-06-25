package br.com.techsolucoes.anagramas;

import java.util.ArrayList;
import java.util.List;

public class GeradorAnagramas {

    public static List<String> gerarAnagramas(List<Character> letras) {
        if (letras == null || letras.isEmpty()) {
            throw new IllegalArgumentException("A lista de letras não pode ser vazia ou nula.");
        }

        List<String> anagramas = new ArrayList<>();
        gerarAnagramasRecursivo(letras, new StringBuilder(), new boolean[letras.size()], anagramas);
        return anagramas;
    }

    private static void gerarAnagramasRecursivo(List<Character> letras, StringBuilder atual, 
                                              boolean[] usadas, List<String> resultado) {
        if (atual.length() == letras.size()) {
            resultado.add(atual.toString());
            return;
        }

        for (int i = 0; i < letras.size(); i++) {
            if (!usadas[i]) {
                usadas[i] = true;
                atual.append(letras.get(i));
                gerarAnagramasRecursivo(letras, atual, usadas, resultado);
                atual.deleteCharAt(atual.length() - 1);
                usadas[i] = false;
            }
        }
    }
}