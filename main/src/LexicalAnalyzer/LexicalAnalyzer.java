package LexicalAnalyzer;

import LexicalUnit.Identificator;
import LexicalUnit.KeyWordUnit;

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

    // TODO: Implementer l'analyseur Lexical et ses différents cas
    /**
     * Methode qui permet de lancer l'analyse lexicale
     */
    public void start() {
        String lineCurrent;
        char charCurrent;

       for(String lineFile : inputList){
           lineNumber++;
           lineCurrent = lineFile.trim();

           if(lineCurrent.isEmpty())
               continue;

           // passer la ligne au lecteur
           reader.setLine(lineCurrent);

           do{
               charCurrent = reader.currentChar();
               if(charCurrent == ' ' || charCurrent == '\t'){
                   // bouger le cursor vers l'avant
                   reader.nextCharForward();
               }else if(isLetter(charCurrent)){
                    // le cas où le character courant est une lettre
                   caseCharIsLetter(charCurrent);
               }
               else if(isDigit(charCurrent)){
                   // le cas où le character courant est un chiffre
                   caseCharIsDigit(charCurrent);
               }
               else if(isOperator(charCurrent)){
                   // le cas où le character courant est un operator
                   caseCharIsOperator(charCurrent);
               }
               else if(isSeparator(charCurrent)){
                   // le cas où le character courant est un separateur
                   caseCharIsSeparator(charCurrent);
               }
           }while(!reader.isEOL());
       }
        System.out.println("J'ai fini");
    }

    /**
     * Méthode à éxecuter dans le cas où le caractère courant est une lettre
     * @param currentChar le caractère courant à analyser
     * @return void
     */
    private void caseCharIsLetter(char currentChar) {
        StringBuilder token = new StringBuilder();

        token.append(currentChar);
        reader.nextCharForward();

        // Si on est pas à la fin de la ligne et que le caractère courant est une suite de lettre
        // chiifre ou le caractère '_' underscore
        while(!reader.isEOL() &&
                (isLetter(reader.currentChar())
                        || isDigit(reader.currentChar())
                        || reader.currentChar() == '_')
        ){
            token.append(reader.currentChar());
            reader.nextCharForward();
        }

        // Vérifier si le token construit est un mot clé
        if(isKeyWord(token.toString())){
            KeyWordUnit keyWord = new KeyWordUnit(token.toString());
            Token sToken = new Token(lineNumber, keyWord);
            tokens.add(sToken);
        }
        // token n'est pas un mot clé mais il contient underscore "_"
        else if(isContainsUndescore(token.toString())){
            // TODO lancer un throw new LexicalException, en créant un custom Exception (LexicalAnalyzerException)
            // throw new LexicalAnalyzerException("Erreur lexical (Ligne "+ lineNumber +"): L'identificateur "+ token.toString() +" n'est pas correct");
        }

        else if(isIdentificator(token.toString())){
            Identificator identificator = new Identificator(token.toString());
            Token sToken = new Token(lineNumber, identificator);
            tokens.add(sToken);
        }
        else{
            // TODO Tenter de récupérer l'erreur, sinon
            // CODE ICI
            // throw new LexicalAnalyzerException("Erreur lexical (Ligne "+ lineNumber +"): L'identificateur "+ token.toString() +" n'est pas correct");
        }

    }

    private void caseCharIsOperator(char currentChar) {
        System.out.println("Voici le caseCharIsOperator dans caseCharIsOperator " + currentChar);
        reader.nextCharForward();
    }

    private void caseCharIsSeparator(char currentChar) {
        System.out.println("Voici le caseCharIsSeparator dans caseCharIsOperator " + currentChar);
        reader.nextCharForward();
    }

    private void caseCharIsDigit(char currentChar) {
        System.out.println("Voici le caseCharIsDigit dans caseCharIsOperator " + currentChar);
        reader.nextCharForward();
    }

    // getter de la liste de Token traité
    public ArrayList<Token> getTokens(){
        return tokens;
    }

}
