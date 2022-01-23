import java.util.Scanner;

public class Count_a_before_blank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int i = 0;
        char c;
        int count = 0;
        while (i < line.length() && (c = line.charAt(i)) != ' ') {
            if (c == 'a') {
                count++;
            }
            i++;
        }
        System.out.println(count);
    }
}