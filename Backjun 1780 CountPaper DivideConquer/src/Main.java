import java.util.Scanner;

public class Main {
    static int N;
    static int[][] board;
    static int Gray = 0; //-1인 파티션
    static int Whilt = 0; //0인 파티션
    static int Black = 0; //1인 파티션

    public void partition(int row, int col, int size) {
        //현재 파티션의 컬러를 확인해서 파티션의 갯수를 증가시켜주세용.
        if (colorCheck(row, col, size) == true) {
            if (board[row][col] == 0) Whilt++;
            else if (board[row][col] == 1) Black++;
            else Gray++;
            return;
        }

        //분할 해서 정복하자
        int newsize = size / 3;
        //왼쪽 위 상단
        partition(row, col, newsize);
        partition(row, col + newsize, newsize);
        partition(row, col + 2 * newsize, newsize);

        //중단 왼쪽
        partition(row + newsize, col, newsize);
        partition(row + newsize, col + newsize, newsize);
        partition(row + newsize, col + 2 * newsize, newsize);

        //하단 왼쪽
        partition(row + 2 * newsize, col, newsize);
        partition(row + 2 * newsize, col + newsize, newsize);
        partition(row + 2 * newsize, col + 2 * newsize, newsize);
    }

    public boolean colorCheck(int row, int col, int size) {
        int color = board[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();//9
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        main.partition(0, 0, N);
        System.out.println(Gray);
        System.out.println(Whilt);
        System.out.println(Black);

    }
}
