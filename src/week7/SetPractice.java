import java.util.*;
public class SetPractice {
    static  Set<String>  intersection(Set<String> a, Set<String> b) {
        Set<String> result = new HashSet<String>(a);
        for (String  s : a) {
           if (!b.contains(s)) {
              result.remove(s);
           }
        }
        return result;
    }
}
