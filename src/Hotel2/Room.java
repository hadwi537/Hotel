package Hotel2;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Could be a hotel room
 * or
 * Kitchen or bathroom or something
 *
 * Add impliements comparaotor to compare room sizes, prices etc
 * (can define multiple comparisons with comparator
 * Only one with Comparable)
 */
public abstract class Room {
    protected int ROOMSIZE; //can't change maximum size of the room
    public String roomName;
    public List<BookingRef> bookings;

    public Room(String name, int size, List<BookingRef> bookings){
        this.roomName = name;
        this.ROOMSIZE = size;
        this.bookings = bookings;
    }

    static final Comparator<Room> BY_PRICE =
            new Comparator<Room>() {
                @Override
                public int compare(Room o1, Room o2) {
                    return 0;
                }
            };
    /* impliemnt */
    static final Comparator<Room> BY_SIZE =
            new Comparator<Room>() {
                @Override
                public int compare(Room o1, Room o2) {
                    return 0;
                }
            };

    /* or define multiple classes like this */
    class BY_SIZE implements Comparator<Room> {
        @Override
        public int compare(Room a, Room b){
            return 0;
        }
    }
}
