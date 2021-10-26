package LexicalUnit;

import LexicalUnit.Interface.IEntity;
import LexicalUnit.Interface.ILexicalUnit;

/**
 * @author Jonathan Kanyinda
 * @version 1.0
 */
@IEntity(typeModel = NumberUnit.class)
public class NumberUnit implements ILexicalUnit {

    private String value;

    public NumberUnit(String value) {
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
