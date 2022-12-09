package hw3;

import api.Icon;
import api.Cell;
import api.Position;
import examples.SamplePiece;
import api.Piece;

/**
 * Abstract superclass for implementations of the Piece interface.
 * 
 * @author logan
 */
public abstract class AbstractPiece implements Piece {
	
	/**
	 * Represents where the piece is, relative to the bounding square
	 */
	private Position position;
	
	/**
	 * Represents an ArrayList of Cells that make up the piece
	 */
	protected Cell[] cells;

	/**
	 * Constructs a piece with the given position. Subclasses extending this class
	 * MUST call setCells to initialize initial cell positions and icons.
	 * 
	 * @param position initial position for upper-left corner of bounding box
	 */
	protected AbstractPiece(Position position) {
		this.position = position;
	}

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public void setCells(Cell[] givenCells) {
		// deep copy the given array
		cells = new Cell[givenCells.length];
		for(int i = 0; i < givenCells.length; ++i) {
			cells[i] = new Cell(givenCells[i]);
		}
	}

	@Override
	public Cell[] getCells() {
		// deep copy this object's cell array
		Cell[] copy = new Cell[cells.length];
		for(int i = 0; i < cells.length; ++i) {
			copy[i] = new Cell(cells[i]);
		}
		return copy;
	}

	@Override
	public Cell[] getCellsAbsolute() {
		Cell[] ret = new Cell[cells.length];
		
		for(int i = 0; i < cells.length; ++i) {
			int row = cells[i].getRow() + position.row();
			int col = cells[i].getCol() + position.col();
			Icon b = cells[i].getIcon();
			ret[i] = new Cell(b, new Position(row, col));
		}
		return ret;
	}

	@Override
	public void shiftDown() {
		position = new Position(position.row() + 1, position.col());

	}

	@Override
	public void shiftLeft() {
		position = new Position(position.row(), position.col() - 1);

	}

	@Override
	public void shiftRight() {
		position = new Position(position.row(), position.col() + 1);

	}

	@Override
	public void cycle() {
		//copy the cells
		Cell[] cellsCopy = getCells();
		
		//change the place of the icons based on the copy of cells
		for (int i = 0; i < cells.length; i++) {
			//check whether cell is first position
			if(i == 0) {
				cells[i].setIcon(cellsCopy[cells.length - 1].getIcon());
			} else {
				//set icon to the icon from position directly behind it
				cells[i].setIcon(cellsCopy[i - 1].getIcon());
			}
		}
	}

	@Override
	public Piece clone() {
		try
		{
			// call the Object clone() method to create a shallow copy
			AbstractPiece s = (AbstractPiece) super.clone();

			// then make it into a deep copy (note there is no need to copy the position,
			// since Position is immutable, but we have to deep-copy the cell array
			// by making new Cell objects
			s.cells = new Cell[cells.length];
			for (int i = 0; i < cells.length; ++i)
			{
				s.cells[i] = new Cell(cells[i]);
			}
			return s;
		}
		catch (CloneNotSupportedException e)
		{
			// can't happen, since we know the superclass is cloneable
			return null;
		}
	}
	
	@Override
	public void transform() {
		// probably does not actually need to be listed in here
	}
	
}