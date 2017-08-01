import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by fatjimmy on 17/7/28.
 */
//leetcode 643
public class MaximumAverageSubarrayI {
    public static double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double max = sum;
        for (int j = 0; j < nums.length - k; j++) {
            sum = sum-nums[j]+nums[j+k];
            if(sum > max){
                max = sum;
            }
        }
        double result = max / k;
        return result;
    }
    public static void main(String[] args){
        int[] numbers = {1,12,-5,-6,50,3};
        int target = 4;
        double result = findMaxAverage(numbers,target);
        System.out.println(result);
    }
}
