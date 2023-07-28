import java.util.*;
public class Main {
    static int L, C;
    static char[] pm, arr, tmpSortArr;
    static int[] ch;
    static ArrayList<Integer> sizeArr = new ArrayList<>();

    public boolean valid(char[] pm) {
        int mo = 0;
        int ja = 0;
        for (char c : pm) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                mo++;
            }else {ja++;}
        }
        if (mo >= 1 && ja >= 2) {
            return true;
        }else
            return false;
    }

    public void DFS(int level, int start) {
        if (level == L) {
            if (valid(pm) == true) {
                for (char c : pm) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
        else {
            for (int i = start; i < C; i++) {
                pm[level] = arr[i];
                DFS(level + 1,i+1);
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb=new Scanner(System.in);
        L = kb.nextInt();//nXn
        C = kb.nextInt();//nXn
        arr = new char[C];
        pm = new char[L];
        ch = new int[C];
        tmpSortArr = new char[L];

        //전체 사각형 입력 받기
        for(int i=0; i<C; i++){
            arr[i] = kb.next().charAt(0);
        }
        Arrays.sort(arr);
        main.DFS(0,0);


    }
}