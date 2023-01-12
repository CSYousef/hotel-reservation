package Service;

import model.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    private static Customer customer;

    private static Map<String, Customer> customerMap = new HashMap<String, Customer>();

    public final static void addCustomer(String email, String firstName, String lastName) {
       customer = new Customer( firstName, lastName,email);
       customerMap.put(customer.getEmail(), customer);
    }
    public static Customer getCustomer(String email) {

          return customerMap.get(email);
    }

    public static Collection<Customer> getAllCustomers() {
        return customerMap.values();
    }
    public static boolean EmailChecking(String email){
        boolean n = false ;
            if(getCustomer(email) != null){
                n = true;
            }
            else {n = false;}


        return n;
    }
}
