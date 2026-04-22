import java.util.Random;

public class TicTacToeApp {

    /*
     * UC1: Board Declaration
     * A 2D array is used to represent the Tic-Tac-Toe board.
     * It has 3 rows and 3 columns.
     * Each cell will store either '-', 'X', or 'O'.
     */
    static char[][] board = new char[3][3];

    /*
     * UC2: Game State Variables
     * These variables help manage the game flow:
     * - isHumanTurn → tracks whose turn it is
     * - humanSymbol → symbol assigned to human player
     * - computerSymbol → symbol assigned to computer
     */
    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    /*
     * Main Method (Entry Point)
     * Executes UC1 and UC2 in sequence:
     * 1. Initialize the board with empty values
     * 2. Perform toss to decide who starts
     * 3. Display toss result and symbol assignment
     * 4. Print the current board
     */
    public static void main(String[] args) {

        initializeBoard();          // UC1: create empty board
        tossAndAssignSymbols();     // UC2: decide turn + symbols
        displayTossResult();        // UC2: show result
        printBoard();               // UC1: display board
    }

    /*
     * UC1: Initialize Board
     * This method fills the entire board with '-'
     * '-' represents an empty cell.
     *
     * Uses nested loops:
     * - Outer loop → iterates rows
     * - Inner loop → iterates columns
     */
    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {          // loop through rows
            for (int j = 0; j < 3; j++) {      // loop through columns
                board[i][j] = '-';             // assign empty symbol
            }
        }
    }

    /*
     * UC1: Print Board
     * Displays the current state of the board on console.
     *
     * Example Output:
     * - - -
     * - - -
     * - - -
     *
     * Uses nested loops to print each cell.
     */
    static void printBoard() {
        System.out.println("Tic-Tac-Toe Board:");

        for (int i = 0; i < 3; i++) {          // loop rows
            for (int j = 0; j < 3; j++) {      // loop columns
                System.out.print(board[i][j] + " ");
            }
            System.out.println();              // move to next line after each row
        }
    }

    /*
     * UC2: Toss and Assign Symbols
     * This method simulates a coin toss using Random class.
     *
     * Logic:
     * - Generate a random number (0 or 1)
     * - If 0 → Human starts first
     * - If 1 → Computer starts first
     *
     * Symbol Assignment:
     * - First player always gets 'X'
     * - Second player gets 'O'
     *
     * Concepts used:
     * - Random number generation
     * - Conditional logic (if-else)
     */
    static void tossAndAssignSymbols() {

        Random rand = new Random();        // create Random object
        int toss = rand.nextInt(2);        // generate 0 or 1

        if (toss == 0) {
            isHumanTurn = true;            // human starts
            humanSymbol = 'X';             // first player gets X
            computerSymbol = 'O';          // second player gets O
        } else {
            isHumanTurn = false;           // computer starts
            humanSymbol = 'O';
            computerSymbol = 'X';
        }
    }

    /*
     * UC2: Display Toss Result
     * Displays:
     * - Who won the toss
     * - Assigned symbols
     * - Who plays first
     *
     * Uses conditional logic based on isHumanTurn variable.
     */
    static void displayTossResult() {

        if (isHumanTurn) {
            System.out.println("You won the toss!");
            System.out.println("You are: " + humanSymbol);
            System.out.println("Computer is: " + computerSymbol);
            System.out.println("You play first.");
        } else {
            System.out.println("Computer won the toss!");
            System.out.println("You are: " + humanSymbol);
            System.out.println("Computer is: " + computerSymbol);
            System.out.println("Computer plays first.");
        }
    }
}