import org.junit.Test;
import static org.junit.Assert.*;

public class HeroTest {
    @Test
    public void newHero_instantiatesCorrectly_true(){
        Hero newHero = Hero.setUpNewHero();
        assertTrue(newHero instanceof Hero);
    }

    @Test
    public void newHero_getName_String(){
        Hero newHero = Hero.setUpNewHero();
        assertEquals("Queen", newHero.getName());
    }

    @Test
    public void newHero_getAge_Int(){
        Hero newHero = Hero.setUpNewHero();
        assertEquals(22, newHero.getAge());
    }

    @Test
    public void newHero_getPower_String(){
        Hero newHero = Hero.setUpNewHero();
        assertEquals("fore-telling the future", newHero.getPower());
    }

    @Test
    public void newHero_getWeakness_String(){
        Hero newHero = Hero.setUpNewHero();
        assertEquals("falling in love", newHero.getWeakness());
    }

    @Test
    public void newHero_getId_Int() {
        Hero.clearAllHeroes();
        Hero newHero = Hero.setUpNewHero();
        Hero otherHero = Hero.setUpNewHero1();
        Hero otherHero2 = Hero.setUpNewHero2();
        assertEquals(0,newHero.getId());
        assertEquals(1,otherHero.getId());
        assertEquals(2,otherHero2.getId());
    }

    @Test
    public void newHero_getAllInstances_true(){
        Hero newHero = Hero.setUpNewHero();
        Hero otherHero = Hero.setUpNewHero();
        assertTrue(Hero.getAllInstances().contains(newHero));
        assertTrue(Hero.getAllInstances().contains(otherHero));
    }

    @Test
    public void newHero_findById_id(){
        Hero.clearAllHeroes();
        Hero newHero = Hero.setUpNewHero();
        Hero otherHero = Hero.setUpNewHero1();
//        assertEquals(1, Hero.findById(newHero.getId()).getId());
        assertEquals(1,Hero.findById(otherHero.getId()).getId());
    }
}
