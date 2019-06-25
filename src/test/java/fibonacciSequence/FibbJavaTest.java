package fibonacciSequence;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FibbJavaTest {

    private FibbJava fibbJava = new FibbJava();
    private FibbKotlin fibbKotlin = new FibbKotlin();

    private List<Integer> list = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811);

    @Test
    public void generateFibbonaciJava() {
        for (int i = 0; i < list.size(); i++) {
            List<Integer> generateFibbonaci = fibbJava.generateFibbonaci(i);
            Assert.assertEquals(list.subList(0, i), generateFibbonaci);
        }
    }

    @Test
    public void generateFibbonaciKotlin() {
        for (int i = 0; i < list.size(); i++) {
            List<Integer> generateFibbonaci = fibbKotlin.generateFibbonaci(i);
            Assert.assertEquals(list.subList(0, i), generateFibbonaci);
        }
    }
}