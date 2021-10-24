package LexicalAnalyzer;

import java.util.ArrayList;
import java.util.List;

public class LexicalAnalyzer {
    private List<String> inputList;
    private ArrayList<Token> tokens;
    private LineReader reader;

    public LexicalAnalyzer(List<String> inputList) {
        this.inputList = inputList;
        this.tokens = new ArrayList<Token>();
        this.reader = new LineReader();
    }

    // TODO: Implementer l'analyseur Lexical et ses diférents cas
    /**
     * Methode qui permet de lancer l'analyse lexicale
     */
    public void start() {
        System.out.println("Je commence l'analyse du fichier qui contient en tout " + inputList.size() + " lignes");

        // afficher les contenues de la liste
        System.out.println("=================================================================");
        for (String line : inputList) {
            System.out.println(line);
        }
        System.out.println("=================================================================");
    }

}
