package automaticTendeuse.entites;


public class Params {
	
	private Params(){
		
	}
	public static enum Orientation {
		NORTH('N', "Nord"),
		EAST('E', "est"),
		WEST('W', "ouest"),
		SOUTH('S', "sud");
		
		private char orientationCode;
		private String orientationLabel;
		
		private Orientation(char pOrientationCode, String pOrientationLabel){
			this.orientationCode = pOrientationCode;
			this.orientationLabel = pOrientationLabel;
		}
		public char getOrientationCode() {
			return orientationCode;
		}
		public String getOrientationLabel() {
			return orientationLabel;
		}
	}

	public static enum InstructionTondeuse{
		DROITE('D', "Pivoter à droite"),
		GAUCHE('G', "Pivoter à gauche"),
		AVANCER('A', "Avancer");
		
		private String instructionLabel;
		private char instructionCode;
		
		private InstructionTondeuse(char pCodeInstruction, String instructionLabel) {
			this.instructionLabel = instructionLabel;
			this.instructionCode = pCodeInstruction;
		}
		
		public String getInstructionLabel() {
			return instructionLabel;
		}
		public char getInstructionCode() {
			return instructionCode;
		}

	}


	public static final String ERREUR_DONNEES_INCORRECTES= "données incorrectes";
	public static final String ERREUR_FICHIER_INEXISTANT= "fichier inexistant";
	public static final String ORIENTATION_INCORRECTE = "orientation incorrecte";
	public static final String INSTRUCTION_INCORRECTE = "instruction incorrecte";
	public static final String POSITION_INCORRECTE = "position incorrecte";
}