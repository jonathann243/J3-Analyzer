package SyntaxicAnalyzer;

import Enums.KeyWordEnum;
import Enums.OperatorEnum;
import Enums.SeparatorEnum;
import LexicalAnalyzer.LexicalAnalyzer;
import LexicalUnit.IdentificatorUnit;
import LexicalUnit.NumberUnit;


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
    public void start() {
        procedure();
    }

    /**
     * Methode qui permet de vérifier si la procédure commence avec le mot clé
     * "Procedure"
     */
    private void procedure() {
        // vérifier que le mot clé du debut est "Procédure"
        if (tokenReader.getCurrentToken().getStrToken().equals(KeyWordEnum.PROCEDURE.getKeyWord())) {
            if (tokenReader.nextToken().getClassToken().equals(IdentificatorUnit.class)) {
                // Sauvegarder l'identificateur dans une collection
                grammarManager.setProcedureName(tokenReader.getCurrentToken().getStrToken());

            } else {
                System.out.println("Erreur : Identificateur attendu - 44");
                // TODO exception
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
                    System.out.println("Fin programme");
                } else {
                    // alert nom de la procedure est different
                    System.out.println("Erreur : Nom de la procédure ne correspondant pas à celui declaré au debut !");
                }
            } else {
                System.out.println("Erreur : mot 'Fin_Procedure' attendu - 66");
                // TODO exception
            }
        } else {
            System.out.println("Erreur : mot 'Procedure' attendu");
            // TODO exception
        }
    }

    /**
     * Début traitement des déclarations
     */
    private void declarations() {
        declaration();
        other_declarations();
    }

    /**
     * Methode qui permet de vérifier si la procédure commence avec le mot clé
     * "declare"
     */
    private void declaration() {

        // vérifier que le mot clé du debut est "declare"
        if (tokenReader.nextToken().getStrToken().equals(KeyWordEnum.DECLARE.getKeyWord())) {

            variable();

            grammarManager.addVariable(tokenReader.getCurrentToken().getStrToken());

            checkDoublePoint();
        } else {
            System.out.println("Erreur : 'declare' attendu");
            // TODO exception
        }
    }

    // Méthode qui vérifie si le token courant est un ":"
    private void checkDoublePoint() {
        if (tokenReader.nextToken().getStrToken()
                .equals(String.valueOf(SeparatorEnum.DOUBLEPOINT.getSeparator()))) {

            checkType();

            checkSemicolon();
        } else {
            System.out.println("Erreur : ':' attendu");
            // TODO exception
        }
    }

    // Méthode qui vérifie si le token courant est un ";"
    private void checkSemicolon() {
        if (tokenReader.nextToken().getStrToken()
                .equals(String.valueOf(SeparatorEnum.SEMICOLON.getSeparator()))) {
            // traitement correct
        } else {
            System.out.println("Erreur : ';' attendu");
            // TODO exception
        }
    }

    private void variable() {
        if (tokenReader.nextToken().getClassToken().equals(IdentificatorUnit.class)) {
           // traitement correct
        } else {
            System.out.println("Erreur : Identificateur attendu - 132");
            // TODO exception
        }
    }

    private void checkType() {
        if (tokenReader.nextToken().getStrToken().equals(KeyWordEnum.ENTIER.getKeyWord())
                || tokenReader.getCurrentToken().getStrToken().equals(KeyWordEnum.REEL.getKeyWord())) {

            // setter le type de la variable ajouté récemment
            grammarManager.addTypeRecentVariable(tokenReader.getCurrentToken().getStrToken());

        } else {
            System.out.println("Erreur : Type attendu");
            // TODO exception
        }
    }

    private void other_declarations() {
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
    private void instructions_affectation() {
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


    private void instruction_affectation() {
        variable();

        Variable varLeft = grammarManager.getVariableByName(tokenReader.getCurrentToken().getStrToken());

        if (varLeft != null) {
            grammarManager.setInstructionAtLeftType(varLeft.getStrType());

            if (tokenReader.nextToken().getStrToken()
                    .equals(String.valueOf(SeparatorEnum.EQUALITY.getSeparator()))) {
                expression_arithmetique();
            } else {
                System.out.println("Erreur : '=' attendu");
                // TODO exception
            }

            if(!grammarManager.isAffectationTypeSupported()){
                System.out.println("resultat reel à un entier");
            }
        } else {
            System.out.println("Erreur : Variable non déclarée - 205");
            // TODO exception

            // Récupération sur erreur en cas de variable non déclarée
            if (tokenReader.nextToken().getStrToken()
                    .equals(String.valueOf(SeparatorEnum.EQUALITY.getSeparator()))) {
                expression_arithmetique();
            } else {
                System.out.println("Erreur : '=' attendu");
                // TODO exception
            }
        }
    }

    private void expression_arithmetique() {
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

    private void terme() {
        facteur();

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
            facteur();
        }
    }

    private void facteur() {
        tokenReader.moveCursorForward();

        if (tokenReader.getCurrentToken().getClassToken().equals(IdentificatorUnit.class)) {
            tokenReader.moveCursorBack();
            variable();
            Variable varRight = grammarManager.getVariableByName(tokenReader.getCurrentToken().getStrToken());

            if (varRight != null) {
                grammarManager.setInstructionAtRightType(varRight.getStrType());
            } else {
                System.out.println("Erreur : Variable non déclarée - 269");
                // TODO exception
            }

        } else if (tokenReader.getCurrentToken().getClassToken().equals(NumberUnit.class)) {
            // parenthèse fermante
            grammarManager.setInstructionTypeNumberAtRight(tokenReader.getCurrentToken().getStrToken());

        } else if (tokenReader.getCurrentToken().getStrToken()
                .equals(String.valueOf(SeparatorEnum.BRACKETOPEN.getSeparator()))) {

            expression_arithmetique();

            if (tokenReader.nextToken().getStrToken()
                    .equals(String.valueOf(SeparatorEnum.BRACKETCLOSE.getSeparator()))) {
                // Traitement correct
            } else {
                tokenReader.moveCursorBack();
                System.out.println("Erreur : ')' attendu");
                // TODO exception
            }
        } else {
            // Traitement correct
        }
    }
}
