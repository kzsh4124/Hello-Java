// ファイルRectShape.java
class RectShape extends Shape {
    double left, bottom, width, height;
    RectShape(double left, double bottom, double width, double height) {
        this.left = left;
        this.bottom = bottom;
        this.width = width;
        this.height = height;
    }
    boolean inside(double x, double y) {
        return left <= x && x <= left + width &&
            bottom <= y && y <= bottom + height;
    }
    // テスト用のmainメソッド
    public static void main(String[] args) {
        RectShape r1 = new RectShape(2.0, 2.0, 5.0, 3.0);
        RectShape r2 = new RectShape(1.0, 1.0, 4.0, 3.5);
        r1.draw(0.0, 7.0, 0.25,
                0.0, 6.0, 0.5);
        System.out.println("------------------------------------------------");
        r2.draw(0.0, 7.0, 0.25,
                0.0, 6.0, 0.5);
    }
}