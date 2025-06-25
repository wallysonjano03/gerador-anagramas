package br.com.techsolucoes.anagramas;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite letras separadas por vírgula (ex: a,b,c): ");
        String input = scanner.nextLine().trim();
        
        // Validação adicional para entrada vazia
        if (input.isEmpty()) {
            System.out.println("Erro: Nenhuma letra foi informada.");
            scanner.close();
            return;
        }

        try {
            List<Character> letras = Arrays.stream(input.split(","))
                .map(s -> {
                    String trimmed = s.trim();
                    if (trimmed.isEmpty()) {
                        throw new IllegalArgumentException("Entrada inválida após vírgula.");
                    }
                    return trimmed.charAt(0);
                })
                .collect(Collectors.toList());
            
            List<String> anagramas = GeradorAnagramas.gerarAnagramas(letras);
            System.out.println("\nAnagramas gerados (" + anagramas.size() + "):");
            anagramas.forEach(System.out::println);
            
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Erro: Formato inválido. Use o padrão 'a,b,c' sem espaços extras entre letras.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}