package automaticTendeuse.Process;
import java.util.ArrayList;
import java.util.List;

import automaticTendeuse.ExceptionTondeuse;
import automaticTendeuse.entites.Params;
import automaticTendeuse.entites.Params.InstructionTondeuse;
import automaticTendeuse.entites.Pelouse;
import automaticTendeuse.entites.TondeusePosition;

public class TreatmentTondeuse {

	private Pelouse pelouse;
	private TondeusePosition positionTondeuse;
	private List<Params.InstructionTondeuse> listeInstruction;
	
	public void setPelouse(Pelouse pelouse) {
		this.pelouse = pelouse;
	}
	
	public void setPositionTondeuse(TondeusePosition positionTondeuse) {
		this.positionTondeuse = positionTondeuse;
	}

	public void setListeInstruction(
			List<Params.InstructionTondeuse> pListeInstruction) {
		this.listeInstruction = pListeInstruction;
		if(pListeInstruction == null){
			listeInstruction = new ArrayList<InstructionTondeuse>();
		}
	}
	public void executerInstructions() throws ExceptionTondeuse{
		for(InstructionTondeuse instruction : listeInstruction){
			TreatmentInstruction.executerInstruction(positionTondeuse,
					instruction, this.pelouse.getPositionMax());
		}
	}

	public String toString(){
		return 	positionTondeuse.getTondeuseCoordinates().getX()
				+ " " 
				+ positionTondeuse.getTondeuseCoordinates().getY()
				+ " " 
				+ positionTondeuse.getTondeuseOrientation().getOrientationCode() ;
	}
}