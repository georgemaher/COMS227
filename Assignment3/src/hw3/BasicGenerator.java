/**
 * @author GeorgeMakhali
 */
package hw3;

import java.util.Random;

import api.Generator;
import api.Icon;
import api.Piece;
import api.Position;
import examples.SamplePiece;

/**
 * Generator for Piece objects in BlockAddiction. Icons are always selected
 * uniformly at random, and the Piece types are generated with the following
 * probabilities:
 * <ul>
 * <li>LPiece - 10%
 * <li>DiagonalPiece - 25%
 * <li>CornerPiece - 15%
 * <li>SnakePiece - 10%
 * <li>IPiece - 40%
 * </ul>
 * The initial position of each ret is based on its vertical size as well as
 * the width of the grid (given as an argument to getNext). The initial column
 * is always width/2 - 1. The initial row is: *
 * <ul>
 * <li>LPiece - row = -2
 * <li>DiagonalPiece - row = -1
 * <li>CornerPiece - row = -1
 * <li>SnakePiece - row = -1
 * <li>IPiece - row = -2
 * </ul>
 * 
 */
public class BasicGenerator implements Generator {
	private Random rand;

	/**
	 * Constructs ret BasicGenerator that will use the given Random object as its
	 * source of randomness.
	 * 
	 * @param givenRandom instance of Random to use
	 */
	public BasicGenerator(Random givenRandom) {
		rand = givenRandom;
	}

	@Override
	public Piece getNext(int width) {
		//The initial column is always width/2 - 1.
		int col = width / 2 - 1;
	   // random number generator to create pieces with specified probabilities
	   // 100 exclusive---> +1
	   int probability = rand.nextInt(100)+1;
	   Piece ret = null ;
	   //LPiece 10%
	   if(probability <= 10)
	   {
		   Icon [] icTemp = new Icon[4];
		   for(int i = 0; i < 4; i++)
		   {
			   icTemp[i] = randomIcon();
		   }
		   ret = new LPiece(new Position(-2,col), icTemp);
	   }
	   //DiagonalPiece 25%
	   else if(probability <= 35)
	   {
		   Icon [] icTemp = new Icon[2];
		   for(int i = 0; i < 2; i++)
		   {
			   icTemp[i] = randomIcon();
		   }
		   ret = new DiagonalPiece(new Position(-1,col), icTemp);
	   }
	   //CornerPiece 15%
	   else if(probability <= 50)
	   {
		   Icon [] icTemp = new Icon[3];
		   for(int i = 0; i < 3; i++)
		   {
			   icTemp[i] = randomIcon();
		   }
		   ret = new CornerPiece(new Position(-1,col), icTemp);
	   }
	   // SnakePiece 10%
	   else if(probability <= 60)
	   {
		   Icon [] icTemp = new Icon[4];
		   for(int i = 0; i < 4; i++)
		   {
			   icTemp[i] = randomIcon();
		   }
		   ret = new SnakePiece(new Position(-1,col), icTemp);
	   }
	   // IPiece 40%
	   else if(probability <= 100)
	   {
		   Icon [] icTemp = new Icon[3];
		   for(int i = 0; i < 3; i++)
		   {
			   icTemp[i] = randomIcon();
		   }
		   ret = new IPiece(new Position(-2,col), icTemp);
	   }
	   return ret;
	    
	}

	@Override
	public Icon randomIcon() {
		return new Icon(Icon.COLORS[rand.nextInt(Icon.COLORS.length)]);
	}
}
