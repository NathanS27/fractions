package fractionCalculator;

public class Fraction {

	public int numerator;
	public int denominator;

	public Fraction(int num, int den) {
		numerator = num;
		denominator = den;
	}

	public Fraction() {
		numerator = 0;
		denominator = 0;
	}

	public String reduce() {
		Boolean negative = numerator * denominator < 0;
		int num = Math.abs(numerator);
		int den = Math.abs(denominator);
		int whole;
		String str = new String();

		if (num > 0 && den > 0) {
			for (int i = Math.min(num, den); i > 0; i--) {
				if (num % i == 0 && den % i == 0) {
					num = num / i;
					den = den / i;
				}
			}
		}
		whole = num / den;
		num = num - (whole * den);

		//add sign back in
		if (negative) {
			if (whole>0) {
				whole = -whole;
			}
			else {
				num = -num;
			}
		}
		
		if (whole != 0) {
			str = String.format("%d ", whole);
		}

		if (num != 0) {
			str += String.format("%d/%d", num, den);
		}

		return str;
	}

	// Multiply
	public void multiply(Fraction f1, Fraction f2) {
		numerator = f1.numerator * f2.numerator;
		denominator = f1.denominator * f2.denominator;
	}
	
	// Divide
		public void divide(Fraction f1, Fraction f2) {
			numerator = f1.numerator / f2.numerator;
			denominator = f1.denominator / f2.denominator;
		}

	public String toString(boolean reduce) {
		if (reduce) {
			return reduce();
		} else {
			return String.format("%d/%d", numerator, denominator);
		}
	}
}