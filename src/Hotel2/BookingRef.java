package Hotel2;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.*;

public class BookingRef {
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Room> bookedRooms;
    private int Numpeople;

    public BookingRef(LocalDate start, LocalDate end, int people, Hotel hotel)
        throws Exception{
        this.startDate = start;
        this.endDate = end;
        this.Numpeople = people;
        this.bookedRooms = bookRooms(hotel,start, end);
    }

    /**
     * Basically idea is to iterate through map until find
     * a free entry (null) or can fit the booking reference in
     *
     * logic:
     * finds the previous booking start date
     * i.e it goes along, finds a start date greater than this bokiong ends date
     * (so good on that end)
     * goes back and get the end date of the previous
     * tries to fit it in
     * @param hotel
     * @return
     */
    public List<Room> bookRooms(Hotel hotel, LocalDate start, LocalDate end)
    throws Exception{
        NavigableMap<LocalDate, List<BookingRef>> bookings = hotel.getBookings();

        //want to find the earliest last booking date that is less than the key
        //returns
        //d1 d d3

        NavigableMap<LocalDate, List<BookingRef>> bookingRange = bookings.subMap(
                end, true, start, true);
        //Iterate through this map:
        Iterator<Map.Entry<LocalDate, List<BookingRef>>> itr =
                bookingRange.entrySet().iterator();
        List<Room> rooms = new ArrayList<>(hotel.getRooms());

        if (bookingRange.isEmpty()){ //nothing there
            ArrayList<Room> bookedRooms = new ArrayList<>();
            bookedRooms.add(rooms.get(0));
            return bookedRooms;
        }

            //go through all boookings and get a list of used rooms
        for(Map.Entry mapElement : bookingRange.entrySet()){
            //get the booking Refs
            List<BookingRef> brRefList = (List<BookingRef>)mapElement.getValue();
            for (BookingRef b : brRefList){
                List<Room> bookedRooms = b.getBookedRooms();
                for (Room r : bookedRooms){
                    rooms.remove(r);
                }
            }
        }
        //remaining rooms
        //try to fill with people
        //this is a dynamic programming solution?
        //subarray = k
        if (rooms.size() > 0){
            ArrayList<Room> bookedRoom = new ArrayList<>();
            bookedRoom.add(rooms.get(0)); //just book one free room
            return bookedRoom;
        }
        System.out.println("no available rooms");
        throw new Exception();

    }


    public int getNumpeople() {
        return Numpeople;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public List<Room> getBookedRooms() {
        return bookedRooms;
    }
}