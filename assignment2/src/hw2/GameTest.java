package hw2;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private String secretWord1;
    private String secretWord2;
    private Game firstGame;
    private Game secondGame;
    private   int secondGameMaxGuesses = 75;
    
    @Before
    public void start()  {
        secretWord1 = "Secret Santaa";
        firstGame = new Game(secretWord1);
        secretWord2 = "That is Amazing";
        secondGame = new Game(secretWord2, secondGameMaxGuesses);
    }
 
 
    @Test
    public  void maxGuesses() {
        assertEquals("Default max guesses is wrong",7, firstGame.getMaxGuesses());
    }
    
    
    
    @Test
    public void maxGuesses2() {
        assertEquals("Max guesses is wrong.",7, firstGame.getMaxGuesses());
    }
 
    
    
    @Test
    public void firstGameSecretWord() {
        assertTrue(firstGame.getSecretWord().equals(secretWord1) );
    }
    
    
    
    @Test
    public void secondGameSecretWord() {
        assertTrue(secondGame.getSecretWord().equals(secretWord2));
    }
    
    @Test
	public void firstGameConstructor(){
		Game game = new Game("WOOOOOOOOOOOOOOOOOOOOOOOOOOOW", 5);
		assertEquals( 5, game.getMaxGuesses());			
	}
	
	@Test
	public void secondGameConstructor(){
		Game game = new Game("Something is fishy here");
		assertEquals( 7, game.getMaxGuesses());			
	}
	@Test
	public void maxGuessesInitial() {
		Game game = new Game("Pivot Pivot");
		assertEquals( 7, game.getMaxGuesses());			
	}
	
	@Test
	public void maxGuessesInitial2(){
		Game game = new Game("phewwwww", 5);
		assertEquals(5, game.getMaxGuesses());		
	}
	
	@Test
	public void maxGuessesintial3(){
		Game game = new Game("Here's Johnny", 0);
		assertEquals( 0, game.getMaxGuesses());		
	}
	@Test
	public void initialSecretWord(){
		String wordTest = "I am the best";
		Game game = new Game(wordTest);
		assertEquals( wordTest, game.getSecretWord());		
	}
	
	@Test
	public void wrongGuessesCount(){
		String wordTest = "Hello, World!";
		Game game = new Game(wordTest);
		game.guessLetter('g');
		assertEquals( 1, game.numWrongGuesses());		
	}
    
    
}
