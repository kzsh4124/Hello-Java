public class Month {
    public static void main(String[] args) {
    for (int n = 0; n < 15; n++) {
    System.out.print(n + ":");
    switch (n) {
    case 1:
    case 3:
    case 5:
    case 7:
    case 8: // 行A
    case 10: // 行B
    case 12:
    System.out.println("long");
    break; // 行C
    case 2:
    case 4:
    case 6:
    case 9: // 行D
    case 11:
    System.out.println("short");
    break;
    default:
    System.out.println("1〜12の範囲ではありません。");
    break;
    }
    }
    }
    }