package model;

public class Room implements IRoom{
    protected final String roomNumber;
    protected double roomPrice;
    protected RoomType enumeration;
    public Room(String roomNumber, double roomPrice, RoomType enumeration) {
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.enumeration = enumeration;
    }
    public String getRoomNumber() { return  roomNumber; }

    public Double getRoomPrice() { return roomPrice; }
    public void setRoomPrice(double roomPrice) { roomPrice = roomPrice; }
    public RoomType getRoomType() { return enumeration; }
    public void setEnumeration(RoomType enumeration) { this.enumeration = enumeration; }
    @Override
    public String toString() {
        return "Room{" + "roomNumber='" + roomNumber + "', roomPrice=" + roomPrice + ",Enumeration=" + enumeration + "}";}

    public boolean isFree() {
        return false;
    }


}
