import Service.CustomerService;
import api.HotelResource;
import model.IRoom;
import model.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class MainMenu {
  static Scanner scanner = new Scanner(System.in);

  public static void mainMenu(){
     String num;
    System.out.print("\nWelcome to the Hotel Reservation Application\n" +
            "--------------------------------------------\n" +
            "1. Find and reserve a room\n" +
            "2. See my reservations\n" +
            "3. Create an Account\n" +
            "4. Admin\n" +
            "5. Exit\n" +
            "--------------------------------------------\n" +
            "Please select a number for the menu option:\n");
           num = scanner.next();
           while (num != "5"){

               switch (num){
               case "1":  findAndReserveRoom();
               break;
               case "2": seeMyReservation();
               break;
               case "3": createAccount();
               break;
               case "4": AdminMenu.AdminMenu();
               break;
               case "5": System.out.println("exit");
              break;
                   default: System.out.println("Please select a valid option");
               break;
               }
               num = scanner.next();
}

}
    public static void findAndReserveRoom()  {

      String num, email;
      Date checkIn = new Date();
        Date checkOut = new Date();

        System.out.println("Enter your Email Like: name@domain.com");
        email = scanner.next();
        if(CustomerService.EmailChecking(email) == true){
        System.out.println("Enter CheckIn Date dd/MM/yyyy");
        try {
             checkIn = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.next());
        } catch (ParseException ex) {
            System.out.println("Error: Invalid date.");
            findAndReserveRoom();
        }

        System.out.println("Enter CheckOut Date dd/MM/yyyy ");
         try {
              checkOut =new SimpleDateFormat("dd/MM/yyyy").parse(scanner.next());
        } catch (ParseException ex) {
            System.out.println("Error: Invalid date.");
            findAndReserveRoom();
        }

    if(checkIn!= null && checkOut!= null) {

        try {
            if (!HotelResource.findRoom(checkIn, checkOut).isEmpty()) {

                for (IRoom room : HotelResource.findRoom(checkIn, checkOut)) {
                    System.out.println(room.toString());
                }
                System.out.println("Choose a room ( Please Enter the room number)");
                num = scanner.next();
                if(num != HotelResource.checkReserved(num,checkIn, checkOut) ){
                HotelResource.bookARoom(email, HotelResource.getRoom(num), checkIn, checkOut);
                    System.out.println("successfully!");
                }
                else{ System.out.println("This room Already reserved try with other room or the room number is invalid");}
                mainMenu();
            } else {
                System.out.println("There is no Room");
            }
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
}
        mainMenu();}
        else{
            System.out.println("please Create Account");
            mainMenu();}

    }
    public static void seeMyReservation(){
        System.out.println("Enter your Email Like: name@domain.com");
         String email = scanner.next();
        if(CustomerService.EmailChecking(email) == true){
         if(HotelResource.getCustomerReservations(email).isEmpty()){
             System.out.println(" There are no Reservation");
         }
         else{

             for (Reservation reservation : HotelResource.getCustomerReservations(email)){
                 System.out.println(reservation.toString());
             }

        }
         mainMenu();}
          else{
            System.out.println("please Create Account");
            mainMenu();}
    }
    public static void createAccount(){
        System.out.println("Enter your Email Like: name@domain.com");
         String email = scanner.next();
        if(CustomerService.EmailChecking(email) == true){
            System.out.println("The Email is already Used Please try with another Email.");
            createAccount();
        }
         else{
        System.out.println("First Name:");
         String firstName = scanner.next();

        System.out.println("Last Name:");
         String lastName = scanner.next();

        try {
            HotelResource.createACustomer(email, firstName, lastName);
            System.out.println("successfully!");

            mainMenu();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getLocalizedMessage());
            createAccount();
        }}


    }

}
