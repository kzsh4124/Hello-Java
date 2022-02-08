public class MultiFilter extends LineProcessor {
    public static void main(String[] args) {
        LineFilter nop = new NopFilter(),
            filter = nop;
        for (String a: args) {
            LineFilter next = nop;
            if (a.equals("number")) {
                next = new NumberFilter();
            } else if (a.equals("quote")) {
                next = new QuoteFilter();
            } else if (a.equals("right")) {
                next = new RightFilter();
            } else if (a.equals("rev")) {
                next = new RevFilter();
            }
            filter = new CompoundFilter(filter, next);

        }
        processAllLines(filter);
    }
}