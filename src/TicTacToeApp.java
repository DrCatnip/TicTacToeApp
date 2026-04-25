import java.util.Random;
import java.util.Scanner;

/**
 * TicTacToe
 * UC1–UC9 implementation
 * - Board display
 * - Toss & symbol assignment
 * - User input
 * - Slot → row/column conversion
 * - Move validation
 * - Place move
 * - Computer random move
 * - Game loop
 * - Win detection
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

    public static void main(String[] args) {

        initializeBoard();
        tossAndAssignSymbols();
        displayTossResult();
        printBoard();

        while (!gameOver) {

            if (isHumanTurn) {

                int slot = getUserSlot();
                int row = getRowFromSlot(slot);
                int col = getColFromSlot(slot);

                if (isValidMove(row, col)) {
                    placeMove(row, col, humanSymbol);

                    // UC9: Check win
                    if (hasWon(humanSymbol)) {
                        printBoard();
                        System.out.println("You win!");
                        gameOver = true;
                        break;
                    }

                    isHumanTurn = false;

                } else {
                    System.out.println("Invalid move, try again.");
                    continue;
                }

            } else {

                computerMove();

                // UC9: Check win
                if (hasWon(computerSymbol)) {
                    printBoard();
                    System.out.println("Computer wins!");
                    gameOver = true;
                    break;
                }

                isHumanTurn = true;
            }

            printBoard();
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
     * UC3: Get user input
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
     * UC7: Computer move
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

    /**
     * UC9: Check winning condition
     * Checks rows, columns, and diagonals
     */
    static boolean hasWon(char symbol) {

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol &&
                    board[i][1] == symbol &&
                    board[i][2] == symbol) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == symbol &&
                    board[1][i] == symbol &&
                    board[2][i] == symbol) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == symbol &&
                board[1][1] == symbol &&
                board[2][2] == symbol) {
            return true;
        }

        if (board[0][2] == symbol &&
                board[1][1] == symbol &&
                board[2][0] == symbol) {
            return true;
        }

        return false;
    }
}