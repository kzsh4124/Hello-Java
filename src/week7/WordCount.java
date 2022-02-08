// ファイルWordCount.java
import java.util.*;

class WordCount {
    public static void main(String[] args) {
        Collection<String> c = new HashSet<String>();
        Scanner sc = FileScanner.fileScanner(args[0]);
        while (sc.hasNext()) {
            String w = sc.next();
            c.add(w);
        }
        System.out.println(c.size() + " words.");
    }
}