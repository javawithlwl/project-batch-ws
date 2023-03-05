import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.sun.management.HotSpotDiagnosticMXBean.ThreadDumpFormat.JSON;

public class ContactServiceInMemoryImpl implements ContactService{

    private FileUtils fileUtils;
    public List<Contact> contactList;

    List<Contact> list ;

    public ContactServiceInMemoryImpl(){
        //contactList = new ArrayList<>();
        fileUtils = new FileUtils();
        try {
            contactList = fileUtils.readCotactFromJson();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    Scanner sc = new Scanner(System.in);
    @Override
    // To add contact i added the contact and return that in to list as Contac

    public List<Contact> addContact() {
        Contact contact1 = new Contact();
        contact1.setId(getIdFor());
        sc.nextLine();
        System.out.println("Enter name of contact");
        contact1.setName(sc.nextLine());
        System.out.println("Enter email");
        contact1.setEmail(this.addMail(sc.nextLine()));
        System.out.println("Enter Mobile number");
        contact1.setMobile(sc.nextDouble());
        //System.out.println("Enter DOB: ");s
        //contact1.setDob(LocalDate.parse(sc.nextLine()));
        System.out.println(String.format("Contact name : %s   Contact number: %s   Contact mail: %s ",contact1.getName(),contact1.getMobile(),contact1.getEmail()));
        contactList.add(contact1);

        return contactList;
    }

    @Override
    public List<Contact> getContacts() {

        for (Contact c:contactList){
            System.out.println(String.format(
                    "Contact id: %s,  Contact name: %s,  Contact mobile number: %s,    Contact Email: %s",
                    c.getId(),c.getName(),c.getMobile(),c.getEmail()));
        }
        return list;
    }

    @Override
    public List<Contact> search(String str) {
        List<Contact> list = contactList;
        sc.nextLine();
        List<Contact> contact2 = contactList.stream().filter(ele -> ele.getName() == str).collect(Collectors.toList());
        return contact2;
    }

    // Have to write code for update, while we're passing Contact contact in method, we have to initialize contact with null, so it's getting null pointerException
    // * I have to write it in proper way
    @Override
    public Contact updateContact(Contact contact) {
        String name = sc.nextLine();
        Double mobileno = sc.nextDouble();
        List<Contact> contactUpadate = contactList.stream().filter(ele-> ele.getName()==name).filter(e->e.getMobile()==mobileno).collect(Collectors.toList());
        for (Contact cont:contactUpadate){
            System.out.println("Enter updating name: ");
            cont.setName(sc.nextLine());
            System.out.println("Enter updating mail id: ");
            cont.setEmail(sc.nextLine());
            System.out.println("Enter new name: ");
            cont.setMobile(sc.nextDouble());
        }

        return contact;
    }

    @Override
    public boolean deleteContact(int id) {
        List<Contact> list = contactList;
        List<Contact> contact2 = contactList.stream().filter(ele -> ele.getId() == id).collect(Collectors.toList());
        if (contact2 instanceof List<Contact>){
            return list.removeAll(contact2);
        }
        return true;
    }

    @Override
    public Contact getContact(int id) {
        sc.nextLine();
        Contact cont = null;
        List<Contact> contact1 = contactList;
        List<Contact> contact2 = contact1.stream().filter(ele -> ele.getId() == id).collect(Collectors.toList());
        for (Contact c : contact2) {
            cont = Contact.builder()
                    .id(c.getId())
                    .name(c.getName())
                    .email(c.getEmail())
                    .mobile(c.getMobile())
                    .dob(c.getDob())
                    .build();
        }
        return cont;
    }

   @Override
    public void export(String type) {
        if (type.equalsIgnoreCase(String.valueOf(JSON))){
            try {
                fileUtils.writeCotactToJson(contactList);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if(type.equalsIgnoreCase("CSV")){
            try {
                fileUtils.writeCotactToCSV(contactList);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            System.out.println("Entered file type is invalid");
        }
    }

    @Override
    public void importContacts(String type) {
        if(type.equalsIgnoreCase(String.valueOf(JSON))){
            try {
                contactList = fileUtils.readCotactFromJson();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (type.equalsIgnoreCase("csv")) {
            try {
                contactList = fileUtils.readCotactFromCSV();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            System.out.println("Entered file type is invalid");
        }
    }

    private int getIdFor() {
        int num = 1;
        int idOfCon = ThreadLocalRandom.current().nextInt(1001, 10000) + num;
        num += 1;

        return idOfCon;
    }
    private String addMail(String a){
        if (a.contains("@gmail.com")){
            return a;
        }else{
            System.out.println("enter valid mail address! enter again :");
            a = sc.nextLine();
        }
        return a;
    }
    /*private Double checkMobile(Double m){
        String s=String.valueOf(m);
        System.out.println(s.length());
        if (s.length() == 10){
            return m;
        } else {
            System.out.println("Enterterd mobile number is wrong! enter corrent number: ");
            m= sc.nextDouble();
        }
        return m;
    }*/
}
