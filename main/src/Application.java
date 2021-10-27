import java.util.List;

import ExceptionCustom.LexicalAnalyzerException;
import LexicalAnalyzer.LexicalAnalyzer;
import SyntaxicAnalyzer.SyntaxicAnalyzer;
import Utilitaire.Utils;
import views.Menu;

/**
 * @author Josue Lubaki
 * @version 1.0
 */
public class Application {
    /**
     * Methode qui permet de démarrer l'application
     * @throws LexicalAnalyzerException lorsqu'une erreur survient lors de l'analyse, elle catégorise l'erreur selon son type
     */
    public static void start() throws LexicalAnalyzerException {
        // Affichage du menu
        Menu.showMenu();

        // Récupération de la saisie utilisateur
        int indice = -1;
        String nameFile;
        boolean exit = false;

        while(!exit){
            indice = Utils.getInputOnlyDigit("\n\tVeuillez choisir une option valide : ");
            if(indice == 0){
                Utils.copyright();
                exit = true;
            }
            else if(indice == 4){
                nameFile = Utils.getInput("\n\tVeuillez saisir le nom de votre fichier");
                openTestFile(nameFile);
            }
            else
                openTestFile(String.valueOf(indice));
        }
        Utils.closeScanner();
    }


    private static void openTestFile(String testNumber) throws LexicalAnalyzerException {
        List<String> allLinesFile = Utils.readFile(testNumber);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Lancement de l'analyse Lexicale
        startLexicalAnalyzer(allLinesFile);
    }

    /**
     * pré-lancement du lexical analyzer
     *
     * @param inputList la liste qui contient tous les contenues récupérées depuis le fichier
     * @throws LexicalAnalyzerException lorsqu'une erreur survient lors de l'analyse, elle catégorise l'erreur selon son type
     */
    private static void startLexicalAnalyzer(List<String> inputList) throws LexicalAnalyzerException {
        if (inputList.isEmpty()) {
            System.out.println("\tAnalyse Lexicale $> Désolé, Le fichier est vide !");
        } else {
            // Début du traitement d'analyse lexicale
            LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(inputList);
            lexicalAnalyzer.start();

            SyntaxicAnalyzer syntaxicAnalyzer = new SyntaxicAnalyzer(lexicalAnalyzer);
            syntaxicAnalyzer.start();
        }
    }
}
