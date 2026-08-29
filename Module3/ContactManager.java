import java.util.ArrayList;
import java.util.HashMap;

public class ContactManager {
      public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("Ada Lovelace",
                new Contact("Ada Lovelace", "+1 617 555 0101"));

        contacts.put("Thomas Anderson",
                new Contact("Thomas Anderson", "+1 617 555 0102"));

        contacts.put("Kevin McCallister",
                new Contact("Kevin McCallister", "+1 617 555 0103"));

        contacts.put("Gordon Freeman",
                new Contact("Gordon Freeman", "+1 617 555 0104"));

        contacts.put("Peter Parker",
                new Contact("Peter Parker", "+1 617 555 0105"));
        // Step 5: look up a contact
        //1st call
        System.out.println(contacts.get("Ada Lovelace"));
        //2nd call (404)
        System.out.println(contacts.getOrDefault("John Doe", Contact.NOT_FOUND));
        // Step 6: print sorted list
        //declared sorted array
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values()); 
        //alphabetically sort
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));
        //printing sorted list
        System.out.println("=== All Contacts ===");
        for (Contact contact : sorted) {
            System.out.println(contact);
        }
    } 
}
