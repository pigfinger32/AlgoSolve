import java.util.*;
class Main {
    public int solution(int[] nums){
        int answer = 0;
        //1.정렬
        Arrays.sort(nums);
        //2.Check 배열 선언
        boolean[] check = new boolean[nums.length];
        //3.for for
        for(int i = 0; i < nums.length; i++){
            //3-1 체크배열이 true 면 continue;
            if(check[i] == true) continue;
            //3-2 flag = false로 초기화
            boolean flag = false;
            //3-3 for 뒤에서부터 앞까지 j를 옮겨
            for(int j = nums.length-1; j >= 0; j--){
                //3-4 체크배열이 true 면 continue;
                if(check[j] == true) continue;
                //3-5 if 둘의 합이 5이하면 수량올리고 check배열 체크하고 flag true 변경
                if(nums[i] + nums[j] <= 5){
                    answer++;
                    check[i] = true;
                    check[j] = true;
                    flag = true;
                    break;
                }
            }
            //3-6 if(flag == false) 수량올리고 check배열 체크하고
            if(flag == false){
                answer++;
                check[i] = true;
            }
        }

        return answer;
    }

    public int solution2(int[] nums){
        int answer = 0;
        //1.정렬
        Arrays.sort(nums);
        //2.left right 변수 선언
        int left = 0;
        int right = nums.length-1;
        //3.while
        while(left <= right){
            if(nums[left] + nums[right] <= 5 ){
                answer++;
                left++;
                right--;
            } else {
                answer++;
                right--;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution2(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution2(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution2(new int[]{3, 3, 3, 3, 3}));
    }
}