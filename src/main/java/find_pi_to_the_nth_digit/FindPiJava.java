package find_pi_to_the_nth_digit;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class FindPiJava {

    // Gauss–Legendre method
    public int findNthDigitOfPI(int nth) {
        if (nth < 0 || nth > 100) return -1;

        Variables var = calculateVariables(10);

        String PI = String.valueOf(getPI(var)).substring(2);

        System.out.println(PI);
        return Character.digit(PI.charAt(nth), 10);
    }

    private BigDecimal getPI(Variables var) {
        return var.a.add(var.b).pow(2).divide(var.t.multiply(new BigDecimal("4")), 10, RoundingMode.FLOOR);
    }

    private Variables calculateVariables(int precision) {
        Variables current = Variables.initial;

        for (int i = 0; i < precision; i++) {
            BigDecimal a = current.a.add(current.b).divide(new BigDecimal("2"), 10, RoundingMode.FLOOR);
            BigDecimal b = sqrt(current.a.add(current.b), 10);
            BigDecimal t = current.t.subtract(current.p.multiply(current.a.subtract(a).pow(2)));
            BigDecimal p = current.p.multiply(new BigDecimal("2"));

            current = new Variables(a, b, t, p);
        }
        return current;
    }

    private static BigDecimal sqrt(BigDecimal in, int scale){
        BigDecimal sqrt = new BigDecimal(1, MathContext.UNLIMITED);
        BigDecimal store = new BigDecimal(in.toString());
        boolean first = true;
        do{
            if (!first){
                store = new BigDecimal(sqrt.toString());
            }
            first = false;

            sqrt = in.divide(store, MathContext.UNLIMITED).add(store).divide(
                    BigDecimal.valueOf(2), MathContext.UNLIMITED);
        }while (!store.equals(sqrt));
        return sqrt;
    }

    private static class Variables {
        static final Variables initial = new Variables(BigDecimal.ONE, BigDecimal.ONE.divide(sqrt(new BigDecimal(2), 2 ), MathContext.UNLIMITED) , new BigDecimal("0.25"), BigDecimal.ONE);
        final BigDecimal a;
        final BigDecimal b;
        final BigDecimal t;
        final BigDecimal p;

        Variables(BigDecimal a, BigDecimal b, BigDecimal t, BigDecimal p) {
            this.a = a;
            this.b = b;
            this.t = t;
            this.p = p;
        }

        @Override
        public String toString() {
            return "Variables{" +
                    "a=" + a +
                    ", b=" + b +
                    ", t=" + t +
                    ", p=" + p +
                    '}';
        }
    }
}
