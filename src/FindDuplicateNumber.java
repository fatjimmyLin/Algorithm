import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by fatjimmy on 17/6/30.
 */
//offer 51 leetcode 287
public class FindDuplicateNumber {
//    public static int findDuplicate(int[] nums) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int i=0;i<nums.length;i++){
//            if(map.containsKey(nums[i])){
//                map.put(nums[i],2);
//            }else {
//                map.put(nums[i], 1);
//            }
//        }
//        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
//        while(entries.hasNext()){
//            Map.Entry<Integer, Integer> entry = entries.next();
//            if(entry.getValue() == 2){
//                return Integer.parseInt(entry.getKey().toString());
//            }
//        }
//        return 0;
//    }
    public static int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length-1;
        while (low < high) {
            int mid = low+(high-low)/2;
            int count = 0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]<=mid){
                    count++;
                }
            }
            if(count<=mid){
                low = mid+1;
            }else high = mid;
        }
        return low;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,4,2,5};
        int result = findDuplicate(nums);
        System.out.println(result);
    }
}
