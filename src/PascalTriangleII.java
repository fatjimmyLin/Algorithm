import java.util.ArrayList;
import java.util.List;

/**
 * Created by fatjimmy on 17/7/31.
 */
//leetcode 119
public class PascalTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> preresult = new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
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
        return result.get(rowIndex);
    }
    public static void main(String[] args){
        int numRows = 0;
        List<Integer> array = getRow(numRows);
        System.out.println(array);
    }
}
