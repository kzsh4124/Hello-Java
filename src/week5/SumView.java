public class SumView implements RobotView{
    double totalAngle, totalMove;
    public SumView(){
        this.totalMove = 0;
        this.totalAngle = 0;
    }
    public void turn(double oldHeading, double newHeading) {
        this.totalAngle+= Math.abs(newHeading - oldHeading);
    }
    public void move(double oldX, double oldY,
                     double newX, double newY) {
                         this.totalMove += Math.sqrt( (newX - oldX)*(newX - oldX) + (newY - oldY)*(newY - oldY) );  
    }
    public double totalMove(){
        return this.totalMove;
    }
    public double totalAngle(){
        return this.totalAngle;
    }
}
