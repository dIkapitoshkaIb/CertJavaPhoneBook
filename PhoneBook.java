import java.util.*;

public class PhoneBook {
    private HashMap<String, HashSet<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        HashSet<String> numbers = contacts.getOrDefault(name, new HashSet<>());
        numbers.add(phoneNumber);
        contacts.put(name, numbers);
    }

    public void printPhoneBook() {
        // Сортировка по убыванию числа телефонов
        List<Map.Entry<String, HashSet<String>>> sortedContacts = new ArrayList<>(contacts.entrySet());
        sortedContacts.sort((c1, c2) -> Integer.compare(c2.getValue().size(), c1.getValue().size()));

        for (Map.Entry<String, HashSet<String>> contact : sortedContacts) {
            System.out.println(contact.getKey() + ": " + contact.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addContact("Alice", "1234567890");
        phoneBook.addContact("Bob", "9876543210");
        phoneBook.addContact("Alice", "5556667777");
        phoneBook.addContact("Bob", "1112223333");

        phoneBook.printPhoneBook();
    }
}