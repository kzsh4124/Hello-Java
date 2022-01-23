// ファイルParabolaGraph.java
class ParabolaGraph extends GraphTemplate {
    public static void main(String[] args) {
        ParabolaGraph p = new ParabolaGraph();
        p.drawAll();
      
    }
    int fn(int x) {
      return x * x ;
    }
    int start() {
      return -7 ;
    }
    int end() {
      return 7 ;
    }
  }