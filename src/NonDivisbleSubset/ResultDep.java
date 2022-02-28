package NonDivisbleSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Problem:
 *
 * Given a set S of disctinct integers, print the maximal subset S
 * where the sum of any 2 numbers in S'' is not divisible by k
 *
 * any S[i] for all 0 <= i <= len(S)
 * is either in the subset or not in the subset (optimal substructure here)
 *
 * the for S[j] : j != i
 * if (S[j] + S[i]) % k = 0 then both S[i] and S[j] in
 *
 */
public class ResultDep {

    /**
     *
     * @param k the divisor
     * @param s the list
     * @return
     */
    public static int nonDivisibleSubset(int k, List<Integer> s){
        Integer[] temp = s.toArray(new Integer[0]);

        int ndsLength = ndsRecurse(k, s, s.size() - 1, s.size() - 2); //starts at end
        return ndsLength;
    }

    /**
     *
     * @param k the divisor
     * @param s complete array
     * @param index index of value currently checking
     * @param curr j to check index
     * @return
     */
    public static int ndsRecurse(int k, List<Integer> s, int index, int curr){
        if (curr < 0 || index < 0){
            return 0; //base case
        }
        int valid = 0;

        //value at index curr
        int j = s.get(curr);
        //indivisible by k
        if ((s.get(index) + j) % k != 0){
            valid = 1;
        }

        int inc_size = ndsRecurse(k, s, index, curr - 1) + valid;//in nds
        int ex_size;
        if (index == curr){
            ex_size = ndsRecurse(k, s, index - 1, index - 1) + valid; //make sure dont compare to each other
        } else {
            ex_size = ndsRecurse(k, s, curr, index) + valid; //i.e ignore that index
        }
        return Math.max(ex_size, inc_size);
    }
}
