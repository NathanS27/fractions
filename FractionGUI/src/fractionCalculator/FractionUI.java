package fractionCalculator;

import javax.swing.*;
import BreezySwing.*;
//test
public class FractionUI extends GBFrame {

	JLabel num1 = addLabel										("First Fraction",		 1, 1, 1, 1);
	IntegerField num1Field = addIntegerField					(0,						 1, 2, 1, 1);
	JLabel den1 = addLabel										("/",					 1, 3, 1, 1);
	IntegerField den1Field = addIntegerField					(0, 					 1, 4, 1, 1);

	JLabel num2 = addLabel										("Second Fraction",		 2, 1, 1, 1);
	IntegerField num2Field = addIntegerField					(0,						 2, 2, 1, 1);
	JLabel den2 = addLabel										("/",					 2, 3, 1, 1);
	IntegerField den2Field = addIntegerField					(0,						 2, 4, 1, 1);

	JButton multiply = addButton								("multiply",			 3, 1, 1, 1);
	JButton divide = addButton									("divide",				 3, 3, 1, 1);

	public void buttonClicked(JButton buttonObj) {
		int den1 =0;
		int num1 = 0;
		int den2 = 0;
		int num2 = 0;
		Fraction f1, f2, f3;
		String str = "";

		if (buttonObj == multiply || buttonObj == divide) {

			String inputError = "";
			Boolean valid = true; 
			
			// Ensures all four inputs are integers
			if (num1Field.isValidNumber()) {
				num1 = num1Field.getNumber();
			}
			else {
				inputError += "Numerator 1 must be a valid integer \n";
				valid = false;
			}
			if (num2Field.isValidNumber()) {
				num2 = num2Field.getNumber();
			}
			else {
				inputError += "Numerator 2 must be a valid integer \n";
				valid = false;
			}
			if (den1Field.isValidNumber()) {
				den1 = den1Field.getNumber();
				if(den1 == 0) {
					inputError +="Denominator 1 cannot equal 0 \n";
					valid = false;
				}
			}
			else {
				inputError += "Denominator 1 must be a valid integer \n";
				valid = false;
			}
			if (den2Field.isValidNumber()) {
				den2= den2Field.getNumber();
				if(den2 == 0) {
					inputError +="Denominator 2 cannot equal 0 \n";
					valid = false;
				}
			}
			else {
				inputError += "Denominator 2 must be a valid integer";
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
					str = String.format("%s * %s = %s", f1.toString(true), f2.toString(true), f3.toString(true));
				}
				else {
					f3.divide(f1, f2);
					str = String.format("%s / %s = %s", f1.toString(false), f2.toString(false), f3.toString(false));
				}
				
				messageBox(str);
			}
		}	
	}

	public static void main(String[] args) {
		JFrame frm = new FractionUI();
		frm.setTitle("Fraction Calculator");
		frm.setSize(500, 300);
		frm.setVisible(true);
	}
}