import java.util.Scanner;

/**
 * Created by fatjimmy on 17/6/1.
 */
//leetcode 191 offer 10
public class NumberOf1Bits {
    public static int hammingWeight(int n) {
        int count = 0;
        int flag = 1;
        while(flag!=0){
            if((n & flag)!=0){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in); //创建Scanner对象read 接受从控制台输入
        System.out.println("请输入n");
        int n = read.nextInt(); //调用Scanner类中的方法.nextInt() 对象名.方法名
        int i  = hammingWeight(n);
        System.out.println("---------"+i);
    }
}
