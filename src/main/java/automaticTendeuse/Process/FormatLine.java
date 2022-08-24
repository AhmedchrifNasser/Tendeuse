package automaticTendeuse.Process;

import java.util.ArrayList;
import java.util.List;

import automaticTendeuse.entites.Coordinates;
import automaticTendeuse.entites.Params.InstructionTondeuse;
import automaticTendeuse.entites.Params.Orientation;
import automaticTendeuse.entites.Pelouse;
import automaticTendeuse.entites.TondeusePosition;

public class FormatLine {

	private static final String CHAINE_ESPACE = " ";

	private FormatLine(){

	}

	public static TondeusePosition formaterLigneTondeuse(String ligneTondeuse){
		String[] elts = ligneTondeuse.split(CHAINE_ESPACE);
		Coordinates pCoordonneesTondeuse = new Coordinates(Integer.valueOf(elts[0]), Integer.valueOf(elts[1]));
		Orientation orientationTondeuse = getOrientation(elts[2].charAt(0));
		return new TondeusePosition(pCoordonneesTondeuse, orientationTondeuse);
	}

	public static Pelouse formaterLignePelouse(String lignePelouse){
		String[] elts = lignePelouse.split(CHAINE_ESPACE);
		return new Pelouse(new Coordinates(Integer.valueOf(elts[0]), Integer.valueOf(elts[1])));
	}
	public static List<InstructionTondeuse> formaterLigneInstruction(String ligneInstruction){
		List<InstructionTondeuse> listInstruction = new ArrayList<InstructionTondeuse>();
		for(char instruction :ligneInstruction.toCharArray()){
			listInstruction.add(getInstruction(instruction));
		}
		return listInstruction;
	}
	public static Orientation getOrientation(char cOrientation){
		for(Orientation orientation : Orientation.values()) {
			if (orientation.getOrientationCode() == cOrientation){
				return orientation;
			}
		}
		return null;
	}
	public static InstructionTondeuse getInstruction(char cInstruction){
		for(InstructionTondeuse instruction : InstructionTondeuse.values()) {
			if (instruction.getInstructionCode() == cInstruction) {
				return instruction;
			}
		}
		return null;
	}
}