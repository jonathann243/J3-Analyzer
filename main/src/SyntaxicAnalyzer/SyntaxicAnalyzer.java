package SyntaxicAnalyzer;

import Enums.*;
import ExceptionCustom.SyntaxicAnalyzerException;
import LexicalAnalyzer.LexicalAnalyzer;
import LexicalUnit.IdentificatorUnit;
import LexicalUnit.NumberUnit;

import static Utilitaire.Utils.*;


/**
 * @author Jonathan Kanyinda & Josue Lubaki
 * @version 1.0
 */
public class SyntaxicAnalyzer {

    private final TokenReader tokenReader;
    private final GrammarManager grammarManager;

    public SyntaxicAnalyzer(LexicalAnalyzer lexicalAnalyzer) {
        this.tokenReader = new TokenReader(lexicalAnalyzer.getTokens());
        this.grammarManager = new GrammarManager();
    }

    /**
     * Methode qui permet de lancer l'analyse syntaxique
     */
    public void start() throws SyntaxicAnalyzerException {
        procedure();
    }

    /**
     * Methode qui permet de vérifier si la procédure commence avec le mot clé
     * "Procedure"
     */
    private void procedure() throws SyntaxicAnalyzerException {
        // vérifier que le mot clé du debut est "Procédure"
        if (tokenReader.getCurrentToken().getStrToken().equals(KeyWordEnum.PROCEDURE.getKeyWord())) {
            if (tokenReader.nextToken().getClassToken().equals(IdentificatorUnit.class)) {
                grammarManager.setProcedureName(tokenReader.getCurrentToken().getStrToken());
            }
            else {
                isKeyWordSyntaxic();
                try{
                    throw new SyntaxicAnalyzerException(SyntaxicAnalyzerExceptionEnum.IDENTIFICATOR_MISSING, tokenReader.getCurrentToken().getLineNumber());
                }catch(SyntaxicAnalyzerException e){
                    e.printStackTrace();
                }
            }

            // vérifier que le mot clé suivant est une declaration (des declarations)
            declarations();

            // vérifier le token suivant soit une suite d'instruction
            instructions_affectation();

            // vérifier que le mot clé suivant est "Fin_Procedure"
            if (tokenReader.nextToken().getStrToken().equals(KeyWordEnum.FIN_PROCEDURE.getKeyWord())) {

                if (tokenReader.nextToken().getClassToken().equals(IdentificatorUnit.class)
                        && grammarManager.isSameProcedure(tokenReader.getCurrentToken().getStrToken())) {
                    // Fin programme
                    System.out.println();
                    System.out.print(YELLOW_BOLD_BRIGHT  + "ANALYSE SYNTAXIQUE :" + RESET);
                    System.out.println(GREEN_BOLD_BRIGHT   + " Le Programme est correct " + RESET);
                } else {
                    isKeyWordSyntaxic();
                    try {
                        // alert nom de la procedure est different
                        throw new SyntaxicAnalyzerException(SyntaxicAnalyzerExceptionEnum.PROCEDURE_NON_MATCH, tokenReader.getCurrentToken().getLineNumber());
                    }catch(SyntaxicAnalyzerException e){
                        e.printStackTrace();
                    }

                }
            } else {
                throw new SyntaxicAnalyzerException(SyntaxicAnalyzerExceptionEnum.FIN_PROCEDURE_ERROR, tokenReader.getCurrentToken().getLineNumber());
            }
        } else {
            throw new SyntaxicAnalyzerException(SyntaxicAnalyzerExceptionEnum.PROCEDURE_MISSING, tokenReader.getCurrentToken().getLineNumber());
        }
    }

    /**
     * Méthode qui vérifie si le token courant un mot clé
     */
    public void isKeyWordSyntaxic() throws SyntaxicAnalyzerException {
        try {
            // Vérifier si l'identificateur courant est un mot clé
            if(isKeyWord(tokenReader.getCurrentToken().getStrToken())){
                throw new SyntaxicAnalyzerException(SyntaxicAnalyzerExceptionEnum.IDENTIFICATOR_SAME_KEYWORDS, tokenReader.getCurrentToken().getLineNumber());
            }
        }catch(SyntaxicAnalyzerException e){
            e.printStackTrace();
        }

    }

    /**
     * Début traitement des déclarations
     */
    private void declarations() throws SyntaxicAnalyzerException {
        declaration();
        other_declarations();
    }

    /**
     * Methode qui permet de vérifier si la declaration commence avec le mot clé
     * "declare"
     */
    private void declaration() throws SyntaxicAnalyzerException {

        // vérifier que le mot clé du debut est "declare"
        if (tokenReader.nextToken().getStrToken().equals(KeyWordEnum.DECLARE.getKeyWord())) {
            variable();
            grammarManager.addVariable(tokenReader.getCurrentToken().getStrToken());
            checkDoublePoint();
        } else {
            try{
                throw new SyntaxicAnalyzerException(SyntaxicAnalyzerExceptionEnum.DECLARE_MISSING, tokenReader.getCurrentToken().getLineNumber());
            }catch(SyntaxicAnalyzerException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Methode qui permet de vérifier le prochain token est (:)
     */
    private void checkDoublePoint() throws SyntaxicAnalyzerException {
        if (tokenReader.nextToken().getStrToken()
                .equals(String.valueOf(SeparatorEnum.DOUBLEPOINT.getSeparator()))) {

            checkType();

            checkSemicolon();
        } else {
            try{
                throw new SyntaxicAnalyzerException(SyntaxicAnalyzerExceptionEnum.DOUBLEPOINT_MISSING, tokenReader.getCurrentToken().getLineNumber());
            }catch(SyntaxicAnalyzerException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Methode qui permet de vérifier le prochain token est un SEMICOLON (;)
     */
    private void checkSemicolon() throws SyntaxicAnalyzerException {
        if (!tokenReader.nextToken().getStrToken()
                .equals(String.valueOf(SeparatorEnum.SEMICOLON.getSeparator()))) {
                throw new SyntaxicAnalyzerException(SyntaxicAnalyzerExceptionEnum.SEMICOLON_MISSING, tokenReader.getCurrentToken().getLineNumber());
        }
    }

    /**
     * Methode qui permet de vérifier si le prochain token est une variable
     */
    private void variable() throws SyntaxicAnalyzerException {
        if (!tokenReader.nextToken().getClassToken().equals(IdentificatorUnit.class)) {
            isKeyWordSyntaxic();
            try{
                throw new SyntaxicAnalyzerException(SyntaxicAnalyzerExceptionEnum.IDENTIFICATOR_MISSING, tokenReader.getCurrentToken().getLineNumber());
            }catch(SyntaxicAnalyzerException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Methode qui permet de vérifier le type de la variable
     */
    private void checkType() throws SyntaxicAnalyzerException {
        if (tokenReader.nextToken().getStrToken().equals(KeyWordEnum.ENTIER.getKeyWord())
                || tokenReader.getCurrentToken().getStrToken().equals(KeyWordEnum.REEL.getKeyWord())) {

            // setter le type de la variable ajouté récemment
            grammarManager.addTypeRecentVariable(tokenReader.getCurrentToken().getStrToken());

        } else {
            throw new SyntaxicAnalyzerException(SyntaxicAnalyzerExceptionEnum.TYPE_MISSING, tokenReader.getCurrentToken().getLineNumber());
        }
    }

    /**
     * Methode qui permet de vérifier si le prochain token est une nouvelle declaration ou non
     */
    private void other_declarations() throws SyntaxicAnalyzerException {
        if (tokenReader.nextToken().getStrToken().equals(KeyWordEnum.DECLARE.getKeyWord())) {
            tokenReader.moveCursorBack();
            declarations();
        } else {
            // aller au token suivant
            tokenReader.moveCursorBack();
        }
    }

    /**
     * Debut traitement des instructions
     */
    private void instructions_affectation() throws SyntaxicAnalyzerException {
        instruction_affectation();

        // Tant que le prochain token corrspond au ";", cela signifie qu'il y a encore
        // une autre instruction à traiter
        while (true) {
            if (!tokenReader.nextToken().getStrToken()
                    .equals(String.valueOf(SeparatorEnum.SEMICOLON.getSeparator()))) {
                tokenReader.moveCursorBack();
                break;
            }

            // il y a encore une instruction à traiter
            instruction_affectation();
        }
    }

    /**
     * Methode qui permet de vérifier la sémantique des instructions
     */
    private void instruction_affectation() throws SyntaxicAnalyzerException {
        variable();

        Variable varLeft = grammarManager.getVariableByName(tokenReader.getCurrentToken().getStrToken());

        if (varLeft != null) {
            grammarManager.setInstructionAtLeftType(varLeft.getStrType());

            if (tokenReader.nextToken().getStrToken()
                    .equals(String.valueOf(SeparatorEnum.EQUALITY.getSeparator()))) {
                expression_arithmetique();
            } else {
                try{
                    throw new SyntaxicAnalyzerException(SyntaxicAnalyzerExceptionEnum.EQUALITY_MISSING, tokenReader.getCurrentToken().getLineNumber());
                }catch(SyntaxicAnalyzerException e){
                    e.printStackTrace();
                }
            }

            if(!grammarManager.isAffectationTypeSupported()) {
                throw new SyntaxicAnalyzerException(SyntaxicAnalyzerExceptionEnum.AFFECTATION_ERROR, tokenReader.getCurrentToken().getLineNumber());
            }
        } else {
            try {
                throw new SyntaxicAnalyzerException(SyntaxicAnalyzerExceptionEnum.VARIABLE_NoDEFINE, tokenReader.getCurrentToken().getLineNumber());
            }catch(SyntaxicAnalyzerException e){
                e.printStackTrace();
            }

//        Récupération sur erreur en cas de variable non déclarée
            if (tokenReader.nextToken().getStrToken()
                    .equals(String.valueOf(SeparatorEnum.EQUALITY.getSeparator()))) {
                expression_arithmetique();
            } else {
                throw new SyntaxicAnalyzerException(SyntaxicAnalyzerExceptionEnum.EQUALITY_MISSING, tokenReader.getCurrentToken().getLineNumber());
            }
        }
    }

    /**
     * Methode qui permet de vérifier les expressions arithmétiques
     */
    private void expression_arithmetique() throws SyntaxicAnalyzerException {
        terme();

        // Tant que le prochain token correspond à "+" ou "-", cela signifie qu'il
        // encore un
        // autre terme à traiter
        while (true) {
            tokenReader.moveCursorForward();
            if (!(tokenReader.getCurrentToken().getStrToken().equals(String.valueOf(OperatorEnum.PLUS.getSymbole()))
                    || tokenReader.getCurrentToken().getStrToken()
                            .equals(String.valueOf(OperatorEnum.MOINS.getSymbole())))) {
                tokenReader.moveCursorBack();
                break;
            }

            // il y a encore un autre terme à traiter
            terme();
        }
    }

    /**
     * Methode qui permet de vérifier la grammaire concernant les termes
     */
    private void terme() throws SyntaxicAnalyzerException {
        factor();

        // Tant que le prochain token correspond à "*" ou "/", cela signique qu'il
        // encore un autre facteur à traiter
        while (true) {
            tokenReader.moveCursorForward();
            if (!(tokenReader.getCurrentToken().getStrToken().equals(String.valueOf(OperatorEnum.MULTIPLY.getSymbole()))
                    || tokenReader.getCurrentToken().getStrToken()
                            .equals(String.valueOf(OperatorEnum.DIVISE.getSymbole())))) {
                tokenReader.moveCursorBack();
                break;
            }

            // il y a encore un autre facteur à traiter
            factor();
        }
    }

    /**
     * Methode qui permet de vérifier la grammaire concernant le facteur
     */
    private void factor() throws SyntaxicAnalyzerException {
        tokenReader.moveCursorForward();

        if (tokenReader.getCurrentToken().getClassToken().equals(IdentificatorUnit.class)) {
            tokenReader.moveCursorBack();
            variable();
            Variable varRight = grammarManager.getVariableByName(tokenReader.getCurrentToken().getStrToken());

            if (varRight != null) {
                grammarManager.setInstructionAtRightType(varRight.getStrType());
            } else {
                try{
                    throw new SyntaxicAnalyzerException(SyntaxicAnalyzerExceptionEnum.VARIABLE_NoDEFINE, tokenReader.getCurrentToken().getLineNumber());
                }catch(SyntaxicAnalyzerException e){
                    e.printStackTrace();
                }
            }

        } else if (tokenReader.getCurrentToken().getClassToken().equals(NumberUnit.class)) {
            // parenthèse fermante
            grammarManager.setInstructionTypeNumberAtRight(tokenReader.getCurrentToken().getStrToken());

        } else if (tokenReader.getCurrentToken().getStrToken()
                .equals(String.valueOf(SeparatorEnum.BRACKETOPEN.getSeparator()))) {

            expression_arithmetique();

            if (!tokenReader.nextToken().getStrToken()
                    .equals(String.valueOf(SeparatorEnum.BRACKETCLOSE.getSeparator()))) {
                tokenReader.moveCursorBack();
                try{
                    throw new SyntaxicAnalyzerException(SyntaxicAnalyzerExceptionEnum.BRACKETCLOSE_MISSING, tokenReader.getCurrentToken().getLineNumber());
                }catch(SyntaxicAnalyzerException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
