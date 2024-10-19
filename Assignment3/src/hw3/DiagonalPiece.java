package hw3;

import api.Icon;
import api.Cell;
import api.Position;

public class DiagonalPiece extends AbstractPiece {

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
	 * constructor for CornerPiece
	 * @param position
	 * @param icons icons array
	 */
	public DiagonalPiece(Position position, Icon[] icons) {
		super(position);
		iconsArr = icons;
	    Cell[] cls = new Cell[2];
	    if(icons.length != 2) {// check for the length of icons
//	      Exception IllegalArgumentException = null;
	  		throw new IllegalArgumentException();
	      }
	    cls[0] = new Cell(iconsArr[0], DiagonalPiece.sequence[0]);
	    cls[1] = new Cell(this.iconsArr[1] ,DiagonalPiece.sequence[DiagonalPiece.sequence.length-2]);
	    setCells(cls);	}

	@Override
	public void transform() {
		// deep copy
		Cell[] tmp = new Cell[getCells().length];
		tmp = getCells();
		// doing the transformation
		if(tmp[0].getCol() == 0) {
			tmp[0].setPosition(DiagonalPiece.sequence[1]);
			tmp[1].setPosition((DiagonalPiece.sequence[(DiagonalPiece.sequence.length-1)]));
		}
		else if(tmp[0].getCol()==1) {
			tmp[0].setPosition(DiagonalPiece.sequence[0]);
			tmp[1].setPosition(DiagonalPiece.sequence[DiagonalPiece.sequence.length-2]);
			}
		setCells(tmp);
	}
}
