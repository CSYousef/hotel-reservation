package model;

public class FreeRoom extends Room{

    public FreeRoom(String roomNumber, double roomPrice, RoomType enumeration) {

        super(roomNumber, 0, enumeration);
    }

    public boolean isFree() {
        return true;
    }

    @Override
    public String toString() {
        return "FreeRoom{" + "roomNumber=" + roomNumber + ", roomPrice=" + roomPrice + ", enumeration=" + enumeration + "}";
    }
}
