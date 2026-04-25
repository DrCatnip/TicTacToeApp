import java.util.Random;
import java.util.Scanner;

/**
 * TicTacToe
 * UC1–UC4 implementation
 * - Displays empty board
 * - Performs toss and assigns symbols
 * - Accepts user slot input
 * - Converts slot (1–9) to row & column
 */

public class TicTacToeApp {

    /* =========================================================
     * UC1: BOARD DECLARATION
     * A 3x3 2D array representing the Tic-Tac-Toe board
     * ========================================================= */
    static char[][] board = new char[3][3];

    /* =========================================================
     * UC2: GAME STATE VARIABLES
     * Tracks turn and symbol assignment
     * ========================================================= */
    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    /**
     * Entry point of the program
     * Executes UC1 → UC4 in sequence
     */
    public static void main(String[] args) {

        initializeBoard();          // UC1
        tossAndAssignSymbols();     // UC2
        displayTossResult();        // UC2
        printBoard();               // UC1

        int slot = getUserSlot();   // UC3

        // UC4: Convert slot to indices
        System.out.println("Row: " + getRowFromSlot(slot));
        System.out.println("Column: " + getColFromSlot(slot));
    }

    /**
     * UC1: Initializes the board
     * Fills all cells with '-' (empty)
     */
    static void initializeBoard() {

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    /**
     * UC1: Prints the board to console
     * Displays a 3x3 grid format
     */
    static void printBoard() {

        System.out.println("Tic-Tac-Toe Board:");

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    /**
     * UC2: Toss logic
     * Randomly decides who plays first
     * Assigns symbols (X or O)
     */
    static void tossAndAssignSymbols() {

        Random rand = new Random();
        int toss = rand.nextInt(2);

        if (toss == 0) {
            isHumanTurn = true;
            humanSymbol = 'X';
            computerSymbol = 'O';
        } else {
            isHumanTurn = false;
            humanSymbol = 'O';
            computerSymbol = 'X';
        }
    }

    /**
     * UC2: Displays toss result
     * Shows who starts and symbol assignment
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

    /**
     * UC3: Reads slot input from user
     * Input: integer (1–9)
     * Output: slot number
     */
    static int getUserSlot() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter slot (1-9): ");
        return scanner.nextInt();
    }

    /**
     * UC4: Converts slot to row index
     * Formula: (slot - 1) / 3
     * Example:
     * slot 7 → (7-1)/3 = 2 → row 2
     */
    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    /**
     * UC4: Converts slot to column index
     * Formula: (slot - 1) % 3
     * Example:
     * slot 7 → (7-1)%3 = 0 → column 0
     */
    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }
}