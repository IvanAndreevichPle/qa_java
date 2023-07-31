import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class FelineTestParams {
    @Parameterized.Parameter()
    public int kittensCount;
    @Parameterized.Parameter(1)
    public int expectedCount;

    @Parameterized.Parameters(name = "Count of kittens: {0}, expected kittens count: {1}")
    public static Object[][] params() {
        return new Object[][]{
                {0, 0},
                {1, 1},
                {12, 12}
        };
    }

    @Test
    public void testGetKittensWithArgumentsReturnsArgument() {
        Feline feline = new Feline();
        int actualResult = feline.getKittens(kittensCount);
        assertEquals(expectedCount, actualResult);
    }
}