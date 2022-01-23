// public, privateというキーワードについては，とりあえず無視して考えてよい．
class Ratio {   // 分数を表すクラス（「レシオ」と読むよ）
    private long num;    // 分子 (numerator)
    private long denom;  // 分母 (denominator)

    public Ratio(long num, long denom) {
        if (denom < 0) {  // 分母は常に正にする
            num *= -1;
            denom *= -1;
        }
        // 約分する
        long g = gcd(num, denom);
        this.num = num / g;
        this.denom = denom / g;
    }
    private long gcd(long p, long q) {
        // 最大公約数を計算する．
        if (q == 0) {
            return p;
        } else {
            return gcd(q, p % q);
        }
    }

    // 公開するメソッド
    @Override
    public String toString() {
        // 文字列への変換の定義
        if (denom == 1) {
            return Long.toString(num);
        } else {
            return num + "/" + denom;
        }
    }
    @Override
    public boolean equals(Object obj) {
     // 「等しさ」の定義: objがthisと「等しい」ならtrue，さもなければfalse
        if (obj instanceof Ratio) {  // 相手もRatio?
            Ratio r = (Ratio)obj;
            return denom == r.denom && num == r.num;  // 分母，分子がそれぞれ等しい
        } else {
            return false;
        }
    }
    // 内部的に利用するメソッド
    private Ratio multiply(long num, long denom) {
        long n = this.num * num;
        long d = this.denom * denom;
        return new Ratio(n, d);
    }
    private  Ratio add(long num, long denom) {
        long n = this.num * denom + num * this.denom;
        long d = this.denom * denom;
        return new Ratio(n, d);
    }

    // 分数どうしの加減乗除
    public Ratio multiply(Ratio r) {
        // thisとrをかけた結果のRatioを作って返す
        return multiply(r.num, r.denom);
    }
    public Ratio add(Ratio r) {
        // thisとrを足した結果のRatioを作って返す
        return add(r.num, r.denom);
    }
    public Ratio subtract(Ratio r) {
        // thisからrを引いた結果のRatioを作って返す
        return add(-r.num, r.denom);
    }
    public Ratio divide(Ratio r) {
        // thisをrで割った結果のRatioを作って返す
        return multiply(r.denom, r.num);
    }
    // 整数との加減乗除
    // ↓ここから
    public Ratio add(long i) { return this.add(i , 1) ; }
    public Ratio subtract(long i) { return add(-i, 1) ; }
    public Ratio multiply(long i) { return  this.multiply(i, 1) ; }
    public Ratio divide(long i) { return this.multiply(1, i) ; }
    // ↑ここまで

    public static void main(String[] args) {
        Ratio r1 = new Ratio(1, 2); // 1/2
        Ratio r2 = new Ratio(1, 4); // 1/4

        Ratio r3 = r1.multiply(r2); // (1/2) * (1/4)
        System.out.println(r3);

        Ratio r4 = r1.add(r2);    // (1/2) + (1/4)
        System.out.println(r4);

        Ratio r5 = r1.subtract(r2);   // (1/2) - (1/4)
        System.out.println(r5);

        Ratio r6 = r1.divide(r2);   // (1/2) / (1/4)
        System.out.println(r6);

        Ratio r7 = r2.multiply(3).divide(2).add(1).multiply(2).subtract(1);
        // r7 = ((1/4) * 3 / 2 + 1) * 2 - 1
        System.out.println(r7);
    }
}
