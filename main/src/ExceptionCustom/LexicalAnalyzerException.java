package ExceptionCustom;

import Enums.LexicalAnalyzerExceptionEnums;

/**
 * @author Josue Lubaki
 * @version 1.0
 */
public class LexicalAnalyzerException extends Exception {
    /**
     * Constructeur de l'exception d'analyse Lexical
     * <p>
     *     example: <br>
     *     throw new LexicalAnalyzerException(A,5) <br>
     *     <h2> possible value for A :</h2>
     *     <ul>
     *         <li><b><span color="lime">{@link LexicalAnalyzerExceptionEnums#IDENTIFIANT_UNDERSCORE_ERROR}</span></b></li>
     *         <li><b><span color="lime">{@link LexicalAnalyzerExceptionEnums#IDENTIFIANT_ERROR}</span></b></li>
     *         <li><b><span color="lime">{@link LexicalAnalyzerExceptionEnums#DIGIT_ERROR}</span></b></li>
     *     </ul>
     * </p>
     *
     * @param typeEnum le type d'erreur à renvoyer parmi celles définies
     * @param nLine le numéro de la ligne où se trouve l'erreur
     *
     */
    public LexicalAnalyzerException(LexicalAnalyzerExceptionEnums typeEnum, int nLine){
        super(typeEnum.getMessage(nLine));
    }



}
