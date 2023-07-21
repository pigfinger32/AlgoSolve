import java.util.*;
class Lecture implements Comparable<Lecture> {
    public int money;
    public int date;

    public Lecture(int money, int date) {
        this.money = money;
        this.date = date;
    }

    @Override
    public int compareTo(Lecture ob) {
        //내림차순
        return ob.date - this.date;
    }
}

public class Main {
    static int n, max = Integer.MIN_VALUE;
    public int solution(ArrayList<Lecture> arr, int max) {
        int answer = 0;
        int j = 0;
        Collections.sort(arr);//내림차순으로 됨
        PriorityQueue<Integer> pQ = new PriorityQueue(Collections.reverseOrder());
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if(arr.get(j).date < i) break;
                pQ.offer(arr.get(j).money);
            }
            if(!pQ.isEmpty()) answer += pQ.poll();
        }
        return answer;
    }
//      6
//        50 2
//        20 1
//        40 2
//        60 3
//        30 3
//        30 1
    public static void main(String[] args){
        Main main = new Main();
        Scanner kb=new Scanner(System.in);
        n = kb.nextInt();
        int max = Integer.MIN_VALUE;
        ArrayList<Lecture> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int money = kb.nextInt();
            int date = kb.nextInt();
            arr.add(new Lecture(money, date));
            if (date > max) {
                max = date;
            }
        }

        System.out.println(main.solution(arr, max));
    }
}