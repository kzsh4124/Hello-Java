package ship;
public class Ship {
    public interface View {
        public void changed(Ship s);
    }
    private double x, y;
    private View view;
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void setView(View view){
        this.view = view;
    }
    public void step(double dx, double dy) {
        x += dx;
        y += dy;
        view.changed(this);   // 変化したことを通知する
    }
}