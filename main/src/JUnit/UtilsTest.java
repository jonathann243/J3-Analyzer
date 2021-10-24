package JUnit;

import Utilitaire.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void isDigit() {
        String input = "test";
        String input2 = "12_";
        String input3 = "123";

        Assertions.assertFalse(Utils.isDigit(input), "Ne contient que les chiffres");
        assertFalse(Utils.isDigit(input2),"Ne contient que les chiffres");
        assertTrue(Utils.isDigit(input3),"Ne contient que les chiffres");
    }
}