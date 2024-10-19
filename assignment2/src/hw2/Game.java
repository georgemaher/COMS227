package hw2;


public class Game {
	private int maxGuesses;// number of max guesses
	private String gameWord; // the selected game word
	private HideableChar[] charArray; // chars of the game word
	private String guessed = ""; // guessed chars
	private int wrong;// number of wrong guesses 
	private boolean over;// state of the game
	
	public static final int DEFAULT_MAX_WRONG_GUESSES = 7;

	/**
	 * constructor to initiate the game class
	 * @param word is the game word 
	 */
	public Game(String word) {
		gameWord = word.trim(); // remove spaces
		maxGuesses = Game.DEFAULT_MAX_WRONG_GUESSES;
		charArray = new HideableChar[gameWord.length()]; // create an array of the game word length of hidden chars
		for (int i = 0 ; i < gameWord.length() ; i++) {
			charArray[i] = new HideableChar(gameWord.charAt(i));// fill the array in
		}
		
	}

	/**
	 * alternative constructor where max guesses can be modified
	 * @param word is the game word
	 * @param maxGuesses number to be chosen instead of the constant one
	 */
	public Game(String word, int maxGuesses) {
		gameWord = word.trim();
		this.maxGuesses = maxGuesses ; 
		charArray = new HideableChar[gameWord.length()];
		for (int i = 0 ; i < gameWord.length() ; i++) {
			charArray[i] = new HideableChar(gameWord.charAt(i));
		}
	}

	/**
	 * method to return the number of max guesses
	 * @return maxGuesses
	 */
	public int getMaxGuesses() {
		return maxGuesses;
	}

	/**
	 * method to check if the game is over
	 * @return boolean true or false
	 */
	public boolean gameOver() {
		over = 	won() || this.wrong >= this.maxGuesses; // is over if the game is won or player lost
		return over;

	}

	/**
	 * method to return the number of wrong guesses made by the player so far
	 * @return an int wrong
	 */
	public int numWrongGuesses() {
		return this.wrong;
	}

	/**
	 * method checking if the player won the game session
	 * @return true or false, won or not
	 */
	public boolean won() {
		if (this.wrong >= this.maxGuesses) { // if player exceeded max guesses then he lost
			return false;
		}
		int count = 0;
		
		for(int i = 0; i <this.gameWord.length() ; i++) {
			// checks the number of hidden chars, if they all have been revealed, the player won
			if(this.charArray[i].isHidden()) { 
				break;
			}
			count++ ;
		}
			
		
		return count == gameWord.length();
	}

	/**
	 * method to return the guessed letters so far by the player
	 * @return a string of guessed chars
	 */
	public String lettersGuessed() {
		return this.guessed;
	}

	/**
	 * Returns a sequence of HideableChar representing the secret word or phrase. 
	 * Letters that have not been guessed yet are hidden. 
	 * @return displayed form of the secret word
	 */
	public HideableChar[] getDisplayedWord() {
		
		return charArray;
	}

	/**
	 * Returns the complete secret word or phrase as a string.
	 * @return the secret word
	 */
	public String getSecretWord() {
		return gameWord;
	}

	/**
	 * private helper method created to unhide each correct guess
	 * @param ch the guess
	 */
	private void unhideCorrectGuess(char ch) {
		for (int i = 0; i < charArray.length ; i++) {
			if (charArray [i].matches(ch)) {
				charArray[i].unHide();
			}
		}
	}
	
	/**
	 * private helper method to add the guessed char to the guessed string 
	 * @param ch the guessed char
	 */
	private void addCharGuess(char ch) {
		boolean guessedBefore = this.guessed.indexOf(ch)>=0; // guessed before
		if(guessedBefore || this.gameOver()) { // if not guessed before or game has ended
			
		}
		else {
			guessed += ch; // else, add it
		}
	}
	
	/**
	 * the method responsible for guessing a letter, checks if it is alphabetic, guessed before, and if in the word
	 * works together with two helper methods to determine the correctness of the guessed char
	 * @param ch the guessed char
	 * @return true if the char is correct and not guessed before, false otherwise
	 */
	public boolean guessLetter(char ch) {
		boolean alphabetic = Character.isAlphabetic(ch);
		boolean guessedBefore = guessed.indexOf(ch) >= 0;
		boolean inWord =  (this.gameWord.indexOf(ch) >= 0);
		boolean correctGuess = !guessedBefore && inWord && alphabetic;
		this.addCharGuess(ch); 
		if(!this.gameOver() && !correctGuess) {
			this.wrong++; // if the game is not over and wrong guess, increment wrong
		}
		else {
			this.unhideCorrectGuess(ch);// else, unhide the char
		}
		
		return correctGuess;
	}
	 
}
