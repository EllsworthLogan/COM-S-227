package hw3;

import api.Cell;
import api.Icon;
import api.Position;
/**
 * Piece type with a 3 x 3 bounding square and initial cell positions
 * (0, 0), (1, 0), (1, 1), and (1, 2) in that order. The transform()
 * method shifts cells forward in a specified sequence of positions.
 * 
 * @author logan
 */
public class SnakePiece extends AbstractPiece {
	
	/**
	 * Represents the number of times transform has been called
	 */
	private int counter;
	
  /**
   * Sequence of positions for the first cell.
   */
  private static final Position[] sequence = {
      new Position(0, 0), //0
      new Position(0, 1), //1
      new Position(0, 2), //2
      new Position(1, 2), //3
      new Position(1, 1), //4
      new Position(1, 0), //5   
      new Position(2, 0), //6
      new Position(2, 1), //7
      new Position(2, 2), //8
      new Position(1, 2), //9
      new Position(1, 1), //10
      new Position(1, 0), //11
  };
  
 /**
  * Constructs a new SnakePiece with the given position and icons.
  * 
  * @param position - initial position of upper-left corner of bounding box
  * @param icons - initial icons for the cells
  * @throws IllegalArgumentException
  */
  public SnakePiece(Position position, Icon[] icons) throws IllegalArgumentException {
    super(position);
    cells = new Cell[4];
	cells[0] = new Cell(icons[0], sequence[0]);
	cells[1] = new Cell(icons[1], sequence[11]);
	cells[2] = new Cell(icons[2], sequence[10]);
	cells[3] = new Cell(icons[3], sequence[9]);
	counter = 1;
	setCells(cells);
  }

  @Override
  public void transform() {
	  Cell[] cells = getCells();
	  cells[0].setPosition(sequence[counter]);
	  //counter is used to determine which position the cell needs to be set to
	  if (counter - 1 < 0) {
		  cells[1].setPosition(sequence[11 + counter]);
	  } else {
		  cells[1].setPosition(sequence[counter - 1]);
	  }

	  if (counter - 2 < 0) {
		  cells[2].setPosition(sequence[10 + counter]);
	  } else {
		  cells[2].setPosition(sequence[counter - 2]);
	  }

	  if (counter - 3 < 0) {
		  cells[3].setPosition(sequence[9 + counter]);
	  } else {
		  cells[3].setPosition(sequence[counter - 3]);
	  }
	  
	  if (counter == 11) {
		  counter = 0;
	  } else {
		  counter++;
	  }
	  
	  setCells(cells);
  }
  
}