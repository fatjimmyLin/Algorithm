import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by fatjimmy on 17/6/18.
 */
//leetcode 179 offer 33
    //Array.sort的使用！
public class LargestNumber {
    public static String largestNumber(int[] nums) {
        if(nums == null) return"";
        String[] str = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str,new comp());
        if(str[0].charAt(0)=='0') return "0";

        StringBuilder string = new StringBuilder();
        for(int i=0;i<nums.length;i++){
            string.append(str[i]);
        }
        return string.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        String result  = largestNumber(nums);
        System.out.println("The largest number is: "+result);
    }
}
class comp implements Comparator<String>{
    @Override
    public int compare(String a, String b){
        String ab = a + b;
        String ba = b + a;
        return ba.compareTo(ab);
    }
}
