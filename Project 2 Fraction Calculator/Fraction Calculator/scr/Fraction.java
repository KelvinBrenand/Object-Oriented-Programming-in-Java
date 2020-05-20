public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator){
        if (denominator == 0){
            throw new IllegalArgumentException("The denominator must be greater than 0.");
        }
        if (denominator < 0){
            numerator = numerator*(-1);
            denominator = denominator*(-1);
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(int numerator){
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction(){
        this.numerator = 0;
        this.denominator = 1;
    }

    public int getNumerator(){
        return numerator;
    }

    public int getDenominator(){
        return denominator;
    }

    public String toString(){
        if (this.denominator == 1){
            return Integer.toString(this.numerator);
        }else {
            return numerator + "/" + denominator;
        }
    }

    public double toDouble(){
        return (double) numerator/denominator;
    }

    public Fraction add(Fraction other){
        if (this.denominator == other.denominator){
            return new Fraction(this.numerator + other.numerator, this.denominator);
        }else {
            int newDen = this.denominator*other.denominator;
            int newNum = (((newDen/this.denominator)*this.numerator) + ((newDen/other.denominator)*other.numerator));

            return new Fraction(newNum, newDen);
        }
    }

    public Fraction subtract(Fraction other){
        if (this.denominator == other.denominator){
            return new Fraction(this.numerator - other.numerator, this.denominator);
        }else {
            int newDen = this.denominator*other.denominator;
            int newNum = (((newDen/this.denominator)*this.numerator) - ((newDen/other.denominator)*other.numerator));

            return new Fraction(newNum, newDen);
        }
    }

    public Fraction multiply(Fraction other){
        return new Fraction(this.numerator*other.numerator, this.denominator*other.denominator);
    }

    public Fraction divide(Fraction other){
        return new Fraction(this.numerator*other.denominator, this.denominator*other.numerator);
    }

    public boolean equals(Object other){
        if (other instanceof Fraction){
            Fraction otherNew = (Fraction) other;
            return (this.numerator/this.denominator == otherNew.numerator/otherNew.denominator);
        }else {
            throw new IllegalArgumentException("Fraction object expected");
        }
    }

    public void toLowestTerms(){
        int i = gcd(this.numerator, this.denominator);
        this.numerator = this.numerator/i;
        this.denominator = this.denominator/i;
    }

    public static int gcd(int numerator, int denominator){
        int i;
        while (numerator != 0 && denominator != 0){
            i = numerator % denominator;
            numerator = denominator;
            denominator = i;
        }
        return numerator;
    }
}
