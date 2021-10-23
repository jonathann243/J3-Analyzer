package LexicalUnit.TestUnit;

import LexicalUnit.KeyWordUnit;
import org.junit.Test;

import static org.junit.Assert.*;

public class KeyWordUnitTest {

    @Test
    public void isKeyWord() {
        String motClef = "Procedure"; // OUI
        String motClef2 = "integer"; // NON

        assertTrue("Est-ce un mot clef ?", KeyWordUnit.isKeyWord(motClef));
        assertFalse("Est-ce un mot clef ?", KeyWordUnit.isKeyWord(motClef2));
    }
}