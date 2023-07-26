import java.util.Arrays;
import java.util.Scanner;
public class Main {
    static int[] dy;
    static int n,m;

    public int solution(int[] coin, int m) {
        Arrays.fill(dy,Integer.MAX_VALUE);
        dy[0] =0;
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j - coin[i]] + 1, dy[j]);
            }
        }
        return dy[m];
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb=new Scanner(System.in);
        n = kb.nextInt();
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = kb.nextInt();
        }
        m = kb.nextInt();
        dy = new int[m+1];
        System.out.println(main.solution(coin, m));
    }
}