package hw3;

import api.Icon;
import api.Cell;
import api.Position;

/**
 * Piece type that has a 2 x 2 bounding square with the icons
 * at (0, 0) and, (1, 1), in that order. The transform() method
 * flips the cells across the vertical centerline of the bounding
 * square.
 * 
 * @author logan
 */
public class DiagonalPiece extends AbstractPiece {

	/**
	 * Constructs a new DiagonalPiece with the given position and icons.
	 * 
	 * @param position - initial position of upper-left corner of bounding square
	 * @param icons - initial icons for the cells
	 * @throws IllegalArgumentException
	 */
	public DiagonalPiece(Position position, Icon[] icons) throws IllegalArgumentException {
		super(position);
		cells = new Cell[2];
		cells[0] = new Cell(icons[0], new Position(0, 0));
		cells[1] = new Cell(icons[1], new Position(1, 1));
		
		setCells(cells);
	}

	@Override
	public void transform() {
		Cell[] cells = getCells();
		
		if (cells[0].getCol() == 0) {
			cells[0].setRowCol(0, 1);
			cells[1].setRowCol(1, 0);
		} else {
			cells[0].setRowCol(0, 0);
			cells[1].setRowCol(1, 1);
		}
		
		setCells(cells);
	}
}
