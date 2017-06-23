import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fatjimmy on 17/6/14.
 */
//leetcode 46 offer 28
public class Permutations{
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        permuteHelper(nums, 0, res);
        return res;
    }

    public static void permuteHelper(int[] nums, int index, List<List<Integer>> list) {
        if(index >= nums.length-1) {
            //add the current array in the list
            List<Integer> temp = new ArrayList<>();
            for(int n : nums) {
                temp.add(n);
            }
            list.add(temp);
            return;
        }
        //permute nums[index...nums.length-1]
        for(int i = index; i<nums.length; i++) {

            //swap the index-th number with the i-th number
            int t = nums[index];
            nums[index] = nums[i];
            nums[i] = t;

            //recurse for nums[index+1,nums.length-1]
            permuteHelper(nums, index+1, list);

            //!!! swap back the number
            t = nums[index];
            nums[index] = nums[i];
            nums[i] = t;
        }
    }

    public static void main(String[] args) {
        int[] number = {1,2,3};
        List<List<Integer>> list = permute(number);
        System.out.println("The permutation list is: "+list);
    }
}
