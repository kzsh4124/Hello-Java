public class Human {
    String name ="";
    String job = "";
    String country = "";
    String lang = "";
    int age = 0;

    Human(String name){
        this.name = name;
    }

    Human(String name, String job, String country, String lang, int age){
        this.name = name;
        this.job = job;
        this.country = country;
        this.lang = lang;
        this.age = age;
    }
    public void greet_name(){
        System.out.println("私の名前は"+this.name+"です。");
    }
    public void greet(){
        System.out.println("私の名前は"+this.name+"です。年齢は"+this.age+"歳で、職業は"+this.job+"です。");
        System.out.println(this.country+"に住んでいて、"+this.lang+"語を話します。");
    }

}
