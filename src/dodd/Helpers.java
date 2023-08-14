package dodd;

import java.io.PrintWriter;

public class Helpers {
	
	public static void writeFile(String fileName, String contents) {
		try {
			PrintWriter out = new PrintWriter(fileName);
			out.print(contents);
			out.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
