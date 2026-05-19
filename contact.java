package contactmanagement;
public class contact {
    String name;
    String phone;

    public contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return name + "," + phone;
    }
}