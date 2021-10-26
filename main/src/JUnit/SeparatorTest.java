package JUnit;

import LexicalUnit.SeparatorUnit;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeparatorTest {

    @ParameterizedTest
    @ValueSource(chars = {'=','(',')',';',':'})
    void isSeparator(char separator) {
        assertTrue(SeparatorUnit.isSeparator(separator), "est-ce un séparateur ?");
    }
}