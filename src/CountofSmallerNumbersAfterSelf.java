import java.util.ArrayList;
import java.util.List;

/**
 * Created by fatjimmy on 17/6/20.
 */
//offer 36
public class CountofSmallerNumbersAfterSelf {
    public static int countSmaller(int[] nums) {
        //List<Integer> list = new ArrayList<>();
        if(nums.length == 0) return 0;
        int[] copy = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            copy[i] = nums[i];
        }
        int count = Inverse(nums,copy,0,nums.length-1);
        return count;
    }
    public static int Inverse(int[] nums,int[] copy,int start,int end){
        if(start == end){
            copy[start] = nums[start];
            return 0;
        }
        int length = (end-start)/2;
        int left = Inverse(copy,nums,start,start+length);
        int right = Inverse(copy,nums,start+length+1,end);
        int i = start+length;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while(i>=start && j>=start+length+1){
            if(nums[i]>nums[j]){
                copy[indexCopy--] = nums[i--];
                count += j-start-length;
            }else{
                copy[indexCopy--] = nums[j--];
            }
        }
        for(;i>=start;--i){
            copy[indexCopy--] = nums[i];
        }
        for(;j>=start+length+1;--j){
            copy[indexCopy--] = nums[j];
        }
        return count+left+right;
    }
    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        //List<Integer> result  = countSmaller(nums);
        int result  = countSmaller(nums);
        System.out.println("The Count of the smaller number is: "+result);
    }
}
