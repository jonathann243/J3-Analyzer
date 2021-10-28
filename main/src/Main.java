import ExceptionCustom.LexicalAnalyzerException;
import ExceptionCustom.SyntaxicAnalyzerException;

public class Main {
    /**
     * Point d'entré de l'application
     * @param args argument d'entrée d'application
     * @throws LexicalAnalyzerException lorsqu'une erreur survient lors de l'analyse lexicale, elle catégorise l'erreur selon son type
     * @throws SyntaxicAnalyzerException lorsqu'une erreur survient lors de l'analyse syntaxique, elle catégorise l'erreur selon son type
     */
    public static void main(String[] args) throws LexicalAnalyzerException, SyntaxicAnalyzerException {
        Application.start();
    }
}

