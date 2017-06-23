import java.util.Scanner;
import java.lang.StringBuffer;

/**
 * Created by fatjimmy on 17/5/28.
 */
public class ReplaceName {
    //Question 4 in Offer
    public static String replace(String string){
        StringBuffer reString = new StringBuffer();
        for(int i=0; i<string.length();i++){
            String ch = String.valueOf(string.charAt(i));
            if(ch.equals(" ")){
                reString.append("%20");
            }else{
                reString.append(ch);
            }
        }
        return string;
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        String str=null;
        System.out.println("Please input the String:");
        str=sc.nextLine();
        String reStr = replace(str);

        System.out.println(reStr);
    }
}
