package automaticTendeuseTest.entites;
import static org.fest.assertions.Assertions.assertThat;

import automaticTendeuse.entites.Coordinates;
import org.junit.Test;

public class CoordinatesTest {

	@Test
	public void verifier_surcharge_equals(){
		Coordinates c1 = new Coordinates(1, 2);
		Coordinates c2 = new Coordinates(1, 2);
		assertThat(c1.equals(c2)).isTrue();
		c2 = new Coordinates(1, 3);
		assertThat(c1.equals(c2)).isFalse();
	}
	
	@Test
	public void verifier_coordonnees_(){
		Coordinates coordinatesPelouse = new Coordinates(5,5);
		Coordinates c0 = new Coordinates(-1,1);
		Coordinates c1 = new Coordinates(1,1);
		assertThat(coordinatesPelouse.isHorsCoordinatesMax(c0)).isFalse();
		assertThat(coordinatesPelouse.isHorsCoordinatesMax(c1)).isTrue();
	}
}
