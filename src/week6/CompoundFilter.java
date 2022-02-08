// ファイルCompoundFilter.java
class CompoundFilter implements LineFilter {
    LineFilter filter1, filter2;
    CompoundFilter(LineFilter a, LineFilter b) {
      filter1 = a; filter2 = b;
    }
    public String processLine(String line) {
        return filter2.processLine(filter1.processLine(line));
    }
}
