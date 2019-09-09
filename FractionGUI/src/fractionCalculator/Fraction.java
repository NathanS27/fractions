package fractionCalculator;

public class Fraction {

	public int numerator;
	public int denominator;
	
	public Fraction(int num, int den){
		numerator = num;
		denominator = den;
	}
	
	public Fraction(){
		numerator = 0;
		denominator = 0;
	}
	
	
	public String reduce() {
		int whole =0;
		int num =numerator;
		int den = denominator;
		String str = new String();
		
		if (num >0 && den >0) {
			for (int i = Math.min(num, den); i>0; i--){
				if (num %i == 0 && den%i == 0 ) {
					num = num /i;
					den = den /i;
				}
			}
		}
		
		else if (num <0 && den <0) {
			for (int i = Math.min(num, den); i<0; i++){
				if (num %i == 0 && den%i == 0 ) {
					num = num /i;
					den = den /i;
				}
			}
		}
		
		whole = num/den;
		num = num - (whole*den);
		
		if (whole != 0) {
			str = String.format("%d ", whole);
		}
		
		if(num != 0) {
			str += String.format("%d/%d", num, den);
		}
		
		return str;
		
	}
	
	
	
	//Negative
	public void negativeFrac () {
		if (numerator<0 && denominator<0) {
			numerator = Math.abs(numerator);
			denominator = Math.abs(denominator);
		}
	}
	
	
	public void multiply (Fraction f1, Fraction f2) {
		
		numerator = f1.numerator * f2.numerator;
		denominator = f1.denominator * f2.denominator;
		
	}
	
	public String toString (boolean reduce) {
		
		if (reduce) {
			
			return reduce();
		}
		else {
			return String.format("%d/%d", numerator, denominator);
		}
		
	}
	
	
}




