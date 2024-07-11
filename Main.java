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
//5- Check if the position available, if not available keep asking the player to enter a
//valid position.
//6- Computer chose random position and check valid position.
//7- Checks if either player or Computer has won.

        //Classes variables. (might end up redundant)
        Scanner sc =new Scanner(System.in);
        Random rand = new Random();

//Start of - The grid **********************************
        int[][] grid={ //row[]column[]

    //Column 0,1,2   //Row
            {0,0,0}, //0
            {0,0,0}, //1
            {0,0,0}  //2
        };
//End of - The grid ***************************************

        //Include in matchMaker()********************
        matchMaker(grid);
       //Include in matchMaker()********************


        //ideas: use a String array instead? to use X/O and empty are " " and wins by isEqualIgnoreCase by the five rules.
        //Match make method: has a boolean to check if there's an empty space left. if not print DRAW/TIE.
    }

 //Methods.

    public static void printGrid(int[][] grid){

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (j/2!=0){
                    System.out.print(grid[i][j]);
                }else{
                    System.out.print(grid[i][j]+" | ");
                }
                if(j/2!=0){
                    System.out.println("\n----------"); //remove from last position
                }
            }
        }
        System.out.println(); //leave space
    }


    public static void aiTurn(int[][] grid){
        Random rand = new Random();
        int randomRow=rand.nextInt(0,3);
        int randomColumn=rand.nextInt(0,3);
        if (grid[randomRow][randomColumn]==0){
            grid[randomRow][randomColumn]=1;
        } //get ai to try again if space is full(not 0), use do while.
    }

    public static void userTurn(int[][] grid){
        Scanner sc =new Scanner(System.in);

        System.out.println("Enter row: ");
        int userRow= sc.nextInt();
        System.out.println("Enter column: ");
        int userColumn= sc.nextInt();
        if (grid[userRow][userColumn]==0){
            grid[userRow][userColumn]=2;
        }
    }
    public static boolean checkSpace(int[][] grid){
        //Check if there's an empty space. (turn into a method)
        boolean isFull = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j]==0){
                    isFull = true;
                }
            }
        }
        return isFull;
    }

    public static void matchMaker(int[][] grid){
        do {
            aiTurn(grid);
            printGrid(grid);
            checkSpace(grid);
            userTurn(grid);
            printGrid(grid);
            checkSpace(grid);
        }while (checkSpace(grid));
        System.out.println("Tie.");
    }
}