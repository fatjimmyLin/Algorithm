import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fatjimmy on 17/8/1.
 */
//leetcode 15 双指针
public class Sum3 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue; //skip the same result
            int lo = i+1;
            int hi = nums.length-1;
            int sum = 0-nums[i];
            while(lo<hi){
                if(nums[lo]+nums[hi]==sum){
                    result.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                    lo++;
                    hi--;
                    while(lo<hi && nums[lo]==nums[lo-1]) lo++; //skip the same result
                    while(lo<hi && nums[hi]==nums[hi+1]) hi--; //skip the same result
                }else if(nums[lo]+nums[hi]>sum) hi--;
                else lo++;
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] num = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> array = threeSum(num);
        System.out.println(array);
    }
}
