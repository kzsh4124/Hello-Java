public class Number {
    public static void main(String[] args) {
        int d1 = 0,
            d2 = 0,
            d3 = 1,
            d4 = 2,
            d5 = 0,
            d6 = 2,
            d7 = 1,
            d8 = 1,
            d9 = 1,
            da = 6,
            db = 0,
            dc = 9,
            dd = 7;
        int v1 = d1 + d3 + d5 + d7 + d9 + db,
            v3 = d2 + d4 + d6 + d8 + da + dc,
            vv = (v3 * 3 + v1 + dd) % 10;
        System.out.println(vv);

        
    }
}
