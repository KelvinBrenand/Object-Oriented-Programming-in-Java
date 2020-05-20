import java.util.*;
public class Project1 {
    public static void main(String[] args){
        String[][] ocean = new String[10][10];

        arrayFiller(ocean);
        greetings(ocean);
        userShipsDeployer(ocean);
        computerShipsDeployer(ocean);
        battle(ocean);
    }

    public static void arrayFiller(String[][] s){
        for(String[] row: s){
            Arrays.fill(row, " ");
        }
    }

    public static void greetings(String[][] s){
        System.out.println("**** Welcome to the Battle Ships game ****");
        System.out.println("\n       Right now, the sea is empty.");

        oceanViewer(s);
    }

    public static void oceanViewer(String[][] s){
        System.out.println("\n                0123456789");

        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                if (j == 0){
                    System.out.print("             " + i + " |");
                }

                if (s[i][j].equals("1")){
                    System.out.print("@");
                }else if (s[i][j].equals("2")){
                    System.out.print(" ");
                }else{
                    System.out.print(s[i][j]);
                }

                if (j == (s[i].length - 1)){
                    System.out.println("| " + i);
                }
            }
        }
        System.out.println("                0123456789");
    }

    public static void userShipsDeployer(String[][] s){
        Scanner input = new Scanner(System.in);
        int count = 1, x, y;

        System.out.println("\nDeploy yours ships:");

        do {
            do {
                System.out.print("Enter X coordinate for your " + count + ". ship: ");
                x = input.nextInt();
            } while (x < 0 || x > 9);
            do {
                System.out.print("Enter Y coordinate for your " + count + ". ship: ");
                y = input.nextInt();
            } while (y < 0 || y > 9);

            if (!s[x][y].equals("1")) {
                s[x][y] = "1";
                count++;
            } else {
                System.out.println("You can NOT place two or more ships on the same location.");
            }
        } while (count < 6);

        System.out.println("--------------------------------------");

        oceanViewer(s);

    }

    public static void computerShipsDeployer(String[][] s){
        Random rand = new Random();
        int count = 1, x, y;

        System.out.println("\nComputer is deploying ships");

        do {
            x = rand.nextInt(10);
            y= rand.nextInt(10);
            if (!s[x][y].equals("1") || !s[x][y].equals("2")){
                s[x][y] = "2";
                System.out.println(count + ". ship DEPLOYED");
                count++;
            }
        } while (count < 6);

        System.out.println("--------------------------------------");

    }

    public static void battle(String[][] s){
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        String[][] computersArray = new String[10][10];
        arrayFiller(computersArray);
        int x, y, userShips = 5, compShips = 5;

        do {
            //User's turn
            System.out.println("\nYOUR TURN");
            do {
                System.out.print("Enter X coordinate: ");
                x = input.nextInt();
            } while (x < 0 || x > 9);
            do {
                System.out.print("Enter Y coordinate: ");
                y = input.nextInt();
            } while (y < 0 || y > 9);

            if (s[x][y].equals("2")){
                System.out.println("Boom! You sunk the ship!");
                s[x][y] = "!";
                compShips--;
            }else if (s[x][y].equals("1")){
                System.out.println("Oh no, you sunk your own ship :(");
                s[x][y] = "x";
                userShips--;
            }else if(s[x][y].equals("!") || s[x][y].equals("x")){
                System.out.println("Sorry, you missed");
            }else {
                System.out.println("Sorry, you missed");
                s[x][y] = "-";
            }

            //Computer's turn
            System.out.println("\nCOMPUTER'S TURN");
            do {
                x = rand.nextInt(10);
                y= rand.nextInt(10);
            }while (computersArray[x][y].equals("*") || s[x][y].equals("!"));

            if (s[x][y].equals("1")){
                System.out.println("The Computer sunk one of your ships!");
                s[x][y] = "x";
                userShips--;
            }else if (s[x][y].equals("2")){
                System.out.println("The Computer sunk one of its own ships");
                s[x][y] = "!";
                compShips--;
            }else {
                System.out.println("Computer missed");
                computersArray[x][y] = "*";
            }
            oceanViewer(s);
            System.out.println("\nYour ships: " + userShips + " | Computer ships: " + compShips);

        }while (userShips > 0 && compShips > 0);
        if (compShips == 0){
            System.out.println("Hooray! You win the battle. :)");
        }else {
            System.out.println("You lose the battle. :(");
        }
    }
}
