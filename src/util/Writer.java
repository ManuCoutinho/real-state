package util;

import java.io.*;

public class Writer {
	public static void save(String fileName) {

		try {
			FileWriter in = new FileWriter(fileName);
			in.close();
			System.out.println("------ operation saved successfully ------");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveObject(String fileName, Object obj) {

		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream inputStream = new ObjectOutputStream(fos);
			inputStream.writeObject(obj);
			inputStream.flush();
			inputStream.close();
			fos.close();
			System.out.println("------ operation saved successfully ------");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
