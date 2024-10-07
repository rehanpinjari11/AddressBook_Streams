package com.bridgelabz.java.streams;

import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public Contact(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters and Setters for encapsulation
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }


    @Override
    public String toString() {
        return "Contact{" +
                "First Name='" + firstName + '\'' +
                ", Last Name='" + lastName + '\'' +
                ", Address='" + address + '\'' +
                ", City='" + city + '\'' +
                ", State='" + state + '\'' +
                ", Zip='" + zip + '\'' +
                ", Phone='" + phoneNumber + '\'' +
                ", Email='" + email + '\'' +
                '}';
    }
}

class AddressBookInfo {

    private ArrayList<Contact> contacts;

    // Constructor initializing the AddressBook with an empty contact list
    public AddressBookInfo() {
        contacts = new ArrayList<>();
    }

    // Method to add a contact to the address book
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // Method to display all contacts in the address book
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    // Method to find a contact by first and last name
    public Contact findContact(String firstName, String lastName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName)) {
                return contact;
            }
        }
        return null;
    }

    // Method to edit an existing contact's details
    public boolean editContact(String firstName, String lastName, Scanner scanner) {
        Contact contact = findContact(firstName, lastName);
        if (contact != null) {
            System.out.print("Enter new Address: ");
            contact.setAddress(scanner.nextLine());

            System.out.print("Enter new City: ");
            contact.setCity(scanner.nextLine());

            System.out.print("Enter new State: ");
            contact.setState(scanner.nextLine());

            System.out.print("Enter new Zip Code: ");
            contact.setZip(scanner.nextLine());

            System.out.print("Enter new Phone Number: ");
            contact.setPhoneNumber(scanner.nextLine());

            System.out.print("Enter new Email: ");
            contact.setEmail(scanner.nextLine());

            System.out.println("Contact updated successfully!\n");
            return true;
        } else {
            System.out.println("Contact not found.");
            return false;
        }
    }
}



public class AddressBook {

        private static AddressBookInfo addressBook = new AddressBookInfo();
        private static Scanner scanner = new Scanner(System.in);

        // Method to add a new contact to the address book
        private static void addNewContact () {
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter Address: ");
            String address = scanner.nextLine();

            System.out.print("Enter City: ");
            String city = scanner.nextLine();

            System.out.print("Enter State: ");
            String state = scanner.nextLine();

            System.out.print("Enter Zip Code: ");
            String zip = scanner.nextLine();

            System.out.print("Enter Phone Number: ");
            String phoneNumber = scanner.nextLine();

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            // Creating a new contact with user input
            Contact newContact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);

            // Adding the contact to the address book
            addressBook.addContact(newContact);
            System.out.println("Contact added successfully!\n");
        }

    // Method to edit an existing contact's details by name
    private static void editContact() {
        System.out.print("Enter First Name of the contact to edit: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name of the contact to edit: ");
        String lastName = scanner.nextLine();

        // Attempt to edit the contact details
        boolean success = addressBook.editContact(firstName, lastName, scanner);
        if (!success) {
            System.out.println("Could not find the specified contact.\n");
        }
    }

        public static void main (String[]args){
            while (true) {
                System.out.println("Address Book Menu:");
                System.out.println("1. Add New Contact");
                System.out.println("2. Edit Contact");
                System.out.println("3. Display All Contacts");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline left-over

                switch (choice) {
                    case 1:
                        addNewContact();
                        break;

                    case 2:
                        editContact();
                        break;

                    case 3:
                        addressBook.displayContacts();
                        break;

                    case 4:
                        System.out.println("Exiting Address Book. Goodbye!");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
