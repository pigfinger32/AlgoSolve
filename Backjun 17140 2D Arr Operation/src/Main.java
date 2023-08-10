import java.util.*;

public class Main {
    static int R,C, K;
    static int count = 0;
    static int arr[][] = new int[101][101];
    static Map<Integer, Integer> map = new HashMap<>();

    public void DFS(int row, int col) {
        if (count > 100) {
            System.out.println(-1);
            System.exit(0);
        }
        if (arr[R-1][C-1] == K) {
            System.out.println(count);
            System.exit(0);
        } else {
            if (row >= col) {
                //0.count를 증가하라
                count++;
                //1.최대 컬럼의 개수변수 선언하라
                Integer maxCol = 0;
                //2.행을정렬
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
                    }
                    //3.배열값을 세팅하라
                    List<Integer> keySet = new ArrayList<>(map.keySet());

                    // Value 값으로 오름차순 정렬
                    keySet.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            if (map.get(o1) == map.get(o2)) { //value값이 같으면 key값으로 오름차순
                                return o1.compareTo(02);
                            }
                            return map.get(o1).compareTo(map.get(o2)); //그냥 value값으로 오름차순
                        }
                    });
                    int m = 0;
                    for (Integer key : keySet) {
                        if (m < 100) {//100이후론 버림
                            arr[i][m++] = key; //m = 0 연산 후 m = 1
                            arr[i][m++] = map.get(key); //m = 1 연산 후 m = 2
                        }
                    }
                    //4.DFS를 최대열의 갯수로 넣어서 재귀하라
                    maxCol = Integer.max(maxCol, map.size() * 2);
                    map.clear();
                }
                //5.DFS를 최대열의 갯수로 넣어서 재귀하라
                if(maxCol >100) maxCol = 100;
                DFS(row, maxCol);
            } else {
                //0.count를 증가하라
                count++;
                //1.최대 행의 개수변수 선언하라
                Integer maxRow = 0;
                //2.열을정렬
                for (int i = 0; i < col; i++) {
                    for (int j = 0; j < row; j++) {
                        map.put(arr[j][i], map.getOrDefault(arr[j][i], 0)+1);
                    }
                    //3.배열값을 세팅하라
                    List<Integer> keySet = new ArrayList<>(map.keySet());

                    // Value 값으로 오름차순 정렬
                    keySet.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            if (map.get(o1) == map.get(o2)) { //value값이 같으면 key값으로 오름차순
                                return o1.compareTo(02);
                            }
                            return map.get(o1).compareTo(map.get(o2)); //그냥 value값으로 오름차순
                        }
                    });
                    int m = 0;
                    for (Integer key : keySet) {
                        if (m < 100) {//100이후론 버림
                            arr[m++][i] = key; //m = 0 연산 후 m = 1
                            arr[m++][i] = map.get(key); //m = 1 연산 후 m = 2
                        }
                    }
                    //4.DFS를 최대열의 갯수로 넣어서 재귀하라
                    maxRow = Integer.max(maxRow, map.size() * 2);

                    map.clear();
                }
                //5.DFS를 최대행의 갯수로 넣어서 재귀하라
                if(maxRow >100) maxRow = 100;
                DFS(maxRow, col);
            }
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);
        R = kb.nextInt();
        C = kb.nextInt();
        K = kb.nextInt();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        main.DFS(3, 3);

    }
}
