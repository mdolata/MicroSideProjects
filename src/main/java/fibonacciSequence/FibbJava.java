package fibonacciSequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class FibbJava {

    List<Integer> generateFibbonaci(int n){
        return fibb(0,1,n);
    }

    private List<Integer> fibb(int first, int second, int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }

        ArrayList<Integer> ints = new ArrayList<>();
        int current = first + second;
        ints.add(first);
        ints.addAll(fibb(second, current, n-1));
        return ints;
    }
}
