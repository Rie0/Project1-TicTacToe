import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//include queue: Variables, Scanner, Conditions, Loops, Arrays, Methods.
//Requirements:
//1- Use 2D Array.
//2- Use method.
//3- Should Display a Game Board.
//4- Ask player position.
//5- Check if the position available, if not available keep asking the player to enter a valid position.
//6- Computer chose random position and check valid position.
//7- Checks if either player or Computer has won.


//Create The grid **********************************
        String[][] grid={ //row[]column[]

    //Column 0,1,2   //Row
            {" "," "," "}, //0
            {" "," "," "}, //1
            {" "," "," "}  //2
        };

//Start the match
        matchMaker(grid);


        //ideas: use a String array instead? to use X/O and empty are " " and wins by isEqualIgnoreCase by the five rules.
    }

 //Methods.
    public static void printGrid(String[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (j/2!=0){
                    System.out.print(grid[i][j]);
                }else{
                    System.out.print(grid[i][j]+"  |  ");
                }
                if(i> grid.length-2){
                    System.out.print("");//removes last line
                }else if(j/2!=0){
                    System.out.println("\n--------------");
                }
            }
        }
        System.out.println("\n"); //leave space
    }


    public static void aiTurn(String[][] grid){
        Random rand = new Random();
        int randomRow=0;
        int randomColumn=0;

        do {
           randomRow=rand.nextInt(0,3);
            randomColumn=rand.nextInt(0,3);
        } while(!grid[randomRow][randomColumn].equals(" "));
        grid[randomRow][randomColumn]="X";

    }

    public static void userTurn(String[][] grid){ //handle exceptions? or gracefully ask user to enter again
        Scanner sc =new Scanner(System.in);

        System.out.println("Enter row: ");
        int userRow= sc.nextInt();
        System.out.println("Enter column: ");
        int userColumn= sc.nextInt();

        while(!grid[userRow][userColumn].equals(" ")){
            System.out.println("Position is taken, try again.");
            System.out.println("Enter row: ");
            userRow= sc.nextInt();
            System.out.println("Enter column: ");
            userColumn= sc.nextInt();
        }
        grid[userRow][userColumn]="O";
    }

    public static boolean isUserWinner(String[][] grid){ //User is O
        boolean isUserWinner = false;
//Case 1 Horizontal wins
        if (grid[0][0].equalsIgnoreCase("O")&&grid[0][1].equalsIgnoreCase("O")&&grid[0][2].equalsIgnoreCase("O")){
            isUserWinner=true;
        }
        if (grid[1][0].equalsIgnoreCase("O")&&grid[1][1].equalsIgnoreCase("O")&&grid[1][2].equalsIgnoreCase("O")){
            isUserWinner=true;
        }
        if (grid[2][0].equalsIgnoreCase("O")&&grid[2][1].equalsIgnoreCase("O")&&grid[2][2].equalsIgnoreCase("O")){
            isUserWinner=true;
        }
//Case 2 vertical wins
        if (grid[0][0].equalsIgnoreCase("O")&&grid[1][0].equalsIgnoreCase("O")&&grid[2][0].equalsIgnoreCase("O")){
            isUserWinner=true;
        }
        if (grid[0][1].equalsIgnoreCase("O")&&grid[1][1].equalsIgnoreCase("O")&&grid[2][1].equalsIgnoreCase("O")){
            isUserWinner=true;
        }
        if (grid[0][2].equalsIgnoreCase("O")&&grid[1][2].equalsIgnoreCase("O")&&grid[2][2].equalsIgnoreCase("O")){
            isUserWinner=true;
        }
//Case 3 Crosses
        if (grid[0][0].equalsIgnoreCase("O")&&grid[1][1].equalsIgnoreCase("O")&&grid[2][2].equalsIgnoreCase("O")){
            isUserWinner=true;
        }
        if (grid[0][2].equalsIgnoreCase("O")&&grid[1][1].equalsIgnoreCase("O")&&grid[2][0].equalsIgnoreCase("O")){
            isUserWinner=true;
        }
        return isUserWinner;
    }

    public static boolean isAiWinner(String[][] grid){ //AI is X
        boolean isAiWinner = false;
//Case 1 Horizontal wins
        if (grid[0][0].equalsIgnoreCase("X")&&grid[0][1].equalsIgnoreCase("X")&&grid[0][2].equalsIgnoreCase("X")){
            isAiWinner = true;
        }
        if (grid[1][0].equalsIgnoreCase("X")&&grid[1][1].equalsIgnoreCase("X")&&grid[1][2].equalsIgnoreCase("X")){
            isAiWinner = true;
        }
        if (grid[2][0].equalsIgnoreCase("X")&&grid[2][1].equalsIgnoreCase("X")&&grid[2][2].equalsIgnoreCase("X")){
            isAiWinner = true;
        }
//Case 2 vertical wins
        if (grid[0][0].equalsIgnoreCase("X")&&grid[1][0].equalsIgnoreCase("X")&&grid[2][0].equalsIgnoreCase("X")){
            isAiWinner=true;
        }
        if (grid[0][1].equalsIgnoreCase("X")&&grid[1][1].equalsIgnoreCase("X")&&grid[2][1].equalsIgnoreCase("X")){
            isAiWinner=true;
        }
        if (grid[0][2].equalsIgnoreCase("X")&&grid[1][2].equalsIgnoreCase("X")&&grid[2][2].equalsIgnoreCase("X")){
            isAiWinner=true;
        }
//Case 3 Crosses
        if (grid[0][0].equalsIgnoreCase("X")&&grid[1][1].equalsIgnoreCase("X")&&grid[2][2].equalsIgnoreCase("X")){
            isAiWinner=true;
        }
        if (grid[0][2].equalsIgnoreCase("X")&&grid[1][1].equalsIgnoreCase("X")&&grid[2][0].equalsIgnoreCase("X")){
            isAiWinner=true;
        }

        return isAiWinner;

    }

    public static boolean isTie(String[][] grid){
        //Check if the grid is full //NAMING PLEAAASE
        boolean isFull = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j].equals(" ")){
                    isFull = true;
                }
            }
        }
        return isFull;
    }

    public static void matchMaker(String[][] grid){
        boolean isGameGoing = false;
        do {// indicate whose turn now, *plus current round when you add the (3 rounds) functionality

            System.out.println("---AI Turn---");
            aiTurn(grid);
            printGrid(grid);
            isGameGoing = (!isTie(grid)||isUserWinner(grid)||isAiWinner(grid));
            if (isGameGoing){break;}
            System.out.println("--User Turn--");
            userTurn(grid);
            printGrid(grid);
//            System.out.println("--------Check--------");
//            System.out.println(isAiWinner(grid));
//            System.out.println(isUserWinner(grid));
//            System.out.println(isTie(grid));
//            System.out.println("--------Check--------");
             isGameGoing = (!isTie(grid)||isUserWinner(grid)||isAiWinner(grid));
        }while (!isGameGoing);

        if (isAiWinner(grid)) {
            System.out.println("AI won, good luck next time!");
        }else if (isUserWinner(grid)) {
            System.out.println("You won!");
        } else if (!isTie(grid))
        {System.out.println("Tie.");
        }
    }
}