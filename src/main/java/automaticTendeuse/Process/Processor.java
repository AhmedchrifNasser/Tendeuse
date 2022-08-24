package automaticTendeuse.Process;

import automaticTendeuse.ExceptionTondeuse;
import automaticTendeuse.entites.Params;
import automaticTendeuse.parser.ParserTondeuse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Processor {

    public List<String> lancerTraitementsTondeuses(File fichier)
            throws ExceptionTondeuse, IOException {
        if (!fichier.isFile()) {
            throw new ExceptionTondeuse(Params.ERREUR_FICHIER_INEXISTANT);
        } else {
            ParserTondeuse parser = new ParserTondeuse();
            Scanner scanner = new Scanner(fichier);
            System.out.println(scanner);
            if (!scanner.hasNext()) {
                throw new ExceptionTondeuse(
                        Params.ERREUR_DONNEES_INCORRECTES);
            }
            //La premiére ligne de la commande présente la taille de la Pelouse
            String input = scanner.nextLine();
            String firstLine = "";
            int endFirstLine = ordinalIndexOf(input, " ", 2);
            if (endFirstLine == -1) {
                throw new ExceptionTondeuse(
                        Params.ERREUR_DONNEES_INCORRECTES);
            } else {
                firstLine = input.substring(0,endFirstLine);
                input = input.substring(endFirstLine+1,input.length());
            }
            // Arraylist contient les lignes de la position de la Tendeuse
            // et les lignes de les instructions.
            ArrayList<String> linePostionInstruction = new ArrayList<String>();
            while (input.contains(" ") & input!=null) {
                String secondLine ="";
                String thirdLine = "";
                //La deuxième ligne de la commande présente la position de la Tendeuse
                int endSecondLine = ordinalIndexOf(input, " ", 3);
                if (endSecondLine == -1) {
                    throw new ExceptionTondeuse(
                            Params.ERREUR_DONNEES_INCORRECTES);
                } else {
                    secondLine = input.substring(0,endSecondLine);
                    input = input.substring(endSecondLine+1,input.length());
                    linePostionInstruction.add(secondLine);
                }
                //La troisième ligne de la commande présente l'instruction
                if (input.contains(" ")) {
                    int endThirdLine = ordinalIndexOf(input, " ", 1);
                    thirdLine = input.substring(0,endThirdLine);
                    input = input.substring(endThirdLine+1,input.length());
                    linePostionInstruction.add(thirdLine);
                } else if (input!= null){
                    thirdLine = input;
                    linePostionInstruction.add(thirdLine);
                } else {
                    throw new ExceptionTondeuse(
                            Params.ERREUR_DONNEES_INCORRECTES);
                }
            }
            try {
                traiterPremiereLigne(parser, firstLine);
                return traiterLignesSuivantes(parser, linePostionInstruction);
            } finally {
                if (scanner != null) {
                    scanner.close();
                }
            }
        }
    }
    private void traiterPremiereLigne(ParserTondeuse parser, String firstLine) throws ExceptionTondeuse {
        parser.setPelouse(firstLine);
    }
    private List<String> traiterLignesSuivantes(ParserTondeuse parser, ArrayList<String> linePostionInstruction) throws ExceptionTondeuse {
        List<String> listePositions = new ArrayList<String>();
        for ( String line:linePostionInstruction){
            if (linePostionInstruction.indexOf(line)%2 ==0) {
                parser.setTondeuse(line);
            }else {
                parser.setInstructions(line);
                listePositions.add(parserEtLancerTraitement(parser));
            }
        }
        return listePositions;
    }
    private String parserEtLancerTraitement(ParserTondeuse parser)
            throws ExceptionTondeuse {
        if (!parser.executeParse()) {
            throw new ExceptionTondeuse(Params.ERREUR_DONNEES_INCORRECTES);
        } else {
            TreatmentTondeuse traitement = new TreatmentTondeuse();
            traitement.setPelouse(FormatLine
                    .formaterLignePelouse(parser.getPelouse()));
            traitement.setPositionTondeuse(FormatLine
                    .formaterLigneTondeuse(parser.getTondeuse()));
            traitement.setListeInstruction(FormatLine
                    .formaterLigneInstruction(parser.getInstructions()));
            traitement.executerInstructions();
            System.out.println(traitement);
            return traitement.toString();
        }
    }
    private static int ordinalIndexOf(String str, String substr, int n) {
        int pos = str.indexOf(substr);
        while (--n > 0 && pos != -1)
            pos = str.indexOf(substr, pos + 1);
        return pos;
    }
}
