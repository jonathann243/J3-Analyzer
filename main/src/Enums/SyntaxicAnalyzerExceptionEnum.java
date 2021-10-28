package Enums;

public enum SyntaxicAnalyzerExceptionEnum {
    PROCEDURE_NON_MATCH(
            "Erreur Syntaxic (PROCEDURE-NoMATCH) : Nom de la procédure ne correspondant pas à celui declaré au debut, problème"
    ),
    FIN_PROCEDURE_ERROR(
            "Erreur Syntaxic (PROCEDURE-NoCOMPLETE) : Mot clé '" + KeyWordEnum.FIN_PROCEDURE.getKeyWord() + "' manquant"
    ),
    PROCEDURE_MISSING(
            "Erreur Syntaxic (PROCEDURE-MISSING) : Mot clé '" + KeyWordEnum.PROCEDURE.getKeyWord() + "' manquant"
    ),
    IDENTIFICATOR_SAME_KEYWORDS(
            "Erreur Syntaxic (PROCEDURE-SAME-KEYWORDS) : Votre identificateur n'est pas correct, car il est un mot clé du langage / Problème"
    ),
    DECLARE_MISSING(
            "Erreur Syntaxic (PROCEDURE-MISSING) : Mot clé '" + KeyWordEnum.DECLARE.getKeyWord() + "' manquant"
    ),
    DOUBLEPOINT_MISSING(
            "Erreur Syntaxic (SEPARATOR-MISSING) : Mot clé '" + SeparatorEnum.DOUBLEPOINT.getSeparator() + "' manquant"
    ),
    SEMICOLON_MISSING(
            "Erreur Syntaxic (SEPARATOR-MISSING) : Mot clé '" + SeparatorEnum.SEMICOLON.getSeparator() + "' manquant"
    ),
    IDENTIFICATOR_MISSING(
            "Erreur Syntaxic (IDENTIFICATOR-MISSING) : Un Identifiant est attendu après chaque mot clé 'Procedure', 'declare' et 'Fin_Procedure'"
    ),
    TYPE_MISSING(
            "Erreur Syntaxic (TYPE-MISSING) : Un Type de variable valide est attendu"
    ),
    EQUALITY_MISSING(
            "Erreur Syntaxic (EQUALITY-MISSING) : le symble d'égalité (=) est attendu"
    ),
    VARIABLE_NoDEFINE(
            "Erreur Syntaxic (VARIABLE_NoDEFINE) : Vous utilisez une variable non-declarée"
    ),
    BRACKETCLOSE_MISSING(
            "Erreur Syntaxic (TYPE-MISSING) : Une parenthèse fermante est attendu"
    ),
    AFFECTATION_ERROR(
            "Erreur Syntaxic (AFFECTATION-ERROR) : On ne peut affecter un résultat reel à une variable de type entier"
    );


    private final String message;

    SyntaxicAnalyzerExceptionEnum(String message) {
        this.message = message;
    }

    public String getMessage(int nLine) {
        return message + " à la ligne " + nLine;
    }
}
