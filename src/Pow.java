import java.util.Scanner;

/**
 * Created by fatjimmy on 17/6/2.
 */
//leetcode 50 offer 11
public class Pow {
    public static double myPow(double x, int n) {
        double result = 1;
        if((x<0.001 && x>0) || (x<0 && x>-0.001)) return 0;
        if(x == 1) return 1;
        if(x == -1){
            if(n%2 == 1){
                return -1;
            }else return 1;
        }
        if(n == 0) return 1;
        if(n >= 1){
            for(int i=0;i<n;i++){
                result = result * x;
            }
        }else if(n < 0){
            int r = -n;
            if (n < -100) return 0;
            for(int i=0;i<r;i++){
                result = result * x;
            }
            result = 1/result;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in); //创建Scanner对象read 接受从控制台输入
        System.out.println("请输入底数x");
        double x = read.nextDouble(); //调用Scanner类中的方法.nextInt() 对象名.方法名
        System.out.println("请输入指数n");
        int n = read.nextInt(); //调用Scanner类中的方法.nextInt() 对象名.方法名
        double i  = myPow(x,n);
        System.out.println("The Pow(x,n) is: "+i);
    }
}
