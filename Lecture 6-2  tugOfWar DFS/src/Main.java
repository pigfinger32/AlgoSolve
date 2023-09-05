import java.util.*;
class Main {
    static int[][] relation;
    static int answer;
    static Stack<Integer> pm;
    static int[] ch;
    public int solution(int[][] fight){
        //0.pm, relation, ch배열 초기화
        answer = 0;
        pm = new Stack<>();
        relation = new int[8][8];
        ch = new int[8];

        //1.Fight relation 2차원 배열
        for(int[] x : fight){
            relation[x[0]][x[1]] = 1;
            relation[x[1]][x[0]] = 1;
        }
        //2.DFS 중복되지 않는 수열 만든다.
        DFS(0);
        //3.answer 반환
        return answer;
    }

    public void DFS(int L){
        //1.7명 줄을 세웠으면 answer++;
        if(L == 7){
            answer++;
        }
        //2.7명이 아니면 중복되지 않는 수열을 만든다.
        else{
            //2-1 pm 자료구조에 값이 있으면서 && 자료구조 마지막 값이 지금 들어갈 값과 싸웠으면 continue 뻗지마
            for(int i = 1; i < 8; i++){
                if(!pm.isEmpty() && relation[pm.peek()][i] == 1) continue;
                if(ch[i] == 0) { //2-2 체크배열에 체크 안되어있으면
                    //2-2-1 체크배열 체크, pm자료구조에 값 넣고, DFS(L+1), 체크배열 풀고, 자료구조 값 빼기
                    ch[i] = 1;
                    pm.push(i);
                    DFS(L+1);
                    ch[i] = 0;
                    pm.pop();
                }
            }

        }

    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
