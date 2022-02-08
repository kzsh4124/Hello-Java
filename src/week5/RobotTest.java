class RobotTest {
    public static void main(String[] args) {
        RobotModel robot = new RobotModel();
        RobotView view = new ScreenView();
        robot.setView(view);
        for (int i = 0; i < 5; i++) {
            robot.moveForward(100);
            robot.turnLeft(144);
        }
    }
}