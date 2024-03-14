package org.example;

import java.util.Arrays;

public class TicTacToe {

    private int[][] board;
    static int result;

    public TicTacToe() {

        board = new int[][] {
                {0, 0, 1},
                {0, 1, 2},
                {2, 1, 0}
        };

        System.out.println(Arrays.deepToString(board));
    }

    private int checkHorizontal() {
        for (int row = 0; row < 3; row ++) {
            for (int col = 0; col < 1; col ++) {
                if (board[row][col] != 0 &&
                        board[row][col] == board[row][col + 1] &&
                        board[row][col] == board[row][col + 2]) {

                    return board[row][col];
                }
            }
        }
        return 0;
    }

    private int checkVertical() {
        for (int col = 0; col < 3; col ++) {
            for (int row = 0; row < 1; row ++) {
                if (board[row][col] != 0 &&
                        board[row][col] == board[row + 1][col] &&
                        board[row][col] == board[row + 2][col]) {

                    return board[row][col];
                }
            }
        }
        return 0;
    }

    private int checkDiagonal() {
        if (board[0][0] != 0 &&
                board[0][0] == board[1][1] &&
                board[0][0] == board[2][2]) {

            return board[0][0]; // Bottom left
        }

        if (board[0][2] != 0 &&
                board[0][2] == board[1][1] &&
                board[0][2] == board[2][0]) {

            return board[0][2]; // Bottom right
        }
        return 0;
    }

    public int getResult() {

        int horizontal = checkHorizontal();
        int vertical = checkVertical();
        int diagonal = checkDiagonal();

        int max = Math.max(Math.max(horizontal, vertical), diagonal);

        switch (max) {
            case 0:
                for (int[] row : board) {
                    for (int cell : row) {
                        if (cell == 0) {
                            System.out.println("Game is not finished >:I");
                            return -1;
                        }
                    }
                }
                System.out.println("It's a draw!");
                return 0;
            case 1:
                System.out.println("X wins!");
                return max;
            case 2:
                System.out.println("O wins!");
                return max;
            default:
                System.out.println("Game is not finished >:I");
                return -1;
        }
    }

    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();
        result = game.getResult();

        System.out.println(result);

    }

}