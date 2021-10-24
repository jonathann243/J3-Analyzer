package JUnit;

import LexicalUnit.Identificator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class IdentificatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcdefgh","     abcd      "})
    void isIdentificator(String identificator) {
        assertTrue(Identificator.isIdentificator(identificator), "Taille de l'identifacteur inférieure à 8");
    }

    @ParameterizedTest
    @ValueSource(strings = {"ab_","_"})
    void containsUnderscore(String str) {
        assertTrue(Identificator.containsUnderscore(str), "l'identifacteur contient underscore");
    }

}