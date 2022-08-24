package automaticTendeuseTest.parser;
import static org.fest.assertions.Assertions.assertThat;

import automaticTendeuse.parser.ParserData;
import org.junit.Test;

public class ParserDataTest {
	
	@Test
	public void parse_tondeuse(){
		assertThat(ParserData.parseTondeuse("")).isFalse();
		assertThat(ParserData.parseTondeuse("1 2 3")).isFalse();
		assertThat(ParserData.parseTondeuse("12N")).isFalse();
		assertThat(ParserData.parseTondeuse("1 2 N")).isTrue();
		assertThat(ParserData.parseTondeuse("1 2 S")).isTrue();
	}
	
	@Test
	public void parse_liste_instruction(){
		assertThat(ParserData.parseListInstruction("")).isFalse();
		assertThat(ParserData.parseListInstruction(" ")).isFalse();
		assertThat(ParserData.parseListInstruction("D G")).isFalse();
		assertThat(ParserData.parseListInstruction("GGAAAGADDAN")).isFalse();
		assertThat(ParserData.parseListInstruction("GGAAAG ADDAN")).isFalse();
		assertThat(ParserData.parseListInstruction("DGA")).isTrue();
		assertThat(ParserData.parseListInstruction("GGAAAGADDA")).isTrue();
	}
	
	@Test
	public void parse_pelouse(){
		assertThat(ParserData.parsePelouse("")).isFalse();
		assertThat(ParserData.parsePelouse("1 2 3")).isFalse();
		assertThat(ParserData.parsePelouse("123")).isFalse();
		assertThat(ParserData.parsePelouse("1 2 ")).isFalse();
		assertThat(ParserData.parsePelouse("1 2")).isTrue();
		assertThat(ParserData.parsePelouse("1 N")).isFalse();
	}

}
