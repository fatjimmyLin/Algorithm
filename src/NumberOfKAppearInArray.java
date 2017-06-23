/**
 * Created by fatjimmy on 17/6/22.
 */
//offer 38 O(logn) 二分法
public class NumberOfKAppearInArray {
    public static int GetFirstK(int[] nums, int k,int start,int end){
        if(start>end) return -1;
        int middleIndex = (start+end)/2;
        int middle = nums[middleIndex];
        if(middle == k){
            if((middle!=0 && nums[middleIndex-1]!=k) || middleIndex==0){
                return middleIndex;
            }else end = middleIndex-1;
        }else if(middle>k){
            end = middleIndex-1;
        }else start = middleIndex+1;
        return GetFirstK(nums,k,start,end);
    }
    public static int GetLastK(int[] nums, int k,int start,int end){
        if(start>end) return -1;
        int middleIndex = (start+end)/2;
        int middle = nums[middleIndex];
        if(middle == k){
            if((middle!=nums.length-1 && nums[middleIndex+1]!=k) || middleIndex==nums.length-1){
                return middleIndex;
            }else start =middleIndex+1;
        }else if(middle>k){
            end = middleIndex-1;
        }else start = middleIndex+1;
        return GetLastK(nums,k,start,end);
    }
    public static int GetKInArray(int[] nums,int k){
        int number = 0;
        if(nums.length!=0){
            int first = GetFirstK(nums,k,0,nums.length-1);
            int last = GetLastK(nums,k,0,nums.length-1);
            if(first>-1 && last>-1) {
                number = last - first + 1;
            }
        }
        return number;
    }
    public static void main(String[] args) {
        int[] num ={1,2,3,3,3,3,4,5};
        int k =3;
        int result = GetKInArray(num,k);
        System.out.println("The number of "+k+" is "+result);
    }
}
