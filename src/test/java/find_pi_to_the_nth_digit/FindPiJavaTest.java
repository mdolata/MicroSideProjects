package find_pi_to_the_nth_digit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class FindPiJavaTest {

    private FindPiJava findPiJava;
    private FindPiKotlin findPiKotlin;

    private String PI = String.valueOf(Math.PI).substring(2);

    @Before
    public void setUp() {
        findPiJava = new FindPiJava();
        findPiKotlin = new FindPiKotlin();
    }

    @Test
    public void findNthDigitOfPIJava() {
        for (int i = 0; i < 100; i++) {
            int expectedResult = getNthPiDigitFromConstant(i);
            int result = findPiJava.findNthDigitOfPI(i);

            Assert.assertEquals(expectedResult, result);
        }

    }

    @Test
    public void findNthDigitOfPIKotlin() {
        for (int i = 0; i < 100; i++) {
            int expectedResult = getNthPiDigitFromConstant(i);
            int result = findPiKotlin.findNthDigitOfPI(i);

            Assert.assertEquals(expectedResult, result);
        }
    }

    @Test
    public void checkPrivateMethod() {
        Assert.assertEquals(getNthPiDigitFromConstant(0), -1);
        Assert.assertEquals(getNthPiDigitFromConstant(1), 1);
        Assert.assertEquals(getNthPiDigitFromConstant(2), 4);
        Assert.assertEquals(getNthPiDigitFromConstant(3), 1);
        Assert.assertEquals(getNthPiDigitFromConstant(4), 5);
        Assert.assertEquals(getNthPiDigitFromConstant(5), 9);
        Assert.assertEquals(getNthPiDigitFromConstant(6), 2);
    }

    private int getNthPiDigitFromConstant(int nth) {
        if (nth < 1 || nth > 100) return -1;

        return Character.digit(PI.charAt(nth - 1), 10);
    }


}