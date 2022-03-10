public class IntCalc extends Calc<IntCalc.Int> {
    // IntCalcのインナークラス IntCalc.Int
    class Int implements Numeric<Int> {
        int value;
        Int(int value) { this.value = value; }
        public Int add(Int v) { return new Int(value + v.value); }
        public Int subtract(Int v) { return new Int(value - v.value); }
        public Int multiply(Int v) { return new Int(value * v.value); }
        public Int divide(Int v) { return new Int(value / v.value); }
        public String toString() { return Integer.toString(value); }
    }
    protected Int fromInt(int v) {
        return new Int(v);
    }
    public static void main(String[] args) {
        new IntCalc().run();
    }
}