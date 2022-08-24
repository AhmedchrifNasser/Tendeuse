package automaticTendeuse;

import java.io.*;
import java.util.List;

import automaticTendeuse.Process.Processor;

public class Principal {

	public static List<String> listResultats;

	public static void main(String... args) throws ExceptionTondeuse, IOException {
		if (args.length == 1) {
			File file = new File(args[0]);
			Processor instance = new Processor();
			listResultats = instance.lancerTraitementsTondeuses(file);
		} else {
			throw new IllegalArgumentException();
		}
	}

}