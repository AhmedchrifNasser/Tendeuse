package automaticTendeuse.parser;

import automaticTendeuse.entites.Params.InstructionTondeuse;
import automaticTendeuse.entites.Params.Orientation;


public class ParserData {

	private ParserData(){

	}
	//Vérifiez si les données entrées Tondeuse sont valides ou non.
	public static boolean parseTondeuse(String tondeuse){
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append(Orientation.NORTH.getOrientationCode())
			.append("|").append(Orientation.SOUTH.getOrientationCode())
			.append("|").append(Orientation.EAST.getOrientationCode())
			.append("|").append(Orientation.WEST.getOrientationCode());
		return tondeuse.matches("(\\d+) (\\d+) (" + stringBuilder.toString()+")");
	}
	//Vérifiez si les données d'entrée Instruction sont valides ou non.
	public static boolean parseListInstruction(String instructions){
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append("(").append(InstructionTondeuse.AVANCER.getInstructionCode())
		.append("|").append(InstructionTondeuse.DROITE.getInstructionCode())
		.append("|").append(InstructionTondeuse.GAUCHE.getInstructionCode())
		.append(")+");

		return instructions.matches(stringBuilder.toString());
	}
	//Vérifiez si les données d'entrée Pelouse sont valides ou non.
	public static boolean parsePelouse(String pelouse){
		return pelouse.matches("(\\d+) (\\d+)");
	}
}