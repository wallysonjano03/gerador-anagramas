package br.com.techsolucoes.anagramas;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class GeradorAnagramasTest {

    @Test
    public void testAnagramasBasicos() {
        List<Character> letras = Arrays.asList('a', 'b', 'c');
        List<String> anagramas = GeradorAnagramas.gerarAnagramas(letras);
        
        assertEquals(6, anagramas.size());
        assertTrue(anagramas.containsAll(Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba")));
    }

    @Test
    public void testAnagramasComUmaLetra() {
        List<Character> letras = Arrays.asList('x');
        List<String> anagramas = GeradorAnagramas.gerarAnagramas(letras);
        
        assertEquals(1, anagramas.size());
        assertEquals("x", anagramas.get(0));
    }

    @Test
    public void testEntradaVazia() {
        assertThrows(IllegalArgumentException.class, () -> {
            GeradorAnagramas.gerarAnagramas(Arrays.asList());
        });
    }
}