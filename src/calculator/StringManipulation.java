package calculator;

import java.util.LinkedList;
import java.util.Stack;

public class StringManipulation {

	/**
	 * Converts an inFix expression to a postFix expression
	 * @param expression inFix expression
	 * @return postFix expression
	 */
	
	public static String addSpaces(String expression)
	{
		StringBuilder sb= new StringBuilder();
		String addedSpaces = null;
		for(int i=0; i<expression.length();i++)
		{
		if(BooleanChecks.isOperator(String.valueOf(expression.charAt(i))))
		{
		    sb.append(" " +expression.charAt(i)+ " ");	
		}
		else
		{
			sb.append(expression.charAt(i));
		}
		addedSpaces= sb.toString();
		
		}
		return addedSpaces;
	}
	
	
	public static String postFixConversion(String expression)
	{
	  String[] expression1=expression.split(" ");
	  String postFix=null;
	  StringBuilder sb = new StringBuilder();
	  LinkedList operands= new LinkedList();
	  Stack<String> operators = new Stack<>();
	  for(int i=0;i<expression1.length;i++)
	  {
		  String test =expression1[i];
		  if(BooleanChecks.isOperator(test))
		  {
			 if(!operators.isEmpty() && BooleanChecks.higherPrecedence(expression1[i], operators.peek()))
			 {
			    operators.push(expression1[i]);
			 }
			 else
			 {
				 if(!operators.isEmpty())
				 {
				   while(!operators.isEmpty())
				   {
					   operands.add(operators.pop());
				   }
				 }
				 operators.push(expression1[i]);
				 
			 }
		  }
		  else
		  {
			  operands.add(expression1[i]);
		  }
	  }
	  
	  while(!operators.isEmpty())
	  {
		  operands.add(operators.pop());
	  }
	  
	 while(!operands.isEmpty())
	 {
		 sb.append(operands.pop()+ ",");
	 }
	  
	 postFix=sb.toString();
	  
	  return postFix;
	}
	
}
