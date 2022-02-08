public class Main {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
String[] strs = { "Alice", "Bob", "Charlie", "Dick" };

for (String s : strs) {
   for (int n : nums) {
        System.out.println(n);
        System.out.println(s);
   }
}
    }
}
