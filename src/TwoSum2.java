/**
 * Created by fatjimmy on 17/7/28.
 */
//leetcode 167
    //注意条件递增数列的使用，使复杂度为O(n)
public class TwoSum2 {
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0;
        int j = numbers.length-1;
        while(numbers[i]+numbers[j] != target){
            if(numbers[i]+numbers[j]<target){
                i++;
            }else if(numbers[i]+numbers[j]>target){
                j--;
            }
        }
        result[0] = i+1;
        result[1] = j+1;
        return result;
    }
    public static void main(String[] args){
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(numbers,target);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
