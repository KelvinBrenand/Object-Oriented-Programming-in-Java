import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class FractionCalculator {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String operation;

        greetings();

        while (true){
            operation = getOperation(input);
            if (operation.equalsIgnoreCase("Q")){
                break;
            }
            Fraction fraction1 = getFraction(input);
            Fraction fraction2 = getFraction(input);
            calculate(operation, fraction1, fraction2);
        }
    }

    public static void greetings(){
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
        System.out.println("--------------------------------------------------------------------------------");
    }

    public static String getOperation(Scanner input) {
        System.out.print("Please enter an operation(+, -, *, /, =, or Q to quit): ");

        String s = input.nextLine();

        if (!(s.equals("+")) && !(s.equals("-")) && !(s.equals("*")) && !(s.equals("/")) && !(s.equals("=")) &&
                !(s.equalsIgnoreCase("Q"))){

            do {
                System.out.print("Invalid input (+, -, *, /, =, or Q to quit): ");
                s = input.nextLine();
            } while (!(s.equals("+")) && !(s.equals("-")) && !(s.equals("*")) && !(s.equals("/")) && !(s.equals("=")) &&
                    !(s.equalsIgnoreCase("Q")));
        }
        return s;
    }

    public static Fraction getFraction(Scanner input) {
        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        String inputFraction = input.nextLine();
        if (!validFraction(inputFraction)){
            do {
                System.out.print("Invalid fraction. Please enter (a/b) or (a), where a and b are integers " +
                        "and is not zero: ");
                inputFraction = input.nextLine();
            } while (!validFraction(inputFraction));
        }
        int index = inputFraction.indexOf('/');
        if (index != -1){
            String numerator = inputFraction.substring(0,index);
            String denominator = inputFraction.substring(index+1);

            return new Fraction(parseInt(numerator), parseInt(denominator));
        }else {
            return new Fraction(parseInt(inputFraction));
        }
    }

    public static boolean validFraction(String input){
        if(input.charAt(0) == '-'){
            StringBuilder sb = new StringBuilder(input);
            sb.deleteCharAt(0);
            input = sb.toString();
        }
        int index = input.indexOf('/');
        if (index != -1){
            String numerator = input.substring(0,index);
            String denominator = input.substring(index+1);
            if (denominator.charAt(0) == '0'){
                return false;
            }
            return ((isNumber(numerator)) && (isNumber(denominator)));
        }
        return (isNumber(input));
    }

    public static boolean isNumber(String s){
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) != '0' && s.charAt(i) != '1' && s.charAt(i) != '2' && s.charAt(i) != '3'
                && s.charAt(i) != '4' && s.charAt(i) != '5' && s.charAt(i) != '6' && s.charAt(i) != '7'
                && s.charAt(i) != '8' && s.charAt(i) != '9'){
                return false;
            }
        }
        return true;
    }

    public static void calculate(String s, Fraction x, Fraction y){
        Fraction result = new Fraction();

        switch (s) {
            case "+":
                result = x.add(y);
                break;
            case "-":
                result = x.subtract(y);
                break;
            case "*":
                result = x.multiply(y);
                break;
            case "/":
                if (y.getNumerator() == 0){
                    System.out.println(x.toString() + " / 0 = Undefined");
                    System.out.println("--------------------------------------------------------------------------------");
                    break;
                }
                result = x.divide(y);
                break;
            case "=":
                boolean resultEquals = x.equals(y);
                System.out.println(x.toString() + " " + s + " " + y.toString() + " is " + resultEquals);
                System.out.println("--------------------------------------------------------------------------------");
                break;
        }

        if (s.equals("+") || s.equals("-") || s.equals("*") || (s.equals("/") && y.getNumerator() != 0)){
            result.toLowestTerms();
            System.out.println(x.toString() + " " + s + " " + y.toString() + " = " + result);
            System.out.println("--------------------------------------------------------------------------------");
        }
    }
}
