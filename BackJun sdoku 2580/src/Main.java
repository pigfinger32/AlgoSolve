import java.util.Scanner;

public class Main {
    static int[][] arr;

    public void sdoku(int row, int col) {
        if (col == 9) {
            sdoku(row + 1, 0);
            return;//잘못 채워진경우 상단의 sdoku로 돌아가기 위해
        }
        //모두 돌았으니 출력하세요.
        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }
        if (arr[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (checkPossible(row, col, i)) {
                    arr[row][col] = i;
                    sdoku(row, col + 1);
                }
            }
            arr[row][col] = 0;//위 스도쿠 재귀에서 만약 해당값으로 스토쿠를 만들지 못했을 때 . 배열은 이미 값이 들어간 것으로 되어있으면 결과가 재대로 나오지 않기 때문이다.
            return;
        }
        sdoku(row, col + 1);
    }

    public boolean checkPossible(int row, int col, int value) {
        //가로
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == value) {
                return false;
            }
        }
        //세로
        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == value) {
                return false;
            }
        }
        //사각형
        int setRow = (row / 3) * 3;
        int setCol = (col / 3) * 3;
        for (int i = setRow; i < setRow + 3; i++) {
            for (int j = setCol; j < setCol + 3; j++) {
                if (arr[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb=new Scanner(System.in);
        arr = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        main.sdoku(0, 0);
    }
}