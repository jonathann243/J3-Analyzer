package JUnit;

import LexicalUnit.KeyWordUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KeyWordUnitTest {

    @Test
    public void isKeyWord() {
        String motClef = "Procedure"; // OUI
        String motClef2 = "integer"; // NON

        assertTrue(KeyWordUnit.isKeyWord(motClef), "Est-ce un mot clef ?");
        assertFalse(KeyWordUnit.isKeyWord(motClef2), "Est-ce un mot clef ?");
    }
}