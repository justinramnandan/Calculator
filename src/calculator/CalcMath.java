package calculator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class CalcMath {
	
	public static String hexaConversion(String expression)
	{
		StringBuilder sb= new StringBuilder();
		int number= Integer.parseInt(expression);
		int remainder;
		String hexaDecimal;
		
		while(number!=0)
		{
			remainder= number%16;
			
			if(remainder >=10)
			{
				switch (remainder)
				{
				case 10:
					sb.append("A");
					break;
				case 11:
					sb.append("B");
					break;
				case 12:
					sb.append("C");
					break;
				case 13:
					sb.append("D");
					break;
				case 14:
					sb.append("E");
					break;
				case 15:
					sb.append("F");
				}
			}
			else
			{
				sb.append(Integer.toString(remainder));
			}
			number= number/16;
			
		}
		hexaDecimal= sb.toString();
		return hexaDecimal;
	}
	
	
	public static String quadriaticFormulaPositive(double a, double b, double c)
	{
		//b+sqrt b^2 -4ac
		
		
		
		double bsquared= Math.pow(b, 2);
		double complex= Math.sqrt(bsquared-4*a*c);
		
		double quadriatic= (b+ complex)/(2*a);
		
		
		String	quadriaticToString= Double.toString(quadriatic);
		
		return quadriaticToString;
		
		
	}
	
	public static String quadriaticFormulaNegative(double a, double b, double c)
	{
		
		
		
		double quadriatic = (b - Math.sqrt(Math.pow(b, 2) - 4*a*c))/(2*a); 
		
		String	quadriaticToString= Double.toString(quadriatic);
		
		return quadriaticToString;
		
		
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
			 if(!operators.isEmpty() && higherPrecedence(expression1[i], operators.peek()))
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
	
	static boolean higherPrecedence(String i, String j)
	{
		boolean flag= false;
		if(i.equals("*")&& j.equals("+")|| i.equals("*")&&j.equals("-")
				|| i.equals("/") && j.equals("+") || i.equals("/")&& j.equals("-"))
		{
			flag=true;
		}
		return flag;
	}
	
	
	
	public static String convertToBinary(String expression)
	{
		boolean operatorFound=false;
		int currentNum=0;
		int remainder=0;
		String binaryConversion = null;
		StringBuilder sb= new StringBuilder();
		
		if(BooleanChecks.OperatorsPresent(expression))
		{
		for(int i=0; i<expression.length()&&operatorFound==false;i++)
		{
			operatorFound=true;
				
				String expression1=StringManipulation.addSpaces(expression);
				String expression2=StringManipulation.postFixConversion(expression1);
				String expression3=CalcMath.solveEquation(expression2);
			
				double convert=Double.parseDouble(expression3);
				int convert2 = (int) convert;
				
				currentNum=convert2;
				
				while(currentNum!=0)
				{
					remainder= currentNum % 2;
					sb.append(remainder);
					
					currentNum=currentNum/2;
					
					
				}
				
				binaryConversion=sb.reverse().toString();
				
				
			}
			
		
			}
		
		
		else
		{
			currentNum=Integer.parseInt(expression);
			
			while(currentNum!=0)
			{
				remainder= currentNum % 2;
				sb.append(remainder);
				
				currentNum=currentNum/2;
				
				
			}
			
			binaryConversion=sb.reverse().toString();
			
			
		}
		
		return binaryConversion;
		}
	
	
	
	
	public static String solveEquation(String expression)
		{
			
			
		StringBuilder sb= new StringBuilder();
			
		String[] split= expression.split(",");

		
		LinkedList<String> list = new LinkedList();	
		double answer = 0;
		String finalAnswer = null;
	
			for(int i=0; i<split.length;i++)
			{
				
				list.add(split[i]);
				
			}
			
			int num=0;
			
				
				while(list.size()!=1)
				{
				
					if(list.size()==1)
					{
						finalAnswer=list.peek().toString();
						break;
					}
					
					
				String test=list.get(num);
				if(BooleanChecks.isOperator(test))
				{
					
					int oneBefore= num-1;
					int twoBefore = num-2;
					String operator= list.remove(num);
					String operand1= list.remove(oneBefore);
					String operand2 =list.remove(twoBefore);
					//convert char to int
					
					double op1= Double.parseDouble(operand1);
					double op2= Double.parseDouble(operand2);
					
					switch (operator)
					{
					case "+":
					 answer= op2+op1;
					break;
					
					case "-":
						answer= op2-op1;
					break;
					case "*":
						answer= op2*op1;
						break;
					case "/":
						answer= op2/op1;
					}
					
					list.add(0, Double.toString(answer));
					num=0;
				}
					else{
						num++;
					}
				}
				
				if(list.size()==1)
				{
					finalAnswer=list.peek().toString();
				}
				
				
			
		
			
			
			return finalAnswer;
		} 

			
		}

