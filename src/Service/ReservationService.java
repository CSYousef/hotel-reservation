package Service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.*;


public class ReservationService {

    public static Reservation reservation;
    public static Collection<IRoom> roomMap = new ArrayList<IRoom>();
    public static Collection<Reservation> reservations = new ArrayList<Reservation>();

    public static void addRoom(IRoom room) {

        roomMap.add(room);
    }

  public static IRoom getRoom(String roomId) {

        for(IRoom room : roomMap){
            if(room.getRoomNumber().equals(roomId)){
                return room;
            }
        }
      return null;
  }

public static Reservation reserveRoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
         reservation = new Reservation(customer, room, checkInDate, checkOutDate);
         reservations.add(reservation);
         return reservation;

}

public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
    Collection<IRoom> Result = new ArrayList<IRoom>();
    for(IRoom room: roomMap){
        Result.add(room);
    }

    Collection<IRoom> Roomreserved = new ArrayList<>();
   for ( IRoom room : roomMap ) {
       for(Reservation reservation : reservations){
           if(room.getRoomNumber().equals(reservation.getRoom().getRoomNumber())){
       if (reservation.getCheckInDate().after(checkInDate) && reservation.getCheckInDate().before(checkOutDate)
               || reservation.getCheckOutDate().after(checkInDate) && reservation.getCheckOutDate().before(checkOutDate)
               || reservation.getCheckInDate().equals(checkInDate) && reservation.getCheckOutDate().equals(checkOutDate)
               ||checkInDate.after(reservation.getCheckInDate()) && checkInDate.before(reservation.getCheckOutDate())
               || checkOutDate.after(reservation.getCheckInDate()) && checkOutDate.before(reservation.getCheckOutDate())){
           Roomreserved.add(room);
       }} }
        }
   for(IRoom room: roomMap){

       if(Roomreserved.contains(room)){
           Result.remove(room);
       }
   }

   return Result;
}

public static Collection<Reservation> getCustomersReservations(Customer customer){
        Collection<Reservation> customers = new ArrayList<Reservation>();
        for(Reservation reservation : reservations)
            if(reservation.getCustomer().equals(customer)){
                customers.add(reservation);
            }
       return customers;
}

public static void printAllReservations(){
        for(Reservation reservation : reservations) {
            System.out.println(reservation.toString());
        }
}


}