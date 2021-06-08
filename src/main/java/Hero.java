//import com.sun.org.apache.bcel.internal.generic.PUSH;

import java.util.ArrayList;

public class Hero {
    private String name;
    private int age;
    private String power;
    private String weakness;
    private int id;
    private static ArrayList<Hero> instance = new ArrayList<>();

    public Hero(String name, Integer age, String power, String weakness){
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        this.id = instance.size();
        instance.add(this);
    }

    public static Hero findById(int id) {
        return instance.get(id);
    }

//    public static Hero setUpNewHero2() {
//    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public String getPower(){
        return this.power;
    }

    public String getWeakness(){
        return this.weakness;
    }
    public int getId(){
        return id;
    }

    public static ArrayList<Hero> getAllInstances(){
        return instance;
    }

    public static void clearAllHeroes(){
        instance.clear();
    }



    public static Hero setUpNewHero(){
        return new Hero("Queen", 22, "fore-telling the future", "falling in love");
    }

    public static Hero setUpNewHero1(){
        return new Hero("Tyler", 20, "fighting", "water");
    }

    public static Hero setUpNewHero2(){
        return new Hero("Alan", 25, "Killing", "falling in love");
    }
}
