package model;

import java.util.regex.Pattern;

public class Customer {
   private String firstName;
   private String lastName;
   private final String email;

   public Customer(String firstName, String lastName, String email ) {
       this.firstName = firstName;
       this.lastName = lastName;
       Pattern pattern = Pattern.compile("^(.+)@(.+).com$");
       if( !pattern.matcher(email).matches()){
           throw new IllegalArgumentException("Invalid email address must be: name@domain.com");
       }
       this.email = email;

   }
   public String getFirstName() {
       return firstName;
   }
   public void setFirstName(String firstName) {
       this.firstName = firstName;}
    public String getLastName() {
       return lastName;}
    public void setLastName(String lastName) {
       this.lastName = lastName;}
    public String getEmail() {
       return email;}



@Override
    public String toString() {
       return firstName + " " + lastName + " <" + email + ">";}



}
