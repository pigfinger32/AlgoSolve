import java.util.*;

class Cube implements Comparable<Cube> {
    public int bottom;
    public int top;
    public int weight;

    public Cube(int bottom, int top, int weight) {
        this.bottom = bottom;
        this.top = top;
        this.weight = weight;
    }

    @Override
    public int compareTo(Cube ob) {
        return ob.bottom - this.bottom;
    }
}

public class Main {
    static ArrayList<Cube> arr;
    static int[] dy;
    static int n;
    public int solution(ArrayList<Cube> arr) {
        dy[0] = arr.get(0).top;
        int answer = dy[0];
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if(arr.get(i).weight<arr.get(j).weight ) max = Integer.max(dy[j],max);
            }
            dy[i] = max + arr.get(i).top;
            answer = Integer.max(dy[i], answer);
        }

        return answer;
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb=new Scanner(System.in);
        n = kb.nextInt();
        arr = new ArrayList<Cube>();
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            arr.add(new Cube(a, b, c));
        }
        Collections.sort(arr);
        System.out.println(main.solution(arr));;
    }
}