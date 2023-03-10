package api;

import Service.CustomerService;
import Service.ReservationService;
import model.Customer;
import model.IRoom;

import java.util.Collection;
import java.util.List;

public class AdminResource {

    public static Customer getCustomer(String email) {

        return CustomerService.getCustomer(email); }

    public static void addRoom(List<IRoom> rooms) {
    for (IRoom room : rooms){
        ReservationService.addRoom(room); }
    }

public static Collection<IRoom> getAllRooms() {

        return ReservationService.roomMap; }

    public static Collection<Customer> getAllCustomers() {

        return CustomerService.getAllCustomers(); }

    public static void displayAllReservations() {
       ReservationService.printAllReservations();
    }

public static String checkRoomNumber(String num){
        for(IRoom room: ReservationService.roomMap){
            if(room.getRoomNumber().equals(num)){
               return num;
            }

            }

    return null;
}

        }








