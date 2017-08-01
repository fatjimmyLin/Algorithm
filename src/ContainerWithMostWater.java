/**
 * Created by fatjimmy on 17/7/31.
 */
//leetcode 11 双指针
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int front = 0;
        int back = height.length-1;
        int maxArea = 0;
        while(front<back){
            int area = 0;
            if(height[front]>height[back]){
                area = height[back]*(back-front);
                back--;
            }else{
                area = height[front]*(back-front);
                front++;
            }
            if(area>maxArea) maxArea=area;
        }
        return maxArea;
    }
    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        int k = maxArea(height);
        System.out.println(k);
    }
}
