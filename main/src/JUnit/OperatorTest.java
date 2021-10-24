package JUnit;

import LexicalUnit.Operator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperatorTest {

    @Test
    public void isOperator() {
        String operator = "+";
        String operator2 = "+-";
        String operator3 = "/";

        assertTrue(Operator.isOperator(operator), "Est-ce un opérateur");
        assertFalse(Operator.isOperator(operator2), "Est-ce un opérateur");
        assertTrue(Operator.isOperator(operator3), "Est-ce un opérateur");
    }
}