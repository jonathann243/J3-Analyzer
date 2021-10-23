package LexicalUnit.TestUnit;

import LexicalUnit.Operator;
import org.junit.Test;

import static org.junit.Assert.*;

public class OperatorTest {

    @Test
    public void isOperator() {
        String operator = "+";
        String operator2 = "+-";
        String operator3 = "/";

        assertTrue("Est-ce un opérateur", Operator.isOperator(operator));
        assertFalse("Est-ce un opérateur", Operator.isOperator(operator2));
        assertTrue("Est-ce un opérateur", Operator.isOperator(operator3));
    }
}