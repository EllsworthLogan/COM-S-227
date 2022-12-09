
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
 * The initial position of each piece is based on its vertical size as well as
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
 * @author logan
 */
public class BasicGenerator implements Generator {
	
	/**
	 * Represents the given random object
	 */
	private Random rand;

	/**
	 * Constructs a BasicGenerator that will use the given Random object as its
	 * source of randomness.
	 * 
	 * @param givenRandom instance of Random to use
	 */
	public BasicGenerator(Random givenRandom) {
		rand = givenRandom;
	}

	@Override
	public Piece getNext(int width) {
		int col = width / 2 - 1;
		// probabilities
		int myRandom = rand.nextInt(100) + 1;
		
		//10% chance for LPiece
		if (myRandom <= 10) {
			Position pos = new Position(-2, col);
			Icon[] icons = {randomIcon(), randomIcon(), randomIcon(), randomIcon() };
			return new LPiece(pos, icons); //1 - 10
			
		//25% chance for DiagonalPiece
		} else if (myRandom <= 35) {
			Position pos = new Position(-1, col);
			Icon[] icons = {randomIcon(), randomIcon() };
			return new DiagonalPiece(pos, icons); //11 - 35
			
		//15% chance for CornerPiece
		} else if(myRandom <= 50) {
			Position pos = new Position(-1, col);
			Icon[] icons = {randomIcon(), randomIcon(), randomIcon() };
			return new CornerPiece(pos, icons); //36 - 50
		
		//10% chance for SnakePiece	
		} else if(myRandom <= 60) {
			Position pos = new Position(-1, col);
			Icon[] icons = {randomIcon(), randomIcon(), randomIcon(), randomIcon() };
			return new SnakePiece(pos, icons); // 51 - 60
			
		//40% chance for IPiece	
		} else {
			Position pos = new Position(-2, col);
			Icon[] icons = {randomIcon(), randomIcon(), randomIcon() };
			return new IPiece(pos, icons); //61 - 100;
		}
	}

	@Override
	public Icon randomIcon() {
		return new Icon(Icon.COLORS[rand.nextInt(Icon.COLORS.length)]);
	}
}
