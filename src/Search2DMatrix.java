import java.util.Scanner;

/**
 * Created by fatjimmy on 17/5/27.
 */
public class Search2DMatrix {
    // Leetcode Question 74
    public static boolean searchMatrix(int[][] matrix, int target) {

        if(matrix==null||matrix.length==0||(matrix.length==1&&matrix[0].length==0)){
            return false;
        } //judge whether the matrix is empty

        int line = matrix.length;  //line
        int column = matrix[0].length;  //column
        int i = 0;
        int j = column-1;

        while(i<line && j>=0){
            if(target == matrix[i][j]){
                return true;
            }else if(target < matrix[i][j]){
                j--;
            }else {
                i++;
            }
        }
        return false;
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
        System.out.println("Please input the number to find:");
        int k = read.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("The result is:");
        boolean flag = searchMatrix(arr,k);
        System.out.print(flag+" ");
    }

}
