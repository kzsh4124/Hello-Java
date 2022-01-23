public class DoubleLoop {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                switch (i - j) {
                case 0:
                    System.out.print("X");
                    break;
                default:
                    System.out.print("-");
                    break;
                }
            }
            System.out.println("");
        }
    }
}