package hw2;

/**
 * Class representing a hidden character for a word-guessing game.
 * Each instance encapsulates one character, which may have a status
 * of "hidden" or "not hidden". When in the hidden state, getDisplayedChar
 * returns null; if not hidden, getDisplayedChar returns the encapsulated
 * character as a one-character string.
 * 
 * @author logan
 */
public class HideableChar {

	/**
	 * Represents the hidden status of a HideableChar.
	 */
	private boolean hidden;
	
	/**
	 * Represents the char that the HideableChar was constructed with.
	 */
	private char currChar;
	
	/**
	 * Constructs a HideableChar with the given character as data. If the
	 * given character is alphabetic (according to the method Character.isAlphabetic),
	 * then this object is initially in the hidden state; otherwise, it is
	 * initially not hidden.
	 * 
	 * @param ch - character data for this object
	 */
	public HideableChar(char ch) {
		currChar = ch;
		hidden = false;
		for (char character = 'A'; character <= 'Z'; character++) {
			if (currChar == character) {
				hidden = true;
				break;
			}
		}
		for (char character = 'a'; character <= 'z'; character++) {
			if (currChar == character) {
				hidden = true;
				break;
			}		
		}		
	}

	/**
	 * Determines whether this object is currently in the hidden state.
	 * 
	 * @return true if this object is hidden, false otherwise
	 */
	public boolean isHidden() {	
		if (hidden) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Sets this object's state to hidden.
	 */
	public void hide() {
		hidden = true;
	}

	/**
	 * Sets this object's state to not hidden.
	 */
	public void unHide() {
		hidden = false;
	}

	/**
	 * Determines whether the given character is equal
	 * to the character stored in this object.
	 * 
	 * @param ch - given character to check
	 * @return true if the given character is equal to this object's data
	 */
	public boolean matches(char ch) {
		if (ch == currChar) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns null if this object is in the hidden state,
	 * otherwise returns a one-character string consisting
	 * of the character stored in this object.
	 * 
	 * @return string consisting of this object's character, or
	 * 		null if hidden
	 */
	public String getDisplayedChar() {
		String display = "";
		if (hidden) {
			return null;
		} else {
			display += currChar;
			return display;
		}
	}

	/**
	 * Returns a one-character string consisting of the
	 * character stored in this object. (whether hidden or not).
	 * 
	 * @return string consisting of this object's character
	 */
	public String getHiddenChar() {
		String display = "";
		display += currChar;
		return display;
	}
}
