// ファイルPrintView.java
import ship.Ship;
class PrintView implements Ship.View {
    public void changed(Ship ship) {
        System.out.println("x = " + ship.getX() + ", y = " + ship.getY());
    }
}