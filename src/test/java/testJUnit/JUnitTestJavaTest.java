package testJUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class JUnitTestJavaTest {

    private final Integer a;
    private final Integer b;
    private final Integer expectedResult;

    private JUnitTestJava javaTest;
    private JUnitTestKotlin kotlinTest;

    public JUnitTestJavaTest(Integer a, Integer b, Integer expectedResult) {
        this.a = a;
        this.b = b;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {1, 1, 2},
                {1, 2, 3},
                {5, 5, 10},
                {Integer.MAX_VALUE, 1, Integer.MIN_VALUE},
                {-10, -10, -20},
                {-10, 5, -5},
                {0, 0, 0}
        });
    }

    @Before
    public void setUp() {
        javaTest = new JUnitTestJava();
        kotlinTest = new JUnitTestKotlin();
    }

    @Test
    public void addTest4Java() {
        Integer result = javaTest.add(a, b);

        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void addTest4Kotlin() {
        Integer result = kotlinTest.add(a, b);

        Assert.assertEquals(result, expectedResult);
    }
}