import java.util.Random;
import java.util.Scanner;

/**
 * TicTacToe
 * UC1–UC7 implementation
 * - Display board
 * - Toss & symbol assignment
 * - User input
 * - Slot → row/column conversion
 * - Move validation
 * - Place move
 * - Computer random move
 */

public class TicTacToeApp {

    /* =========================================================
     * UC1: BOARD DECLARATION
     * 3x3 board represented using a 2D array
     * Each cell stores '-', 'X', or 'O'
     * ========================================================= */
    static char[][] board = new char[3][3];

    /* =========================================================
     * UC2: GAME STATE VARIABLES
     * Tracks current turn and assigned symbols
     * ========================================================= */
    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    /**
     * Entry point of the program
     * Executes UC1 → UC7
     */
    public static void main(String[] args) {

        initializeBoard();          // UC1
        tossAndAssignSymbols();     // UC2
        displayTossResult();        // UC2
        printBoard();               // UC1

        // Human move
        int slot = getUserSlot();   // UC3

        int row = getRowFromSlot(slot);   // UC4
        int col = getColFromSlot(slot);   // UC4

        if (isValidMove(row, col)) {
            placeMove(row, col, humanSymbol);   // UC6
        } else {
            System.out.println("Invalid move");
        }

        printBoard();

        // UC7: Computer move
        computerMove();

        System.out.println("\nAfter computer move:");
        printBoard();
    }

    /**
     * UC1: Initialize board
     * Fills all cells with '-'
     */
    static void initializeBoard() {

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    /**
     * UC1: Print board
     * Displays the 3x3 grid
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
     * Randomly decides first player and assigns symbols
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
     * UC2: Display toss result
     */
    static void displayTossResult() {

        if (isHumanTurn) {
            System.out.println("You won the toss!");
            System.out.println("You are: " + humanSymbol);
            System.out.println("Computer is: " + computerSymbol);
        } else {
            System.out.println("Computer won the toss!");
            System.out.println("You are: " + humanSymbol);
            System.out.println("Computer is: " + computerSymbol);
        }
    }

    /**
     * UC3: Read user slot input (1–9)
     */
    static int getUserSlot() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter slot (1-9): ");
        return scanner.nextInt();
    }

    /**
     * UC4: Convert slot to row index
     * Formula: (slot - 1) / 3
     */
    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    /**
     * UC4: Convert slot to column index
     * Formula: (slot - 1) % 3
     */
    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }

    /**
     * UC5: Validate move
     * - Row and column must be within 0–2
     * - Target cell must be empty
     */
    static boolean isValidMove(int row, int col) {

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        if (board[row][col] != '-') {
            return false;
        }

        return true;
    }

    /**
     * UC6: Place move on board
     * Updates board at given position with symbol
     */
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    /**
     * UC7: Computer random move
     * - Generates random slot (1–9)
     * - Converts to row/column
     * - Validates move
     * - Repeats until valid
     * - Places computer symbol
     */
    static void computerMove() {

        Random rand = new Random();

        while (true) {

            int slot = rand.nextInt(9) + 1;

            int row = getRowFromSlot(slot);
            int col = getColFromSlot(slot);

            if (isValidMove(row, col)) {
                placeMove(row, col, computerSymbol);
                break;
            }
        }
    }
}