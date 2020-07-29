// class to represent rational numbers such as 1/2

public class Rational
{
	//declare variables
	private int numerator;  
	private int denominator;
	
	
	public Rational(int numer, int denom)
	{
		numerator = numer;
		denominator = denom;
	}
	
	public int getNumerator()
	{
		return numerator;
	}
	
	public int getDenominator()
	{
		return denominator;
	}	
	

	public void setNumerator(int newNumer)
	{
		numerator = newNumer;
	}


	public void setDenominator(int newDenom)
	{
		denominator = newDenom;
	}
	
	public Rational add(Rational r)
	{
		//Rational sum;

		//cross multiply then add the two numbers
		int numer = numerator * r.denominator + denominator * r.numerator;

		//denominators mulitply with each other
		int denom = denominator * r.denominator;

		return new Rational(numer, denom);


	}

	public Rational subtract(Rational r)
	{
		//Rational diff;

		//cross multiply then subtract the two numbers
		int numer = numerator * r.denominator - denominator * r.numerator;

		//denominators multiply with each other
		int denom = denominator * r.denominator;

		return new Rational(numer, denom);

	}

	public Rational multiplication(Rational r)
	{
		Rational product;

		//multiply across
		int numer = numerator * r.numerator;

		//multiply across
		int denom = denominator * r.denominator;

		return new Rational(numer, denom);
	}

	public Rational division(Rational r)
	{
		//Rational quotient;

		int numer = numerator * r.denominator;

		int denom = denominator * r.numerator;

		return new Rational(numer, denom);
	}

	public String toString()
	{
		if (denominator == 1)
			return ""+numerator;
		else
			return numerator + "/" + denominator;
	}
	public static void main(String[] args)
	{
		Rational r1 = new Rational(1,2);
		Rational r2 = new Rational(2,4);
		Rational r3 = r1.add(r2);
		System.out.println("r3: " +r3);
	}
}