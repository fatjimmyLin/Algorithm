import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * Created by fatjimmy on 17/7/3.
 */
public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        if(s.length() == 0 || p.length() == 0) return false;
        char[] str = s.toCharArray();
        char[] ptr = p.toCharArray();
        return Match(str,ptr);
    }
    public static boolean Match(char[] s,char[] p){
        if(s.length == 0 && p.length ==0) return true;
        else if(s.length !=0 && p.length == 0) return false;
        if (p[1] == '*') {
            if(p[0]==s[0] || (p[0]=='.')){

            }
        }
        return false;
    }
    public static void main(String[] args) {
        String a = "aaa";
        String b = "a.a";
        boolean flag = isMatch(a,b);
        System.out.println(flag);
    }
}
