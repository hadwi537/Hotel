package NonDivisbleSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Result {

    public static int nonDivisibleSubset(int k, List<Integer> s){
        int max_size = Math.min(1, s.size());
        HashMap<Integer, Integer> mod = new HashMap<>();
        int [] rem_counts = new int[k]; //ignore 0 index

        for (int i = 0; i < s.size(); i++){
            int rem = s.get(i) % k;
            rem_counts[rem] += 1;
        }
        printAr(rem_counts);
        int high = rem_counts.length -1;
        int low = 1;
        int count = 0;
        if (rem_counts[0] > 0){
            count = 1;
        }
        while(true){
            if (high < low){
                break;
            }
            if (high == low){
                if (rem_counts[high] > 0){
                    count += 1;
                    break;
                }
                break;
            }
            if (rem_counts[low] > rem_counts[high]){
                    count += rem_counts[low];
            } else {
                count += rem_counts[high];
            }
            low++;
            high--;
        }
        return count; //curr 47410
    }

    public static void printAr(int[] r){
        for(int i = 1; i < r.length; i++){
            System.out.print(r[i]);
            System.out.print(", ");
        }
        System.out.print("] \n");
    }

}
