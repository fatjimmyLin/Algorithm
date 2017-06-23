/**
 * Created by fatjimmy on 17/6/1.
 */
//leetcode 154 二分法 有重复数字
public class FindMinRotatedSortedArray2 {
    public static int findMin(int[] nums) {
        int front = 0;
        int rear = nums.length-1;
        if(nums.length == 1 || nums[0]<nums[rear]){
            return nums[0];
        }
        while(front+1!=rear){
            int mid = (front+rear)/2;
            if(nums[front] == nums[mid] && nums[mid] == nums[rear]){
                return Search(nums,front,rear);// 只能顺序搜索了
            }
            if(nums[front]<=nums[mid]){
                front = mid;
            }else{
                rear = mid;
            }
        }
        return nums[rear];
    }
    public static int Search(int[] nums,int front,int rear){
        int min = nums[front];
        for(int i=front+1;i<rear;i++){
            if(nums[i]<min){
                min = nums[i];
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int[] array = {10,2,10,10,10};
        int i = findMin(array);
        System.out.println("The minimum number is: "+i);
    }
}
