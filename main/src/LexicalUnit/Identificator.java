package LexicalUnit;

import LexicalUnit.Interface.IEntity;
import LexicalUnit.Interface.ILexicalUnit;

@IEntity(typeModel = Identificator.class)
public class Identificator implements ILexicalUnit {

    private String identificator;

    public Identificator(String identificator) {
        this.identificator = identificator;
    }

    public String getIdentificator() {
        return identificator;
    }

    @Override
    public String getStrToken() {
        return identificator;
    }

    /**
     * Methode qui perme de vérifier que le mot passé en pamaètre a une taille
     * inférieure ou égale à 8 caractères
     * 
     * @param identificator mot à vérifier
     * @return true si le mot est inférieur ou égale à 8 caractères, false sinon
     */
    public static boolean isIdentificator(String identificator) {
        return identificator.trim().length() <= 8;
    }

    /**
     * Methode qui permet de vérifier que si le mot passé en paramètre contient '_'
     * underscore
     * 
     * @param identificator mot à vérifier
     * @return true si le mot contient '_', false sinon
     */
    public static boolean containsUnderscore(String identificator) {
        return identificator.contains("_");
    }

}
