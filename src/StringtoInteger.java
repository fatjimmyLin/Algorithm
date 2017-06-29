/**
 * Created by fatjimmy on 17/6/29.
 */
public class StringtoInteger {
    public static int myAtoi(String str) {
        if(str.equals(""))return 0;
        long num = 0;
        int count = 0;
        str = str.trim();
        boolean miuns = false;
        for(int i=0;i<str.length();i++){
            char digit = str.charAt(i);
            if(count>1){
                num = 0;
                break;
            }
            if(digit == '-'){
                miuns = true;
                count++;
                continue;
            }
            else if(digit == '+'){
                miuns = false;
                count++;
                continue;
            }
            int number = digit-'0';
            if(number>=0 && number<=9){
                num = num*10+number;
                if(num>2147483647) break;
            }else{
                break;
            }
        }
        if(miuns == true){
            num = 0 - num;
        }
        if(num > 2147483647) num = 2147483647;
        if(num < -2147483648) num = -2147483648;
        return (int)num;
    }
    public static void main(String[] args) {
        String str = "  -0012a42";
        int result  = myAtoi(str);
        System.out.println("The number is: "+result);
    }
}
