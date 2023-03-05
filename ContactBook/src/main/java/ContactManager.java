import java.util.List;
import java.util.Scanner;

public class ContactManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ContactService contactService = new ContactServiceInMemoryImpl();

        System.out.println("Options: 1:Add Contact   2: Get All Contacts   3: Search Contact   4:Update Contact   5:Delete Contact  6:Get Contact   7:Export Data 8.Import Contacts");
        while(true){
            System.out.println("Enter choice : ");
            int option = sc.nextInt();
            switch (option){
                case 1:
                    contactService.addContact();
                    break;
                case 2:
                    contactService.getContacts();
                    break;
                case 3:
                    System.out.println("Enter name of Contact");
                    List<Contact> list = contactService.search(sc.nextLine());
                    for (Contact c:list){
                        System.out.println(c.getMobile());
                    }
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Enter id to Delete: ");
                    System.out.println(contactService.deleteContact(sc.nextInt()));
                    break;
                case 6:
                    System.out.println(contactService.getContact(sc.nextInt()));
                    break;
                case 7:
                    sc.nextLine();
                    System.out.println("Enter file type: ");
                    String type = sc.nextLine();
                    contactService.export(type);
                    break;
                case 8:
                    sc.nextLine();
                    System.out.println("Enter file type");
                    String type1 = sc.nextLine();
                    contactService.importContacts(type1);
                    break;

            }
        }
    }

}



