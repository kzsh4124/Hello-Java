class X {
    X() { System.out.println("[X]");}         
    void a() { System.out.println("[x.a]");}
    void b() { System.out.println("[x.b]");}
  }
  class Y extends X {
    Y() { System.out.println("[Y]"); }          
    void a() { System.out.println("[y.a]"); }  
  }

  public class Main{
      public static void main(String[] args) {
        Y y = new Y();
        y.a();
        y.b();
          
      }

  }
  