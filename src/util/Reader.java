package util;

import java.io.*;

public class Reader {
	public static void getFile(String fileName) {

		try {
			FileReader out = new FileReader(fileName);
			out.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Object getObject(String fileName) {
		Object obj = null;
		try {
			ObjectInputStream outputStream = new ObjectInputStream(new FileInputStream(fileName));
			obj =  outputStream.readObject();
			if (obj != null) {
				outputStream.close();
				return obj;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("--- END ----");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
