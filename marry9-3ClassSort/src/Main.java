import java.util.*;

//      5
//        14 18
//        12 15
//        15 20
//        20 30
//        5 14
public class Main {
    static class Time implements Comparable<Time> {
        public int time;
        public char state;

        public Time(int t, char s) {
            this.time = t;
            this.state = s;
        }

        @Override
        public int compareTo(Time o) {
            //오름차순
            if (this.time == o.time) {
                return this.state - o.state;
            } else {
                return this.time - o.time;
            }
        }

    }
    public int solution(ArrayList<Time> arr, int n) {
        int answer = Integer.MIN_VALUE;
        int tmp = 0;
        Collections.sort(arr);
        for (Time time1 : arr) {
            if (time1.state == 'S') {
                tmp++;
            } else {
                tmp--;
            }
            answer = Math.max(answer, tmp);
        }
        return answer;
    }
    public static void main(String[] args){
        Main main = new Main();
        Scanner kb=new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int t1 = kb.nextInt();
            char s1 = 'S';
            arr.add(new Time(t1, s1));
            int t2 = kb.nextInt();
            char s2 = 'E';
            arr.add(new Time(t2, s2));
        }

        System.out.println(main.solution(arr,n));
        return ;
    }
}