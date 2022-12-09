package hw3;

import java.awt.Color;

import api.Cell;
import api.Icon;
import api.Position;

/**
 * Piece type that has a 3 x 3 bounding square with the icons at
 * (0, 0), (0, 1), (1, 1), and (2, 1), in that order. The transform()
 * method flips the cells horizontally across the vertical centerline
 * of the bounding square.
 * 
 * @author logan
 */
public class LPiece extends AbstractPiece {

	/**
	 * Constructs a new LPiece with the given position and icons.
	 * 
	 * @param position - initial position of upper-left corner of bounding square
	 * @param icons - initial icons for the cells
	 * @throws IllegalArgumentException
	 */
	public LPiece(Position position, Icon[] icons) throws IllegalArgumentException {
		super(position);
		cells = new Cell[4];
		cells[0] = new Cell(icons[0], new Position(0, 0));
		cells[1] = new Cell(icons[1], new Position(0, 1));
		cells[2] = new Cell(icons[2], new Position(1, 1));
		cells[3] = new Cell(icons[3], new Position(2, 1));
		
		setCells(cells);
	}

	@Override
	public void transform() {
		//flip over a vertical centerline
		Cell[] cells = getCells();
		if(cells[0].getCol() == 0) {
			cells[0].setCol(2);
		} else {
			cells[0].setCol(0);
		}
		
		setCells(cells);
	}
}
