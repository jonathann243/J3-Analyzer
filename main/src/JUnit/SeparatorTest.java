package JUnit;

import LexicalUnit.Separator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeparatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"=","(",")",";",":"})
    void isSeparator(String separator) {
        assertTrue(Separator.isSeparator(separator), "est-ce un séparateur ?");
    }
}