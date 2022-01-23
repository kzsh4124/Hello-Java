class toma{
    private int x;
    private int y;
    private static int counter=0;
    toma(int x, int y){
        this.x = x;
        this.y = y;
        counter++;
    }
    public double average(){
        return (this.x + this.y) / 2;
    }
    public static int count(){
        return toma.counter;
    }

}



public class yamaguchi {
    public static void main(String[] args){
        toma t = new toma(2,4);
        toma tomamodoki = new toma(3,5);
        System.out.println(t.average());
        System.out.println(tomamodoki.average());
        System.out.println(toma.count());

    }
    
}
