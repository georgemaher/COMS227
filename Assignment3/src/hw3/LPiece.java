/**
 * @author GeorgeMakhali
 */
package hw3;

import api.Cell;
import api.Icon;
import api.Position;

public class LPiece extends AbstractPiece {

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
		 
	
	public LPiece(Position position, Icon[] icons) {
		super(position);
		   
	    iconsArr = icons;
	    Cell[] cls = new Cell[4];
	    if(icons.length != 4) {// check if the icon array length matches what is needed
//	      Exception IllegalArgumentException = null;
	  		throw new IllegalArgumentException();
	      }
	    cls[0] = new Cell(iconsArr[0], LPiece.sequence[0]);
	    cls[1] = new Cell(this.iconsArr[1] ,LPiece.sequence[1]);
	    cls[2] = new Cell(this.iconsArr[2] , LPiece.sequence[4]);
	    cls[3] = new Cell(this.iconsArr[3], LPiece.sequence[7]);
	    setCells(cls);	
	}

	@Override
	public void transform() {
		//create a deep copy
		Cell[] tmp = new Cell[getCells().length];
		tmp = getCells();
		//make the transform
		if(tmp[0].getCol() == 0) {
			tmp[0].setPosition(new Position(0,2));
		}
		else {
			tmp[0].setPosition(new Position(0,0));
		}
		setCells(tmp);
	}
}
