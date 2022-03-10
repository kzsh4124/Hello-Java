// ファイル Calc.java
import java.util.*;
import java.util.function.BinaryOperator;

public abstract class Calc<E extends Numeric<E>> {
    // Calcのインナークラス
    class Op {
        BinaryOperator<E> op;
        Op(BinaryOperator<E> op) { this.op = op; }
        public void exec(Deque<E> stack) {
            E v2 = stack.pop();
            E v1 = stack.pop();
            E value = op.apply(v1, v2);
            System.out.println(value);
            stack.push(value);
        }
    }
    Deque<E> stack;
    Scanner scanner;
    Map<String, Op> ops;  // 命令辞書
    Calc() {
        stack = new LinkedList<E>();
        scanner = new Scanner(System.in);
        // 辞書に命令語を登録する．
        ops = Map.of("+", new Op((l, r)-> l.add(r)),
             "-", new Op((l, r)-> l.subtract(r)),
             "*", new Op((l, r)-> l.multiply(r)),
             "/", new Op((l, r)-> l.divide(r)));
    }
    protected abstract E fromInt(int v);
    public void run() {
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {  // 次の単語は整数
                stack.push(fromInt(scanner.nextInt()));
            } else {
                String token = scanner.next();
                try {
                    ops.get(token).exec(stack); // 辞書を引いて命令を解釈する．
                } catch (Exception e) {
                    System.out.println("エラー: " + e);
                }
            }
        }
    }
}