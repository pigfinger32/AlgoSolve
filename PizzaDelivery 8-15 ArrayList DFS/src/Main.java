
import java.util.*;
class Point{
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m, len, answer = Integer.MAX_VALUE;
    static int[] combi;//수열을 담을 배열
    static ArrayList<Point> hs,pz;
    public void DFS(int L, int s) { //
        if(L == m){
            int sum = 0;
            for (Point h : hs) {
                int dis = Integer.MAX_VALUE;
                for (int i : combi) { //피자집중 가장 최소값을 찾아서 dis에 담아줘
                    dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        }else {//수열을 만들어
            for (int i = s; i < len; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }

        }
    }
    //        4 4
//        0 1 2 0
//        1 0 2 1
//        0 2 1 2
//        2 0 1 2
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        hs = new ArrayList<>();
        pz = new ArrayList<>();

        //집 좌표, 피자 좌표 ArrayList
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = kb.nextInt();
                if(tmp == 1) hs.add(new Point(i, j));
                else if(tmp == 2) pz.add(new Point(i, j));
            }
        }
        len = pz.size();
        combi = new int[m];
        main.DFS(0, 0);
        System.out.println(answer);

    }
}