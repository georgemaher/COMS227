	package hw2;

public class HideableChar {
	
	private char c ;
	private boolean hidden; // state of the char
	
	/**
	 * constructor for each char in the line
	 * @param ch the char in the string
	 */
	public HideableChar(char ch) {
		 
		c = ch;
		hidden = Character.isAlphabetic(c); // initially hidden
	}

	/**
	 * method to know the state of the char
	 * @return state
	 */
	public boolean isHidden() {
		return hidden;
	}

	/**
	 * method to hide the character
	 */
	public void hide() {
		hidden = true;
	}

	/**
	 * method to unhide the character
	 */
	public void unHide() {
		hidden = false;
	}

	/**
	 * method to check if the character matches with one in the string of the game word
	 * @param ch the selected char
	 * @return true or false, matched or not
	 */
	public boolean matches(char ch) {

		return this.c == ch;
	}

	/**
	 * method to return a string of the char if not hidden, null otherwise
	 * @return string with one char
	 */
	public String getDisplayedChar() {
		if (hidden) { 
			return null;
		}
		else {
			return this.getHiddenChar();
		}
	
	}

	/**
	 * method to return a string with one char independent of its state
	 * @return a string with one char
	 */
	public String getHiddenChar() {
		return "" + c;
	}
}
