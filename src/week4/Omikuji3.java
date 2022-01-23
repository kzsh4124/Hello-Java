// ファイルOmikuji3.java
class Omikuji3 extends Omikuji2 {
    @Override
    String second() {
        switch(rand()) {
        case 0:
            return "アンラッキー";
        case 1:
            return "ちょっとラッキー";
        case 2:
            return "ラッキー";
        default:
            return "大ラッキー";
        }
    }
     public static void main(String[] args) {
     (new Omikuji3()).print();
     }
 }