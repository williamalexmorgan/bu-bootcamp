public class Contact {

    private String name;
    private String phone;

    public static final Contact NOT_FOUND =
            new Contact("Contact not found.", "");

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {

        if (this == NOT_FOUND) {
            return "Contact not found.";
        }

        return name + " | " + phone;
    }
}