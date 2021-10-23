package LexicalUnit.TestUnit;

import LexicalUnit.Separator;
import org.junit.Test;

import static org.junit.Assert.*;

public class SeparatorTest {

    @Test
    public void isSeparator() {
        String separator = "=";
        String separator2 = "+";
        String separator3 = ")";

        assertTrue("est-ce une séparateur ?", Separator.isSeparator(separator));
        assertFalse("est-ce une séparateur ?", Separator.isSeparator(separator2));
        assertTrue("est-ce une séparateur ?", Separator.isSeparator(separator3));
    }
}