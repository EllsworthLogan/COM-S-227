package hw3;

import api.Cell;
import api.Icon;
import api.Position;

/**
 * Piece type with a 2 x 2 bounding square and initial cell positions
 * (0, 0), (1, 0), and (1, 1) in that order. The transform() method shifts
 * the cells following the sequence (0, 0), (0, 1), (1, 1), (1, 0).
 * 
 * @author logan
 */
public class CornerPiece extends AbstractPiece {

	/**
	 * Constructs a new CornerPiece with the given position and icons.
	 * 
	 * @param position - initial position of upper-left corner of bounding square
	 * @param icons - initial icons for the cells
	 * @throws IllegalArgumentException
	 */
	public CornerPiece(Position position, Icon[] icons) throws IllegalArgumentException {
		super(position);
		cells = new Cell[3];
		cells[0] = new Cell(icons[0], new Position(0, 1));
		cells[1] = new Cell(icons[1], new Position(1, 0));
		cells[2] = new Cell(icons[2], new Position(1, 1));
		setCells(cells);
	}

	@Override
	public void transform() {
//		move icons clockwise
//		after 1 call, positions are (0,1), (0,0), (1,0)
//		after 4 calls they are back to initial positions
		for (int i = 0; i < cells.length; i++) {	
			//row is 0
			if (cells[i].getRow() == 0) {
				//col is 0
				if(cells[i].getCol() == 0) {
					cells[i].setCol(1);
				//col is 1
				} else {
					cells[i].setRow(1);
				}
			//row is 1
			} else {
				//col is 0
				if(cells[i].getCol() == 0) {
					cells[i].setRow(0);
				//col is 1
				} else {
					cells[i].setCol(0);
				}
			}
		}
		setCells(cells);
	}
}
