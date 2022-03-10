public class Main {
    public static void main(String args[]){
        Human taro = new Human("太郎");
        Human jiro = new Human("次郎", "ラーメン屋","日本","日本",24);
        taro.greet_name();
        jiro.greet();

    }
}
