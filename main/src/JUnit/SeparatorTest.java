package JUnit;

import LexicalUnit.Separator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeparatorTest {

    @Test
    public void isSeparator() {
        String separator = "=";
        String separator2 = "+";
        String separator3 = ")";

        assertTrue(Separator.isSeparator(separator), "est-ce un séparateur ?");
        assertFalse(Separator.isSeparator(separator2), "est-ce un séparateur ?");
        assertTrue(Separator.isSeparator(separator3), "est-ce un séparateur ?");
    }
}