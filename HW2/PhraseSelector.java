package hw2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Generator for secret words or phrases for word-guessing games. A PhraseSelector
 * chooses a line randomly from a file specified in the constructor. This version
 * reads the file just once in the constructor and stores the words in an ArrayList.
 * For an alternate version that does not use an ArrayList, see PhraseSelectorAlt.java.
 * 
 * @author logan
 */
public class PhraseSelector {
	
	/**
	 * Represents the random word or phrase that is selected by the selectWord() method.
	 */
	private String randomPhrase = "";
	
	/**
	 * Represents the file that is passed into the constructor by the user.
	 */
	private File userFile;
	
	/**
	 * Contains a list of Strings, each consisting of one complete line of the given file.
	 */
	private ArrayList<String> fileLines;
	
	/**
	 * Constructs a PhraseSelector that will select words from the given file. This
	 * constructor may throw a FileNotFoundException if the file cannot be opened.
	 * 
	 * @param givenFilename - the name of the file
	 * @throws FileNotFoundException
	 */
	public PhraseSelector(String givenFilename) throws FileNotFoundException {
		userFile = new File (givenFilename);
		Scanner fileScanner = new Scanner (userFile);
		//instantiate the arraylist for the file contents
		fileLines = new ArrayList<String>();

		//while the scanner sees the file has contents
		while (fileScanner.hasNextLine()) {
			fileLines.add(fileScanner.nextLine());
		}
		
		//Declare a random number generator.
		Random randLine = new Random();
		//call the selectWord method and pass randLine.
		randomPhrase = selectWord(randLine);
		
		fileScanner.close();
	}

	/**
	 *Returns a word or phrase selected at random from this PhraseSelector's file,
	 *using the given source of randomness. Specifically, this method returns the
	 *nth line of the file, where n = rand.nextInt(size) and size is the number of
	 *lines in the file. This method may throw FileNotFoundException if the file
	 *cannot be opened.
	 * 
	 * @param rand - a Random object
	 * @return a randomly selected line of the file
	 * @throws FileNotFoundException
	 */
	public String selectWord(Random rand) throws FileNotFoundException {
		//gets a random number within the length of array size
		int randLineNum = rand.nextInt(fileLines.size());
		randomPhrase = fileLines.get(randLineNum).toString();
		return randomPhrase;
	}
}
