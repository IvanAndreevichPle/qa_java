import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Test
    public void testGetFamilyReturnsCats() {
        Feline feline = new Feline();
        String result = feline.getFamily();
        assertEquals("Кошачьи", result);
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        int kittens = feline.getKittens();
        assertEquals(1, kittens);
    }

    @Test
    public void testGetKittensWithArgument() {
        Feline feline = new Feline();
        int kittens = feline.getKittens(3);
        assertEquals(3, kittens);
    }

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> mealList = List.of("Животные", "Птицы", "Рыба");
        List<String> food = feline.eatMeat();
        assertEquals(food, mealList);
    }
}