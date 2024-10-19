package mini2;

import java.util.ArrayList;

/**
 * Implementation of a version of the "twenty-four" game.
 */
public class NumberGame {

	  public static void main(String[] args) {
		  IntExpression e1 = new IntExpression(1);
	        IntExpression e2 = new IntExpression(2);
	        IntExpression e3 = new IntExpression(3);
	        IntExpression e4 = new IntExpression(4);
	        ArrayList<IntExpression> k = new ArrayList<IntExpression>();
	        k.add(e1);
	        k.add(e2);
	        k.add(e3);
	       k.add(e4);
	        ArrayList<String> st = new ArrayList<String>();
	        findSolution(k , 30 , st);
	    }
	
	public static void findSolution(ArrayList<IntExpression> list, int target, ArrayList<String> results) {
//		Pseudocode  
//		step 1: if the list has length 1 
//		  if the value matches the target  
//		    add it to the list of results 		
		if(list.size() == 0) {
			return;
		}
		if(list.size() == 1)
	    {
	    	if(list.get(0).getIntValue() == target)
	    	{
	    		results.add(list.get(0).toString());
	    	}
	    }
	    else
	    {
//	    	  step2:
	    	//otherwise 
//	    	  for each number x in the list 
//	    	    create a copy of the list that does not include x 
//	    	    find solutions using that list 
	    	for(IntExpression exp : list)
			{
	    		//creating a duplicate
				ArrayList<IntExpression> newList = new ArrayList<IntExpression>(list);
//				System.out.print(" " + exp.getIntValue());
				//remove one 
				newList.remove(exp);
//				System.out.println(" " + newList.size());
				//recursion of the new list modified to find a solution
				findSolution(newList, target, results);
			}
	    	
	    	
//	    	step 3 :for each pair of numbers x, y in the list 
//	        for each allowable arithmetic combination z of x and y 
//	          create a copy of the list without x and y, but with z added 
//	          find solutions using that list 
//	    	
	    	for(int i = 0; i < list.size(); i++)
			{ 
	    		
//	    	
	    		// taking out one exp
				IntExpression exp1 = list.get(i);
//				System.out.println(" " +exp1.getIntValue());
				ArrayList<IntExpression> subList = new ArrayList<IntExpression>(list);
				//removing the selected exp and loop through the sublist
				subList.remove(i); 
				for(int j = 0; j < subList.size(); j++)
				{
					// taking the next exp 
					IntExpression exp2 = subList.get(j);
//					System.out.println(" " +exp2.getIntValue());
					ArrayList<IntExpression> subList2 = new ArrayList<IntExpression>(subList);
	    			//removing it from the list
					subList2.remove(j);
					//applying arithemtic operation +
					//assuming 
	    			IntExpression exp3 = new IntExpression(exp1, exp2, '+');
//	    			System.out.println(" " +exp3.getIntValue());
	    			// adding to the list to the end of the list recursive through
	    			subList2.add(exp3);
	    			// will be added to out
	    			findSolution(subList2, target, results);
	    			
	    			findSolutionRec(subList2 , exp1,exp2,'-',target, results);
	    			//same for multiplying
	    			findSolutionRec(subList2 , exp1,exp2,'*',target, results);
	    			//checking for division conditions
	    			// check for zero first to avoid diving by zero for second condition
	    			
	    			if(exp2.getIntValue() != 0  )
	    			{
	    				if (exp1.getIntValue() % exp2.getIntValue() == 0) {
	    				findSolutionRec(subList2 , exp1,exp2,'/',target, results);
	    			
	    				}
	    			}
				}
			}
	    	
	    }
//		printList(results);
	}	
	private static void findSolutionRec(ArrayList<IntExpression> subList2,IntExpression e1 , IntExpression e2,char op ,int target, ArrayList<String> results) {
		//performing arithmetic operation by selected char
		IntExpression exp = new IntExpression(e1, e2, op);
//		System.out.println(" " +exp.getIntValue());
		
		subList2.set(subList2.size() - 1, exp);
		//recursion
		findSolution(subList2, target, results);
		
	}
	private static void printList(ArrayList<String> liststr) {
		ArrayList<String> tmp = new ArrayList<String>();
    	for(String x : liststr) {
    		if(!tmp.contains(x)) {
    			tmp.add(x);
    		}
    	}
    	for(String s: tmp) {
			System.out.println(s);	
		}	
	}
}