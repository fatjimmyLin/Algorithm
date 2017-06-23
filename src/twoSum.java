
/**
 * Created by fatjimmy on 17/6/17.
 */
public class twoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int target = 6;
        int[] n = {3,3};
        int[] result  = twoSum(n,target);
        for(int i=0;i<2;i++){
            System.out.println("The two Sum is: "+result[i]);
        }

    }
}
