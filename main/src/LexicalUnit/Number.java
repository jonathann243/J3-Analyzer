package LexicalUnit;

import LexicalUnit.Interface.IEntity;
import LexicalUnit.Interface.ILexicalUnit;

@IEntity(typeModel = Number.class)
public class Number implements ILexicalUnit {

    private String value;

    public Number(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String getStrToken() {
        return value;
    }
    
}
