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
class ThreadTest implements Runnable {

    /**
     * 重写（Override）run()方法 JVM会自动调用该方法
     */
    public void run() {
        System.out.println("I'm a running!");
    }
}
public class Test {
    public void dosometthing()throws ArithmeticException{
        System.out.println();
    }
    public static void main(String[] args) {
//        Test ett = new Test();
//        ett.dosometthing();
//        System.out.println(new people());
//        System.out.println(1+2+"");
//        System.out.println(""+1+2);
        ThreadTest thread = new ThreadTest();
        Thread t = new Thread(thread);
        t.start();
    }
}
