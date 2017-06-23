
/**
 * Created by fatjimmy on 17/5/30.
 */
//leetcode 153 offer 8 二分法 无相同数字
public class FindMinRotatedSortedArray {
    public static int findMin(int[] nums) {
        int front = 0;
        int rear = nums.length-1;
        if(nums.length == 1 || nums[0]<nums[rear]){
            return nums[0];
        }
        while(front+1!=rear){
            int mid = (front+rear)/2;
            if(nums[front]<nums[mid]){
                front = mid;
            }else{
                rear = mid;
            }
        }
        return nums[rear];
    }
    public static void main(String[] args) {
        int[] array = {3,3,1};
        int i = findMin(array);
        System.out.println("The minimum number is: "+i);
    }
}
