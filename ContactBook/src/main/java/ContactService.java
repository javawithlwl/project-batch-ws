import java.util.List;

public interface ContactService {

    List<Contact> addContact();
    List<Contact> getContacts();
    List<Contact> search(String str);
    Contact updateContact(Contact contact);
    boolean deleteContact(int id);
    Contact getContact(int id);
    void export(String type);
    void importContacts(String type);
}
