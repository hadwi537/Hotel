package Hotel;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        Hotel hotel = new Hotel();

        //will be a ui
        BookingRef br = new BookingRef(LocalDate.of(2022, 2, 20),
                LocalDate.of(2022,2,22), 3);

        hotel.bookRoom(br);
        System.out.println(hotel.getHotelRooms().toString());
    }

}
