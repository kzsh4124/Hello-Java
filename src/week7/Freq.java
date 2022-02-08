import java.util.Map;
import java.util.*;
class Freq {
    public static void main(String[] args) {
        Map<String,Integer> table = new TreeMap<String,Integer>();
        Scanner sc = FileScanner.fileScanner(args[0]);
        while (sc.hasNext()) {
            String w = sc.next().toLowerCase();
            if (table.containsKey(w)) {
                table.put(w, table.get(w)+ 1);
            } else {
                table.put(w, 1);
            }
        }
        for (String w : table.keySet()) {
            System.out.printf("%3d: %s%n", table.get(w), w);
        }
    }
}