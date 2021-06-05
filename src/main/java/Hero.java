import java.util.ArrayList;

public class Hero {
    private String name;
    private int age;
    private String power;
    private String weakness;
    private int id;
    private static ArrayList<Hero> instance = new ArrayList<>();

    public Hero(String name, Integer age, String power, String weakness, Integer id){
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        this.id = instance.size();
        instance.add(this);
    }

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
        return this.id;
    }


    public static Hero setUpNewHero(){
        return new Hero("Queen", 22, "fore-telling the future", "falling in love");
    }
}
