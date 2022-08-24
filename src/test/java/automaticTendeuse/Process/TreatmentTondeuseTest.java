package automaticTendeuse.Process;

import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import automaticTendeuse.ExceptionTondeuse;
import automaticTendeuse.entites.Coordinates;
import automaticTendeuse.entites.Params;
import automaticTendeuse.entites.Params.InstructionTondeuse;
import automaticTendeuse.entites.Params.Orientation;
import automaticTendeuse.entites.Pelouse;
import automaticTendeuse.entites.TondeusePosition;

import org.junit.Test;


public class TreatmentTondeuseTest {
	Coordinates coordonnesMax = new Coordinates(5, 5);
	
	@Test
	public void executer_instruction_aucune_instruction() throws ExceptionTondeuse{
		int x = 0;
		int y = 0;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition positionTondeuse = new TondeusePosition(coordonnees, Orientation.NORTH);
		
		TreatmentTondeuse traitemetT = new TreatmentTondeuse();
		traitemetT.setPelouse(new Pelouse(coordonnesMax));
		traitemetT.setPositionTondeuse(positionTondeuse);
		traitemetT.setListeInstruction(new ArrayList<Params.InstructionTondeuse>());
		traitemetT.executerInstructions();
		assertThat(traitemetT.toString()).isEqualTo("0 0 N");
	}
	
	@Test
	public void executer_instruction_unitaire() throws ExceptionTondeuse{
		List<InstructionTondeuse> listInstruction = new ArrayList<Params.InstructionTondeuse>();
		listInstruction.add(InstructionTondeuse.AVANCER);
		int x = 1;
		int y = 1;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition positionTondeuse = new TondeusePosition(coordonnees, Orientation.NORTH);
		TreatmentTondeuse traitemetT = new TreatmentTondeuse();
		traitemetT.setPelouse(new Pelouse(coordonnesMax));
		traitemetT.setPositionTondeuse(positionTondeuse);
		traitemetT.setListeInstruction(listInstruction);
		traitemetT.executerInstructions();
		assertThat(traitemetT.toString()).isEqualTo("1 2 N");
	}
	
	@Test
	public void executer_instruction_plusieurs() throws ExceptionTondeuse{
		List<InstructionTondeuse> listInstruction = new ArrayList<Params.InstructionTondeuse>();
		listInstruction.add(InstructionTondeuse.GAUCHE);
		listInstruction.add(InstructionTondeuse.AVANCER);
		listInstruction.add(InstructionTondeuse.GAUCHE);
		listInstruction.add(InstructionTondeuse.AVANCER);
		int x = 3;
		int y = 2;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition positionTondeuse = new TondeusePosition(coordonnees, Orientation.NORTH);
		TreatmentTondeuse traitemetT = new TreatmentTondeuse();
		traitemetT.setPelouse(new Pelouse(coordonnesMax));
		traitemetT.setPositionTondeuse(positionTondeuse);
		traitemetT.setListeInstruction(listInstruction);
		traitemetT.executerInstructions();
		assertThat(traitemetT.toString()).isEqualTo("2 1 S");
	}
	
	@Test
	public void executer_instruction_cas_reel_1() throws ExceptionTondeuse{
		List<InstructionTondeuse> listInstruction = new ArrayList<Params.InstructionTondeuse>();
		listInstruction.add(InstructionTondeuse.GAUCHE);
		listInstruction.add(InstructionTondeuse.AVANCER);
		listInstruction.add(InstructionTondeuse.GAUCHE);
		listInstruction.add(InstructionTondeuse.AVANCER);
		listInstruction.add(InstructionTondeuse.GAUCHE);
		listInstruction.add(InstructionTondeuse.AVANCER);
		listInstruction.add(InstructionTondeuse.GAUCHE);
		listInstruction.add(InstructionTondeuse.AVANCER);
		listInstruction.add(InstructionTondeuse.AVANCER);
		int x = 1;
		int y = 2;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition positionTondeuse = new TondeusePosition(coordonnees, Orientation.NORTH);
		TreatmentTondeuse traitemetT = new TreatmentTondeuse();
		traitemetT.setPelouse(new Pelouse(coordonnesMax));
		traitemetT.setPositionTondeuse(positionTondeuse);
		traitemetT.setListeInstruction(listInstruction);
		traitemetT.executerInstructions();
		assertThat(traitemetT.toString()).isEqualTo("1 3 N");
	}
	@Test
	public void executer_instruction_cas_reel_2() throws ExceptionTondeuse{
		List<InstructionTondeuse> listInstruction = new ArrayList<Params.InstructionTondeuse>();
		listInstruction.add(InstructionTondeuse.AVANCER);
		listInstruction.add(InstructionTondeuse.AVANCER);
		listInstruction.add(InstructionTondeuse.DROITE);
		listInstruction.add(InstructionTondeuse.AVANCER);
		listInstruction.add(InstructionTondeuse.AVANCER);
		listInstruction.add(InstructionTondeuse.DROITE);
		listInstruction.add(InstructionTondeuse.AVANCER);
		listInstruction.add(InstructionTondeuse.DROITE);
		listInstruction.add(InstructionTondeuse.DROITE);
		listInstruction.add(InstructionTondeuse.AVANCER);
		int x = 3;
		int y = 3;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition positionTondeuse = new TondeusePosition(coordonnees, Orientation.EAST);
		TreatmentTondeuse traitemetT = new TreatmentTondeuse();
		traitemetT.setPelouse(new Pelouse(coordonnesMax));
		traitemetT.setPositionTondeuse(positionTondeuse);
		traitemetT.setListeInstruction(listInstruction);
		traitemetT.executerInstructions();
		assertThat(traitemetT.toString()).isEqualTo("5 1 E");
	}
	
	
	@Test
	public void coordonnees_x_y_north_instruction_avancer() throws ExceptionTondeuse {
		int x = 0;
		int y = 0;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition positionTondeuse = new TondeusePosition(coordonnees,Orientation.NORTH);
		TreatmentInstruction.executerInstruction(positionTondeuse, Params.InstructionTondeuse.AVANCER, coordonnesMax);
		assertThat(positionTondeuse.getTondeuseCoordinates()).isEqualTo(new Coordinates(x, y+1));
		assertThat(positionTondeuse.getTondeuseOrientation()).isEqualTo(Orientation.NORTH);
	}
	
	@Test
	public void coordonnees_x_y_East_instruction_avancer() throws ExceptionTondeuse {
		int x = 0;
		int y = 0;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition positionTondeuse = new TondeusePosition(coordonnees,Orientation.EAST);
		TreatmentInstruction.executerInstruction(positionTondeuse, Params.InstructionTondeuse.AVANCER, coordonnesMax);
		assertThat(positionTondeuse.getTondeuseCoordinates()).isEqualTo(new Coordinates(x+1, y));
		assertThat(positionTondeuse.getTondeuseOrientation()).isEqualTo(Orientation.EAST);
	}
	
	@Test
	public void coordonnees_x_y_South_instruction_avancer() throws ExceptionTondeuse {
		int x = 5;
		int y = 5;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition positionTondeuse = new TondeusePosition(coordonnees,Orientation.SOUTH);
		TreatmentInstruction.executerInstruction(positionTondeuse, Params.InstructionTondeuse.AVANCER, coordonnesMax);
		assertThat(positionTondeuse.getTondeuseCoordinates()).isEqualTo(new Coordinates(x, y-1));
		assertThat(positionTondeuse.getTondeuseOrientation()).isEqualTo(Orientation.SOUTH);
	}
	
	@Test
	public void coordonnees_x_y_West_instruction_avancer() throws ExceptionTondeuse {
		int x = 5;
		int y = 5;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition positionTondeuse = new TondeusePosition(coordonnees,Orientation.WEST);
		TreatmentInstruction.executerInstruction(positionTondeuse, Params.InstructionTondeuse.AVANCER, coordonnesMax);
		assertThat(positionTondeuse.getTondeuseCoordinates()).isEqualTo(new Coordinates(x-1, y));
		assertThat(positionTondeuse.getTondeuseOrientation()).isEqualTo(Orientation.WEST);
	}
	@Test
	public void coordonnees_x_y_West_instruction_Tourner_gauche() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition positionTondeuse = new TondeusePosition(coordonnees,Orientation.WEST);
		TreatmentInstruction.executerInstruction(positionTondeuse, Params.InstructionTondeuse.GAUCHE, coordonnesMax);
		assertThat(positionTondeuse.getTondeuseCoordinates()).isEqualTo(new Coordinates(x, y));
		assertThat(positionTondeuse.getTondeuseOrientation()).isEqualTo(Orientation.SOUTH);
	}
	
	@Test
	public void coordonnees_x_y_east_instruction_Tourner_gauche() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition positionTondeuse = new TondeusePosition(coordonnees,Orientation.EAST);
		TreatmentInstruction.executerInstruction(positionTondeuse, Params.InstructionTondeuse.GAUCHE, coordonnesMax);
		assertThat(positionTondeuse.getTondeuseCoordinates()).isEqualTo(new Coordinates(x, y));
		assertThat(positionTondeuse.getTondeuseOrientation()).isEqualTo(Orientation.NORTH);
	}

	@Test
	public void coordonnees_x_y_west_instruction_Tourner_gauche() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition positionTondeuse = new TondeusePosition(coordonnees,Orientation.WEST);
		TreatmentInstruction.executerInstruction(positionTondeuse, Params.InstructionTondeuse.GAUCHE, coordonnesMax);
		assertThat(positionTondeuse.getTondeuseCoordinates()).isEqualTo(new Coordinates(x, y));
		assertThat(positionTondeuse.getTondeuseOrientation()).isEqualTo(Orientation.SOUTH);
	}
	@Test
	public void coordonnees_x_y_south_instruction_Tourner_gauche() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition positionTondeuse = new TondeusePosition(coordonnees,Orientation.SOUTH);
		TreatmentInstruction.executerInstruction(positionTondeuse, Params.InstructionTondeuse.GAUCHE, coordonnesMax);
		assertThat(positionTondeuse.getTondeuseCoordinates()).isEqualTo(new Coordinates(x, y));
		assertThat(positionTondeuse.getTondeuseOrientation()).isEqualTo(Orientation.EAST);
	}
	
	@Test
	public void coordonnees_x_y_north_instruction_Tourner_Droite() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition positionTondeuse = new TondeusePosition(coordonnees,Orientation.NORTH);
		TreatmentInstruction.executerInstruction(positionTondeuse, InstructionTondeuse.DROITE, coordonnesMax);
		assertThat(positionTondeuse.getTondeuseCoordinates()).isEqualTo(new Coordinates(x, y));
		assertThat(positionTondeuse.getTondeuseOrientation()).isEqualTo(Orientation.EAST);
	}
	
	@Test
	public void coordonnees_x_y_east_instruction_Tourner_Droite() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition positionTondeuse = new TondeusePosition(coordonnees,Orientation.EAST);
		TreatmentInstruction.executerInstruction(positionTondeuse, InstructionTondeuse.DROITE, coordonnesMax);
		assertThat(positionTondeuse.getTondeuseCoordinates()).isEqualTo(new Coordinates(x, y));
		assertThat(positionTondeuse.getTondeuseOrientation()).isEqualTo(Orientation.SOUTH);
	}

	@Test
	public void coordonnees_x_y_west_instruction_Tourner_Droite() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordinates coordonnees = new Coordinates(x, y);
		TondeusePosition positionTondeuse = new TondeusePosition(coordonnees,Orientation.WEST);
		TreatmentInstruction.executerInstruction(positionTondeuse, InstructionTondeuse.DROITE, coordonnesMax);
		assertThat(positionTondeuse.getTondeuseCoordinates()).isEqualTo(new Coordinates(x, y));
		assertThat(positionTondeuse.getTondeuseOrientation()).isEqualTo(Orientation.NORTH);
	}

}