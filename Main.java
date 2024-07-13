import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] grid={ //row[]column[]
        //Column 0,1,2   //Row
                {0,0,0}, //0
                {0,0,0}, //1
                {0,0,0}  //2
        };
        String playerChoice = playerChar();
//Start the match
        matchMaker(grid,playerChoice);
    }

    //Methods.
    public static void printGrid(int[][] grid, String playerChar){ //prints the game board
        int blockNum=1;
        String aiChar = (playerChar.equalsIgnoreCase("X")) ? "O" : "X";

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (j / 2 != 0) {
                    if (grid[i][j] == 20) {
                        System.out.print(playerChar);
                    } else if (grid[i][j] == 10) {
                        System.out.print(aiChar);
                    } else {
                        System.out.print(blockNum);
                    }
                } else {
                    if (grid[i][j] == 20) {
                        System.out.print(playerChar + "  |  ");
                    } else if (grid[i][j] == 10) {
                        System.out.print(aiChar + "  |  ");
                    } else {
                        System.out.print(blockNum + "  |  ");
                    }
                }
                if (i > grid.length - 2) {
                    System.out.print(""); // Removes last line
                } else if (j / 2 != 0) {
                    System.out.println("\n--------------");
                }
                blockNum++;
            }
        }
        System.out.println("\n"); // Leave space between game board
    }

    public  static void resetGrid(int[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
               grid[i][j]=0;
            }
        }
    }

    public static String playerChar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Play X or O:");
        String playerChar = sc.nextLine();
        while (!playerChar.equalsIgnoreCase("X") && !playerChar.equalsIgnoreCase("O")) {
            System.out.println("Enter either X or O.");
            playerChar = sc.nextLine();
        }
        return playerChar.toUpperCase(); // Return uppercase to ensure consistency
    }

    public static void aiTurn(int[][] grid){

        Random rand = new Random();
        int randomRow=rand.nextInt(3);
        int randomColumn=rand.nextInt(3);

        while(grid[randomRow][randomColumn]!=0){  //get AI to try again if space is full (not 0).
            randomRow=rand.nextInt(3);
            randomColumn=rand.nextInt(3);
        }
        grid[randomRow][randomColumn]=10; //10 will be printed as O later
    }

    public static void userTurn(int[][] grid) {
        Scanner sc = new Scanner(System.in);

        int row=0;
        int column=0;
        boolean isPositionTaken;

        //NOTE: I know a switch isn't the optimal solution, but I REALLY want to use it because I never did before :)


            System.out.println("Pick a position: ");
            do {
                int userPosition = sc.nextInt();
                switch (userPosition) {
                    case 1:
                        row = 0;
                        column = 0;
                        break;
                    case 2:
                        row = 0;
                        column = 1;
                        break;
                    case 3:
                        row = 0;
                        column = 2;
                        break;
                    case 4:
                        row = 1;
                        column = 0;
                        break;
                    case 5:
                        row = 1;
                        column = 1;
                        break;
                    case 6:
                        row = 1;
                        column = 2;
                        break;
                    case 7:
                        row = 2;
                        column = 0;
                        break;
                    case 8:
                        row = 2;
                        column = 1;
                        break;
                    case 9:
                        row = 2;
                        column = 2;
                        break;
                }
                if (grid[row][column] == 0) {
                    grid[row][column] = 20; //20 will be printed at X later
                    break;
                } else {
                    System.out.println("Position is taken. Please choose another position.");
                    isPositionTaken = true;
                }
            } while (isPositionTaken);


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

    public static void matchMaker(int[][] grid, String playerChoice) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter the number of rounds:");
            int rounds = sc.nextInt();

            // Validate rounds input
            while (rounds <= 0) {
                System.out.println("Rounds can't be less than 1");
                rounds = sc.nextInt();
            }

            // Ensure odd number of rounds
            while (rounds % 2 == 0) {
                System.out.println("Pick only an odd number of rounds.");
                rounds = sc.nextInt();
            }

            int userWins = 0;
            int aiWins = 0;
            int ties = 0;

            // Game loop
            for (int round = 1; round <= rounds; round++) {
                System.out.println("\n---*ROUND " + round + "*---\n");

                do {
                    System.out.println("---AI Turn---");
                    aiTurn(grid);
                    printGrid(grid, playerChoice);
                    if (isAiWinner(grid)) {
                        System.out.println("AI won this round!");
                        aiWins++;
                        break;
                    }
                    if (isTie(grid)) {
                        System.out.println("It's a tie this round!");
                        ties++;
                        break;
                    }

                    System.out.println("--User Turn--");
                    userTurn(grid);
                    printGrid(grid, playerChoice);
                    if (isUserWinner(grid)) {
                        System.out.println("You won this round!");
                        userWins++;
                        break;
                    }
                    if (isTie(grid)) {
                        System.out.println("It's a tie this round!");
                        ties++;
                        break;
                    }
                } while (true);

                resetGrid(grid); // Reset the grid for the next round
            }

            // Display final results
            System.out.println("\n--- RESULTS ---");
            System.out.println("AI Wins: " + aiWins);
            System.out.println("Your Wins: " + userWins);
            System.out.println("Ties: " + ties);

            // Determine final winner
            if (aiWins > userWins) {
                System.out.println("\nAI won, better luck next time!");
            } else if (userWins > aiWins) {
                System.out.println("\nYou won, Congratulations!");
            } else {
                System.out.println("\nTie.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Exiting program...");
        } catch (Exception e) {
            System.out.println("An Exception occurred: " + e.getMessage());
        }
    }
}