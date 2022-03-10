// ファイルAngleView.java
import ship.Ship;
class AngleView implements Ship.View {
    public void changed(Ship ship) {
        System.out.printf("%.3f%n",Math.atan(ship.getY()/ship.getX()));
    }
}