import java.util.Random;
import java.util.Scanner;

/**
 * TicTacToe
 * UC1–UC8 implementation
 * - Board display
 * - Toss & symbol assignment
 * - User input
 * - Slot → row/column conversion
 * - Move validation
 * - Place move
 * - Computer random move
 * - Continuous game loop
 */

public class TicTacToeApp {

    /* =========================================================
     * UC1: BOARD DECLARATION
     * ========================================================= */
    static char[][] board = new char[3][3];

    /* =========================================================
     * UC2: GAME STATE VARIABLES
     * ========================================================= */
    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    /* =========================================================
     * UC8: GAME LOOP CONTROL
     * ========================================================= */
    static boolean gameOver = false;

    /**
     * Entry point of the program
     * Executes UC1 → UC8
     */
    public static void main(String[] args) {

        initializeBoard();          // UC1
        tossAndAssignSymbols();     // UC2
        displayTossResult();        // UC2
        printBoard();               // UC1

        // UC8: Continuous game loop
        while (!gameOver) {

            if (isHumanTurn) {

                // Human turn
                int slot = getUserSlot();        // UC3
                int row = getRowFromSlot(slot);  // UC4
                int col = getColFromSlot(slot);  // UC4

                if (isValidMove(row, col)) {
                    placeMove(row, col, humanSymbol);   // UC6
                    isHumanTurn = false;                // switch turn
                } else {
                    System.out.println("Invalid move, try again.");
                    continue;
                }

            } else {

                // Computer turn
                computerMove();   // UC7
                isHumanTurn = true;  // switch turn
            }

            printBoard();   // show updated board
        }
    }

    /**
     * UC1: Initialize board
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
     * UC3: Get user slot input
     */
    static int getUserSlot() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter slot (1-9): ");
        return scanner.nextInt();
    }

    /**
     * UC4: Slot → row
     */
    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    /**
     * UC4: Slot → column
     */
    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }

    /**
     * UC5: Validate move
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
     * UC6: Place move
     */
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    /**
     * UC7: Computer random move
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