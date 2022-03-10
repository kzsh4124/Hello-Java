public class TreeCalc extends Calc<TreeCalc.Tree> {
    abstract class Tree implements Numeric<Tree> {
        abstract public String toString();
        public Tree add(Tree t) { return new Node("+",this,t ); 
        }
        public Tree subtract(Tree t) { return new Node("-",this,t); }
        public Tree multiply(Tree t) { return new Node("*", this,t); }
        public Tree divide(Tree t) { return new Node("/", this, t); }
    }
    class Leaf extends Tree {
        int value;
        Leaf(int value) { this.value = value; }
        public String toString() { return Integer.toString(value); }
    }
    class Node extends Tree {
        Node(String opName, Tree left, Tree right) {
            this.opName = opName; this.left = left; this.right = right;
        }
        String opName;
        Tree left, right;
        public String toString() {
            return "(" + this.left

                       + this.opName

                       + this.right
 + ")";
        }
    }
    protected Tree fromInt(int v) {
        return new Leaf(v)
 ;
    }
    public static void main(String[] args) {
        new TreeCalc().run();
    }
}