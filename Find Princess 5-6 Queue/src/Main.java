import java.util.*;

class Main {
    public int solution(int n, int k) { //
        int result = 0, cnt = 0;
        //1.Q에 1~N까지 모두 offer
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i =0; i < n; i++) {
            queue.offer(i+1);
        }
        //2.Q의 사이즈가 1이면 종료해. 마지막 왕자가 남으면 끝내
        while (queue.size() != 1) {
            cnt++;
            if (cnt % k == 0) {
                queue.poll();
            }else {
                queue.offer(queue.poll());
            }
        }
        //3.Q에 남은 한왕자를 return해
        return queue.poll();
    }
    //        8 3
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();

        System.out.print(main.solution(n,k));

        //Hashtable.replace(key, value);

    }
}