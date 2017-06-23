/**
 * Created by fatjimmy on 17/6/19.
 */
//leetcode 264 offer 34
public class UglyNumber2 {
    public static int nthUglyNumber(int n) {
        if(n <= 0) return 0;
        int index = 1;
        int[] uglyNumber = new int[n];
        uglyNumber[0] = 1;
        int i,j,k;
        // i for 2; j for 3; k for 5;
        i = j = k =0;
        while(index<n){
            int min  = Min(uglyNumber[i]*2,uglyNumber[j]*3,uglyNumber[k]*5);
            uglyNumber[index] = min;
            while(uglyNumber[i]*2 <= uglyNumber[index]) i++;
            while(uglyNumber[j]*3 <= uglyNumber[index]) j++;
            while(uglyNumber[k]*5 <= uglyNumber[index]) k++;
            index++;
        }
        return uglyNumber[index-1];
    }
    public static int Min(int i, int j, int k){
        int min = (i<j) ? i : j;
        min = (min<k) ? min : k;
        return min;
    }
    public static void main(String[] args) {
        int nums = 10;
        int result  = nthUglyNumber(nums);
        System.out.println("The "+nums+"th ugly number is: "+result);
    }

}
