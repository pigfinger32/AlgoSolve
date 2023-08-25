import java.util.*;
class Main {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length];
        List<Number> list = new ArrayList<>();
        for(int n : nums){
            int num = n;
            String binary = Integer.toBinaryString(num);
            int count = getCount(binary);
            list.add(new Number(num,binary,count));
        }
        Collections.sort(list);

        for(int i = 0; i < nums.length;i++){
            answer[i] = list.get(i).num;
        }

        return answer;
    }
    public int getCount(String binary){
        int count = 0;
        for(char i : binary.toCharArray()){
            if(i == '1'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}
class Number implements Comparable<Number>{
    public int num;
    public String binary;
    public int count;
    public Number(int n, String bin, int c){
        this.num = n;
        this.binary = bin;
        this.count = c;
    }
    @Override
    public int compareTo(Number o){
        if(this.count == o.count){
            return this.num - o.num;
        }else{
            return this.count - o.count;
        }
    }

}