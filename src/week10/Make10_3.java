import java.nio.file.DirectoryStream.Filter;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Make10_3 {
    abstract class Tree {
        abstract public String toString();
        abstract public Ratio eval();
    }
    class Leaf extends Tree {
        int value;
        Leaf(int value) { this.value = value; }
        public String toString() { return Integer.toString(value); }
        public Ratio eval() { return new Ratio(value, 1); }
    }
    final Map<String,BinaryOperator<Ratio>> ops;
    final static Ratio TEN = new Ratio(10, 1); // 10
    class Node extends Tree {
        Node(String opName, Tree left, Tree right) {
            this.opName = opName; this.left = left; this.right = right;
        }
        String opName;
        Tree left, right;
        public String toString() {
            return "(" + left + opName + right + ")";
        }
        public Ratio eval() {
            return ops.get(opName).apply(left.eval(), right.eval());
        }
    }
    final Leaf leaf1, leaf2, leaf3; 
    //コンストラクタ
    Make10_3(int num1, int num2, int num3) {
        leaf1 = new Leaf(num1); leaf2 = new Leaf(num2); leaf3 = new Leaf(num3);
        ops = Map.of("+", Ratio::add, "-", Ratio::subtract,
                    "*", Ratio::multiply, "/", Ratio::divide);
    }
    Stream<String> opStream() {
        return Stream.of("+", "-", "*", "/");
    }
    Stream<Node> nodeStream(String op1, String op2, Leaf leaf1, Leaf leaf2, Leaf leaf3) {
        // 演算子がop1, op2, 葉がleaf1, leaf2, leaf3である木のストリーム
        return Stream.of(new Node(op1, new Node(op2, leaf1, leaf2), leaf3),
                         new Node(op1, leaf1, new Node(op2, leaf2, leaf3)));
    }
    static boolean isTen(Tree t) {
        try {
            return t.eval().equals(TEN);
        } catch (ArithmeticException e) {
            return false;
        }
    }
    //すべての木構造を生成し、10になるものだけを返す
    Stream<Node> treeStream() {
        return opStream()
        .flatMap(op1 ->            // op1に当てはまる演算子4通りすべてについて
                 opStream()
                 .flatMap(op2 ->   // op2に当てはまる演算子4通りすべてについて
                    nodeStream(op1, op2, leaf1, leaf2, leaf3)))
          // .peek(System.out::println)   // 試しにプリントしてみる
         . filter(t -> isTen(t) )
          ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new Make10_3(sc.nextInt(), sc.nextInt(), sc.nextInt())
                    .treeStream()
                    .forEach(System.out::println);
    }
}