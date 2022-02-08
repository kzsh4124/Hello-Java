

public class RobotModel  {
    // ロボットの内部状態を表すデータ
    double x, y;    // 現在の座標．
    double heading; // 角度(0〜360)．0は東(右)，90は北(上)を表す．
    RobotView view;
    public RobotModel() {
        x = y = heading = 0.0;
    }
    public void setView(RobotView view) {
        this.view = view;
    }
    public void turnLeft(double degree) {
        view.turn(heading, heading + degree);
        heading += degree;
    }
    public void turnRight(double degree) {
        turnLeft(-degree);
    }
    public void moveForward(double step) {
        double radian = heading / 180.0 * Math.PI,
            newX = this.x + Math.cos(radian) * step,
            newY = this.y + Math.sin(radian) * step;
        view.move(this.x, this.y, newX, newY);
        this.x = newX;
        this.y = newY;
    }
}
