package JUnit;

import Utilitaire.Utils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"12","123"})
    void isDigit(String input) {
        assertTrue(Utils.isDigit(input), "Ne contient que les chiffres");
    }
}