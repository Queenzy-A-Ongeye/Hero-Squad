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
    public void newHero_getId_Int(){
        Hero newHero = Hero.setUpNewHero();
        Hero
    }
}
