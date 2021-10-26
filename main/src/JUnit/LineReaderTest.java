package JUnit;

import LexicalAnalyzer.LineReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Josue Lubaki
 * @version 1.0
 */
class LineReaderTest {

    private static LineReader reader;

    @BeforeAll
    public static void init(){
        reader = new LineReader();
    }

    @Test
    void nextChar() {
        String str = "Bonjour";
        char nextCharExcepted = 'o';

        reader = new LineReader();
        reader.setLine(str);
        char nextChar = reader.nextChar();

        assertEquals(nextCharExcepted, nextChar);
    }

    @Test
    void prevChar() {
        String str = "Bonjour";
        char prevCharExcepted = '\0';

        reader = new LineReader();
        reader.setLine(str);
        char prevChar = reader.prevChar();

        assertEquals(prevCharExcepted, prevChar);
    }

    @Test
    void currentChar() {
        String str = "Bonjour";
        char currentCharExcepted = 'B';

        reader = new LineReader();
        reader.setLine(str);
        char currentChar = reader.currentChar();

        assertEquals(currentCharExcepted, currentChar);
    }

    @Test
    void isEOL() {
        String str = "";

        reader = new LineReader();
        reader.setLine(str);
        boolean isEOL = reader.isEOL();

        assertTrue(isEOL);
    }

    @Test
    void isBOL() {
        String str = "Bonjour";

        reader = new LineReader();
        reader.setLine(str);
        boolean isBOL = reader.isBOL();

        assertTrue(isBOL);
    }
}