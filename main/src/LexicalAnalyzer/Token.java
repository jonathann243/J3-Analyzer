package LexicalAnalyzer;

import LexicalUnit.Interface.IEntity;
import LexicalUnit.Interface.ILexicalUnit;

public class Token {
    private String strToken;
    private IEntity entity;
    private Class classToken;
    private int lineNumber;

    public <T extends ILexicalUnit> Token(int nLine, T token) {
        this.strToken = token.getStrToken();
        this.entity = token.getClass().getAnnotation(IEntity.class);
        this.classToken = this.entity.typeModel();
        this.lineNumber = nLine;
    }

    public String getStrToken() {
        return strToken;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public Class getClassToken() {
        return classToken;
    }

    public IEntity getEntity() {
        return entity;
    }

}
