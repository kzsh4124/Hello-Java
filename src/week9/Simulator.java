import ship.Ship;
class Simulator {
    public static void main(String[] args) {
        Ship ship = new Ship();
        ship.setView(new AngleView());
        int dy = 1;
        for (int i = 0; i < 10; i++) {
            ship.step(i, dy);
            dy = dy + i;
        }
    }
}