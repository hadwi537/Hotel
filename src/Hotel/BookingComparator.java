package Hotel;

import java.awt.print.Book;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class BookingComparator implements Comparator<BookingRef> {

    /**
     * Compare end dates
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(BookingRef o1, BookingRef o2) {
        long days =  ChronoUnit.DAYS.between(o1.getEndDate(), o2.getEndDate());
        try {
            int intDays = (int) days;
            return intDays;
        } catch (ClassCastException e){}
        return Integer.MAX_VALUE;
    }
}
