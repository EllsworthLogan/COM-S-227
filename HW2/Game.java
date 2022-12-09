package hw2;

/**
 * Class representing a game of hangman. This class encapsulates all
 * aspects of the game state, including the secret word or phrase, the
 * letters guessed so far, and the number of wrong guesses. A hangman
 * game can be constructed with a specified maximum number of wrong
 * guesses which defaults to DEFAULT_MAX_WRONG_GUESSES. The secret word
 * or phrase is represented as an array of HideableChar and may contain
 * whitespace and arbitrary punctuation characters. Clients of this code
 * decide how to represent the "hidden" characters to the user.
 * Non-alphabetic characters are normally not hidden.
 * 
 * @author logan
 */

public class Game {

	/**
	 * Contains a list of HideableChar objects.
	 */
	private HideableChar[] charArray;
	
	/**
	 * Represents the random phrase that was passed into the constructor.
	 */
	private String givenPhrase;
	
	/**
	 * Represents all of the letters that have been guessed by the user.
	 */
	private String guessedLetters = "";
	
	/**
	 * Represents the maximum number of allowed guesses.
	 */
	private int maxGuesses;
	
	
	/**
	 * Represents the number of guesses that were incorrect.
	 */
	private int wrongGuesses;
	
	/**
	 * Represents the "won" or "lost" aspect of the game.
	 */
	private boolean gameWon = false;
	
	/**
	 * Represents the first round of the game.
	 */
	private boolean firstRound = true;
	
	/**
	 * Default value for the maximum number of wrong guesses.
	 */
	public static final int DEFAULT_MAX_WRONG_GUESSES = 7;

	/**
	 * Constructs a hangman game using the given word as the secret
	 * word and the default maximum number of wrong guesses.
	 * 
	 * @param word - the secret word
	 */
	public Game(String word) { 
		givenPhrase = word;
		maxGuesses = DEFAULT_MAX_WRONG_GUESSES;
		wrongGuesses = 0;
	}

	/**
	 * Constructs a hangman game using the given word as the secret
	 * word and the given value as the maximum number of wrong guesses.
	 * 
	 * @param word - the secret word
	 * @param maxGuesses
	 */
	public Game(String word, int maxGuesses) {
		givenPhrase = word;
		this.maxGuesses = maxGuesses;
	}

	/**
	 * Returns the maximum number of wrong guesses for this game.
	 * 
	 * @return maximum number of wrong guesses
	 */
	public int getMaxGuesses() {
		return maxGuesses;
	}

	/**
	 * Determines whether this game is over.
	 * 
	 * @return true if the player has won or has run out of guesses,
	 * false otherwise
	 */
	public boolean gameOver() {
		if (wrongGuesses == maxGuesses) {
			gameWon = false;
			return true;
		} else if (firstRound == true) {
			return false;
		//checks to see whether the game has been won.
		} else {
			gameWon = true;
			for (int j = 0; j < charArray.length; j++) {
				String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
				//if the char is a letter, check other conditions, else skip it.
				if(alphabet.contains(charArray[j].getHiddenChar())) {
					//if the letter is contained in the string of guessed letters, continue.
					if(guessedLetters.contains(charArray[j].getHiddenChar())) {
						continue;
					} else {
						gameWon = false;
					}
					}
			}
			if (gameWon == false) {
				return false;
			} else {
				return true;
			}
		}
	}

	/**
	 * Returns the number of wrong guesses made so far by the player.
	 * 
	 * @return number of wrong guesses
	 */
	public int numWrongGuesses() {
		return wrongGuesses;
	}

	/**
	 * Determines whether the player has guessed all the letters in the
	 * secret word.
	 * 
	 * @return true if the player has won, false otherwise
	 */
	public boolean won() {
		return gameWon;
	}

	/**
	 * Returns a string containing all the letters guessed so far by the
	 * player, without duplicates.
	 * 
	 * @return letters guessed so far by the player
	 */
	public String lettersGuessed() {
		return guessedLetters;
	}

	/**
	 *  Returns a sequence of HideableChar representing the secret word
	 *  or phrase. Letters that have not been guessed yet are hidden.
	 *  Non-alphabetic characters (according to the method Character.isAlphabetic)
	 *  are never hidden; the HideableChar constructor will normally help enforce
	 *  this condition.
	 *
	 * @return displayed form of the secret word
	 */
	public HideableChar[] getDisplayedWord() {
		charArray = new HideableChar[givenPhrase.length()];
		for (int i = 0; i < givenPhrase.length(); i++) {
			HideableChar hidChar = new HideableChar(givenPhrase.charAt(i));
			charArray[i] = hidChar;
			
			if(guessedLetters.contains(charArray[i].getHiddenChar())) {
				charArray[i].unHide();
			}
		}
		return charArray;
	}
	
	/**
	 * Returns the complete secret word or phrase as a string.
	 * 
	 * @return the secret word or phrase
	 */
	public String getSecretWord() {
		return givenPhrase;
	}

	/**
	 * Invoked by the player to guess a letter. The behavior is as follows:
	 *	If the game is already over, this method does nothing and returns false.
	 *  If the letter has previously been guessed by the player, records it as
	 *	a wrong guess and returns false.
	 *	If the letter has not previously been guessed, but does not occur in the
	 *	secret word or phrase, records it as a wrong guess and returns false.
	 *	If the letter has not previously been guessed and does occur in the secret
	 *	word, changes all occurrences of the letter in the secret word to "not
	 *	hidden" and returns true.
	 * 
	 * @param ch - the letter to check
	 * @return true if the letter has not been guessed already and occurs in
	 * 		   the secret word, false otherwise
	 */
	public boolean guessLetter(char ch) {
		String str = "" + ch;
		if (!guessedLetters.contains(str)) {
			guessedLetters += str;
		}
		if (givenPhrase.contains(str)) {		
			firstRound = false;
			return true;
		} else {
			wrongGuesses++;
			firstRound = false;
			return false;
		}
	}
}
