package automaticTendeuseTest.entites;

import static org.fest.assertions.Assertions.assertThat;

import automaticTendeuse.entites.Coordinates;
import automaticTendeuse.entites.Params.Orientation;

import automaticTendeuse.entites.TondeusePosition;
import org.junit.Test;

public class TondeusePositionTest {

	@Test
	public void verifier_surcharge_equals() {
		
		TondeusePosition positionT = new TondeusePosition(new Coordinates(5, 5), Orientation.NORTH);
		TondeusePosition positionTOk = new TondeusePosition(new Coordinates(5, 5), Orientation.NORTH);
		TondeusePosition positionTKo = new TondeusePosition(new Coordinates(5, 5), Orientation.SOUTH);
		
		assertThat(positionT.equals(positionTOk)).isTrue();
		assertThat(positionT.equals(positionTKo)).isFalse();
	}

}
