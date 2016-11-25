package calculator;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class CalcGui extends JPanel {
	JTextField display;
	JButton one, two, three, four, five, six, seven, eight, nine, equal, multiply, divide, subtract, add, clear;
    
	/**
	 * This function takes what is in the display and adds spaces in the appropriate places
	 * for splitting later
	 * 
	 * @param expression This will be what is typed in the display
	 * @return the function with the spaces
	 */
	private String addSpaces(String expression)
	{
		StringBuilder sb= new StringBuilder();
		
		for(int i=0; i<display.getText().length();i++)
		{
			if(BooleanChecks.isOperator(String.valueOf(display.getText().charAt(i))))
			{
				sb.append(" " + String.valueOf(display.getText().charAt(i)+ " "));
			}
			else
			{
				sb.append(String.valueOf(display.getText().charAt(i)));
			}
		}
		
		String withSpaces=sb.toString();
		
		return withSpaces;
	}
	/**
	 * Adds input to the display JLabel
	 * @param text the text that needs to be added
	 */
	
	private  void addtoDisplay(String text)
	{
		display.setText(display.getText()+text);
	}

	/**
	 * Constructor
	 */
	
	CalcGui() {
		setLayout(new FlowLayout());

		display = new JTextField(25);
		
        clear= new JButton("CE");
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		equal = new JButton("=");
		multiply = new JButton("*");
		divide = new JButton("/");
		subtract = new JButton("-");
		add = new JButton("+");

	display.setPreferredSize(new Dimension(35,35));
		
		JButton arr[] = {clear,one,two,three, four ,five, six,seven,eight, nine ,equal,multiply,divide,subtract,add};
		
		
		for(int i=0; i<arr.length;i++)
		{
			arr[i].setPreferredSize(new Dimension(75,75));
		}
		
		clear.addActionListener(new ButtonListener());
		one.addActionListener(new ButtonListener());
		two.addActionListener(new ButtonListener());
		three.addActionListener(new ButtonListener());
		four.addActionListener(new ButtonListener());
		five.addActionListener(new ButtonListener());
		six.addActionListener(new ButtonListener());
		seven.addActionListener(new ButtonListener());
		eight.addActionListener(new ButtonListener());
		nine.addActionListener(new ButtonListener());
		equal.addActionListener(new ButtonListener());
		multiply.addActionListener(new ButtonListener());
		divide.addActionListener(new ButtonListener());
		
		subtract.addActionListener(new ButtonListener());
		add.addActionListener(new ButtonListener());

		add(display);
		add(clear);
		add(one);
		add(two);
		add(three);
		add(four);
		add(five);
		add(six);
		add(seven);
		add(eight);
		add(nine);
		add(multiply);
		add(divide);
		add(subtract);
		add(add);
		add(equal);
		
	}

	class ButtonListener implements ActionListener  {

		
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub

			

			if (event.getSource() == one) {
				
				addtoDisplay("1");
				
			} 
			else if(event.getSource()==clear)
			{
			  display.setText(null);	
			}
			
			else if (event.getSource() == two) {
			
				addtoDisplay("2");
				
			} else if (event.getSource() == three) {
				
				addtoDisplay("3");
				
			} else if (event.getSource() == four) {
				
				addtoDisplay("4");
			} else if (event.getSource() == five) {
				
				addtoDisplay("5");
				
			} else if (event.getSource() == six) {
				
				addtoDisplay("6");
				
			} else if (event.getSource() == seven) {
				
				addtoDisplay("7");
				
				
			} else if (event.getSource() == eight) {
				
				addtoDisplay("8");
				
			} else if (event.getSource() == nine) {
				
				addtoDisplay("9");
			}

			else if (event.getSource() == multiply) {
				
				addtoDisplay("*");
				
			} else if (event.getSource() == divide) {
				
				addtoDisplay("/");
				
			} else if (event.getSource() == subtract) {
				
				addtoDisplay("-");
				
			} else if (event.getSource() == add) {
				
				addtoDisplay("+");
				
			} else if (event.getSource() == equal) {
				String store1 = display.getText().replaceAll("\\s", "");
				char[] store1toArr = store1.toCharArray();

				if (BooleanChecks.checkOperatorsAtEnd(store1toArr)) {
					display.setText("ERROR! OPERATOR AT END");
				}
				else if (BooleanChecks.checkTwoOperatorsInSequence(store1toArr))
				{
					display.setText("ERROR! TWO OPERATORS IN SEQUENCE");
				}

				else {
					
					String addedSpaces=addSpaces(display.getText());
					
					String converttoPostFix=StringManipulation.postFixConversion(addedSpaces);
					String answer= CalcMath.solveEquation(converttoPostFix);
					
					display.setText(answer);
					
					

						}

					}
					
				
					
					
				}

			}


	}

