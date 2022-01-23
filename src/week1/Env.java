public class Env {
    public static void main(String[] args) {
        String[] keys = { "java.vm.vendor", "java.vm.name",
            "java.vm.version" };
        for (String k : keys) {
            System.out.print(System.getProperty(k) + ";");
        }
        System.out.println();
    }
}