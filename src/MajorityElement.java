import java.util.ArrayList;
import java.util.List;

/**
 * Created by fatjimmy on 17/6/16.
 */

//leetcode 169 offer 29; leetcode 229
public class MajorityElement {
    public static int majorityElement1(int[] nums) {
        int element = nums[0];
        int times = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == element){
                times++;
            }else{
                times--;
                if(times == 0){
                    element = nums[i];
                    times = 1;
                }
            }
        }
        return element;
    }
//leetcode 229
    public static List<Integer> majorityElement2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length ==0) return result;
        int number1 = 0;
        int number2 = 0;
        int count1 = 0;
        int count2 = 0;
        //保证超过1/3的数一定会落在number1和number2中
        for(int i=0; i<nums.length;i++){
            if(nums[i] == number1){
                count1++;
            }
            else if(nums[i] == number2){
                count2++;
            }
            else if(count1 == 0){
                number1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0){
                number2 = nums[i];
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==number1) count1++;
            if(nums[i]==number2) count2++;
        }
        if(count1>nums.length/3) result.add(number1);
        if(count2>nums.length/3 && number1 != number2) result.add(number2);
        return result;
    }
    public static void main(String[] args) {
        int[] number = {1,2,3,4,2,2};
        int i =majorityElement1(number);
        List<Integer> list = majorityElement2(number);
        System.out.println("The major element is: "+list);
    }
}
