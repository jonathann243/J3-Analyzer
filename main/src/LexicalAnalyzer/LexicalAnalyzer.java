package LexicalAnalyzer;

import Enums.LexicalAnalyzerExceptionEnums;
import ExceptionCustom.LexicalAnalyzerException;
import LexicalUnit.IdentificatorUnit;
import LexicalUnit.KeyWordUnit;
import LexicalUnit.NumberUnit;
import LexicalUnit.OperatorUnit;
import LexicalUnit.SeparatorUnit;

import java.util.ArrayList;
import java.util.List;

import static Utilitaire.Utils.*;

public class LexicalAnalyzer {
    private final List<String> inputList;
    private final ArrayList<Token> tokens;
    private final LineReader reader;
    private int lineNumber = 0; // numéro de ligne de chaque instruction

    public LexicalAnalyzer(List<String> inputList) {
        this.inputList = inputList;
        this.tokens = new ArrayList<>();
        this.reader = new LineReader();
    }

    /**
     * Lancement du lexical analyzer
     * <p>
     *  Lancement de l'analyse, on récupère une ligne de la liste, puis on vérifie le premier caractère du mot,
     *  celui-ci determine dans quel cas nous nous situons parmi ceux implémentés
     * </p>
     *
     * @see #caseCharIsLetter(char charCurrent) le cas où la lettre courant est une lettre
     * @see #caseCharIsDigit(char charCurrent) le cas où la lettre courant est un chiffre
     * @see #caseCharIsOperator(char charCurrent) le cas où la lettre courant est un opérateur
     * @see #caseCharIsSeparator(char charCurrent) le cas où la lettre courant est un séparateur
     * @throws LexicalAnalyzerException lorsqu'une erreur survient lors de l'analyse, elle catégorise l'erreur selon son type
     */
    public void start() throws LexicalAnalyzerException {
        String lineCurrent;
        char charCurrent;

        for (String lineFile : inputList) {
            lineNumber++;
            lineCurrent = lineFile.trim();

            if (lineCurrent.isEmpty())
                continue;

            // passer la ligne au lecteur
            reader.setLine(lineCurrent);

            do {
                charCurrent = reader.currentChar();
                if (charCurrent == ' ' || charCurrent == '\t') {
                    // bouger le cursor vers l'avant
                    reader.nextCharForward();
                } else if (isLetter(charCurrent)) {
                    // le cas où le character courant est une lettre
                    caseCharIsLetter(charCurrent);
                } else if (isDigit(charCurrent)) {
                    // le cas où le character courant est un chiffre
                    caseCharIsDigit(charCurrent);
                } else if (isOperator(charCurrent)) {
                    // le cas où le character courant est un operator
                    caseCharIsOperator(charCurrent);
                } else if (isSeparator(charCurrent)) {
                    // le cas où le character courant est un separateur
                    caseCharIsSeparator(charCurrent);
                }
            } while (!reader.isEOL());
        }

        System.out.println("J'ai fini, voici les contenues de la liste des tokens");
        tokens.forEach(m -> System.out.print(m.getStrToken() + " "));
    }

    /**
     * Méthode à exécuter dans le cas où le caractère courant est une lettre
     * 
     * @param currentChar le caractère courant à analyser
     * @throws LexicalAnalyzerException lorsqu'une erreur survient lors de l'analyse, elle catégorise l'erreur selon son type
     */
    private void caseCharIsLetter(char currentChar) throws LexicalAnalyzerException {
        StringBuilder token = new StringBuilder();

        token.append(currentChar);
        reader.nextCharForward();

        // Si on est pas à la fin de la ligne et que le caractère courant est une suite
        // de lettre chiffre ou le caractère '_' underscore
        while (!reader.isEOL()
                && (isLetter(reader.currentChar()) || isDigit(reader.currentChar()) || reader.currentChar() == '_')) {
            token.append(reader.currentChar());
            reader.nextCharForward();
        }

        // Vérifier si le token construit est un mot clé
        if (isKeyWord(token.toString())) {
            KeyWordUnit keyWord = new KeyWordUnit(token.toString());
            Token sToken = new Token(lineNumber, keyWord);
            tokens.add(sToken);
        }
        // token n'est pas un mot clé et il contient underscore "_"
        else if (isContainsUndescore(token.toString())) {
            throw new LexicalAnalyzerException(LexicalAnalyzerExceptionEnums.IDENTIFIANT_UNDERSCORE_ERROR, lineNumber);
        }

        else if (isIdentificator(token.toString())) {
            IdentificatorUnit identificator = new IdentificatorUnit(token.toString());
            Token sToken = new Token(lineNumber, identificator);
            tokens.add(sToken);
        } else {
            // TODO Tenter de récupérer l'erreur, sinon
            throw new LexicalAnalyzerException(LexicalAnalyzerExceptionEnums.IDENTIFIANT_ERROR, lineNumber);
        }

    }

    /**
     * Méthode à éxecuter dans le cas où le caractère courant est un chiffre
     * 
     * @param currentChar le caractère courant à analyser
     */
    private void caseCharIsDigit(char currentChar) throws LexicalAnalyzerException {
        StringBuilder token = new StringBuilder();

        token.append(currentChar);
        reader.nextCharForward();

        // Si on est pas à la fin de la ligne et que le caractère courant est une suite
        // de chiffre
        while (!reader.isEOL() && (isDigit(reader.currentChar()) || reader.currentChar() == '.')) {
            token.append(reader.currentChar());
            reader.nextCharForward();
        }

        // Vérifier si le token construit est un entier
        if (isDigit(token.toString())) {
            NumberUnit integer = new NumberUnit(token.toString());
            Token sToken = new Token(lineNumber, integer);
            tokens.add(sToken);
        } else {
            // TODO Tenter de récupérer l'erreur, sinon
            throw new LexicalAnalyzerException(LexicalAnalyzerExceptionEnums.DIGIT_ERROR, lineNumber);
        }
    }

    /**
     * Méthode à éxecuter dans le cas où le caractère courant est un opérator
     * 
     * @param currentChar le caractère courant à analyser
     */
    private void caseCharIsOperator(char currentChar) {
        OperatorUnit operator = new OperatorUnit(currentChar);
        Token sToken = new Token(lineNumber, operator);
        tokens.add(sToken);

        // bouger le curseur sur le caractère suivant
        reader.nextCharForward();
    }

    /**
     * Méthode à éxecuter dans le cas où le caractère courant est un opérator
     * 
     * @param currentChar le caractère courant à analyser
     */
    private void caseCharIsSeparator(char currentChar) {
        SeparatorUnit separator = new SeparatorUnit(currentChar);
        Token sToken = new Token(lineNumber, separator);
        tokens.add(sToken);

        // bouger le curseur sur le caractère suivant
        reader.nextCharForward();
    }

    // getter de la liste de Token traité
    public ArrayList<Token> getTokens() {
        return tokens;
    }

}
