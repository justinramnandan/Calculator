
package calculator;

import java.awt.Dimension;
import java.util.LinkedList;

import javax.swing.JFrame;

public class CalcDriver  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		CalcGui calc= new CalcGui();
		
		frame.setTitle("My Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 500);
		frame.setVisible(true);
		frame.getContentPane().add(calc);
		
		
		
	
	}

}
