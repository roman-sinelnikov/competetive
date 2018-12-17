
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class King {

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int r, c;
        r = in.nextInt();
        c = in.nextInt();

        int result = 0;

        result = solve(r, c);

        out.println(result);

        in.close();
        out.close();
    }

    public static int solve(int r, int c) {
        // Idea for solving this issue attached in xls file 
        return r*c - (int) Math.ceil((double)r/3) * (int) Math.ceil((double)c/3);
    }

    // brute force backtracking solution
    private static int solveBrute(boolean[][] board) {
        return Math.max(solveBrute(0, 0, board, 0), solveBrute(0, 1, board, 0));
    }

    // the idea is to fill rows optimally first, then fill columns for one row and sum the values,
    // out of time on values > 70
    private static int solveSmart(boolean[][] board) {
        int maxFilledRows = 0;
        int maxFilledColumns = 0;
        maxFilledRows = Math.max(maxFilledRows(0, board, 0), maxFilledRows(1, board, 0));
        maxFilledColumns = Math.max(maxFilledColumns(0, board[0], 0), maxFilledColumns(1, board[0], 0));
        //System.out.println("Optimal rows: " + maxFilledRows + " Optimal cols: " + maxFilledColumns);
        System.out.println("Ops: " + maxFilledRowsCount);
        return maxFilledRows * board[0].length + (board.length - maxFilledRows) * maxFilledColumns;
    }

    private static int solveSmarter(boolean[][] board) {
        return 0;
    }


    private static boolean canMove(int r, int c, boolean[][] board) {
        for (int i = r - 1; i <= r + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {
                if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
                    continue;
                if (!board[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void printBoard(boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print((board[i][j] ? "t" : "f") + " ");
            }
            System.out.println();
        }
    }


    private static boolean blocking(int r, int c, boolean[][] board) {
        boolean notBlocking = true;
        if (r != 0 && c != 0 && board[r-1][c-1]) {
            notBlocking &= canMove(r-1, c-1, board);
        }
        if (c != 0 && board[r][c-1]) {
            notBlocking &= canMove(r, c-1, board);
        }

        return !notBlocking;
    }

    private static int solveBrute(int r, int c, boolean[][] board, int max) {
        if (c >= board[0].length) {
            // switch to next row if column is invalid
            return solveBrute(r + 1, board[0].length == c ? 0 : 1, board, max);
        }
        if (r >= board.length) {
           // printBoard(board);
            return max;
        }

        board[r][c] = true;

        if (!blocking(r, c, board)) {
            int localMax = max + 1;
            for (int i = r; i < board.length; i++) {
                for (int j = c; j < board[0].length; j++) {
                    max = Math.max(solveBrute(r, c + 1, board, localMax), solveBrute(r, c + 2, board, localMax));
                }
            }
        }
        board[r][c] = false;
        return max;
    }



    private static boolean canFillRow(int r, boolean[][] board) {
        if (r == 0 && board.length == 1) {
            return false;
        }
        if (r == 0) // can fill first row if there is a space after it
            return true;
        if (r == board.length - 1 && board[r-1][0] == false) { // can fill last row only if previous row is not filled
            return true;
        }
        if (r > 0 && r < board.length - 1) { // can fill intermediary
            if (board[r-1][0] == false) { //if previous is empty
                return true;
            } else if (r > 1 && board[r-2][0] == false) { // or previous row has line to move
                return true;
            }
        }

        return false;
    }

    private static boolean canFillColumn(int c, boolean[] row) {
        if (c == 0) { // always can fill first column
            return true;
        }
        if (c == row.length - 1 && row[c-1] == false) { // can fill last row only if previous column is not filled
            return true;
        }
        if (c > 0 && c < row.length - 1) { // can fill intermediary
            if (row[c - 1] == false) { // if previous is empty
                return true;
            } else if (c > 1 && row[c - 2] == false) { // or previous row has space to move
                return true;
            }
        }
        return false;
    }
    private static int maxFilledRowsCount = 0;
    private static int maxFilledRows(int r, boolean[][] board, int max) {

        if (r >= board.length) {
            maxFilledRowsCount += 1;
            System.out.println(r);
            //System.out.println();
            //printBoard(board);
            //System.out.println("MAX: " + max);
            return max;
        }

        if (canFillRow(r, board)) {
            int localMax = max + 1;
            board[r][0] = true;//Arrays.fill(board[r], true); // No need to actually fill the whole row, we use only first item to check
            max = Math.max(maxFilledRows(r + 1, board, localMax), max);
            max = Math.max(maxFilledRows(r + 2, board, localMax), max);
            board[r][0] = false; //Arrays.fill(board[r], false); // No need to actually fill the whole row
        }

        return max;
    }

    private static int maxFilledColumns(int c, boolean[] row, int max) {
        if (c >= row.length) {
            //System.out.println();
            //printBoard(new boolean[][] { row });
            return max;
        }

        if (canFillColumn(c, row)) {
            int localMax = max + 1;
            row[c] = true;
            max = Math.max(maxFilledColumns(c + 1, row, localMax), max);
            max = Math.max(maxFilledColumns(c + 2, row, localMax), max);
            row[c] = false;
        }
        return max;
    }

}