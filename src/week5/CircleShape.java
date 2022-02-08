// ファイルCircleShape.java
class CircleShape extends Shape {
    double x0, y0, r;  // 中心座標(x0, y0), 半径r
    CircleShape(double x0, double y0, double r) {
        this.x0 = x0; this.y0 = y0; this.r = r;
    }
    boolean inside(double x, double y) {  
        double dx = x - x0, dy = y - y0;
        return dx*dx + dy*dy 
<=
  r*r ; 
    }
    // テスト用のmainメソッド
    public static void main(String[] args) {
        CircleShape c = new CircleShape(5.0, 5.0, 3.0);
        c.draw(0.0, 10.0, 0.25,
               0.0, 10.0, 0.5);
    }
}