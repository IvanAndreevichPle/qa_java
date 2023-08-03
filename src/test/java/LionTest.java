import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        int kittens = lion.getKittens();
        assertEquals(1, kittens);
    }

    @Test
    public void testEatMeat() throws Exception {
        Lion lion = new Lion("Самец", feline);

        List<String> mealList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(mealList);

        List<String> food = lion.getFood();
        assertEquals(food, mealList);
    }
    @Test
    public void testInvalidSex() {
        assertThrows(Exception.class, () -> new Lion("InvalidSex", feline));
    }
}