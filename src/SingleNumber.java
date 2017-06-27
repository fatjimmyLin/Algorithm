import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by fatjimmy on 17/6/26.
 */
//leetcode 136 offer 40
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        List<Integer> list = new ArrayList<>();
        if(map.containsValue(1)){
            Iterator<Integer> it = map.keySet().iterator();
            while(it.hasNext()){
                int tmp = it.next();
                if (map.get(tmp) == 1){
                    list.add(tmp);
                }
            }
        }else return 0;
        int i = list.get(0);
        return i;
    }
    //  known that A XOR A = 0
//    public static int singleNumber(int[] nums) {
//        int result = 0;
//        for (int i = 0; i<nums.length; i++){
//            result ^=nums[i];
//        }
//        return result;
//    }
    public static void main(String[] args) {
        int[] nums = {2,3,6,3,2,5,5};
        int result  = singleNumber(nums);
        System.out.println(result);
    }
}
