import org.omg.CORBA.PUBLIC_MEMBER;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by fatjimmy on 17/6/28.
 */
public class Offer43 {
    public static void printPro(int n){
        int max_Numebr = 6;
        if(n<1) return;
        int[][] point = new int[2][];
        point[0] = new int[n * max_Numebr+1];
        point[1] = new int[n * max_Numebr+1];
        for(int i=0;i<n*max_Numebr+1;i++){
            point[0][i] = 0;
            point[1][i] = 0;
        }
        int flag = 0;
        for(int i=1;i<=max_Numebr;i++){
            point[flag][i] = 1;
        }
        for(int k=2;k<=n;k++){
            for(int i=0;i<k;i++){
                point[1-flag][i] = 0;
            }
            for(int i=k;i<=k*max_Numebr;i++){
                point[1-flag][i] = 0;
                for(int j=1;j<=i && j<=max_Numebr;j++){
                    point[1-flag][i] += point[flag][i-j];
                }
            }
            flag = 1-flag;
        }
        double total = Math.pow(max_Numebr,n);
        for(int i=n;i<=n*max_Numebr;i++){
            double possibility = point[flag][i]/total;
            System.out.println("Possibility of "+i+" is "+possibility);
        }
    }
    public static void main(String[] args) {
        int target = 3;
        printPro(target);
    }
}
