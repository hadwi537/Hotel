package Hotel2;


import java.util.ArrayList;
import java.util.PriorityQueue;

public class HotelRoom extends Room {

    /**
     *
     * @param name
     * @param size
     */
    public HotelRoom(String name, int size){
        super(name, size, new ArrayList<>());
    }

}
