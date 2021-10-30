import java.util.List;

import exceptionCustom.LexicalAnalyzerException;
import exceptionCustom.SyntaxicAnalyzerException;
import lexicalAnalyzer.LexicalAnalyzer;
import syntaxicAnalyzer.SyntaxicAnalyzer;
import utilitaire.Utils;
import views.Menu;

import static utilitaire.Utils.*;

/**
 * @author Josue Lubaki
 * @version 1.0
 */
public class Application {
    /**
     * Methode qui permet de démarrer l'application
     * @throws LexicalAnalyzerException lorsqu'une erreur survient lors de l'analyse lexicale, elle catégorise l'erreur selon son type
     * @throws SyntaxicAnalyzerException lorsqu'une erreur survient lors de l'analyse syntaxique, elle catégorise l'erreur selon son type
     */
    public static void start() throws LexicalAnalyzerException, SyntaxicAnalyzerException {


        // Récupération de la saisie utilisateur
        int indice = -1;
        String nameFile;
        boolean exit = false;

        while(!exit){
            // Affichage du menu
            Menu.showMenu();
            indice = Utils.getInputOnlyDigit("\n\tVeuillez choisir une option valide : ");
            if(indice == 0){
                Utils.copyright();
                exit = true;
            }
            else if(indice == 10){
                nameFile = Utils.getInput("\n\t " + YELLOW_BOLD_BRIGHT + "ANALYSE LEXICALE : " + RESET + "Veuillez saisir le nom de votre fichier " +
                        "(exemple : "+ YELLOW_BOLD_BRIGHT + "testFile1" + RESET + ")");
                openTestFile(nameFile);
            }
            else
                openTestFile(String.valueOf(indice));
        }
        Utils.closeScanner();
    }

    /**
     * Méthode qui permet d'ouvrir le ficher test dont l'utilisateur aura choisi
     * @param nameFile le numéro correspondant au test dont l'utilisateur veut exécuter ou le nom du fichier.
     * @throws LexicalAnalyzerException lorsqu'une erreur survient lors de l'analyse lexicale, elle catégorise l'erreur selon son type
     * @throws SyntaxicAnalyzerException lorsqu'une erreur survient lors de l'analyse syntaxique, elle catégorise l'erreur selon son type
     */
    private static void openTestFile(String nameFile) throws LexicalAnalyzerException, SyntaxicAnalyzerException {
        List<String> allLinesFile = Utils.readFile(nameFile);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Lancement de l'analyse Lexicale
        startLexicalAnalyzer(allLinesFile, nameFile);
    }

    /**
     * pré-lancement du lexical analyzer
     *
     * @param inputList la liste qui contient tous les contenues récupérées depuis le fichier
     * @throws LexicalAnalyzerException lorsqu'une erreur survient lors de l'analyse lexicale, elle catégorise l'erreur selon son type
     * @throws SyntaxicAnalyzerException lorsqu'une erreur survient lors de l'analyse syntaxique, elle catégorise l'erreur selon son type
     */
    private static void startLexicalAnalyzer(List<String> inputList, String nameFile) throws LexicalAnalyzerException, SyntaxicAnalyzerException {
        if(isDigit(nameFile.charAt(0))){
            nameFile = "testFile" + nameFile;
        }

        if (inputList.isEmpty()) {
            System.out.println(YELLOW_BOLD_BRIGHT + "\tANALYSE LEXICALE " + RESET + " $> Désolé, Le fichier est vide !");
        } else {
            System.out.println("=================== FILE " + nameFile + ".txt =================");
            for (int i = 0; i < inputList.size(); i++){
                System.out.println((i+1) + GREEN_BOLD + ".\t" + inputList.get(i) + RESET);
            }
            System.out.println("==========================================================");

            // Début du traitement d'analyse lexicale
            LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(inputList);
            lexicalAnalyzer.start();

            SyntaxicAnalyzer syntaxicAnalyzer = new SyntaxicAnalyzer(lexicalAnalyzer);
            syntaxicAnalyzer.start();
        }
    }
}
