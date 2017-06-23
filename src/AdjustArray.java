import java.util.Scanner;

/**
 * Created by fatjimmy on 17/6/3.
 */
//offer 14
public class AdjustArray {
    public static int[] AdjustArray(int[] array){
        if(array.length == 0) return null;
        int front = 0;
        int rear = array.length-1;
        while(rear > front){
            while(rear>front && array[front]%2!=0) front++;
            while (rear>front && array[rear]%2==0) rear--;
            if(rear > front){
                int swap = array[front];
                array[front] = array[rear];
                array[rear] =swap;
            }
        }
        return array;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int[] result = AdjustArray(array);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}
