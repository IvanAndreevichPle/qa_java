import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTestParams {
    @Mock
    Feline feline;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameter()
    public String sex;
    @Parameterized.Parameter(1)
    public boolean expectedHasMane;

    @Parameterized.Parameters(name = "Sex: {0}, expected presence of a mane: {1}")
    public static Object[][] params() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"", false}
        };
    }

    @Test
    public void doesHaveMane(){
        try {
            Lion lion = new Lion(sex, feline);
            boolean actualResult = lion.doesHaveMane();
            assertEquals(expectedHasMane, actualResult);
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), "Используйте допустимые значения пола животного - самец или самка");
        }
    }
}