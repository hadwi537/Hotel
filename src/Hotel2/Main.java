package Hotel2;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;

/**
 * ToDO add method to remove old booking references
 * (basically will only matter when start using todays date
 * or when someone want to change their booking)
 * TODO add avaialble rooms method
 */
public class Main {
    public static void main(String[] args){
        Hotel hotel = new Hotel();

        //will be a ui
        try {
            BookingRef br = new BookingRef(LocalDate.of(2022, 2, 20),
                    LocalDate.of(2022,2,22), 3, hotel);
            BookingRef br2 = new BookingRef(LocalDate.of(2022, 2, 20),
                    LocalDate.of(2022,2,22), 3, hotel);
            BookingRef br3 = new BookingRef(LocalDate.of(2022, 1, 1),
                    LocalDate.of(2022,1,3), 3, hotel);
            BookingRef br4 = new BookingRef(LocalDate.of(2022, 1, 5),
                    LocalDate.of(2022,1,6), 3, hotel);
            BookingRef br5 = new BookingRef(LocalDate.of(2022, 1, 3),
                    LocalDate.of(2022,1,4), 3, hotel);

            hotel.addBooking(br);
            hotel.addBooking(br2);
            hotel.addBooking(br3);
            hotel.addBooking(br4);
            hotel.addBooking(br5);
            System.out.println(hotel.getBookings());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
