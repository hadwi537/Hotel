package Hotel2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class BookingComparator implements Comparator<LocalDate> {
    /**
     * Compare end dates
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(LocalDate o1, LocalDate o2) {
        long days =  ChronoUnit.DAYS.between(o1, o2);
        try {
            int intDays = (int) days;
            return intDays;
        } catch (ClassCastException e){}
        return Integer.MAX_VALUE;
    }
    public static int compareDates(LocalDate o1, LocalDate o2){
        long days =  ChronoUnit.DAYS.between(o1, o2);
        try {
            int intDays = (int) days;
            return intDays;
        } catch (ClassCastException e){}
        return Integer.MAX_VALUE;
    }
}
