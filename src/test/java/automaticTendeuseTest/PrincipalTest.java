package automaticTendeuseTest;

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;

import automaticTendeuse.ExceptionTondeuse;
import automaticTendeuse.Principal;
import automaticTendeuse.entites.Params;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PrincipalTest {
	final String CHEMIN_FICHIER = "./src/test/resources/"; 

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test(expected = IllegalArgumentException.class)
	public void main_fichier_erreur_args() throws ExceptionTondeuse, IOException {
		Principal.main("1", "2");
	}
	
	@Test
	public void main_fichier_erreur_fichier_inexistant() throws ExceptionTondeuse, IOException {
		expectedEx.expect(ExceptionTondeuse.class);
		expectedEx.expectMessage(Params.ERREUR_FICHIER_INEXISTANT);
		Principal.main("fichierinexistant");
	}
	
	@Test
	public void main_fichier_erreur_1_ligne() throws ExceptionTondeuse, IOException {
		expectedEx.expect(ExceptionTondeuse.class);
		expectedEx.expectMessage(Params.ERREUR_DONNEES_INCORRECTES);
		Principal.main(CHEMIN_FICHIER + "fichier_ligne_1.txt");
	}
	
	@Test
	public void main_fichier_erreur_2_lignes() throws ExceptionTondeuse, IOException {
		expectedEx.expect(ExceptionTondeuse.class);
		expectedEx.expectMessage(Params.ERREUR_DONNEES_INCORRECTES);
		Principal.main(CHEMIN_FICHIER + "fichier_ligne_2.txt");
	}
	@Test
	public void main_fichier_erreur_ligne_manquante() throws ExceptionTondeuse, IOException {
		expectedEx.expect(ExceptionTondeuse.class);
		expectedEx.expectMessage(Params.ERREUR_DONNEES_INCORRECTES);
		Principal.main(CHEMIN_FICHIER + "fichier_ligne_manquante.txt");

	}
	@Test
	public void main_fichier_erreur_fichier_vide() throws ExceptionTondeuse, IOException {
		expectedEx.expect(ExceptionTondeuse.class);
		expectedEx.expectMessage(Params.ERREUR_DONNEES_INCORRECTES);
		Principal.main(CHEMIN_FICHIER + "fichier_vide.txt");

	}
	
	@Test
	public void main_fichier_erreur_fichier_ko() throws ExceptionTondeuse, IOException {
		expectedEx.expect(ExceptionTondeuse.class);
		expectedEx.expectMessage(Params.ERREUR_DONNEES_INCORRECTES);
		Principal.main(CHEMIN_FICHIER + "fichier_ko.txt");
	}
	
	@Test
	public void main_fichier_erreur_fichier_correct() throws ExceptionTondeuse, IOException {
		Principal.main(CHEMIN_FICHIER + "fichier_correct.txt");
		assertThat(Principal.listResultats).isNotNull();
		assertThat(Principal.listResultats).hasSize(2).contains("1 3 N").contains("5 1 E");
		
	}
}