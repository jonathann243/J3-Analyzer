package LexicalUnit;

import Enums.OperatorEnum;
import LexicalUnit.Interface.IEntity;
import LexicalUnit.Interface.ILexicalUnit;

@IEntity(typeModel = Operator.class)
public class Operator implements ILexicalUnit {

    private String operator;

    public Operator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public String getStrToken() {
        return operator;
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
