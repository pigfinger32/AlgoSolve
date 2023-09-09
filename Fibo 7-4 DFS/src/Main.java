
import javax.naming.PartialResultException;
import java.util.*;

public class Main {
    static long n = 0, m = 0;
    static long[] arr;

    public Long factorial(long L) { //
        if(L <= 1) return arr[(int)L] = L;
        else {
            return arr[(int)L] = factorial(L-1) * L;
        }
    }
    // 3 2
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextLong(); // 자연수
        m = kb.nextLong(); // 갯수
        arr = new long[(int)n+1];
        main.factorial(n);

        System.out.println( arr[(int)n] / (arr[(int)n-(int)m] * arr[(int)m]));

        // Hashtable.replace(key, value);

    }
}