import lombok.Data;

import java.util.List;

@Data
class ContactWraper {
    public List<ContactInfo> wraperList;
}
@Data
public class ContactInfo {
    public String id;
    public List<Contact> contactList;
}

