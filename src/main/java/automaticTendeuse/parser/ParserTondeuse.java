package automaticTendeuse.parser;

public class ParserTondeuse {

	private String pelouse ;
	private String tondeuse ;
	private String instructions ;

	public ParserTondeuse(){
		this.pelouse = "";
		this.tondeuse = "";
		this.instructions = "";
	}
	//Mapper les données entrées récupérer par processor vers ParserData pour les verifier.
	public boolean executeParse(){
		return ParserData.parseTondeuse(tondeuse)
				&& ParserData.parsePelouse(pelouse)
				&& ParserData.parseListInstruction(instructions);
	}
	
	public String getPelouse() {
		return pelouse;
	}

	public void setPelouse(String pelouse) {
		this.pelouse = pelouse;
	}

	public String getTondeuse() {
		return tondeuse;
	}

	public void setTondeuse(String tondeuse) {
		this.tondeuse = tondeuse;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
}