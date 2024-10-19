package hw3;
/**
 * @author GeorgeMakhali
 */
import api.Cell;
import api.Icon;
import api.Position;

public class SnakePiece extends AbstractPiece
{
  /**
   * Sequence of positions for the first cell.
   */
  private static final Position[] sequence = {
      new Position(0, 0),
      new Position(0, 1),
      new Position(0, 2),
      new Position(1, 2),
      new Position(1, 1),
      new Position(1, 0),    
      new Position(2, 0),
      new Position(2, 1),
      new Position(2, 2),
      new Position(1, 2),
      new Position(1, 1),
      new Position(1, 0),
  };
  private Icon[] iconsArr;
 
  /**
   * Constructor for SnakePiece
   * @param position position
   * @param icons Icons to be created with
   * @throws IllegalArgumentException in case that the Icons not enough
   */
  public SnakePiece(Position position, Icon[] icons)  {
    super(position);
   
    iconsArr = icons;
    Cell[] cls = new Cell[4];
    if(icons.length != 4) {
//      Exception IllegalArgumentException = null;
  		throw new IllegalArgumentException();
      }
    cls[0] = new Cell(iconsArr[0], SnakePiece.sequence[0]);
    cls[1] = new Cell(this.iconsArr[1] ,SnakePiece.sequence[SnakePiece.sequence.length-1]);
    cls[2] = new Cell(this.iconsArr[2] , SnakePiece.sequence[SnakePiece.sequence.length-2]);
    cls[3] = new Cell(this.iconsArr[3], SnakePiece.sequence[SnakePiece.sequence.length-3]);
    setCells(cls);
    
  }
  //transform counter
  private int i = 1;
  @Override
  public void transform() {
	  //deep copy
    Cell[]tmp = new Cell[getCells().length];
    tmp = getCells();
    
	
	// making the transformations
	tmp[3].setPosition(new Position(tmp[2].getRow(), tmp[2].getCol()));
	tmp[2].setPosition(new Position(tmp[1].getRow(), tmp[1].getCol()));
	tmp[1].setPosition(new Position(tmp[0].getRow(), tmp[0].getCol()));
	// reset when done with all transformations
	if (i >= 12)
	{
		i = 0;
		tmp[0].setPosition(sequence[0]);
	}
	else
	{
		tmp[0].setPosition(sequence[i]);
	}
	//increment
	i++;

    	setCells(tmp);
    
    
  }
}
