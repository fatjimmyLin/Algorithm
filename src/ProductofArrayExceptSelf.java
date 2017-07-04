/**
 * Created by fatjimmy on 17/6/30.
 */
// leetcode 52 offer 238
public class ProductofArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for(int i=1;i<nums.length;i++){
            result[i] = result[i-1]*nums[i-1];
        }
        int temp =1;
        for(int j=nums.length-2;j>=0;j--){
            temp = temp * nums[j+1];
            result[j] = result[j]*temp;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] result = productExceptSelf(nums);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}

