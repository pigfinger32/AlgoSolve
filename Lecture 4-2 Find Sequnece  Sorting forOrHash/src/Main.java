import java.util.*;
class Main {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length / 2];
        int idx = 0;
        //1.오름차순 정렬
        Arrays.sort(nums);
        //2.check배열 선언
        boolean[] check = new boolean[nums.length];
        //3.for for
        for(int i = 0; i < nums.length; i++){
            //3-1 check배열이 True 이미 선택되었기 때문에 continue
            if(check[i] == true) continue;
            for(int j = i+1; j < nums.length; j++){
                //3-2 j는 i의 두배 && check[j] == false
                if(nums[i] * 2 == nums[j] && check[j] == false){
                    answer[idx] = nums[i];
                    check[j] = true;
                    idx++;
                }
            }
        }

        return answer;
    }

    public int[] solution2(int[] nums){
        int[] answer = new int[nums.length / 2];
        int idx = 0;
        //0.오름차순 정렬
        Arrays.sort(nums);
        //1.hashMap 선언
        HashMap<Integer,Integer> hash = new HashMap<>();

        //2.hashMap을 값을 채워주세요.
        for(int x : nums){
            hash.put(x, hash.getOrDefault(x, 0) + 1);
        }
        //3.for for
        for(int x : nums){
            //3-1 hash가 이미 0이기 때문에 continue
            if(hash.get(x) == 0) continue;
            //3-2 값을 넣고 hash에 값을 1씩 줄여줘
            answer[idx] = x;
            idx++;
            hash.put(x, hash.get(x) - 1);
            hash.put(x*2, hash.get(x*2) - 1);
        }

        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(Arrays.toString(T.solution2(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution2(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution2(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}