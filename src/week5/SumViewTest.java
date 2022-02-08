public class SumViewTest {
    public static void main(String[] args) {
        RobotModel robot = new RobotModel();
        SumView view = new SumView();
        //RobotView view = new ScreenView();
        robot.setView(view);
        for (int i = 0; i < 100; i++) {
            robot.moveForward(i * 2);
            robot.turnLeft(92);
        }
        for (int i = 100; i > 0; i--) {
            robot.moveForward(i * 2);
            robot.turnRight(92);
        }
        System.out.println("距離: " + view.totalMove() + ", 角度: " + view.totalAngle());
    }    
}