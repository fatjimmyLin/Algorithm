import java.util.ArrayList;
import java.util.List;

/**
 * Created by fatjimmy on 17/6/28.
 */
//leetcode 283
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                list.add(nums[i]);
            }else{
                count++;
            }
        }
        for(int j=0;j<count;j++){
            list.add(0);
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = list.get(i);
        }
    }
    public static void main(String[] args) {
        int[] n = {0, 1, 0, 3, 12};
        moveZeroes(n);
    }
}
