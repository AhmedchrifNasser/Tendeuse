package automaticTendeuseTest.entites;

import static org.fest.assertions.Assertions.assertThat;

import automaticTendeuse.entites.Coordinates;
import automaticTendeuse.entites.Pelouse;
import org.junit.Test;

public class PelouseTest {

	@Test
	public void verifier_surcharge_equals() {
		Pelouse p1 = new Pelouse(new Coordinates(1, 2));
		Pelouse p2 = new Pelouse(new Coordinates(1, 2));
		assertThat(p1.equals(p2)).isTrue();
		p2 = new Pelouse(new Coordinates(1, 3));
		assertThat(p1.equals(p2)).isFalse();
	}
}
