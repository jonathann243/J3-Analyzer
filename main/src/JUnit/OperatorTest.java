package JUnit;

import LexicalUnit.Operator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"+","-","*","/"})
    void isOperator(String op) {
        assertTrue(Operator.isOperator(op), "Est-ce un opérateur");
    }
}