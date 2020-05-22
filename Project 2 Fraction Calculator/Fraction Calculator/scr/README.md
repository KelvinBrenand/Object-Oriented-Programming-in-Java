# Project Description

### Module 2 Project - Fraction Calculator

You will be creating two classes, one called Fraction and the other called FractionCalculator. The Fraction class is an object that holds information about a fraction (numerator and denominator). It will have several constructors and both private and public methods implementing the behavior of a fraction. The FractionCalculator class is a class that will allow the user to enter in fractions and operations, calculating and displaying the result. It will run until the user tells it to quit. When this program is complete, you won’t have to second guess your fraction arithmetic ever again!

#### Part 1 - Fraction Class

Create a new class called "Fraction" and include the following:

#### Fields

* two private instance variables to hold the numerator and denominator as ints

#### Constructors

* a two parameter constructor that initializes the numerator and denominator

  * This constructor should throw an IllegalArgumentException if the denominator is zero
  * If the user enters a negative denominator bump the negative sign to the numerator. For example, -3/-2 should be converted to 3/2. Likewise, 5/-3 should be converted to -5/3
  * *example*: Fraction myFrac = new Fraction(4,5); creates a fraction who's numerator is 4 and denominator is 5
* one parameter constructor that initializes the object equal in value to the integer parameter.
  
  * *example*: Fraction myFrac = new Fraction(3) would create a Fraction with numerator equal to 3 and denominator equal to 1.
* zero parameter constructor that initializes the object to 0, meaning the numerator is 0 and the denominator is 1
  
  * *example*: Fraction myFrac = new Fraction(); would create a fraction who's decimal value is 0

You should eliminate as much redundancy as possible by letting your constructors rely on one another using the "this" keyword.

### Methods

Method to implement |	parameter	| return | description
--------------------|-----------|--------|------------
getNumerator() | none | int	| exposes the value of the numerator field to the user
getDenominator() | none	| int |	exposes the value of the denominator field to the user
toString() | none | String | "numerator/denominator", a String representation of the Fraction
toDouble() | none	| double | the result of numerator / denominator
add()	| Fraction other | Fraction	| returns a new Fraction that is the sum of other and this fractions
subtract() | Fraction other	| Fraction | returns a new Fraction that is the difference between the other and this fraction
multiply() | Fraction other	| Fraction | returns a new Fraction that is the product of the other and this fraction
divide() | Fraction other	| Fraction | returns a new Fraction that is the division of the other and this fraction, throw an IllegalArgumentException() if the user asks you to divide by 0
equals() | Object other	| boolean	| must take in an "Object" to properly override the Object class's equals method, but should ultimately check if two fractions are equal
toLowestTerms()	| none | none	| converts the current fraction to the lowest terms
gcd()	| int num, int den | int | takes in two ints and determines the greatest common divisor of the two ints, should be a static method

#### equals()

Override the Object equals() method so that it accurately determines whether or not two fractions are equal. In order to have it override, it has to take an Object as a parameter. Your method should check whether or not the parameter is an instanceof Fraction, since if it is not a Fraction it cannot be equal. Don’t forget to cast the parameter to a Fraction after you check if it is an Object of type Fraction so that you can access its variables. Two fractions are equal if they represent the same number (i.e. 3/6 = 1/2 and -2/3 = 2/-3).

#### toLowestTerms()

To convert a fraction to lowest terms we have to determine the greatest common divisor (factor) between the numerator and denominator. The greatest common divisor of two numbers a and b, is the largest number that evenly divides both a and b.

The Euclidean Algorithm is a fast method for determining the GCD of two numbers. Here is pseudocode for its implementation:

while a and b are not zero
    find the remainder of a divided by b
    set a to b
    set b to the remainder you found
return a
Here is an example of how it would work if a is 105 and b is 147.

Loop Iteration | Value of a at end of loop run | Value of b at end of loop run | a % b
---------------|-------------------------------|-------------------------------|------
Pre-Loop | 105 | 147 |	
1	|147 | 105 | 105 % 147 = 105
2	|105 | 42	| 147 % 105 = 147 - 105 = 42
3	|42	| 21 | 105 % 42 = 105 - 84 = 21
4	|21	| 0	| 42 % 21 = 0

#### gcd()

Implement gcd() as a public static method that takes two integers as parameters and returns an int that is their greatest common divisor.

#### Part 2 – FractionCalculator Class

In this section, you will implement a FractionCalculator class that has a main method and three helper methods. Here is a screenshot from a sample run:

![](/Images/1-sampleOutput.png)

Your program should be robust so that it if the user enters invalid input it will continue to re-prompt them until it is valid. Here is an example run where the user is confused and enters invalid input:

![](/Images/2-inputValidation.png)

#### Methods

Method to implement	| parameter | return | description
--------------------|-----------|--------|------------
getOperation() | Scanner input | String	| Asks the user to enter in a valid mathematical operation. If the user enters anything except "+", "-", "/", "*", "=", "q", or "Q" it should re-prompt them until there is valid input.			
validFraction()	| String input | boolean | returns true if the parameter is in the form "a/b" where a is any int and b is any positive int
getFraction()	| Scanner input	| Fraction | It prompts the user for a String that is a validFraction. If they enter any thing that is not a valid Fraction, it should re-prompt them until it is valid

#### getOperation()

Here is example output from a call to **getOperation()**:

![](/Images/3-getFraction.png)

##### validFraction()

Some things to be mindful of when implementing the **validFraction()** method:

* The first character may or may not be a "-" character. If a negative shows up anywhere else, then it is not a valid fraction. It may be helpful to remove the "-" character if there is one.
* If there is no "/" character, then every character in the string must be a number (if you removed the "-" sign).
* If there is a "/" character, then it may be helpful to create substrings for the numerator and denominator.
  
  * Both substrings must be non-empty.
  * Both must be entirely made of numbers.
  * The denominator cannot be "0".

**Hint 1**: It may be useful to create a helper method isNumber() that takes a String as input and returns true if every character in the String is a number 0-9 and false otherwise. This method can also check for empty strings. **Hint 2**: Once you determine whether or not the Strings are numbers, you may find the Integer.parseInt() method helpful.

#### getFraction()

Here is example output from a call to **getFraction()**. If the user enters any thing that is not a valid Fraction, it should re-prompt them until it is valid:

![](/Images/3-getFraction.png)

This call would return a new Fraction object equal to -31/1. No user input should throw an exception! If you are getting exceptions, then it is likely your validFraction method isn’t correct.

#### Part 3 - Putting it all together!

1. Write a short introduction method that describes the calculator program and welcomes your user
2. Ask the user to enter in an operation
3. As long as the user enters something that’s not "q" or "Q" when asked for an operation you should run the calculator
4. Get two fractions from the user and then perform whichever operation they ask for
5. Print the result of the operation

Here is an example run of the entire program:

![](/Images/4-sampleRun.png)
