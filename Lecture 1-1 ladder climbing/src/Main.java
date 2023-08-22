import java.util.*;
class Solution {
    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];
        //1.n개의 Alpha ArrayList를 만들어 사다리를 넘어갈때마다 position을 갱신하자.
        ArrayList<Node> alphaList = new ArrayList();
        for(int i = 0; i < n; i ++){
            char c = (char)('A' + i);
            Node node = new Node(c, i+1);
            alphaList.add(node);
        }
        for(Node node : alphaList){
            for(int[] step : ladder){
                for(int start : step){
                    if(node.position == start){
                        node.position++;
                    } else if(node.position == start+1){
                        node.position--;
                    }
                }
            }
        }
        Collections.sort(alphaList);
        for(int i = 0; i< n;i++){
            answer[i]=alphaList.get(i).alpha;
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
class Node implements Comparable<Node>{
    public char alpha;
    public int position;

    public Node(char c, int p){
        this.alpha = c;
        this.position = p;
    }

    @Override
    public int compareTo(Node o){
        //오름차순
        return this.position - o.position;
    }

}