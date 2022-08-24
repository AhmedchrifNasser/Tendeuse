package automaticTendeuse.Process;

import automaticTendeuse.ExceptionTondeuse;
import automaticTendeuse.entites.Coordinates;
import automaticTendeuse.entites.Params;
import automaticTendeuse.entites.Params.InstructionTondeuse;
import automaticTendeuse.entites.Params.Orientation;
import automaticTendeuse.entites.TondeusePosition;

public  class TreatmentInstruction {

	private TreatmentInstruction(){

	}
	public static Coordinates avancerTondeuse(TondeusePosition tondeusePosition, Coordinates coordinatesMax) throws ExceptionTondeuse{
		Coordinates nextCoordinates = null;
		int x, y;
		switch (tondeusePosition.getTondeuseOrientation()) {
		case NORTH:
			x = tondeusePosition.getTondeuseCoordinates().getX();
			y = tondeusePosition.getTondeuseCoordinates().getY() + 1;
			break;
		case EAST:
			x = tondeusePosition.getTondeuseCoordinates().getX() + 1;
			y = tondeusePosition.getTondeuseCoordinates().getY();
			break;
		case SOUTH:
			x = tondeusePosition.getTondeuseCoordinates().getX();
			y = tondeusePosition.getTondeuseCoordinates().getY() - 1;
			break;
		case WEST:
			x = tondeusePosition.getTondeuseCoordinates().getX() - 1;
			y = tondeusePosition.getTondeuseCoordinates().getY();
			break;
		default:
			throw new ExceptionTondeuse(Params.POSITION_INCORRECTE);
		}
		nextCoordinates = new Coordinates(x, y);
		// si les nouvelles coordonnées sont en dehors de la pelouse, on garde
		// la derniere position connue
		if (nextCoordinates != null
				&& coordinatesMax.isHorsCoordinatesMax(nextCoordinates)) {
			return nextCoordinates;
		} else {
			return tondeusePosition.getTondeuseCoordinates();
		}
	}
	public static Orientation pivoterDroite(Orientation orientation) throws ExceptionTondeuse{
		Orientation nextOrientation = null ;
		switch (orientation){
			case NORTH : 
				nextOrientation =  Orientation.EAST;
				break;
			case EAST : 
				nextOrientation =  Orientation.SOUTH;
				break;
			case SOUTH : 
				nextOrientation =  Orientation.WEST;
				break;
			case WEST : 
				nextOrientation =  Orientation.NORTH;
				break;
			default : 
				throw new ExceptionTondeuse(Params.ORIENTATION_INCORRECTE);
		}
		return nextOrientation;
	}
	public static Orientation pivoterGauche(Orientation orientation) throws ExceptionTondeuse{
		Orientation nextOrientation = null ;
		switch (orientation){
			case NORTH : 
				nextOrientation =  Orientation.WEST;
				break;
			case EAST : 
				nextOrientation =  Orientation.NORTH;
				break;
			case SOUTH : 
				nextOrientation =  Orientation.EAST;
				break;
			case WEST : 
				nextOrientation =  Orientation.SOUTH;
				break;
			default : 
				throw new ExceptionTondeuse(Params.ORIENTATION_INCORRECTE);
		}
		return nextOrientation;
	}
	public static void executerInstruction(TondeusePosition tondeusePostion, InstructionTondeuse instruction, Coordinates coordonnesMax) throws ExceptionTondeuse{
		
		switch (instruction){
			case AVANCER : 
				tondeusePostion.setTondeuseCoordinates(TreatmentInstruction.avancerTondeuse(tondeusePostion, coordonnesMax));
				break;
			case DROITE : 
				tondeusePostion.setTondeuseOrientation(TreatmentInstruction.pivoterDroite(tondeusePostion.getTondeuseOrientation()));
				break;
			case GAUCHE : 
				tondeusePostion.setTondeuseOrientation(TreatmentInstruction.pivoterGauche(tondeusePostion.getTondeuseOrientation()));
				break;
			default: throw new ExceptionTondeuse(Params.INSTRUCTION_INCORRECTE);
		}
	}
}