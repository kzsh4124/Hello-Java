// ファイルLineProcessor.java
import java.util.Scanner;

class NopFilter implements LineFilter {
    public String processLine(String line) { return line; }
}
class QuoteFilter implements LineFilter {
    public String processLine(String line) { return "> " + line; }
}
class RightFilter implements LineFilter {
    public String processLine(String line) { return " ".repeat(40 - line.length()) + line; }
}
class NumberFilter implements LineFilter {
    int count;    // 0に初期化される
    public String processLine(String line) { return  String.format("%3d: %s", ++count, line); }
}
class RevFilter implements LineFilter{
    public String processLine(String line){
        String result = "";
        for (int i = 0; i < line.length(); i++){
            result += line.charAt(line.length()-1-i);
        }
        return result;
    }
}
class LineProcessor {
    static final void processAllLines(LineFilter filter) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            System.out.println(filter.processLine(line));
        }
    }
    public static void main(String[] args) {
        processAllLines(new RevFilter());
    }
}