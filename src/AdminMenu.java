import Service.ReservationService;
import api.AdminResource;
import model.Customer;
import model.IRoom;
import model.Room;
import model.RoomType;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {

    static Scanner scanner = new Scanner(System.in);

    public static void AdminMenu(){
        String num;
        System.out.println("\nAdmin Menu\n" +
                "--------------------------------------------\n" +
                "1. See all Customers\n" +
                "2. See all Rooms\n" +
                "3. See all Reservations\n" +
                "4. Add a Room\n" +
                "5. Back to Main Menu\n" +
                "--------------------------------------------\n" +
                "Please select a number for the menu option:\n");

        num = scanner.next();
        while (num != "5") {
            switch (num) {
                case "1":
                    seeAllCustomers();
                    break;
                case "2":
                    seeAllRooms();
                    break;
                case "3":
                    seeAllReservations();
                    break;
                case "4":
                    AddARoom();
                    break;
                case "5":
                    MainMenu.mainMenu();
                    break;
                default:
                    System.out.println("Please select a valid option");
                    break;
            }
            num = scanner.next();
        }

    }
    public static void seeAllCustomers(){
        if(AdminResource.getAllCustomers().isEmpty()){
            System.out.println("There are no Customers");
        }
        else{
            for (Customer customer : AdminResource.getAllCustomers()) {
              System.out.println(customer.toString());
            }

        }

        AdminMenu();
    }
    public static void seeAllRooms(){
        if(AdminResource.getAllRooms().isEmpty()){
            System.out.println("There are no Rooms");
        }
        else{

            for(IRoom room : AdminResource.getAllRooms()){
                System.out.println(room.toString());
            }

        }
        AdminMenu();
    }
    public static void seeAllReservations(){
        if(ReservationService.reservation == null){
            System.out.println("There are no Reservations");
        }
        else{
        AdminResource.displayAllReservations();}
        AdminMenu();
    }

    public static void AddARoom() {
try{

        System.out.println("Enter room number:");
        String roomNumber = scanner.next();
    if(roomNumber != AdminResource.checkRoomNumber(roomNumber)){
        System.out.println("Enter price:");
        double roomPrice = scanner.nextDouble();
        System.out.println("Enter room type: 1 for single bed, 2 for double bed:");
        int roomType = scanner.nextInt();
        RoomType a = RoomType.SINGLE;
        RoomType b = RoomType.DOUBLE;
        Room room = null;
        if (roomType == 1) {
            room = new Room(roomNumber, roomPrice, a);
        } else if (roomType == 2) {
            room = new Room(roomNumber, roomPrice, b);
        } else {
            System.out.println("Please enter a valid room type");
            AddARoom();
        }
        ReservationService.addRoom(room);
        System.out.println("successfully!");

        AdminMenu();
    }else {
        System.out.println(" try with a different room number");
        AdminMenu();
    }
}
catch (Exception e){
    System.out.println("Please enter a valid inputs");
      AdminMenu();

}
    }

}

