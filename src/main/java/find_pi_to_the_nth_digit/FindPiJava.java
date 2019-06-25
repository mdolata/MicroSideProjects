package find_pi_to_the_nth_digit;

public class FindPiJava {

    private final String PI;

    public FindPiJava() {
        PI = "14159265358979323846264338327950288419716939937510582097494459230";
    }

    public int findNthDigitOfPI(int nth) {
        if (nth < 1) return -1;
        return Integer.valueOf(PI.substring(nth - 1, nth));
    }

}
