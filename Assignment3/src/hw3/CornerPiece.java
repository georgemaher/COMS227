package hw3;
/**
 * @author GeorgeMakhali
 */
import api.Cell;
import api.Icon;
import api.Position;

public class CornerPiece extends AbstractPiece {
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
	 * Constructor for CornerPiece
	 * @param position
	 * @param icons array of icons
	 */
	public CornerPiece(Position position, Icon[] icons) {
		super(position);
		 iconsArr = icons;
		    Cell[] cls = new Cell[3];
		    if(icons.length != 3) {// check for the length of icons array
//		      Exception IllegalArgumentException = null;
		  		throw new IllegalArgumentException();
		      }
		    cls[0] = new Cell(iconsArr[0], CornerPiece.sequence[1]);
		    cls[1] = new Cell(this.iconsArr[1] ,CornerPiece.sequence[0]);
		    cls[2] = new Cell(this.iconsArr[2] , CornerPiece.sequence[CornerPiece.sequence.length-1]);
		    setCells(cls);	
		
	}

	@Override
	public void transform() {
		// deep copy
		Cell[] tmp = new Cell[getCells().length];
		tmp = getCells();
		// making the transformations
		for(int i = 0; i < tmp.length ; i++) {
			if(tmp[i].getRow() == 0 && tmp[i].getCol() == 0) {
				tmp[i].setPosition(CornerPiece.sequence[1]);
			}
			else if (tmp[i].getRow() == 1 && tmp[i].getCol() == 0) {
				tmp[i].setPosition(CornerPiece.sequence[0]);
			}
			else if (tmp[i].getRow() == 1 && tmp[i].getCol() == 1) {
				tmp[i].setPosition(CornerPiece.sequence[CornerPiece.sequence.length-1]);
			}
			else {
				tmp[i].setPosition(CornerPiece.sequence[CornerPiece.sequence.length-2]);
			}
		}
		setCells(tmp);
	}
}
