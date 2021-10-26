package JUnit;

import LexicalUnit.OperatorUnit;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperatorTest {

    @ParameterizedTest
    @ValueSource(chars = {'+','-','*','/'})
    void isOperator(char op) {
        assertTrue(OperatorUnit.isOperator(op), "Est-ce un opérateur");
    }
}