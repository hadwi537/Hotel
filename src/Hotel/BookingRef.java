package Hotel;

import java.time.LocalDate;

public class BookingRef {
    private LocalDate startDate;
    private LocalDate endDate;
    private Room[] bookedRooms;
    private int Numpeople;

    public BookingRef(LocalDate start, LocalDate end, int people){
        this.startDate = start;
        this.endDate = end;
        this.Numpeople = people;
        this.bookedRooms = HotelRoom
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

}