package serialiserbare;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Person;

public class Serial {
	private String Path;

	public void setPath(String path) {
		Path = path;
	}

	public Serial(String path) {
		Path = path;
	}

	public void savePeople() {
		try {
			FileOutputStream outStream = new FileOutputStream(Path);

			ObjectOutputStream objOutStream = new ObjectOutputStream(outStream);

			for (Person p : Person.getPersons()) {
				objOutStream.writeObject(p);
			}

			objOutStream.close();
			outStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadPeople() {
		try {
			FileInputStream inStream = new FileInputStream(Path);

			ObjectInputStream objInStream = new ObjectInputStream(inStream);

			Object o = null;

			while ((o = objInStream.readObject()) != null) {
				if (o instanceof Person) {
					Person.getPersons().add((Person) o);
				}
			}

			objInStream.close();
			inStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
