/**
 * Created by fatjimmy on 17/7/31.
 */
//leetcode 35
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int result = 0;
        for(int i=0;i<nums.length;i++){
            if(target>nums[i]){
                result = i+1;
            }else if(target == nums[i]){
                result = i;
                break;
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] numbers = {1,3,5,6};
        int target = 0;
        int result = searchInsert(numbers,target);
        System.out.println(result);
    }
}
