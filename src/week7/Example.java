import java.util.*;
class Example {
    static <E> List<E> reverse(List<E> list) {
        List<E> result = new LinkedList<E>(); // 空のリスト
        for (E s : list) {
            result.add(0,s);
        }
        return result;
    }
}