/**
 * @author GeorgeMakhali
 */
package hw3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import api.AbstractGame;
import api.Generator;
import api.Icon;
import api.Position;


public class BlockAddiction extends AbstractGame {
/**
 * Constructor for BlockAddiction class
 * @param height height specified
 * @param width width specified
 * @param gen generator
 */ 
	public BlockAddiction(int height, int width, Generator gen) {
		//calling super constructor
		super(height, width, gen);
	}
/**
 * Constructor for  Block Addiction class the takes an extra parameter prefill rows
 * @param height height specified
 * @param width width specified
 * @param gen generator 
 * @param preFillRows  number of rows to be prefilled
 */
	public BlockAddiction(int height, int width, Generator gen, int preFillRows) {
		super(height, width, gen);
		if(preFillRows > 0 )
		{
			prefilling(preFillRows);
		}
	}
	
/**
 * Helper method to do the prefilling
 * @param rowsToFill rows to be prefilled when the game starts
 */
	private void prefilling(int rowsToFill) {
		// new Random
		Random rand = new Random();
		//new BasicGenerator
		BasicGenerator gen1 = new BasicGenerator(rand);
		// looping through the area to be prefilled
		for(int i = getHeight() - 1  -rowsToFill; i < getHeight() - 1 ; i++)
		{
			//loop in 2d
			for(int j = 0 ; j < getWidth(); j +=1)
			{
				// check the required conditions to prefill
				if((i%2 == 0 && j %2 == 0) || (i%2 != 0 && j%2 != 0)) {
				setBlock(i,j,gen1.randomIcon());
			
				}
			}
		}
	}

	
	@Override
	public List<Position> determinePositionsToCollapse() {
		//create array positionList of coordinates, not x & y
		List<Position> coordinates = new ArrayList<Position>();
	    for (int i = 0; i < getHeight(); i++)
	    {	
 	        for (int j = 0; j < getWidth(); ++j)
	        {
 	        	//looping in two dimensions
	        	if(getIcon(i,j) != null)
	        	{   		
	        		//if it doesn't have icon , adjust positions to check
	        		//up, right, left, and down
	        		// a cross pattern for each time a null cell is found
	        		Position [] positionList = { 
	        				new Position(i - 1, j),
	        				new Position(i, j + 1), 
	        				new Position(i, j - 1),
	        				new Position(i + 1, j)
	        				};
	        		
	        		ArrayList<Position> list1 = new ArrayList<Position>();
	        		ifNull(i,j,positionList,list1);
	        		// if the list1 items is larger than two, add new position and loop 
	        		if(list1.size() >=2 )
	        		{
	        			coordinates.add(new Position(i,j));
	        			for (int k = 0; k < list1.size(); k++)
	        			{
	        				coordinates.add(list1.get(k));
	        			}
	        		}
	        	}
	        }
	      
	    }
	    //sort the array of coordinates, NOT x,y
	 		Collections.sort(coordinates);
	 		return coordinates;
	}
	
	private void ifNull(int row, int col, Position[] positionList,ArrayList<Position> list1 ) {
		for (int pos = 0; pos < positionList.length; pos++)
		{
			//loop through the adjusted positions
			Position temp = positionList[pos];
			//check for coordinates
			// else will throw an exception
			if(temp.row() >= 0 && temp.col() >= 0 ) 
			{
				//check for boundaries
				if( temp.row() < getHeight() && temp.col() < getWidth()) {
					//check the matches and add it to the positionList
					if(getIcon(row,col).matches(getIcon(temp.row(), temp.col())))
					{
						list1.add(temp);
					}
				}
			}			
		}
	}
	

}
