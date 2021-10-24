import java.util.InputMismatchException;
import java.util.List;

import LexicalAnalyzer.LexicalAnalyzer;
import Utilitaire.Utils;
import views.Menu;

public class Application {
    public static void start() {
        
        // Affichage du menu
        Menu.showMenu();

        // Récupération de la saisie utilisateur
        int indice = Utilitaire.Utils.getInputOnlyDigit("\n\tVeuillez choisir une option : ");
        Utilitaire.Utils.closeScanner();

        if (indice == 0) {
            Utilitaire.Utils.copyright();
        } else {
            String path = "main/src/TestsFiles/testFile" + indice;
            List<String> file = Utils.readFile(path);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            startLexicalAnalyzer(file);
        }
    }

    /**
     * Lancement du lexical analyzer
     *
     * @param file
     */
    private static void startLexicalAnalyzer(List<String> file) {
        if (file.isEmpty()) {
            System.out.println("\tAnalyse Lexicale $> Désolé, Le fichier est vide !");
        } else {
            // Début du traitement d'analyse lexicale
            LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(file);
            lexicalAnalyzer.start();
        }
    }
}
