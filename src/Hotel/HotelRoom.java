package Hotel;


import java.util.PriorityQueue;

public class HotelRoom extends Room {
    private PriorityQueue<BookingRef> bookings;

    public HotelRoom(String name, int size){
        super(name, size);
        bookings = new PriorityQueue<BookingRef>(new BookingComparator());
    }

    public PriorityQueue<BookingRef> getBookings(){
        return new PriorityQueue<BookingRef>(bookings);
    }

    /** not quite correctt Prioirty queue instanciation
     * Reference open
     * @param b
     */
    public void addBooking(BookingRef b){
        bookings.add(b);
    }
}
