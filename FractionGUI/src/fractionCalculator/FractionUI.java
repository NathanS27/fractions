package fractionCalculator;

import javax.swing.*;
import BreezySwing.*;
import java.awt.*;
import java.awt.geom.*;

public class FractionUI extends GBFrame {

	JLabel space1 = addLabel									("		",				 3, 1, 1, 1);
	JLabel space2 = addLabel									("		",				 3, 4, 1, 1);
	
	JLabel num1 = addLabel										("First Fraction",		 1, 2, 1, 1);
	JTextField num1Field = addTextField							(null,					 1, 3, 1, 1);
	JTextField den1Field = addTextField							(null, 					 2, 3, 1, 1);

	JLabel num2 = addLabel										("Second Fraction",		 4, 2, 1, 1);
	JTextField num2Field = addTextField							(null,					 4, 3, 1, 1);
	JTextField den2Field = addTextField							(null,					 5, 3, 1, 1);

	JButton multiply = addButton								("multiply",			 7, 2, 1, 1);
	JButton divide = addButton									("divide",				 7, 3, 1, 1);

	public void buttonClicked(JButton buttonObj) {
		int den1 = 0;
		int num1 = 0;
		int den2 = 0;
		int num2 = 0;
		Fraction f1, f2, f3;
		String str = "";

		String inputError = "";
		Boolean valid = true; 
		
		// Ensures all four inputs are integers
		try {
			num1 = Integer.parseInt(num1Field.getText());
		}
		catch (NumberFormatException e) {
			inputError += "Numerator 1 must be a valid integer \n";
			valid = false;
		}
		
		try {
			num2 = Integer.parseInt(num2Field.getText());
		}
		catch (NumberFormatException e) {
			inputError += "Numerator 2 must be a valid integer \n";
			valid = false;
		}
		
		try {
			den1 = Integer.parseInt(den1Field.getText());
		}
		catch (NumberFormatException e) {
			inputError += "Denominator 1 must be a valid integer \n";
			valid = false;
		}
		
		try {
			den2 = Integer.parseInt(den2Field.getText());
		}
		catch (NumberFormatException e) {
			inputError += "Denominator 2 must be a valid integer \n";
			valid = false;
		}
		
		if(!valid) { 	
			messageBox(inputError);
		}
		else {
			
			f1 = new Fraction(num1, den1);
			f2 = new Fraction(num2, den2);
			
			f3 = new Fraction();
			
			if(buttonObj ==multiply) {
				f3.multiply(f1, f2);
				str = String.format("%s * %s = %s", f1.toString(true), f2.toString(true ), f3.toString(true));
			} 
			else {
				f3.divide(f1, f2);
				str = String.format("%s / %s = %s", f1.toString(true), f2.toString(true), f3.toString(true));
			}
			
			//prints final answer
			messageBox(str);
		}
	}	
	
	//draws lines between numerator and denominator
	public void paint(Graphics g) {
		super.paint(g); //calls the base to paint itself before adding additional graphics
		Graphics2D g2 = (Graphics2D) g;
		Line2D frac1 = new Line2D.Float(250, 63, 425, 63);
		g2.draw(frac1);
		Line2D frac2 = new Line2D.Float(250, 187, 425, 187);
		g2.draw(frac2);
	}
	
	public static void main(String[] args) {
		JFrame frm = new FractionUI();
		frm.setTitle("Fraction Calculator");
		frm.setResizable (false);
		frm.setSize(500, 300);
		frm.setVisible(true);
	}
}