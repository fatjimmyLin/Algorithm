import java.util.Scanner;

/**
 * Created by fatjimmy on 17/6/1.
 */
//leetcode 70 offer 9
public class ClimbingStairs {
    public static int climbStairs(int n) {
        int m = 0;
        int k = 1;
        int sum = 0;
        if(n==0) return m;
        if(n==1) return k;
        for(int i=2;i<=n;i++){
            sum = m+k;
            m = k;
            k = sum;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in); //创建Scanner对象read 接受从控制台输入
        System.out.println("请输入n");
        int n = read.nextInt(); //调用Scanner类中的方法.nextInt() 对象名.方法名
        int i  = climbStairs(n);
        System.out.println("---------"+i);
    }
}
