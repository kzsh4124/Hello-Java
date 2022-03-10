public class RatCalc extends Calc<Ratio> {
    protected Ratio fromInt(int v){
        return new Ratio(v, 1);
    }
     public static void main(String[] args) {
         new RatCalc().run();
     }
 }