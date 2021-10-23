package LexicalUnit;

import Enums.SeparatorEnum;
import LexicalUnit.Interface.IEntity;
import LexicalUnit.Interface.ILexicalUnit;

@IEntity(typeModel = Separator.class)
public class Separator implements ILexicalUnit {

    private String separator;

    public Separator(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }

    @Override
    public String getStrToken() {
        return separator;
    }

    /**
     * Methode qui permet de vérifier si le separateur est un séparateur définie dans l'enum SeparatorEnum
     * 
     * @param separatorValue séparateur à vérifier
     * @return true si le séparateur est un séparateur définie dans l'enum SeparatorEnum, false sinon
     */
    public static Boolean isSeparator(String separatorValue) {
        for (SeparatorEnum separator : SeparatorEnum.values()) {
            if (separator.getSeparator().equals(separatorValue)) {
                return true;
            }
        }
        return false;
    }

}
