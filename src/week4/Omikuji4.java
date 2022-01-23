// ファイルOmikuji4.java
class Omikuji4 extends Omikuji2 {
    @Override
    void print(){
        System.out.println(second() + last() + first());

    }
     public static void main(String[] args) {
     (new Omikuji4()).print();
     }
 }