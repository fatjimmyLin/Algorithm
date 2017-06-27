
/**
 * Created by fatjimmy on 17/6/17.
 */
// leetcode 1 offer 41
public class twoSum {
    // O(n*n);
//    public static int[] twoSum(int[] nums, int target) {
//        int[] result = new int[2];
//        for(int i=0;i<nums.length;i++){
//            for(int j=i+1;j<nums.length;j++){
//                if(nums[i]+nums[j] == target){
//                    result[0] = i;
//                    result[1] = j;
//                    break;
//                }
//            }
//        }
//        return result;
//    }
    // O(n)适用于排序数组
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int ahead = 0;
        int back = nums.length-1;
        while(back>ahead){
            if(nums[ahead]+nums[back] == target){
                result[0] = ahead;
                result[1] = back;
                break;
            }else if(nums[ahead]+nums[back]<target){
                ahead++;
            }else back--;
        }
        return result;
    }
    public static void main(String[] args) {
        int target = 6;
        int[] n = {2,3,4};
        int[] result  = twoSum(n,target);
        for(int i=0;i<2;i++){
            System.out.println("The two Sum is: "+result[i]);
        }

    }
}
