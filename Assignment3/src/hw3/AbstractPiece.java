package hw3;
/**
 * @author GeorgeMakhali
 */
import api.Icon;
import api.Cell;
import api.Position;
import api.Piece;

/**
 * Abstract superclass for implementations of the Piece interface.
 */

public abstract class AbstractPiece implements Piece {

	private Position position;
	private Cell[] cells;
	
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
		 cells = new Cell[givenCells.length];
		 // creating new cells
		for (int i = 0; i < cells.length; i++)
		{
			cells[i] = new Cell(givenCells[i]);
		}
	}

	@Override
	public Cell[] getCells() {
		Cell[] copy = new Cell[cells.length];
		for (int i = 0; i < cells.length; i++)
		{
			copy[i] = new Cell(cells[i]);
		}

		return copy;
	}

	@Override
	public Cell[] getCellsAbsolute() {
		Cell[] ret = new Cell[cells.length];
		// get the needed info
		for (int i = 0; i < cells.length; i++)
		{
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
		Cell[] tmp1 = getCells();
		Cell[] tmp2 = new Cell[tmp1.length]; 
		for(int i = 1 ; i < tmp1.length ; i++)
		{
			tmp2[i]= new Cell(tmp1[i]);
			tmp2[i].setIcon(tmp1[i-1].getIcon());// get the icon of the previous cell
			
		}
		tmp2[0]= new Cell(tmp1[0]);
		tmp2[0].setIcon(tmp1[tmp1.length-1].getIcon());// first cell gets the last cell icon
		setCells(tmp2);
	}

	@Override
	public Piece clone() {
		try
	    {
	     // using the super clone method and type casting
		 AbstractPiece s = (AbstractPiece) super.clone();
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

}