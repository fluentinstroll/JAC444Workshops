package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.UnaryOperator;

public class BabyRanking {
	// all are strings because we don't need to do any calculations with them
	List<String> rank;
	List<String> boyNum;
	List<String> girlNum;
	List<String> boyName;
	List<String> girlName;

	// initialize ArrayLists to take info from the file, we use ArrayList
	// because of its powerful functions
	public BabyRanking() {
		rank = new ArrayList<String>();
		boyNum = new ArrayList<String>();
		girlNum = new ArrayList<String>();
		boyName = new ArrayList<String>();
		girlName = new ArrayList<String>();
	}

	public int getRank(int gender, String name) {
		int rankNumber = -1; // initialize as an impossible number
		UnaryOperator<String> uo = (x) -> x.toUpperCase();

		if (gender == 0) {

			boyName.replaceAll(uo); // replaces all boy names with upper case
			// search for boy names that match the input
			// (all is made upper case to allow the user to enter all lower case
			// and all upper case or any combination thereof and still get a
			// result)
			if (boyName.contains(name.toUpperCase())) {
				// making the rankNumber + 1 is important because we initialize
				// the rankNumber as -1
				rankNumber = boyName.indexOf(name.toUpperCase()) + 1;
			}
		} else {
			girlName.replaceAll(uo); // replaces all girl names with upper case
			// search for girl names that match the input using ArrayList
			// .contains and .indexOf methods
			if (girlName.contains(name.toUpperCase())) {
				rankNumber = girlName.indexOf(name.toUpperCase()) + 1;
			}

		}
		// print a simple message in console as error info
		if (rankNumber < 0) {
			System.out.println("Could not find a match");
		}

		return rankNumber;
	}

	public void getFileContents(String fileName) {
		BufferedReader reader;
		File file = new File("babynamesranking" + fileName + ".txt");
		System.out.println("File exists: " + file.exists());
		try {
			// because every file has a naming convention, we can infer some parts of the name
			reader = new BufferedReader(new FileReader(file));
			// using readLine to accurately get each line of the file
			String line = reader.readLine();
			while(line != null) {
				StringTokenizer token;

				try {
					if(line != null) {
					token = new StringTokenizer(line);

					//maybe split is better than tokenizer?
					//basically store each variable of a line into a separate array list to search through later
					rank.add(token.nextToken());
					boyName.add(token.nextToken());
					boyNum.add(token.nextToken());
					girlName.add(token.nextToken());
					girlNum.add(token.nextToken());

				}

				}catch(Exception e) {
					System.out.println("Exception: " + e);
				}

				line = reader.readLine();
			}
			reader.close();

		// IO exception to catch any file problems
		}catch(IOException e) {
			System.out.println("Exception: " + e);
		}
	}

	public void clear() {
		// a clear method to make sure the object is safe
		rank.clear();
		boyNum.clear();
		girlNum.clear();
		boyName.clear();
		girlName.clear();

	}

}
