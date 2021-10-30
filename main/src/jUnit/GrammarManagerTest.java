package jUnit;

import enums.KeyWordEnum;
import syntaxicAnalyzer.GrammarManager;
import syntaxicAnalyzer.Variable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GrammarManagerTest {

    private static GrammarManager grammarManager;
    private static List<Variable> variables;
    private static Variable maVariable;
    private static String instruction = "A";

    @BeforeAll
    public static void init(){
        grammarManager = new GrammarManager();
        variables = new ArrayList<>();
        grammarManager.setProcedureName("MaProcedure");
        grammarManager.setVariables(variables);
        maVariable = new Variable("var");
        variables.add(maVariable);
    }

    @Test
    void isSameProcedure() {
        String procedureName = "MaProcedure";
        assertTrue(grammarManager.isSameProcedure(procedureName));
    }

    @Test
    void addVariable() {
        assertTrue(grammarManager.getVariables().contains(maVariable));
        assertEquals("var", grammarManager.getVariables().get(0).getStrVariable());
    }

    @Test
    void addTypeRecentVariable() {
        grammarManager.addTypeRecentVariable(KeyWordEnum.ENTIER.getKeyWord());
        assertNotNull(grammarManager.getVariables().get(0).getStrType());
        assertEquals(KeyWordEnum.ENTIER.getKeyWord(), variables.get(0).getStrType());
    }

    @Test
    void getVariableByName() {
        assertNotNull(grammarManager.getVariableByName("var"));
    }

    @Test
    void setInstructionAtLeftType() {
        grammarManager.setInstructionAtLeftType(instruction);
        assertNotNull(grammarManager.getInstructionAtLeftType());
    }

    @Test
    void setInstructionAtRightType() {
        instruction = "entier";
        grammarManager.setInstructionAtRightType(instruction);
        assertNotNull(grammarManager.getInstructionAtRightType());
        assertEquals(KeyWordEnum.ENTIER.getKeyWord(),grammarManager.getInstructionAtRightType());
    }

    @Test
    void setInstructionTypeNumberAtRight() {
        instruction = "23.4";
        grammarManager.setInstructionTypeNumberAtRight(instruction);
        assertEquals("reel", grammarManager.getInstructionAtRightType());
    }

    @Test
    void getInstructionAtLeftType() {
        grammarManager.setInstructionAtLeftType(instruction);
        assertNotNull(grammarManager.getInstructionAtLeftType());
    }

    @Test
    void getInstructionAtRightType() {
        grammarManager.setInstructionAtRightType(instruction);
        assertNotNull(grammarManager.getInstructionAtRightType());
        assertEquals(grammarManager.getInstructionAtRightType(),instruction);
    }

    @Test
    void isAffectationTypeSupported() {
        grammarManager.setInstructionAtLeftType("entier");
        grammarManager.setInstructionAtRightType("reel");
        assertFalse(grammarManager.isAffectationTypeSupported());
    }
}