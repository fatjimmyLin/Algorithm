import java.util.Scanner;

/**
 * Created by fatjimmy on 17/2/2.
 */
public class Merge {
    public static int[] mergeAB(int[] A, int[] B, int n, int m) {
        // write code here
        int i = n-1;
        int j = m-1;
        while((i>0)&&(j>0)){
            if(A[i]>=B[j]){
                A[i+j+1] = A[i];
                i--;
                if(i==-1){
                    for (int p=0;p<=j;p++){
                        A[p] = B[p];
                    }
                    break;
                }
            }else {
                A[i+j+1] = B[j];
                j--;
                if(j==-1){
                    for(int p=0;p<=i;p++){
                        A[p] = A[p];
                    }
                    break;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in); //创建Scanner对象read 接受从控制台输入

        int n; //元素个数
        System.out.println("请输入数组A元素个数");
        n = read.nextInt(); //调用Scanner类中的方法.nextInt() 对象名.方法名
        int[] arr;
        arr = new int[n];
        System.out.println("请输入数组A");
        for (int i = 0; i < arr.length; i++) {  //一般都用for循环进行数组元素从键盘输入
            arr[i] = read.nextInt();  //调用Scanner类中的方法.nextInt() 对象名.方法名
        }

        int m; //元素个数
        System.out.println("请输入数组B元素个数");
        m = read.nextInt(); //调用Scanner类中的方法.nextInt() 对象名.方法名
        int[] brr;
        brr = new int[m];
        System.out.println("请输入数组B");
        for (int i = 0; i < brr.length; i++) {  //一般都用for循环进行数组元素从键盘输入
            brr[i] = read.nextInt();  //调用Scanner类中的方法.nextInt() 对象名.方法名
        }
        int[] crr = new int[n+m];
        for(int i=0;i<arr.length;i++){
            crr[i] = arr[i];
        }
        for(int i=arr.length;i<crr.length;i++){
            crr[i] = 0;
        }
        int[] drr = new int[n+m];
        drr = mergeAB(crr,brr,n,m);
        for(int i=0;i<drr.length;i++){
            System.out.print(drr[i]+" ");
        }
    }
}
