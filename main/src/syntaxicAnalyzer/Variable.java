package syntaxicAnalyzer;

/**
 * @author Jonathan Kanyinda
 * @version 1.0
 */
public class Variable {
    private String mVariable;
    private String mType;

    public Variable(String mVariable){
        this.mVariable = mVariable;
    }

    public String getStrVariable() {
        return  mVariable;
    }

    public void setStrVariable(String str) {
        this.mVariable = str;
    }

    public String getStrType() {
        return mType;
    }

    public void setStrType(String str) {
        this.mType=str;
    }

}
