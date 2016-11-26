package calculator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QuadGui extends JPanel {

	JTextField aNum, bNum,cNum;
	JLabel aNumLabel, bNumLabel,cNumLabel, answerMinus,answerPlus,actualAnswerMinus,actualAnswerPlus;
	JButton calculate;
	
	public QuadGui()
	{
		setLayout(new FlowLayout());
		
		aNum= new JTextField(10);
		bNum= new JTextField(10);
		cNum= new JTextField(10);
		
		aNumLabel= new JLabel("a");
		bNumLabel= new JLabel ("b");
		cNumLabel= new JLabel ("c");
		
		answerMinus= new JLabel("(b-4ac)/2a = ");
		answerPlus= new JLabel("(b+4ac)/2a = ");
		
		actualAnswerMinus= new JLabel("");
		actualAnswerPlus= new JLabel("");
		
		calculate= new JButton("Calculate");
		
		calculate.addActionListener(new ButtonListener());
		
		add(aNumLabel);
		add(aNum);
		add(bNumLabel);
		add(bNum);
		add(cNumLabel);
		add(cNum);
		add(calculate);
		add(answerMinus);
		add(actualAnswerMinus);
		add(answerPlus);
		add(actualAnswerPlus);
		
	}
	
	public class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub

			if(event.getSource()== calculate)
			{
				double a=Double.parseDouble(aNum.getText());
				double b=Double.parseDouble(bNum.getText());
				double c=Double.parseDouble(cNum.getText());
				
				actualAnswerMinus.setText(CalcMath.quadriaticFormulaNegative(a, b, c));
				actualAnswerPlus.setText(CalcMath.quadriaticFormulaPositive(a, b, c));
				
				
			}
			
		}
}
}
