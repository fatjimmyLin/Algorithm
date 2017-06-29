import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;

/**
 * Created by fatjimmy on 17/6/27.
 */
//leetcode 151 offer 42; leetcode 541; leetcode 557
public class ReverseWordsInString {
    //leetcode 151
    public static String reverseWords(String s) {
        if(s.trim().isEmpty())return "";
        ArrayList<String> str = new ArrayList<>();
        String[] spilt = s.trim().split(" ");
        for(int i=0;i<spilt.length;i++){
            if(!spilt[i].equals("")) {
                str.add(spilt[i]);
            }
        }
        StringBuilder string = new StringBuilder();
        for(int i=str.size()-1;i>=0;i--){
            string.append(str.get(i));
            string.append(" ");
        }
        return string.toString().trim();
    }
    //leetcode 541
    public static String reverseStr(String s, int k) {
        if(s.length()==0) return s;
        char[] reverse = s.toCharArray();
        if(s.length()<k){
            Reverse(0,s.length()-1,reverse);
            return String.copyValueOf(reverse);
        }
        int begin;
        int end;
        for(int i=0;i<s.length();i+=2*k){
            begin = i;
            end = i+k-1;
            if(end>=s.length()){
                int gap = s.length()-1-i;
                if(gap>=0 && gap<k){
                    Reverse(i,s.length()-1,reverse);
                }
                break;
            }
            Reverse(begin,end,reverse);
        }
        return String.copyValueOf(reverse);
    }
    public static void Reverse(int begin,int end,char[] reverse){
        while(begin<end){
            char tmp = reverse[begin];
            reverse[begin] = reverse[end];
            reverse[end] = tmp;
            begin++;
            end--;
        }
    }
    public static void main(String[] args) {
        String s = "abcdefg";
        int i = 8;
        // leetcode 151 String  result  = reverseWords(s);
        String result = reverseStr(s,i);
        System.out.println("..."+result+"...");
    }
}
