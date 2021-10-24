package JUnit;

import LexicalUnit.Identificator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IdentificatorTest {

    @Test
    public void isIdentificator() {
        String id = "abcdefgh";
        String id2 = "abcdefghij";
        String id3 = "     abcd      ";
        assertTrue(Identificator.isIdentificator(id), "Taille de l'identifacteur inférieure à 8");
        assertFalse(Identificator.isIdentificator(id2), "Taille de l'identifacteur inférieure à 8");
        assertTrue(Identificator.isIdentificator(id3), "Taille de l'identifacteur inférieure à 8");
    }

    @Test
    public void containsUnderscore() {
        String id = "ab_";
        String id2 = "abc";
        String id3 = "_";
        String id4 = "";
        assertTrue(Identificator.containsUnderscore(id), "l'identifacteur contient underscore");
        assertFalse(Identificator.containsUnderscore(id2),"l'identifacteur contient underscore");
        assertTrue(Identificator.containsUnderscore(id3), "l'identifacteur contient underscore");
        assertFalse(Identificator.containsUnderscore(id4),"l'identifacteur contient underscore");
    }
}