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
import static org.junit.Assert.assertThrows;

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
                {"Самка", false}
        };
    }

    @Test
    public void doesHaveMane() throws Exception {
            Lion lion = new Lion(sex, feline);
            boolean actualResult = lion.doesHaveMane();
            assertEquals(expectedHasMane, actualResult);
    }
}