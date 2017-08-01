import java.util.List;

/**
 * Created by fatjimmy on 17/7/31.
 */
//leetcode 189
public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if(k == 0 ) return;
        if(n == k){
            reverse(nums,n);
            return;
        }
        reverse(nums,n-k);
        reverse(nums,n);
        reverse(nums,k);
    }
    public static void reverse(int[] nums, int m){
        int j = m-1;
        for(int k=0;k<=j/2;k++){
            int tem = nums[k];
            nums[k] = nums[j-k];
            nums[j-k] = tem;
        }
    }
    public static void main(String[] args){
        int[] nums = {1,2,3};
        int k = 3;
        rotate(nums,k);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]);
        }
    }
}
