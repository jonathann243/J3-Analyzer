package JUnit;

import LexicalUnit.KeyWordUnit;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class KeyWordUnitTest {

    @ParameterizedTest
    @ValueSource(strings = {"Procedure","entier","reel","declare","Fin_Procedure"})
    void isKeyWord(String motClef) {
        assertTrue(KeyWordUnit.isKeyWord(motClef), "Est-ce un mot clef ?");
    }
}