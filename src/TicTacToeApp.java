import java.util.Random;
import java.util.Scanner;

public class TicTacToeApp {

    /*
     * UC1: Board Declaration
     * 3x3 Tic-Tac-Toe board
     */
    static char[][] board = new char[3][3];

    /*
     * UC2: Game State Variables
     */
    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    /*
     * Main Method
     * UC1 → UC2 → UC3
     */
    public static void main(String[] args) {

        initializeBoard();          // UC1
        tossAndAssignSymbols();     // UC2
        displayTossResult();        // UC2
        printBoard();               // UC1

        int slot = getUserSlot();   // UC3
        System.out.println("Slot entered: " + slot);
    }

    /*
     * UC1: Initialize Board
     */
    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    /*
     * UC1: Print Board
     */
    static void printBoard() {
        System.out.println("Tic-Tac-Toe Board:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
     * UC2: Toss Logic
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

    /*
     * UC2: Display Toss Result
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

    /*
     * UC3: Accept User Slot Input (1–9)
     */
    static int getUserSlot() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter slot (1-9): ");
        int slot = scanner.nextInt();

        return slot;
    }
}