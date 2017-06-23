/**
 * Created by fatjimmy on 17/6/18.
 */
//leetcode 233 offer 32
public class NumberOfDigitOne {
    public static int countDigitOne(int n) {
        if(n <= 0)return 0;
        String string = String.valueOf(n);
        return numberOfOne(string);
    }
    public static int numberOfOne(String str){
        if(str == null) return 0;
        int first = Integer.parseInt(String.valueOf(str.charAt(0)));
        int length = str.length();
        if(length == 1 && first == 0) return 0;
        if(length == 1 && first > 0) return 1;
        int number = Integer.parseInt(String.valueOf(str));
        number = number - first*calculate(length-1);
        int firstNumberDigit = 0;
        if(first > 1){
            firstNumberDigit = calculate(length-1);
        }else if(first == 1){
            firstNumberDigit = number+1;
        }
        //notice! *(length - 1)!
        int otherDigit = first  * (length-1) * calculate(length-2);
        int recursiveDigit = numberOfOne(String.valueOf(number));
        return firstNumberDigit+otherDigit+recursiveDigit;
    }
    public static int calculate(int length){
        int sum = 1;
        for(int i=0;i<length;i++){
            sum = sum*10;
        }
        return sum;
    }
    public static void main(String[] args) {
        int nums = 100;
        int result  = countDigitOne(nums);
        System.out.println("Digit one appears: "+result+" times");
    }
}
