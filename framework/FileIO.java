package framework;

import java.io.FileWriter;
import java.io.IOException;

import error.Popup;

public class FileIO {

	public static void writeToFile(String path,String data) {
		try {
			FileWriter fw = new FileWriter(path);
			fw.write(data);
		} catch (IOException e) {
			Popup.showError("Cannot write the file");
		}

	}
}
