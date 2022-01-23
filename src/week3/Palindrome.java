import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int i = 0;
        int len = line.length();
        while (2*i < len && line.charAt(i) == line.charAt(len - i - 1)) {
            i++;
        }
        System.out.print(line + "は回文で");
        if (2 * i >= len ) {
            System.out.println("す．");
        } else {
            System.out.println("はありません．");
        }
    }
}
