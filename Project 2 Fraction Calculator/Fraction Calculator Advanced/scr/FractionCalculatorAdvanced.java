import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class FractionCalculatorAdvanced {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] inputToCalculate;

        greetings();
        while (true) {
            inputToCalculate = getOperation(input);
            if (inputToCalculate[0].equalsIgnoreCase("Q")) {
                break;
            }
            Fraction firstNumber = builder(inputToCalculate[0], inputToCalculate[1]);
            Fraction secondNumber = builder(inputToCalculate[2], inputToCalculate[3]);
            calculate(inputToCalculate[4], firstNumber, secondNumber);
        }
    }

    public static void greetings(){
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Valid operations are of the form \"[FRAC] [OPERATION] [FRAC]\". ");
        System.out.println("[FRAC] can be either a single integer or two integers separated by \"/\".");
        System.out.println("[OPERATION] can be +, -, *, / or =.");
    }

    public static String[] getOperation(Scanner input){
        System.out.print("Enter an operation (Q to quit): ");
        String[] arrayOfStrings = new String[4];
        int index;
        boolean error = false;

        String s = input.nextLine();

        if (s.equalsIgnoreCase("Q")){
            arrayOfStrings[0] = "Q";
            return arrayOfStrings;
        }
        char type = typeOfOperation(s);

        arrayOfStrings = inputVerifier(s, type);
        for (String arrayOfString : arrayOfStrings) {
            if (arrayOfString.equals("ERROR")) {
                error = true;
                break;
            }
        }

        if (type == 'E' || error){
            do {
                error = false;
                System.out.println("Invalid operation. Must be \"[FRAC] [OPERATION] [FRAC]\".");
                System.out.print("Enter an operation (Q to quit): ");
                s = input.nextLine();
                type = typeOfOperation(s);
                arrayOfStrings = inputVerifier(s, type);
                for (String arrayOfString : arrayOfStrings) {
                    if (arrayOfString.equals("ERROR")) {
                        error = true;
                        break;
                    }
                }
            }while (type == 'E' || error);
        }
        return arrayOfStrings;
    }

    public static Fraction builder(String s, String m){
        if (!m.equals("0")){
            return new Fraction(parseInt(s),parseInt(m));
        }else {
            return new Fraction(parseInt(s));
        }
    }

    public static char typeOfOperation(String s){
        String options = "+-*/=";
        int index = -1, i;
        for (i = 0; i < options.length(); i++){
            index = s.indexOf(" " + options.charAt(i) + " ");
            if (index > 0){
                break;
            }
        }
        if (index > 0){
            return options.charAt(i);
        }else {
            return 'E';
        }
    }

    public static String[] inputVerifier(String s, char c){
        String[] arrayOfStrings = new String[5];
        boolean minusVerifier = false, minusVerifier2 = false;
        arrayOfStrings[4] = Character.toString(c);

        int index = s.indexOf(" " + c + " ");
        if (index == -1){
            arrayOfStrings[0] = "ERROR";
        }else {
            String beginning = s.substring(0, index);
            String end = s.substring(index+3);

            if(beginning.charAt(0) == '-'){
                minusVerifier = true;
                StringBuilder sb = new StringBuilder(beginning);
                sb.deleteCharAt(0);
                beginning = sb.toString();
            }

            int index2 = beginning.indexOf('/');
            if (index2 != -1){
                String beginningNum = beginning.substring(0, index2);
                if (isNumber(beginningNum)){
                    if (minusVerifier){
                        StringBuilder sb2 = new StringBuilder(beginning);
                        sb2.insert(0,'-');
                        beginning = sb2.toString();
                        beginningNum = beginning.substring(0, index2+1);
                    }
                    arrayOfStrings[0] = beginningNum;
                }else {
                    arrayOfStrings[0] = "ERROR";
                }

                String beginningDem;

                if (minusVerifier){
                    beginningDem = beginning.substring(index2+2);
                }else {
                    beginningDem = beginning.substring(index2+1);
                }
                if (beginningDem.equals("0")){
                    arrayOfStrings[1] = "ERROR";
                }else {
                    if (isNumber(beginningDem)){
                        arrayOfStrings[1] = beginningDem;
                    }else {
                        arrayOfStrings[1] = "ERROR";
                    }
                }
            }else {
                if (isNumber(beginning)){
                    if (minusVerifier){
                        StringBuilder sb1 = new StringBuilder(beginning);
                        sb1.insert(0,'-');
                        beginning = sb1.toString();
                    }
                    arrayOfStrings[0] = beginning;
                    arrayOfStrings[1] = "1";
                }else {
                    arrayOfStrings[0] = "ERROR";
                }
            }



            //second number



            if(end.charAt(0) == '-'){
                minusVerifier2 = true;
                StringBuilder sb3 = new StringBuilder(end);
                sb3.deleteCharAt(0);
                end = sb3.toString();
            }

            int index3 = end.indexOf('/');
            if (index3 != -1){
                String endNum = end.substring(0, index3);
                if (isNumber(endNum)){
                    if (minusVerifier2){
                        StringBuilder sb4 = new StringBuilder(end);
                        sb4.insert(0,'-');
                        end = sb4.toString();
                        endNum = end.substring(0, index3+1);
                    }
                    arrayOfStrings[2] = endNum;
                }else {
                    arrayOfStrings[2] = "ERROR";
                }

                String endDem;

                if (minusVerifier2){
                    endDem = end.substring(index3+2);
                }else {
                    endDem = end.substring(index3+1);
                }
                if (endDem.equals("0")){
                    arrayOfStrings[3] = "ERROR";
                }else {
                    if (isNumber(endDem)){
                        arrayOfStrings[3] = endDem;
                    }else {
                        arrayOfStrings[3] = "ERROR";
                    }
                }
            }else {
                if (c == '/' && end.equals("0")){
                    arrayOfStrings[2] = "ERROR";
                }
                if (isNumber(end)){
                    if (minusVerifier2){
                        StringBuilder sb5 = new StringBuilder(end);
                        sb5.insert(0,'-');
                        end = sb5.toString();
                    }
                    arrayOfStrings[2] = end;
                    arrayOfStrings[3] = "1";
                }else {
                    arrayOfStrings[2] = "ERROR";
                }
            }
        }
        return arrayOfStrings;
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
                    break;
                }
                result = x.divide(y);
                break;
            case "=":
                boolean resultEquals = x.equals(y);
                System.out.println(x.toString() + " " + s + " " + y.toString() + " is " + resultEquals);
                break;
        }

        if (s.equals("+") || s.equals("-") || s.equals("*") || (s.equals("/") && y.getNumerator() != 0)){
            result.toLowestTerms();
            System.out.println(x.toString() + " " + s + " " + y.toString() + " = " + result);
            }
    }
}