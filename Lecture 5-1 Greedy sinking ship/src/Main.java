import java.util.*;
class Main {
    public int solution(int[] nums, int m){
        int answer = 0;
        //1.배열 내림차순
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        //2.Check배열 생성
        int n = nums.length;
        boolean[] check = new boolean[n];
        //3.배에태우기
        for(int i = 0; i < n; i++){
            if(check[i] == true)
                continue;
            else {
                check[i] = true;
                for(int j = i + 1; j < n; j++){
                    if(check[j] == false && (arr[i] + arr[j] <= m)){
                        check[j] = true;
                        break;
                    }
                }
                answer++;
            }
        }
        return answer;
    }
    public int solution2(int[] nums, int m){
        int answer = 0;
        //1.배열 내림차순
        Arrays.sort(nums);
        int n = nums.length;
        //2.배에태우기
        int lt = 0;
        int rt = n-1;
        while(lt <= rt){
            if(nums[lt] + nums[rt] <= m){
                lt++;
                rt--;
                answer++;
            } else {//한명만 탈수있는 상황
                rt--;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution2(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(T.solution2(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(T.solution2(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }
}