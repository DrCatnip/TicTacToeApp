import java.util.Random;
import java.util.Scanner;

/**
 * TicTacToe
 * UC1–UC5 implementation
 * - Board display
 * - Toss and symbol assignment
 * - User input
 * - Slot → row/column conversion
 * - Move validation
 */

public class TicTacToeApp {

    /* =========================================================
     * UC1: BOARD DECLARATION
     * 3x3 board using 2D array
     * ========================================================= */
    static char[][] board = new char[3][3];

    /* =========================================================
     * UC2: GAME STATE VARIABLES
     * Tracks turn and symbols
     * ========================================================= */
    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    /**
     * Entry point of the program
     * Executes UC1 → UC5
     */
    public static void main(String[] args) {

        initializeBoard();          // UC1
        tossAndAssignSymbols();     // UC2
        displayTossResult();        // UC2
        printBoard();               // UC1

        int slot = getUserSlot();   // UC3

        int row = getRowFromSlot(slot);   // UC4
        int col = getColFromSlot(slot);   // UC4

        // UC5: Validate move
        if (isValidMove(row, col)) {
            System.out.println("Valid move");
        } else {
            System.out.println("Invalid move");
        }
    }

    /**
     * UC1: Initialize board with '-'
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
     * UC2: Toss logic and symbol assignment
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
            System.out.println("You play first.");
        } else {
            System.out.println("Computer won the toss!");
            System.out.println("You are: " + humanSymbol);
            System.out.println("Computer is: " + computerSymbol);
            System.out.println("Computer plays first.");
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
     * - Row & column must be within 0–2
     * - Cell must be empty ('-')
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
}