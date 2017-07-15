import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by fatjimmy on 17/7/14.
 */
interface China{
    public static final String name="Rollen";
    public static  int age=20;
    public void sayChina();
    public void sayHello(String name, int age);
}

class Person implements China,Hk{
    public Person() {

    }
    public Person(String sex){
        this.sex=sex;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    @Override
    public void sayChina(){
        System.out.println("hello ,china");
    }
    @Override
    public void sayHello(String name, int age){
        System.out.println(name+"  "+age);
    }
    @Override
    public void sayHK(){
        System.out.println("hello ,HK");
    };
    private String sex;
}

public class hello{
    public static void main(String[] args) {
        Class<?> demo=null;
        try{
            demo=Class.forName("Person");
        }catch (Exception e) {
            e.printStackTrace();
        }
        Person person = new Person("male");
        System.out.println("类加载器  "+person.getClass().getClassLoader().getClass().getName());
    }
}