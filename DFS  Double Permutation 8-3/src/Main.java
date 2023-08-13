
import java.util.*;

public class Main {
    static int answer = Integer.MIN_VALUE;
    static int n = 0, m = 0;
    static int[] pm;

    public void DFS(int L) { //
        if (L == m) {
            for (int i : pm) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                pm[L] = i;
                DFS(L + 1);
            }
        }
    }

    // 3 2
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt(); // 자연수
        m = kb.nextInt(); // 갯수
        pm = new int[m];

        main.DFS(0);

        // Hashtable.replace(key, value);

    }
}