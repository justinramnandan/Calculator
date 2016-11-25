package calculator;

public class BooleanChecks {
	
	/**
	 * Checks if there are two operators in sequence in the array
	 * @param arr The array passed in
	 * @return true if two operators in sequence found
	 */
	
	public static boolean OperatorsPresent(String expression)
	{
		boolean flag=false;
		for(int i=0; i<expression.length();i++)
		{
			if(isOperator(String.valueOf(expression.charAt(i))))
				{
				flag=true;
				}
			
		}
		return flag;
	}
	
	
	public static boolean checkTwoOperatorsInSequence(char[] arr) {
		boolean flag = false;
		for (int i = 0; i < arr.length - 1; i++) {
			if ((arr[i] == '+' && arr[i + 1] == '+')
					|| (arr[i] == '+' && arr[i + 1] == '-')
					|| (arr[i] == '+' && arr[i + 1] == '/')
					|| (arr[i] == '+' && arr[i + 1] == '*')
					|| arr[i] == '-' && arr[i + 1] == '+'
					|| (arr[i] == '-' && arr[i + 1] == '-')
					|| (arr[i] == '-' && arr[i + 1] == '/')
					|| (arr[i] == '-' && arr[i + 1] == '*')
					|| (arr[i] == '/' && arr[i + 1] == '+')
					|| (arr[i] == '/' && arr[i + 1] == '-')
					|| (arr[i] == '/' && arr[i + 1] == '/')
					|| (arr[i] == '/' && arr[i + 1] == '*')
					|| (arr[i] == '/' && arr[i + 1] == '+')
					|| (arr[i] == '/' && arr[i + 1] == '-')
					|| (arr[i] == '/' && arr[i + 1] == '/')
					|| (arr[i] == '/' && arr[i + 1] == '*')) 
			{
				flag = true;

			}
		}
		return flag;
	}
	
	

	
	/**
	 * Checks if there is an operator on the end
	 * @param arr The array passed in
	 * @return true if an operator is on the end
	 */
	public static boolean checkOperatorsAtEnd(char[] arr)
	{
		boolean flag= false;
		if(arr[arr.length - 1] == '+' || arr[arr.length - 1] == '/'
				|| arr[arr.length - 1] == '-' 
				|| arr[arr.length - 1] == '*')
		{
			flag= true;
		}
		return flag;
	}
	/**
	 * 
	 * @param op String passed in 
	 * @return True if it is an operator
	 */
	static  boolean isOperator(String op)
	{
		boolean flag= false;
		if (op.equals("+")||op.equals("-")||op.equals("/")||op.equals("*"))
		{
			flag=true;
		}
		return flag;
	}
	/**
	 * Function to obey the rules of operation
	 * @param i The higher precedent operator
	 * @param j The lower precedent operator
	 * @return true if i is of higher precedence
	 */
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


	
}
