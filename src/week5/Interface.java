public class Interface {
    public static void main(String[] args) {
        A a1 = new C_A1();
    }
    
}
interface A { public void a();    }
class C_A implements A { public void a() { /* 何もしない */ } }
interface A1 extends A { public void a1(); }
class C_A1 implements A1 {
  public void a() { /* 何もしない */ }
  public void a1() { /* 何もしない */ }
}