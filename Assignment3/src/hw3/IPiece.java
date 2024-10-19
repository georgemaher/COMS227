
package hw3;
/**
 * @author GeorgeMakhali
 */

import api.Cell;
import api.Icon;
import api.Position;

public class IPiece extends AbstractPiece {

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
	 * Constructor for IPiece
	 * @param position
	 * @param icons
	 */
	public IPiece(Position position, Icon[] icons) {
		super(position);
		iconsArr = icons;
		Cell[] cls = new Cell[3];
		if(icons.length != 3) { // check for icons length to match the needed length
			//Exception IllegalArgumentException = null;
			throw new IllegalArgumentException();
		}
		cls[0] = new Cell(iconsArr[0], IPiece.sequence[1]);
		cls[1] = new Cell(this.iconsArr[1] ,IPiece.sequence[IPiece.sequence.length-2]);
		cls[2] = new Cell(this.iconsArr[2] , IPiece.sequence[7]);
		setCells(cls);	
	}

	@Override
	public void transform() {
		return;
	}
}
