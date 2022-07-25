```java
/**
 * Rational class by Breakout Room 9
 * Greg Sciame
 * collaborators: Mike Park, Kiana H, Marieke T
 */


/**
   class Rational
   An instance of this class will represent a rational number (p/q s.t. p,q ints && q!=0),
   and facilitate mathematical operations with another instance of class Rational.

   Basic level (complete all):
   - toString
   - default constructor
   - multiply
   - divide

   Intermediate level (complete Basic methods plus these methods):
   - floatValue
   - overloaded constructor

   Advanced level (complete Basic + Intermediate + these methods):
   -

*/


public class Rational
{
  // Instance variables aka attributes for numerator and denominator
  private int _numerator;
  private int _denominator;


  // default constructor (no parameters)
  // creates a new Rational with value 0/1
  public Rational()
  {
    /* YOUR ELEGANT CODE HERE */
    this._numerator = 0;
    this._denominator = 1;
  }


  // overloaded constructor
  // takes 2 parameters, one for the numerator, one for the denominator
  // if an invalid denominator is attempted, should print a message and set the number to 0/1
  public Rational( int n, int d )
  {
    if(d != 0){
      _denominator = d;
      _numerator = n;
  } else {
      _numerator = 0;
      _denominator = 1;
      System.out.println("Invalid denominator attempted... reverting to default value of 0/1");
  }

  }
  // toString
  // returns a string representation of the rational number (formatting of your choice)
  public String toString()
  {
    /* YOUR ELEGANT CODE HERE */
    
    return(_numerator + "/" + _denominator);
  }


  // floatValue
  // returns floating point approximation of the number
  // uses the most precise floating point primitive
  public double floatValue()
  {
    if (_denominator == 0)
    {
      //this should never happen; can't produce denominator of zero by constructor OR division
      System.out.println("Error: divide by 0. Returning 0.0");
      return 0.0;
    } else
    {
      return (double) _numerator / _denominator;
    }
  }


  // multiply
  // takes a Rational parameter and multiplies it by this Rational
  // does not return a value
  // modifies this object
  // does not modify input
  // need not reduce
  public void multiply( Rational r )
  {
    //multiply numerator by r's numerator and denominator by r's denominator
    this._numerator *= r._numerator;
    this._denominator *= r._denominator;
    this.reduce();
  }


  // divide
  // same as multiply, except operation is division
  public void divide( Rational r )
  {
    //if r's numerator is 0, then multiplying by the reciprocal will produce a denominator of 0
    if (r._numerator == 0){
      System.out.println("Error: divide by 0. Value is still " + this);
    }
    else {
      //multiply this fraction by reciprocal of r
      this._numerator *= r._denominator;
      this._denominator *= r._numerator;
      this.reduce();
    }
  }

  public int gcd(int n, int d){
    int gcd = 1;
    //check values between 2 and smaller int for divisibility into both ints
    for (int i = 2; i <= Math.min(n, d); i++)
    {
      if (n % i == 0 && d % i == 0){
        gcd = i;
      }
    }
    return gcd;
  }
  //reduces the rational number to lowest terms
  public void reduce(){
    int gcf = gcd(this._numerator, this._denominator); 
    
    //divide both numerator and denominator by gcf
    _numerator /= gcf;
    _denominator /= gcf;
  }

  public boolean equals(Rational other)
  {
    this.reduce();
    other.reduce();
    return (this._numerator == other._numerator && this._denominator == other._denominator);
  }

  public int compareTo(Rational other)
  {
    int result;
    //make denominators match by multiplying both rationals by opposite denominator
    Rational temp1 = new Rational(this._numerator*other._denominator, this._denominator*other._denominator); //this 
    Rational temp2 = new Rational(other._numerator*this._denominator, other._denominator*this._denominator); //other
    if (temp1._numerator > temp2._numerator)
    {
      result = 1;
    }
    else if (temp1._numerator < temp2._numerator)
    {
      result = -1;
    }
    else
    {
      result = 0;
    }
    return result;
  }

  
}//end class
```
