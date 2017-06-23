/**
 * Created by fatjimmy on 17/6/19.
 */
//leetcode 42
public class TrappingRainWater {
    public static int trap(int[] height) {
        if(height.length == 0) return 0;
        int max = height[0];
        int index =0;
        for(int i= 0;i<height.length;i++){
            if(height[i]>max){
                max = height[i];
                index = i;
            }
        }
        int currentMax = height[0];
        int count =0;
        for(int i=1;i<index;i++){
            if(height[i]>currentMax) currentMax = height[i];
            else count = count+(currentMax - height[i]);
        }
        currentMax = height[height.length-1];
        for(int i=height.length-2;i>index;i--){
            if(height[i]>currentMax) currentMax = height[i];
            else count = count+(currentMax - height[i]);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result  = trap(nums);
        System.out.println("The tarp water is: "+result);
    }
}
