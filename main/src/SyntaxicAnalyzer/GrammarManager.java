package SyntaxicAnalyzer;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import Enums.KeyWordEnum;

/**
 * @author Jonathan Kanyinda
 * @version 1.0
 */
public class GrammarManager {
    private String procedureName;
    private List<Variable> variables;
    private String instructionAtLeftType;
    private String instructionAtRightType;

    public GrammarManager() {
        this.variables = new ArrayList<>();
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public boolean isSameProcedure(String procedureName) {
        return this.procedureName.equals(procedureName);
    }

    public void addVariable(String str) {
        variables.add(new Variable(str));
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }

    public void addTypeRecentVariable(String str) {
        int size = variables.size();
        variables.get(size-1).setStrType(str);
    }

    /**
     * Méthode qui permet de récuperer l'instance de la variable
     * 
     * @param str correspond au nom de la variable à rechercher
     * @return Variable, sinon null
     */
    public Variable getVariableByName(String str) {
        for (Variable variable: variables){
            if(variable.getStrVariable().equals(str))
                return variable;
        }

        return null;
    }

    public void setInstructionAtLeftType(String instructionAtLeftType) {
        this.instructionAtLeftType = instructionAtLeftType;
        this.instructionAtRightType = "";
    }

    public void setInstructionAtRightType(String type) {
        // si l'instruction se trouvant à droite de l'égalité est un reel
        // alors conserver le type reel
        if(!this.instructionAtRightType.equals(KeyWordEnum.REEL.getKeyWord()))
            this.instructionAtRightType = type;
        else
            this.instructionAtRightType = KeyWordEnum.REEL.getKeyWord();
    }

    /**
     * methode qui permet de setter le tyoe de la variable si celui est un nombre
     * 
     * @param typeNumber le type de la variable à affecter
     */
    public void setInstructionTypeNumberAtRight(String typeNumber) {
        KeyWordEnum type;

        if (typeNumber.matches("[0-9]{1,13}(\\.[0-9]+)")) {
            type = KeyWordEnum.REEL;
        } else {
            type = KeyWordEnum.ENTIER;
        }

        this.setInstructionAtRightType(type.getKeyWord());
    }

    public String getInstructionAtLeftType() {
        return instructionAtLeftType;
    }

    public String getInstructionAtRightType() {
        return instructionAtRightType;
    }

    /**
     * On vérifie si le type de la variable peut supporter le type de son
     * affectation
     * <p>
     * <h2>Possiblité :</h2> <br>
     * <ul>
     * <li>Un entier peut être affecté à une variable de type entier</li>
     * <li>Un entier peut être affecté à une variable de type réel</li>
     * <li>Un réel peut être affecté à une variable de type réel</li>
     * <li><b><span color="#e96695">Un réel ne peut pas être affecté à une variable de
     * type entier</span></b></li>
     * </ul>
     * </p>
     * 
     * @return boolean
     */
    public boolean isAffectationTypeSupported() {
        if (instructionAtLeftType.equals(KeyWordEnum.ENTIER.getKeyWord())
                && instructionAtRightType.equals(KeyWordEnum.REEL.getKeyWord())) {
            return false;
        }
        return true;
    }
}
