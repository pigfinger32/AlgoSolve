import java.util.*;
class Time implements Comparable<Time>{
    public int s,e;
    public Time(int s, int e) {
        this.s = s;
        this.e = e;
    }
    @Override
    public int compareTo(Time o) {
        if(o.e == this.e) return this.s - o.s;
        else return this.e - o.e;
    }
}

public class Main {

    public int solution(int n, ArrayList<Time> arr) {
        int answer =0;
        Collections.sort(arr);
        int et = Integer.MIN_VALUE;
        for (Time t : arr) {
            if(t.s >= et){
                answer++;
                et = t.e;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = kb.nextInt();
            int e = kb.nextInt();
            Time t = new Time(s, e);
            arr.add(t);
        }
        System.out.println(main.solution(n, arr));

    }
}