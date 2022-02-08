// ファイルSpell.java
import java.util.*;

class Spell {
    static Set<String> readWordsFromFile(String fileName) {
        // ファイルfileName内のすべての英単語を小文字に変換して集合に入れて返す
        Set<String> result = new HashSet<String>();
        Scanner sc = FileScanner.fileScanner(fileName);
  ;
        while (sc.hasNext()) {
            result.add( sc.next().toLowerCase() );
        }
        return result;
    }
   public static void main(String[] args) {
       Set<String> dict = readWordsFromFile("dict.txt");
       for (String s : readWordsFromFile(args[0])) {
                 if (! dict.contains(s)) {
                     System.out.println(s);
                 }
             }
    }
}