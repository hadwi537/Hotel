package Hotel;

/**
 * Could be a hotel room
 * or
 * Kitchen or bathroom or something
 */
public abstract class Room {
    protected int ROOMSIZE; //can't change maximum size of the room
    public String roomName;

    public Room(String name, int size){
        this.roomName = name;
        this.ROOMSIZE = size;
    }

}
