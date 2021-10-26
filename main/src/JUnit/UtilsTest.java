package JUnit;

import Utilitaire.Utils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Josue Lubaki
 * @version 1.0
 */
class UtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"12","123"})
    void isDigit(String input) {
        assertTrue(Utils.isDigit(input), "Ne contient que les chiffres");
    }

    @ParameterizedTest
    @ValueSource(chars = {'1','3'})
    void isDigit(char input) {
        assertTrue(Utils.isDigit(input), "Est un chiffre");
    }

    @ParameterizedTest
    @ValueSource(chars = {'a','A'})
    void isLetter(char input) {
        assertTrue(Utils.isLetter(input), "Est une lettre ?");
    }

    @ParameterizedTest
    @ValueSource(chars = {'+','-','*','/'})
    void isOperator(char input) {
        assertTrue(Utils.isOperator(input), "Est un operator ?");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Procedure","entier","reel","declare","Fin_Procedure"})
    void isKeyWord(String input) {
        assertTrue(Utils.isKeyWord(input), "Est un mot clé ?");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdefgh","     abcd      "})
    void isIdentificator(String input) {
        assertTrue(Utils.isIdentificator(input), "Est un identificateur ?");
    }

    @ParameterizedTest
    @ValueSource(strings = {"ab_","_","_ab","a_b"})
    void isContainsUndescore(String input) {
        assertTrue(Utils.isIdentificator(input), "Est un identificateur ?");
    }

    @ParameterizedTest
    @ValueSource(chars = {'=','(',')',';',':'})
    void isSeparator(char input) {
        assertTrue(Utils.isSeparator(input), "est un séparateur ?");
    }
}