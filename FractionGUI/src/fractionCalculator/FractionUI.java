package fractionCalculator;
import javax.swing.*;
import BreezySwing.*;

public class FractionUI extends GBFrame{
	
    JLabel num1							= addLabel 			("First Fraction",			1,1,1,1);
    IntegerField num1Field			 	= addIntegerField 	(0,     	      			1,2,1,1);
    JLabel den1							= addLabel 			("/", 						1,3,1,1);
    IntegerField den1Field			 	= addIntegerField 	(0,     	      			1,4,1,1);
   
    JLabel num2				        	= addLabel			("Second Fraction",   	 	2,1,1,1);
    IntegerField num2Field			   	= addIntegerField 	(0,  	          			2,2,1,1);
    JLabel den2				        	= addLabel			("/", 		   				2,3,1,1);
    IntegerField den2Field			   	= addIntegerField 	(0,    	        			2,4,1,1);
    
    
    JButton calculate	              	= addButton 		("calculate",            	3,1,1,1);
    
    	    
    public void buttonClicked(JButton buttonObj){
        int den1, num1, den2, num2;
        
        Fraction f1,f2, f3;
        String str = "";
        
      
        if (buttonObj == calculate){
        	//inputs
            num1 = num1Field.getNumber();
            den1 = den1Field.getNumber();
            num2 = num2Field.getNumber();
            den2 = den2Field.getNumber();
            
            
            //Error Checking
            String error = "ERROR:";
            String zero = "";
            String noNum = "";
	        Boolean errorCheck = true; 
            
            while (errorCheck = true) {
	            if(den1 == 0 || den2 == 0 ) {
	            	zero = "The denominator cannot be Zero";
	            }
	            else {
	            	errorCheck = false;
	            	break;
	            }
	 
	            
	            
	            
	            
	          
	        error = String.format("%s \n %s", zero, noNum );
	        messageBox(error);
		    break;
            }
            
            //create fractions
            
            f1 = new Fraction(num1, den1);
            f2 = new Fraction(num2, den2);
            
            //Negatives
            f1.negativeFrac();
            f2.negativeFrac();
            
            //calculations
            
            f3 = new Fraction();
            f3.multiply(f1, f2);
            
            str=String.format("%s * %s = %s", f1.toString(true), f2.toString(true), f3.toString(true));
            
            messageBox(str);
        }

    }

    public static void main(String[] args){
        JFrame frm = new FractionUI();
        frm.setTitle ("Fraction Calculator");
        frm.setSize (500, 300);
        frm.setVisible (true);
   }

}







