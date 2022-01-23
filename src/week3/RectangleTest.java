// ファイル Rectangle.java


public class RectangleTest {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5, 3, 10, 20);
        Rectangle r2 = new Rectangle(9, 13, 12, 10);
        Point[] p = {new Point(4, 30), new Point(6, 30), new Point(20, 30),
                     new Point(4, 20), new Point(6, 20), new Point(20, 20),
                     new Point(4, 2), new Point(6, 2), new Point(20, 2)};
        System.out.print("r1: ");
        r1.printRectangle();
        System.out.print("r2: ");
        r2.printRectangle();

        System.out.print("r1はr2より");
        if (r1.isLarger(r2)) {
            System.out.println("大きい．");
        } else {
            System.out.println("大きくない．");
        }

        for (int i = 0; i < p.length; i++) {
            p[i].printPoint();
            if (r1.contains(p[i])) {
                System.out.println("r1の中．");
            }
            if (r2.contains(p[i])) {
                System.out.println("r2の中．");
            }
        }
    }
}

public class Rectangle {
    int left;   // 左端の座標
    int bottom; // 下端の座標
    int width;  // 幅
    int height; // 高さ
   
    Rectangle(int left, int bottom, int width, int height) {
	    this.left = left;
    	this.bottom = bottom;
    	this.width = width;
    	this.height = height;
    }
    void printRectangle() {
        System.out.print("左下(" + left + ", " + bottom + "), ");
        System.out.println("右上(" + (left + width)  + ", " + (bottom + height) + ")");
    }
    int getArea() {
        // 面積を返す
        return width *  height;
    }

    boolean isLarger(Rectangle r) {
        // thisの面積がrの面積より大きければ true ，そうでなければ falseを返す．
        return this.getArea() > r.getArea();===
    }
   
    boolean contains(Point p) {
        // pが長方形の中にあれば(端の線上にある場合も含む) true を返す．
        return left <= p.x && p.x <= (left + width) && bottom <= p.y && p.y <= (bottom + height);
    }
}
// ファイルPoint.java
public class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    void printPoint() {
        System.out.println("座標(" + x + ", " + y + ")");
    }
}

