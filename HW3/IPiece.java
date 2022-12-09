
package hw3;

import java.awt.Color;

import api.Cell;
import api.Icon;
import api.Position;

/**
 * Piece type that has a 3 x 3 bounding square with the icons
 * down the center in the order (0, 1), (1, 1), and (2, 1). For
 * IPiece, the transform() method does nothing.
 * 
 * @author logan
 */
public class IPiece extends AbstractPiece {
	
	/**
	 * Constructs a new IPiece with the given position and icons.
	 * 
	 * @param position - initial position of upper-left corner of bounding square
	 * @param icons - initial icons for the cells
	 * @throws IllegalArgumentException
	 */
	public IPiece(Position position, Icon[] icons) throws IllegalArgumentException {
		super(position);
		cells = new Cell[3];
		cells[0] = new Cell(icons[0], new Position(0, 1));
		cells[1] = new Cell(icons[1], new Position(1, 1));
		cells[2] = new Cell(icons[2], new Position(2, 1));
		
		setCells(cells);
	}

	@Override
	public void transform() {
		// does nothing
	}
	
}
