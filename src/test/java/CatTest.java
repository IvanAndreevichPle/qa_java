import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;

    @Test
    public void testGetSoundReturnsMeow() {
        Cat cat = new Cat(feline);
        String catSound = cat.getSound();
        assertEquals("Мяу", catSound);
    }

    @Test
    public void testGetFoodSuccess() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
        Cat cat = new Cat(feline);
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);
    }

    @Test(expected = Exception.class)
    public void testGetFoodThrowsException() throws Exception {
        Cat cat = new Cat(null);
        cat.getFood();
    }

}