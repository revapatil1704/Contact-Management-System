package contactmanagement;


	import java.io.*;
	import java.util.*;

	public class ContactManager {

	    static Scanner sc = new Scanner(System.in);
	    static ArrayList<contact> contacts = new ArrayList<>();
	    static final String FILE_NAME = "contacts.txt";

	    public static void main(String[] args) {

	        loadContacts();

	        int choice;

	        do {
	            System.out.println("\n===== CONTACT MANAGEMENT SYSTEM =====");
	            System.out.println("1. Add Contact");
	            System.out.println("2. View Contacts");
	            System.out.println("3. Update Contact");
	            System.out.println("4. Delete Contact");
	            System.out.println("5. Save Contacts");
	            System.out.println("6. Exit");

	            System.out.print("Enter choice: ");
	            choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {

	                case 1:
	                    addContact();
	                    break;

	                case 2:
	                    viewContacts();
	                    break;

	                case 3:
	                    updateContact();
	                    break;

	                case 4:
	                    deleteContact();
	                    break;

	                case 5:
	                    saveContacts();
	                    break;

	                case 6:
	                    saveContacts();
	                    System.out.println("Exiting...");
	                    break;

	                default:
	                    System.out.println("Invalid choice!");
	            }

	        } while (choice != 6);
	    }

	    // Add Contact
	    static void addContact() {

	        System.out.print("Enter Name: ");
	        String name = sc.nextLine();

	        System.out.print("Enter Phone: ");
	        String phone = sc.nextLine();

	        contacts.add(new contact(name, phone));

	        System.out.println("Contact Added!");
	    }

	    // View Contacts
	    static void viewContacts() {

	        if (contacts.isEmpty()) {
	            System.out.println("No contacts found.");
	            return;
	        }

	        System.out.println("\n--- Contact List ---");

	        for (int i = 0; i < contacts.size(); i++) {
	            contact c = contacts.get(i);

	            System.out.println((i + 1) + ". "
	                    + c.name + " - " + c.phone);
	        }
	    }

	    // Update Contact
	    static void updateContact() {

	        viewContacts();

	        System.out.print("Enter contact number to update: ");
	        int index = sc.nextInt() - 1;
	        sc.nextLine();

	        if (index >= 0 && index < contacts.size()) {

	            System.out.print("Enter new name: ");
	            String name = sc.nextLine();

	            System.out.print("Enter new phone: ");
	            String phone = sc.nextLine();

	            contacts.set(index, new contact(name, phone));

	            System.out.println("Contact Updated!");

	        } else {
	            System.out.println("Invalid contact number.");
	        }
	    }

	    // Delete Contact
	    static void deleteContact() {

	        viewContacts();

	        System.out.print("Enter contact number to delete: ");
	        int index = sc.nextInt() - 1;

	        if (index >= 0 && index < contacts.size()) {

	            contacts.remove(index);

	            System.out.println("Contact Deleted!");

	        } else {
	            System.out.println("Invalid contact number.");
	        }
	    }

	    // Save Contacts to File
	    static void saveContacts() {

	        try {

	            BufferedWriter bw = new BufferedWriter(
	                    new FileWriter(FILE_NAME));

	            for (contact c : contacts) {
	                bw.write(c.toString());
	                bw.newLine();
	            }

	            bw.close();

	            System.out.println("Contacts Saved!");

	        } catch (IOException e) {
	            System.out.println("Error saving file.");
	        }
	    }

	    // Load Contacts from File
	    static void loadContacts() {

	        try {

	            BufferedReader br = new BufferedReader(
	                    new FileReader(FILE_NAME));

	            String line;

	            while ((line = br.readLine()) != null) {

	                String[] data = line.split(",");

	                contacts.add(new contact(data[0], data[1]));
	            }

	            br.close();

	        } catch (IOException e) {
	            System.out.println("No previous contacts found.");
	        }
	    }
	}
