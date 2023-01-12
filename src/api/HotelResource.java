package api;

import Service.CustomerService;
import Service.ReservationService;
import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
public static Customer getCustomer(String email) {
    return CustomerService.getCustomer(email);
}
    public static void createACustomer(String email, String firstName, String lastName) {
       CustomerService.addCustomer(email, firstName, lastName);
    }
    public static IRoom getRoom(String roomNumber) {
       return ReservationService.getRoom(roomNumber);
    }
public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate ){

return ReservationService.reserveRoom(CustomerService.getCustomer(customerEmail),room,checkInDate,checkOutDate);
}
public static Collection<Reservation> getCustomerReservations(String customerEmail){

    return ReservationService.getCustomersReservations(CustomerService.getCustomer(customerEmail));
}
public static Collection<IRoom> findRoom(Date checkInDate, Date checkOutDate){
    return  ReservationService.findRooms(checkInDate, checkOutDate);

}

    public static String checkReserved(String num, Date checkIn, Date checkOut){
        for(IRoom room: findRoom(checkIn, checkOut)){
            if(room.getRoomNumber().equals(num)){
                return null;
            }

        }

        return num;
    }
}
