package csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.Person;

public class CSV {
	private String path;

	public CSV(String path_) {
		path = path_;
	}

	public void savePeople() {
		try {
			FileWriter fWriter = new FileWriter(path);

			BufferedWriter bWriter = new BufferedWriter(fWriter);

			for (Person p : Person.getPersons()) {
				bWriter.write(p.getfNavn() + "¤" + p.geteNavn() + "¤" + p.getAlder() + "\n");
			}

			bWriter.close();
			fWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadPeople() {

		try {
			FileReader fReader = new FileReader(path);

			BufferedReader bReader = new BufferedReader(fReader);

			String line;

			while ((line = bReader.readLine()) != null) {
				String[] split = line.split("¤");
				new Person(split[0], split[1], Integer.valueOf(split[2]));
			}

			bReader.close();
			fReader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
