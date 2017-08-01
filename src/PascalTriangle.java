import java.util.ArrayList;
import java.util.List;

/**
 * Created by fatjimmy on 17/7/31.
 */
//leetcode 118
public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> preresult = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> subresult = new ArrayList<>();
            for(int j=0;j<i+1;j++){
                if(j==0 || j==i) {
                    subresult.add(1);
                }else {
                    subresult.add(preresult.get(j - 1) + preresult.get(j));
                }
            }
            preresult = subresult;
            result.add(subresult);
        }
        return result;
    }
    public static void main(String[] args){
        int numRows = 6;
        List<List<Integer>> array = generate(numRows);
        System.out.println(array);
    }
}

