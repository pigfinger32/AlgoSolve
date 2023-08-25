import java.util.*;
class Main {
    public int solution2(int[] nums){
        int answer = 0;
        int count = 1;
        int lt = 0, rt = 0;
        Arrays.sort(nums);

        while(true){
            if(rt >= nums.length) {
                answer = Math.max(answer,count);
                break;
            }
            if(Math.abs(Math.abs(nums[rt]) - Math.abs(nums[lt])) > 1){//수열의 차가 1보다 크다면
                answer = Math.max(answer,count);
                lt = rt;
                count = 1;
            }else if(Math.abs(Math.abs(nums[rt]) - Math.abs(nums[lt])) == 1){//수열의 차가 1이라면
                count++;
                lt = rt;
            } //else일 경우는 수열의 크기가 같을경우
            rt++;
        }

        return answer;
    }
    public int solution(int[] nums){
        int answer = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(Integer i : nums) hs.add(i);
        for(Integer x : hs){
            //hsSet 원소값보다 1 적은값이 있으면 다음에 그친구가 반복해서 찾도록 continue
            if(hs.contains(x-1)) continue;
            int count=0;
            while(hs.contains(x)){
                count++;
                x++;
            }
            answer = Math.max(answer,count);
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}