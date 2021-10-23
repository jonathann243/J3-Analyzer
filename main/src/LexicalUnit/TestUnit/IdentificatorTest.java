package LexicalUnit.TestUnit;

import LexicalUnit.Identificator;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IdentificatorTest {

    @Test
    public void isIdentificator() {
        String id = "abcdefgh";
        String id2 = "abcdefghij";
        String id3 = "     abcd      ";
        assertTrue("Taille de l'identifacteur inférieure à 8", Identificator.isIdentificator(id));
        assertFalse("Taille de l'identifacteur inférieure à 8", Identificator.isIdentificator(id2));
        assertTrue("Taille de l'identifacteur inférieure à 8", Identificator.isIdentificator(id3));
    }

    @Test
    public void containsUnderscore() {
        String id = "ab_";
        String id2 = "abc";
        String id3 = "_";
        String id4 = "";
        assertTrue("l'identifacteur contient underscore", Identificator.containsUnderscore(id));
        assertFalse("l'identifacteur contient underscore", Identificator.containsUnderscore(id2));
        assertTrue("l'identifacteur contient underscore", Identificator.containsUnderscore(id3));
        assertFalse("l'identifacteur contient underscore", Identificator.containsUnderscore(id4));
    }
}