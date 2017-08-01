import org.omg.PortableInterceptor.LOCATION_FORWARD;
import sun.util.resources.cldr.ewo.LocaleNames_ewo;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Main {
/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    public static long guessMyPath(List<Long[]> dimList){
        long m = 0;
        String[] haha = {"0","0","0","0","0"};
        Long[] first = new Long[5];
        for(int i=0;i<5;i++){
            first[i] = Long.parseLong(haha[i]);
        }
        Long[] lastindex = new Long[dimList.size()];
        for(int i=0;i<lastindex.length;i++){
            lastindex[i] = dimList.get(i)[4];
        }
        Arrays.sort(lastindex);

        for(int i=0;i<dimList.size();i++){
            long fuel =0;
            for(int j=0;j<dimList.size();j++) {
                if (dimList.get(j)[4] == lastindex[i]) {
                    fuel = Math.abs(first[0] - dimList.get(j)[0]) + Math.abs(first[1] - dimList.get(j)[1]) + Math.abs(first[2] - dimList.get(j)[2])
                            + 10 * Math.abs(first[3] - dimList.get(j)[3]) + 100 * Math.abs(first[4] - dimList.get(j)[4]);
                    first = dimList.get(j);
                    break;
                }
            }
            m += fuel;
        }
        return m;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long res;
        int dimension_size = Integer.parseInt(in.nextLine().trim());
        List<Long[]> dimList = new ArrayList<Long[]>();

        for (int _dimension_i = 0; _dimension_i < dimension_size; _dimension_i++) {
            Long[] dimension_item = new Long[5];
            String dimItemStr = in.nextLine().trim();
            String[] dimItemStrs = dimItemStr.split(" ");
            for (int j = 0; j < 5; j++) {
                dimension_item[j] = Long.parseLong(dimItemStrs[j]);
            }
            dimList.add(dimension_item);
        }
        res = guessMyPath(dimList);
        System.out.println(res);
    }
}