import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class FileReading {

	public static void main(String[] args) throws FileNotFoundException {

		String currMovieTitle, userMovieTitle, currMovie;
		int marker, bTestScore = 0;
		File file = new File("/Users/faithcomising/Downloads/CareerLaunchApp-main/Bechdel.csv");
		System.out.println("Enter a movie name: ");
		Scanner input = new Scanner(System.in);
		userMovieTitle = input.nextLine();
		System.out.println(userMovieTitle);
		input = new Scanner(file);
		boolean found = false;

		while (input.hasNextLine()) {
			currMovie = input.nextLine();
			marker = currMovie.indexOf(',') + 1;
			if (currMovie.length() >= marker + userMovieTitle.length()) { // checking that the length of the file line is long enough to be checked
				currMovieTitle = currMovie.substring(marker, marker + userMovieTitle.length()); // getting the movie title in the file line
				if (currMovieTitle.equals(userMovieTitle)) {
					found = true;
					bTestScore = Character.getNumericValue(currMovie.charAt(currMovie.length() - 6)); // getting score from the file line
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
			System.out
					.println(userMovieTitle + " did not pass the Bechdel Test. Only 2 out of the 3 criteria were met.");
		}

	}

}
