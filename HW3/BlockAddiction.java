
package hw3;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import api.AbstractGame;
import api.Generator;
import api.Icon;
import api.Position;

/**
 * Concrete subclass of AbstractGame implementing the rules for BlockAddiction.
 * 
 * @author logan
 */

public class BlockAddiction extends AbstractGame {

	/**
	 * Constructs a game with the given height (rows) and width (columns).
	 * 
	 * @param height - height of the game grid (number of rows)
	 * @param width - width of the game grid (number of columns)
	 * @param gen - instance of the Generator interface to be used for generating pieces in this game
	 */
	public BlockAddiction(int height, int width, Generator gen) {
		super(height, width, gen);
	}

	/**
	 * Constructs a game with the given height (rows) and width (columns). If preFillRows
	 * is greater than zero, the given number of rows at the bottom of the grid will be
	 * initialized in a checkerboard pattern using randomly generated icons from the given
	 * generator. (That is, an array cell at (row, col) is filled if row and col are both
	 * even or both odd.)
	 * 
	 * @param height - height of the game grid (number of rows)
	 * @param width - width of the game grid (number of columns)
	 * @param gen - instance of the Generator interface to be used for generating pieces in this game
	 * @param preFillRows - number of rows at the bottom to be filled with a checkerboard pattern
	 */
	public BlockAddiction(int height, int width, Generator gen, int preFillRows) {
		super(height, width, gen);
		if(preFillRows > 0) {
			preFill(preFillRows, gen);
		}
	}

	@Override
	public List<Position> determinePositionsToCollapse() {
		ArrayList<Position> ret = new ArrayList<Position>();
		
		//iterate through rows
		for (int i = 0; i < getHeight(); i++) {
			//iterate through columns
			for(int j = 0; j < getWidth(); j++) {
				ArrayList<Position> pos = new ArrayList<Position>();
				if (getIcon(i, j) != null) {
					
					//if at top row
					if (i == 0) {
						//below
						if (getIcon(i, j).matches(getIcon(i+1, j))) {
							pos.add(new Position(i, j));
							pos.add(new Position(i+1, j));
						}
						//right
						if (j != getWidth() - 1 && getIcon(i, j).matches(getIcon(i, j+1))) {
							pos.add(new Position(i, j));
							pos.add(new Position(i, j+1));
						}
						//left
						if (j != 0 && getIcon(i, j).matches(getIcon(i, j-1))) {
							pos.add(new Position(i, j));
							pos.add(new Position(i, j-1));
						}
					}
					//if at bottom row
					else if (i == getHeight() - 1) {
						//above
						if (getIcon(i, j).matches(getIcon(i-1, j))) {
							pos.add(new Position(i, j));
							pos.add(new Position(i-1, j));
						}
						//right
						if (j != getWidth() - 1 && getIcon(i, j).matches(getIcon(i, j+1))) {
							pos.add(new Position(i, j));
							pos.add(new Position(i, j+1));
						}
						//left
						if (j != 0 && getIcon(i, j).matches(getIcon(i, j-1))) {
							pos.add(new Position(i, j));
							pos.add(new Position(i, j-1));
						}
					}
					//if at far right
					else if (j == getWidth() - 1) {
						//below
						if (i != getHeight() - 1 && getIcon(i, j).matches(getIcon(i+1, j))) {
							pos.add(new Position(i, j));
							pos.add(new Position(i+1, j));
						}
						//above
						if (i != 0 && getIcon(i, j).matches(getIcon(i-1, j))) {
							pos.add(new Position(i, j));
							pos.add(new Position(i-1, j));
						}
						//left
						if (getIcon(i, j).matches(getIcon(i, j-1))) {
							pos.add(new Position(i, j));
							pos.add(new Position(i, j-1));
						}
					}
					//if at far left
					else if (j == 0) {
						//below
						if (i != getHeight() - 1 && getIcon(i, j).matches(getIcon(i+1, j))) {
							pos.add(new Position(i, j));
							pos.add(new Position(i+1, j));
						}
						//above
						if (i != 0 && getIcon(i, j).matches(getIcon(i-1, j))) {
							pos.add(new Position(i, j));
							pos.add(new Position(i-1, j));
						}
						//right
						if (getIcon(i, j).matches(getIcon(i, j+1))) {
							pos.add(new Position(i, j));
							pos.add(new Position(i, j+1));
						}
					} 
					else {
						//below
						if (getIcon(i, j).matches(getIcon(i+1, j))) {
							pos.add(new Position(i, j));
							pos.add(new Position(i+1, j));
						}
						//above
						if (getIcon(i, j).matches(getIcon(i-1, j))) {
							pos.add(new Position(i, j));
							pos.add(new Position(i-1, j));
						}
						//right
						if (getIcon(i, j).matches(getIcon(i, j+1))) {
							pos.add(new Position(i, j));
							pos.add(new Position(i, j+1));
						}
						//left
						if (getIcon(i, j).matches(getIcon(i, j-1))) {
							pos.add(new Position(i, j));
							pos.add(new Position(i, j-1));
						}
					}
				}
				
				// check whether the list has 3+ elements
				if(pos.size() >= 3) {
					for (int h = 0; h < pos.size(); h++) {
						Position retPos = pos.get(h);
						    if(!ret.contains(retPos)) {
							ret.add(retPos);
						    }
					}	
				}
			}
		}
		//sort the array
		Collections.sort(ret);
	
		//return the sorted array
		return ret;
	}

	/**
	 * Fills the bottom of the grid with random icons.
	 * 
	 * @param rows - number of rows at the bottom to be filled with a checkerboard pattern
	 * @param gen - instance of the Generator interface to be used for generating pieces in this game
	 */
	private void preFill(int rows, Generator gen) {
		for (int i = getHeight() - 1; i >= getHeight() - rows; i--) {
			for (int j = 0; j<= getWidth() - 1; j++) {
				//if they are both even or both odd
				if((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
					Icon randomIcon = gen.randomIcon();
					setBlock(i, j, randomIcon);
				}
			}
		}
	}
}
