import java.util.Scanner;

/**
 * Created by fatjimmy on 17/1/30.
 */
public class ScaleSort {
    public static int[] sortElement(int[] A, int n, int k) {
        // write code herep
        int[] B = new int[k];
        int flag = 0;
        for (int p = 0; p <= n-k; p++) {
            for (int i = 0; i < k; i++) {
                B[i] = A[i + p];//建立小根堆
            }
            B = buildHeap(B);
            for(int i = p;i < p+k; i++){
                if(A[i] ==  B[0]){//将堆顶弹出,放在数组A中
                    flag = i;//对每一个堆处理，标记弹出数在A中位置
                }
            }
            int tem = A[p];//每运行一轮，B[0]弹出插入到A[p]位置上，我们需要将A中弹出的数A[flag]填上原本在A[p]位置上的数
            A[p] = B[0];
            A[flag] = tem;
        }
        for(int i=k-1;i>0;i--){//对最后k个数进行堆排序，从大到小
            int t = B[0];
            B[0] = B[i];
            B[i] = t;
            adjustHeap(B,0,i);
        }
        for(int i=0;i<k;i++) {//将最后K个数反序插入到原数组A中
            A[n - k + i ] = B[k - i - 1];
        }
        return A;
    }

    private static int[] buildHeap(int[] A) { //建立堆
        for (int i = A.length - 1; i >= 0; i--) {
            adjustHeap(A, i, A.length);
        }
        return A;
    }

    private static void adjustHeap(int[] A, int k, int len) {//对堆的数字进行调整
        int tem = A[k];
        for (int i = 2 * k + 1; i < len; i = 2 * i + 1) {
            if (i != len - 1 && A[i] > A[i + 1]) {
                i++;//如果左子树大于右子树，那么取右子树
            }
            if (tem < A[i]) {//将子树与树根比较
                break;
            } else {
                A[k] = A[i];
                k = i;//修改K值，以方便下调
            }
        }
        A[k] = tem;
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in); //创建Scanner对象read 接受从控制台输入
        int n; //元素个数
        System.out.println("请输入数组元素个数");
        n = read.nextInt(); //调用Scanner类中的方法.nextInt() 对象名.方法名
        int[] arr;
        arr = new int[n];
        int i, k;
        for (i = 0; i < arr.length; i++) {  //一般都用for循环进行数组元素从键盘输入
            arr[i] = read.nextInt();  //调用Scanner类中的方法.nextInt() 对象名.方法名
        }
        System.out.println("请输入移动距离");
        k = read.nextInt();
        arr = sortElement(arr,n,k);
        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
