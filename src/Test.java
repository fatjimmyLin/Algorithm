import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by fatjimmy on 17/5/30.
 */
class people{
    private String name;
    private int age;
    public people(){
        this.name = "mijjy";
        this.age = 27;
    }
    public String toString(){
        return "name:"+name+" age"+age;
    }
}

public class Test {
    public void dosometthing()throws ArithmeticException{
        System.out.println();
    }
    public static void main(String[] args) {
//        Test ett = new Test();
//        ett.dosometthing();
        System.out.println(new people());
        System.out.println(1+2+"");
        System.out.println(""+1+2);
    }
}
