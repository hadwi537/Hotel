package Hotel2;

import java.time.LocalDate;
import java.util.*;

//global bst
//
public class Hotel {
    /**
     * @sorted start date
     */
    private NavigableMap<LocalDate, List<BookingRef>> bookings=
            Collections.synchronizedNavigableMap(new TreeMap<>( new BookingComparator()));
    private List<Room> rooms;

    public Hotel() {
        rooms = new ArrayList(Arrays.asList(
                new HotelRoom("2A", 1),
                new HotelRoom("2B", 5),
                new HotelRoom("2D", 3),
                new HotelRoom("2C", 4)
        ));
    }

    public NavigableMap<LocalDate, List<BookingRef>> getBookings() {
        return bookings;
    }

    public List<Room> getRooms() {
        return rooms;
    }
    public void addBooking(BookingRef br){
        if (bookings.containsKey(br.getStartDate())){ //its replacing, want to just add a booking
            List<BookingRef> bookingsList = bookings.get(br.getStartDate());
            bookingsList.add(br);
            bookings.put(br.getStartDate(), bookingsList);
            return;
        }
        List<BookingRef> bookingsList = new ArrayList<>();
        bookingsList.add(br);
        bookings.put(br.getStartDate(), bookingsList);

    }
}
