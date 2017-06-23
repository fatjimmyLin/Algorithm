import java.util.Scanner;

/**
 * Created by fatjimmy on 17/1/30.
 */
public class Repeat {
    public static boolean checkDuplicate(int[] A, int n) {
        // write code here
        //1,建立大根堆
        boolean flag = false;
        A=buildMaxHap(A);
        //2,调整排序
        for(int i=n-1;i>0;i--){
            //堆顶和堆底元素交换
            int tem=A[0];
            A[0]=A[i];
            A[i]=tem;
            adjustHeap(A, 0, i);//将剩余的元素整理成堆
        }
        for(int i=1;i<n;i++){
            if(A[i]==A[i-1]){
                flag = true;
                break;
            }
        }
        return flag;
    }

    private static int[] buildMaxHap(int[] A) {
        for(int i=A.length/2;i>=0;i--){
            adjustHeap(A,i,A.length);
        }
        return A;
    }
    //堆的调整:将元素A[k]自下往上逐步调整树形结构
    private static void adjustHeap(int[] A, int k, int len) {
        int tem=A[k];
        for(int i=2*k+1;i<len;i=2*i+1){
            if(i!=len-1 && A[i]<A[i+1]){
                i++;//右>左,取右
            }
            if(tem>A[i]){
                break;//根>右,结束
            }else{
                //否则,改变根植,并继续向下调整
                A[k]=A[i];
                k=i;//【关键】修改k值，以便继续向下调整
            }
        }
        A[k]=tem; //被调整的结点的值放入最终位置
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in); //创建Scanner对象read 接受从控制台输入
        int n; //元素个数
        boolean flag = true;
        System.out.println("请输入数组元素个数");
        n = read.nextInt(); //调用Scanner类中的方法.nextInt() 对象名.方法名
        int[] arr;
        arr = new int[n];
        int i, k;
        for (i = 0; i < arr.length; i++) {  //一般都用for循环进行数组元素从键盘输入
            arr[i] = read.nextInt();  //调用Scanner类中的方法.nextInt() 对象名.方法名
        }
        flag = checkDuplicate(arr,n);
        System.out.println(flag);
    }
}
