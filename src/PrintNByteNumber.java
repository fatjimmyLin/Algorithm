import java.util.Scanner;

/**
 * Created by fatjimmy on 17/6/3.
 */
//offer 12
public class PrintNByteNumber {
    public static void PrintNumber(int n){
        if(n <= 0 ) return;
        char[] number = new char[n];
        for(int i=0; i<n;i++){
            number[i] = '0';
        }
        while(!Increasement(number)){
            PrintChar(number);
        }
    }
    static boolean Increasement(char[] num){
        boolean isOverFlow = false;
        int JingWei = 0;
        int n = num.length;
        for(int i=n-1;i>=0;i--){
            int sum = num[i]-'0'+JingWei;
            if(i == n-1) sum++;
            if(sum>=10){
                if(i==0) isOverFlow = true;
                else {
                    sum = sum - 10;
                    JingWei = 1;
                    num[i] = (char)('0' + sum);
                }
            }else{
                num[i] = (char)('0' + sum);
                break;
            }
        }
        return isOverFlow;
    }
    static void PrintChar(char[] num){
        boolean isBegin = true;
        int n = num.length;
        for(int i=0;i<n;i++){
            if(isBegin && num[i]!='0'){
                isBegin = false;
            }
            if(!isBegin){
                System.out.print(num[i]);
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in); //创建Scanner对象read 接受从控制台输入
        System.out.println("请输入n");
        int n = read.nextInt(); //调用Scanner类中的方法.nextInt() 对象名.方法名
        PrintNumber(n);
    }
}
