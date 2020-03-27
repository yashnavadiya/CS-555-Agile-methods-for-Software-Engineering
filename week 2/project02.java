// Name: Yash Navadiya
// CWID : 10455328
// CS555-A
// project 02

package agile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class project02 {
	public static void main(String[] args) throws FileNotFoundException {
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("NOTE", 0);
		hmap.put("TRLR", 0);
		hmap.put("HEAD", 0);
		hmap.put("FAMC", 1);
		hmap.put("FAMS", 1);
		hmap.put("HUSB", 1);
		hmap.put("WIFE", 1);
		hmap.put("CHIL", 1);
		hmap.put("BIRT", 1);
		hmap.put("DATE", 2);
		hmap.put("DEAT", 1);
		hmap.put("SEX", 1);
		hmap.put("NAME", 1);
		hmap.put("MARR", 1);
		hmap.put("DIV", 1);
		hmap.put("INDI", 2);
		hmap.put("FAM", 2);

		Scanner scanner = new Scanner(new File("C:\\Users\\12016\\Downloads\\proj02test.ged"));
		while (scanner.hasNextLine()) {
			String argument = "";
			String line = scanner.nextLine();
			String[] tokens = line.split(" ");

			for (int i = 2; i < tokens.length; i++) {
				argument = argument + " " + tokens[i];
			}
			System.out.println(" --> " + line);

			int flag = 0;
			if (tokens.length > 2) {
				if ((tokens[2].equals("INDI") || tokens[2].equals("FAM")) && Integer.parseInt(tokens[0]) == 0) {
					flag = 1;
				}
			}
			for (Entry<String, Integer> entry : hmap.entrySet()) {
				if (entry.getKey().equals(tokens[1].trim()) && entry.getValue() == Integer.parseInt(tokens[0])) {
					flag = 1;
					break;
				}
			}

			if (flag == 1) {
				System.out.println(" <-- " + tokens[0] + " | " + tokens[1] + " | Y | " + argument);
			} else {
				System.out.println(" <-- " + tokens[0] + " | " + tokens[1] + " | N | " + argument);
			}
		}
		scanner.close();
	}
}
