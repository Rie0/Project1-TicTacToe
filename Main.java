import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//include queue: Variables, Scanner, Conditions, Loops, Arrays, Methods. ++++Exception! maybe a general one is enough
//Requirements:
//1- Use 2D Array.
//2- Use method.
//3- Should Display a Game Board.
//4- Ask player position.
//5- Check if the position available, if not available keep asking the player to enter a valid position.
//6- Computer chose random position and check valid position.
//7- Checks if either player or Computer has won.


//Create The grid **********************************
        int[][] grid={ //row[]column[]

        //Column 0,1,2   //Row
                {0,0,0}, //0
                {0,0,0}, //1
                {0,0,0}  //2
        };

//Start the match
        matchMaker(grid);


        //ideas: use a String array instead? to use X/O and empty are " " and wins by isEqualIgnoreCase by the five rules.
    }

    //Methods.
    public static void printGrid(int[][] grid){

        int blockNum=1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (j/2!=0){
                    if (grid[i][j]==20){
                        System.out.print("X");
                    } else if (grid[i][j]==10) {
                        System.out.print("O");
                    }else{ System.out.print(blockNum);}
                }else{
                    if (grid[i][j]==20){
                        System.out.print("X"+ "  |  ");
                    } else if (grid[i][j]==10) {
                        System.out.print("O"+ "  |  ");
                    }else {
                        System.out.print(blockNum + "  |  ");
                    }
                }
                if(i> grid.length-2){
                    System.out.print("");//removes last line
                }else if(j/2!=0){
                    System.out.println("\n--------------");
                }
                blockNum++;
            }
        }
        System.out.println("\n"); //leave space
    }



    public static void aiTurn(int[][] grid){
        Random rand = new Random();
        int randomRow=rand.nextInt(3);
        int randomColumn=rand.nextInt(3);

        while(grid[randomRow][randomColumn]!=0){  //get ai to try again if space is full (not 0). do while is better??
            randomRow=rand.nextInt(3);
            randomColumn=rand.nextInt(3);
        }
        grid[randomRow][randomColumn]=10;

    }

    public static void userTurn(int[][] grid) { //handle exceptions? or gracefully ask user to enter again
        Scanner sc = new Scanner(System.in);

        int row=0;
        int column=0;
        boolean isAccepted = true;
        //NOTE: I know a switch isn't the best solution, but I really want to use it because I never did before :)
        System.out.println("Pick a position: ");
        do {
            int userPosition = sc.nextInt();
            switch (userPosition) {
                case 1:
                   row=0;
                   column=0;
                    break;
                case 2:
                    row=0;
                    column=1;
                    break;
                case 3:
                    row=0;
                    column=2;
                    break;
                case 4:
                    row=1;
                    column=0;
                    break;
                case 5:
                    row=1;
                    column=1;
                    break;
                case 6:
                    row=1;
                    column=2;
                    break;
                case 7:
                    row=2;
                    column=0;
                    break;
                case 8:
                    row=2;
                    column=1;
                    break;
                case 9:
                    row=2;
                    column=2;
                    break;
            }
            if (grid[row][column] == 0) {
                grid[row][column] = 20;
                break;
            } else { //loops forever
                System.out.println("Position is taken. Please choose another position.");
                isAccepted =false;
            }
        } while (!isAccepted);
    }

    public static boolean isUserWinner(int[][] grid){
        boolean isUserWinner = false;
//Case 1 Horizontal wins
        if (grid[0][0]==20&&grid[0][1]==20&&grid[0][2]==20){
            isUserWinner=true;
        }
        if (grid[1][0]==20&&grid[1][1]==20&&grid[1][2]==20){
            isUserWinner=true;
        }
        if (grid[2][0]==20&&grid[2][1]==20&&grid[2][2]==20){
            isUserWinner=true;
        }
//Case 2 vertical wins
        if (grid[0][0]==20&&grid[1][0]==20&&grid[2][0]==20){
            isUserWinner=true;
        }
        if (grid[0][1]==20&&grid[1][1]==20&&grid[2][1]==20){
            isUserWinner=true;
        }
        if (grid[0][2]==20&&grid[1][2]==20&&grid[2][2]==20){
            isUserWinner=true;
        }
//Case 3 Crosses
        if (grid[0][0]==20&&grid[1][1]==20&&grid[2][2]==20){
            isUserWinner=true;
        }
        if (grid[0][2]==20&&grid[1][1]==20&&grid[2][0]==20){
            isUserWinner=true;
        }
        return isUserWinner;
    }

    public static boolean isAiWinner(int[][] grid){ //(int[][] grid, current player? with user being 2 and AI 1??)
        boolean isAiWinner = false;
//Case 1 Horizontal wins
        if (grid[0][0]==10&&grid[0][1]==10&&grid[0][2]==10){
            isAiWinner = true;
        }
        if (grid[1][0]==10&&grid[1][1]==10&&grid[1][2]==10){
            isAiWinner = true;
        }
        if (grid[2][0]==10&&grid[2][1]==10&&grid[2][2]==10){
            isAiWinner = true;
        }
//Case 2 vertical wins
        if (grid[0][0]==10&&grid[1][0]==10&&grid[2][0]==10){
            isAiWinner=true;
        }
        if (grid[0][1]==10&&grid[1][1]==10&&grid[2][1]==10){
            isAiWinner=true;
        }
        if (grid[0][2]==10&&grid[1][2]==10&&grid[2][2]==10){
            isAiWinner=true;
        }
//Case 3 Crosses
        if (grid[0][0]==10&&grid[1][1]==10&&grid[2][2]==10){
            isAiWinner=true;
        }
        if (grid[0][2]==10&&grid[1][1]==10&&grid[2][0]==10){
            isAiWinner=true;
        }

        return isAiWinner;

    }

    public static boolean isTie(int[][] grid){
        //Check if the grid is full
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j]==0){
                   return false;
                }
            }
        }
        return true;
    }

    public static void matchMaker(int[][] grid){
        boolean isGameGoing = false;
        do {// indicate whose turn now, *plus current round when you add the (3 rounds) functionality

            //can't see grid when ai wins :(
            System.out.println("---AI Turn---");
            aiTurn(grid);
            printGrid(grid);
            isGameGoing = (isTie(grid)||isUserWinner(grid)||isAiWinner(grid));
            if (isGameGoing){break;}
            System.out.println("--User Turn--");
            userTurn(grid);
            printGrid(grid);
//            System.out.println("--------Check--------");
//            System.out.println(isAiWinner(grid));
//            System.out.println(isUserWinner(grid));
//            System.out.println(isTie(grid));
//            System.out.println("--------Check--------");
            isGameGoing = (isTie(grid)||isUserWinner(grid)||isAiWinner(grid));
        }while (!isGameGoing);

        if (isAiWinner(grid)) {
            System.out.println("AI won, good luck next time!");
        }else if (isUserWinner(grid)) {
            System.out.println("You won!");
        } else if (isTie(grid))
        {System.out.println("Tie.");
        }
    }
}