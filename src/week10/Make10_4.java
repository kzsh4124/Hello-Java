import java.util.Scanner;
import java.util.stream.Stream;

public class Make10_4 extends Make10_3 {
    final Leaf leaf4;
    Make10_4(int num1, int num2, int num3, int num4) {
        super(num1, num2, num3);
        leaf4 = new Leaf(num4);
    }
    Stream<Node> nodeStream(String op1, String op2, String op3, Leaf leaf1, Leaf leaf2, Leaf leaf3, Leaf leaf4) {
        var s1 = nodeStream(op1, op2, leaf1, leaf2 , leaf3).map(t -> new Node(op3, t, leaf4 ));
        var s2 = nodeStream(op2, op3, leaf2, leaf3 , leaf4).map(t -> new Node( op1, leaf1, t ));
        var node = new Node(op2, new Node( op1, leaf1,leaf2 ), new Node(op3, leaf3, leaf4 ));
    
        return Stream.concat(s1, Stream.concat(s2, Stream.of(node)));
    }
    Stream<Node> treeStream() {
        return opStream()
        .flatMap(op1 ->
                 opStream()
                 .flatMap(op2 ->
                    opStream().flatMap(op3 ->
                    nodeStream(op1, op2, op3, leaf1, leaf2, leaf3, leaf4)))).filter(t -> isTen(t));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new Make10_4(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt())
                    .treeStream()
                    .forEach(System.out::println);
    }
}
