package ev222hh_lab4;

import java.io.File;
import java.io.FileNotFoundException;

public class FileHandler {
	public File files(int number) throws FileNotFoundException {
		File file = null;
		
		switch (number) {
		case 1:
			file = new File("heltal.txt");
			return file;
		
		case 2:
			file = new File("heltalTva.txt");
			return file;
			
		case 3:
			file = new File("heltalTre.txt");
			return file;
			
		default:
			System.out.println("Vänligen välj en av följande filer med heltal i HistogramMain:\n"
					+ "[ 1 ] Version 1\n"
					+ "[ 2 ] Version 2\n"
					+ "[ 3 ] Version 3\n");
		}
		
		return null;
	}
}