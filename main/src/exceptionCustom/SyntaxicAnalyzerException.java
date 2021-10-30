package exceptionCustom;

import enums.SyntaxicAnalyzerExceptionEnum;

/**
 * @author Josue Lubaki
 * @version 1.0
 */
public class SyntaxicAnalyzerException extends Exception {
    public SyntaxicAnalyzerException(SyntaxicAnalyzerExceptionEnum enums,int nLine){
        super(enums.getMessage(nLine));
    }
}
