package automaticTendeuse.Process;
import static org.fest.assertions.Assertions.assertThat;
import automaticTendeuse.entites.Coordinates;
import automaticTendeuse.entites.Params.InstructionTondeuse;
import automaticTendeuse.entites.Params.Orientation;
import automaticTendeuse.entites.Pelouse;

import org.junit.Test;
public class FormatLineTest {

	@Test
	public void formater_ligne_tondeuse() {
		assertThat(FormatLine.formaterLigneTondeuse("10 15 N").getTondeuseCoordinates()).isEqualTo(new Coordinates(10, 15));
		assertThat(FormatLine.formaterLigneTondeuse("10 15 N").getTondeuseOrientation()).isEqualTo(Orientation.NORTH);
	}

	@Test
	public void formater_ligne_pelouse() {
		assertThat(FormatLine.formaterLignePelouse("10 15")).isEqualTo(new Pelouse(new Coordinates(10, 15)));
	}

	@Test
	public void formater_ligne_instruction() {
		assertThat(FormatLine.formaterLigneInstruction("DGAD")).hasSize(4)
				.contains(InstructionTondeuse.DROITE)
				.contains(InstructionTondeuse.GAUCHE)
				.contains(InstructionTondeuse.AVANCER);
	}

	@Test
	public void recuperer_orientation() {
		assertThat(FormatLine.getOrientation('E')).isEqualTo(Orientation.EAST);
		assertThat(FormatLine.getOrientation('N')).isEqualTo(Orientation.NORTH);
		assertThat(FormatLine.getOrientation('S')).isEqualTo(Orientation.SOUTH);
		assertThat(FormatLine.getOrientation('W')).isEqualTo(Orientation.WEST);
		assertThat(FormatLine.getOrientation('a')).isNull();
	}

	@Test
	public void testGetInstruction() {
		assertThat(FormatLine.getInstruction('A')).isEqualTo(InstructionTondeuse.AVANCER);
		assertThat(FormatLine.getInstruction('D')).isEqualTo(InstructionTondeuse.DROITE);
		assertThat(FormatLine.getInstruction('G')).isEqualTo(InstructionTondeuse.GAUCHE);
		assertThat(FormatLine.getInstruction(' ')).isNull();
	}

}
