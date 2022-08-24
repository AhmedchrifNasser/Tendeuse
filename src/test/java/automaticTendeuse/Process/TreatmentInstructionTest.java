package automaticTendeuse.Process;

import static org.fest.assertions.Assertions.assertThat;
import automaticTendeuse.ExceptionTondeuse;
import automaticTendeuse.entites.Coordinates;
import automaticTendeuse.entites.Params.InstructionTondeuse;
import automaticTendeuse.entites.Params.Orientation;
import automaticTendeuse.entites.TondeusePosition;

import org.junit.Test;


public class TreatmentInstructionTest {

	@Test
	public void coordonnees_x_y_south_instruction_Tourner_Droite() throws ExceptionTondeuse {
		Coordinates coordonnesMax = new Coordinates(5, 5);
		int x = 2;
		int y = 3;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition positionTondeuse = new TondeusePosition(coordonnees,Orientation.SOUTH);
		TreatmentInstruction.executerInstruction(positionTondeuse, InstructionTondeuse.DROITE, coordonnesMax);
		assertThat(positionTondeuse.getTondeuseCoordinates()).isEqualTo(new Coordinates(x, y));
		assertThat(positionTondeuse.getTondeuseOrientation()).isEqualTo(Orientation.WEST);
	}
	
	
	@Test
	public void pivoter_a_droite() throws ExceptionTondeuse{
		
		Orientation orientationSuivante = TreatmentInstruction.pivoterDroite(Orientation.EAST);
		assertThat(orientationSuivante).isEqualTo(Orientation.SOUTH);
		
		orientationSuivante = TreatmentInstruction.pivoterDroite(Orientation.WEST);
		assertThat(orientationSuivante).isEqualTo(Orientation.NORTH);
		
		orientationSuivante = TreatmentInstruction.pivoterDroite(Orientation.NORTH);
		assertThat(orientationSuivante).isEqualTo(Orientation.EAST);
		
		orientationSuivante = TreatmentInstruction.pivoterDroite(Orientation.SOUTH);
		assertThat(orientationSuivante).isEqualTo(Orientation.WEST);
	}
	
	@Test
	public void pivoter_a_gauche() throws ExceptionTondeuse{
		Orientation orientationSuivante = TreatmentInstruction.pivoterGauche(Orientation.EAST);
		assertThat(orientationSuivante).isEqualTo(Orientation.NORTH);
		
		orientationSuivante = TreatmentInstruction.pivoterGauche(Orientation.WEST);
		assertThat(orientationSuivante).isEqualTo(Orientation.SOUTH);
		
		orientationSuivante = TreatmentInstruction.pivoterGauche(Orientation.NORTH);
		assertThat(orientationSuivante).isEqualTo(Orientation.WEST);
		
		orientationSuivante = TreatmentInstruction.pivoterGauche(Orientation.SOUTH);
		assertThat(orientationSuivante).isEqualTo(Orientation.EAST);
	}

}
