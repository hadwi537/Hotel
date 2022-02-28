package Hotel;

import java.awt.print.Book;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Hotel class
 * @author William Hadden
 */
public class Hotel {
    private ArrayList<HotelRoom> HotelRooms;

    public Hotel() {
        HotelRooms = new ArrayList(Arrays.asList(
                new HotelRoom("2A", 1),
                new HotelRoom("2B", 5),
                new HotelRoom("2D", 3),
                new HotelRoom("2C", 4)
        ));
    }
    public void bookRoom(BookingRef br) {
        //for each hotel room
        //get the earliest free date
        LocalDate brStartDate = br.getStartDate();

        //bfs through rooms
        Queue<SearchNode> q = new LinkedList<>();
        //initalise list
        for (HotelRoom hotelRoom : HotelRooms) {
            q.add(new SearchNode(hotelRoom, hotelRoom.getBookings()));
        }
        while (true) {
            HotelRoom curr = q.peek().h;
            PriorityQueue<BookingRef> qs = q.peek().q;
            q.remove(); //remove this index
            BookingRef currBr = qs.peek();
            if (currBr == null) { //there is space
                System.out.println(br);
                curr.addBooking(br);
                break;
            } else { //there isn't space, or can we fit in?
                qs.remove(); //remove first el
                q.add(new SearchNode(curr, qs));
            }
        }
    }

    private static class SearchNode{
        public HotelRoom h;
        public PriorityQueue<BookingRef> q;

        public SearchNode(HotelRoom h, PriorityQueue<BookingRef> q){
            this.h = h;
            this.q = q;
        }
    }

    public ArrayList<HotelRoom> getHotelRooms() {
        return HotelRooms;
    }
}
