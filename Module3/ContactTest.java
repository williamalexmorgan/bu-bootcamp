import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach; 

public class ContactTest {

    private Contact contact;

    @BeforeEach
  void setUp() {
    contact = new Contact("Ada Lovelace", "+1 617 555 0101");
  } 

    @Test 
  void constructor_setsNameCorrectly() { 
    Contact c = new Contact("Ada Lovelace", "+1 617 555 0101"); 
    assertEquals("Ada Lovelace", c.getName()); 
  } 
 
  @Test
  void constructor_setsPhoneCorrectly() { 
    Contact c = new Contact("Ada Lovelace", "+1 617 555 0101"); 
    assertEquals("+1 617 555 0101", c.getPhone()); 
  } 
 
  @Test
  void getName_returnsExactString_notTransformed() { 
    Contact c = new Contact("Grace Hopper", "555-0000"); 
    assertEquals("Grace Hopper", c.getName());
  } 
 
  @Test
  void toString_containsName() { 
    Contact c = new Contact("Alan Turing", "555-0001"); 
    assertTrue(c.toString().contains("Alan Turing"));
  } 
 
  @Test
  void toString_containsPhone() {
    Contact c = new Contact("Alan Turing", "555-0001");
    assertTrue(c.toString().contains("555-0001"));
  }

  @Test
  //test that two different Contact objects with the same name are independent (changing one does not affect the other)
  void contactsWithSameName_areIndependent() {

      //Both are technically the same, but not same object
      Contact contact1 = new Contact("Ada Lovelace", "+1 617 555 0101");
      Contact contact2 = new Contact("Ada Lovelace", "+1 617 555 0101");

      //Change one object, but not supposed to change the other
      contact1.setPhone("+1 617 555 9999");

      //Assert
      assertEquals("+1 617 555 9999", contact1.getPhone());
      assertEquals("+1 617 555 0101", contact2.getPhone());
  }
}
