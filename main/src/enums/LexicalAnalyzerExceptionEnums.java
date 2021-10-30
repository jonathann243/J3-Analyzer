package enums;

/**
 * @author Josue Lubaki
 * @version 1.0
 */
public enum LexicalAnalyzerExceptionEnums {

    IDENTIFIANT_UNDERSCORE_ERROR(
            "Erreur Lexical (IDENT1E-UNDERSCORE-ERROR) : L'Identifiant n'est pas correct, " +
                    "car il contient le caractère '_', voir dans votre fichier"
    ),
    IDENTIFIANT_ERROR(
            "Erreur Lexical (IDENT2E-ERROR) : L'Identifiant n'est pas correct, " +
                    "car il ne respecte pas les normes de nomenclature définis, voir dans votre fichier"
    ),
    DIGIT_ERROR(
            "Erreur Lexical (DIGIT2E-ERROR) : L'entier saisit n'est pas correct, " +
                    "car il ne respecte pas les normes de nomenclature définis, voir dans votre fichier"
    );;

    private final String message;

    LexicalAnalyzerExceptionEnums(String message) {
        this.message = message;
    }

    public String getMessage(int nLine) {
        return message + " (ligne " + nLine + ")";
    }
}
