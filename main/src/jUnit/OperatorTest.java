package jUnit;

import lexicalUnit.OperatorUnit;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Josue Lubaki
 * @version 1.0
 */
public class OperatorTest {

    @ParameterizedTest
    @ValueSource(chars = {'+','-','*','/'})
    void isOperator(char op) {
        assertTrue(OperatorUnit.isOperator(op), "Est-ce un opérateur");
    }
}