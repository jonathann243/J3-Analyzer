package LexicalAnalyzer;

import java.util.List;

public class LexicalAnalyzer {
    private List<String> file;

    public LexicalAnalyzer(List<String> file) {
        this.file = file;
    }

    // Analyse Lexical du fichier file
    public void analyse() {
        System.out.println("Je commence l'analyse du fichier file qui contient en tout " + file.size() + " lignes");
    }

    
}