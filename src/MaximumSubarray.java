/**
 * Created by fatjimmy on 17/6/18.
 */
// leetcode 53 offer 31
public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        if(nums == null) return 0;
        int sum = nums[0];
        int cursum = 0;
        for(int i=0;i<nums.length;i++){
            if(cursum >=0) {
                cursum = cursum + nums[i];
            }else cursum = nums[i];
            if(cursum > sum) sum = cursum;
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] nums = {3,3,-1,2,3,-5,4,6,-9};
        int result  = maxSubArray(nums);
        System.out.println("The largest Sum is: "+result);
    }
}
