package LexicalUnit;

import Enums.OperatorEnum;
import LexicalUnit.Interface.IEntity;
import LexicalUnit.Interface.ILexicalUnit;

/**
 * @author Jonathan Kanyinda
 * @version 1.0
 */
@IEntity(typeModel = OperatorUnit.class)
public class OperatorUnit implements ILexicalUnit {

    private char operator;

    public OperatorUnit(char operator) {
        this.operator = operator;
    }

    public char getOperator() {
        return operator;
    }

    @Override
    public String getStrToken() {
        return String.valueOf(operator);
    }

    /**
     * Methide qui vérifie si l'operator passé en paramètre est un opérateur
     * contenue dans l'Enum des opérateurs
     * 
     * @param operator opérateur à vérifier
     * @return true si l'opérateur est un opérateur, false sinon
     */
    public static boolean isOperator(char operator) {
        for (OperatorEnum op : OperatorEnum.values()) {
            if (op.getSymbole() == operator) {
                return true;
            }
        }
        return false;
    }

}
