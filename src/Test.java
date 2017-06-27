/**
 * Created by fatjimmy on 17/5/30.
 */

public class Test {
    static {
        System.out.println("hello 1");
    }
    public static void main(String[] args) {
        outtt:
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(j>=2)
                    break outtt;
                System.out.println(j);
            }
        }
        System.out.println("hello 2");
    }
}
