import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class FileReading {

	public static void main(String[] args) throws FileNotFoundException {

		String currMovieTitle, userMovieTitle, currMovie;
		int userInput, marker, bTestScore = 0;
		File file = new File("/Users/faithcomising/Downloads/CareerLaunchApp-main/Bechdel.csv");
		boolean repeat = false;
		Scanner input = new Scanner(System.in);
		System.out.println("Bechdel Test Program \n1. Definition \n2. Search \nEnter 1 or 2: ");
		userInput = input.nextInt();
		
		if (userInput == 1) {
			System.out.println(
					"The Bechdel Test for films has 3 criteria: 1) the film has two female character, who 2) talk to each other, about 3) something other than a man");
		}

		do {

			System.out.println("Enter a movie name: ");
			// somethings happening here
			userMovieTitle = input.nextLine();
			System.out.println(userMovieTitle);
			input = new Scanner(file);
			boolean found = false;

			while (input.hasNextLine()) {
				currMovie = input.nextLine();
				marker = currMovie.indexOf(',') + 1;
				if (currMovie.length() >= marker + userMovieTitle.length()) {
					currMovieTitle = currMovie.substring(marker, marker + userMovieTitle.length());
					if (currMovieTitle.equals(userMovieTitle)) {
						found = true;
						bTestScore = Character.getNumericValue(currMovie.charAt(currMovie.length() - 6));
					}
				}

			}

			if (found == false) {
				System.out.println(userMovieTitle + " was not found in the database");
			} else if (bTestScore == 3) {
				System.out.println(userMovieTitle + " passes all 3 criteria of the Bechdel Test!");
			} else if (bTestScore == 0 || bTestScore == 1) {
				System.out.println(userMovieTitle + " did not pass the Bechdel Test. " + bTestScore
						+ " out of the 3 criteria was met.");
			} else {
				System.out.println(
						userMovieTitle + " did not pass the Bechdel Test. Only 2 out of the 3 criteria were met.");
			}

			System.out.println("Do you want to seach another movie? (y/n)");
			if (input.next() == "y") {
				repeat = true;
			}
		} while (repeat);
		input.close();
	}

}
