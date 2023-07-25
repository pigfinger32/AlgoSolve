import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] arr;
    static int[] dy;
    static int n;
    public int solution(int[] arr) {
        int answer = 0;
        dy[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if(arr[i]>arr[j] && dy[j] > max) max = dy[j];
            }
            dy[i] = max + 1;
            answer = Integer.max(dy[i], answer);
        }

        return answer;
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb=new Scanner(System.in);
        n = kb.nextInt();
        arr = new int[n];
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(main.solution(arr));;
    }
}