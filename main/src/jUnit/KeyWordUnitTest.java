package jUnit;

import lexicalUnit.KeyWordUnit;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Josue Lubaki
 * @version 1.0
 */
public class KeyWordUnitTest {

    @ParameterizedTest
    @ValueSource(strings = {"Procedure","entier","reel","declare","Fin_Procedure"})
    void isKeyWord(String motClef) {
        assertTrue(KeyWordUnit.isKeyWord(motClef), "Est-ce un mot clef ?");
    }
}