import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by fatjimmy on 17/6/19.
 */
public class FirstUniqueCharacter {
    public static int firstUniqChar(String s) {
        char[] str = s.toCharArray();
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for(int i=0;i<str.length;i++){
            if(!map.containsKey(str[i])) map.put(str[i],1);
            else{
                map.put(str[i],map.get(str[i])+1);
            }
        }
        Iterator iter = map.entrySet().iterator();
        int count =0;
        char ss =' ';
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            if(Integer.parseInt(entry.getValue().toString()) == 1){
                ss = entry.getKey().toString().charAt(0);
                break;
            }
        }
        for(int i=0;i<str.length;i++){
            if(str[i] == ss) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        String string = "dddccdbba";
        int result  = firstUniqChar(string);
        System.out.println("The index of the first unique char is: "+result);
    }
}
