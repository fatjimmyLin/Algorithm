import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/**
 * Created by fatjimmy on 17/6/8.
 */
// leetcode 54 offer 20
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix.length == 0) return list;
        int columns = matrix[0].length;
        int rows = matrix.length;
        if(columns<=0 || rows<=0) return null;
        int start = 0;
        while(columns>start*2 && rows >start*2){
            list.addAll(CollectMatrixInCircle(matrix,columns,rows,start));
            start++;
        }
        return list;
    }
    public static List<Integer> CollectMatrixInCircle(int[][] matrix,int column,int row,int start){
        List<Integer> list = new ArrayList<Integer>();
        int endX = column-1-start;
        int endY = row-1-start;
        for(int i=start;i<=endX;i++){
            list.add(matrix[start][i]);
        }
        if(start<endY){
            for(int i=start+1;i<=endY;i++){
                list.add(matrix[i][endX]);
            }
        }
        if(start<endX && start<endY){
            for(int i=endX-1;i>=start;i--){
                list.add(matrix[endY][i]);
            }
        }
        if(start<endX && start<endY-1){
            for(int i=endY-1;i>=start+1;i--){
                list.add(matrix[i][start]);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in); //创建Scanner对象read 接受从控制台输入

        System.out.println("Please input the column of array:");
        int n = read.nextInt(); //调用Scanner类中的方法.nextInt() 对象名.方法名
        System.out.println("Please input the line of array:");
        int m = read.nextInt();

        int[][] arr;
        arr = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = read.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("The result is:");
        List<Integer> result = spiralOrder(arr);
        System.out.println(result);
    }
}
