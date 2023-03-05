import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {


   public List<Contact> readCotactFromJson() throws IOException {
        List<Contact> contacts = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        ContactWraper cont = objectMapper.readValue(new File("ContactBook/src/main/resources/contacts.json"), ContactWraper.class);
        List<ContactInfo> contactlist = cont.getWraperList();
        for (ContactInfo conInfo:contactlist){
            conInfo.getId();
            List<Contact> listContact = conInfo.getContactList();
            for (Contact cont1:listContact){
                String name = cont1.getName();
                String email = cont1.getEmail();
                Double mobile = cont1.getMobile();
               // String dob = String.valueOf(cont1.getDob());
                Contact contact = Contact.builder()
                        .id(Integer.parseInt(conInfo.getId()))
                        .name(name)
                        .email(email)
                        .mobile(mobile)
                        //.dob(dob)
                        .build();
                contacts.add(contact);
            }
        }
        return contacts;
    }

    public List<Contact> writeCotactToJson(List<Contact> contacts) throws IOException {
        List<ContactInfo> wraperList = new ArrayList<>();

        Set<Integer> ids = contacts.stream().map(ele -> ele.getId()).collect(Collectors.toSet());
        Map<Integer, List<Contact>> contactsMap = contacts.stream().collect(Collectors.groupingBy(Contact::getId));

        for (Integer id : ids) {
            List<Contact> idContacts = contactsMap.get(id);
            Map<Integer, List<Contact>> contactMap = idContacts.stream().collect(Collectors.groupingBy(Contact::getId));
            List<Contact> contactList = new ArrayList<>();
            contactMap.forEach((contactId, idContactList) -> {
                for (Contact det : idContactList) {
                    Contact contactObj = new Contact();
                    contactObj.setName(det.name);
                    contactObj.setEmail(det.email);
                    contactObj.setMobile(det.mobile);
                    contactObj.setDob(det.getDob());
                    contactList.add(contactObj);
                }
            });
            ContactInfo contactWraper = new ContactInfo();
            contactWraper.setId(String.valueOf(id));
            contactWraper.setContactList(contactList);
            wraperList.add(contactWraper);
        }
        ContactWraper contactWraper = new ContactWraper();
        contactWraper.setWraperList(wraperList);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        objectMapper.writeValue(new File("ContactBook/src/main/resources/contacts.json"), contactWraper);
        return contacts;
    }


    public List<Contact> readCotactFromCSV() throws IOException {
        Reader reader = null;
        try {
            reader = new FileReader(new File(FileUtils.class.getResource("/contacts.csv").getFile()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String[] HEADERS = "id,name,email,mobile,dob".split(",");
        List<Contact> contacts = new ArrayList<>();
        Iterable<CSVRecord> recordContacts = CSVFormat.DEFAULT
                .withHeader(HEADERS)
                .withFirstRecordAsHeader()
                .parse(reader);

        for (CSVRecord record : recordContacts) {
            int id = Integer.parseInt(record.get("id"));
            String name = record.get("name");
            String email = record.get("email");
            String mobile = record.get("mobile");
            //String dob = record.get("dob");
            Contact contact = Contact.builder()
                    .id(id)
                    .name(name)
                    .email(email)
                    .mobile(Double.valueOf(mobile))
                   // .dob(LocalDate.parse(dob))
                    .build();
            contacts.add(contact);
        }
        return contacts;
    }

    public void writeCotactToCSV(List<Contact> list) throws IOException {


        File file = new File("ContactBook/src/main/resources/contacts.csv");

        String header[] = new String[]{"id", "name", "email", "mobile", "dob"};
        List<String[]> contList = new ArrayList<>();
        contList.add(header);
        for (Contact c : list) {
            String[] cnt = new String[4];
            cnt[0] = String.valueOf(c.getId());
            cnt[1] = c.getName();
            cnt[2] = c.getEmail();
            cnt[3] = String.valueOf(c.getMobile());
            //cnt[4] = String.valueOf(c.getDob());
            contList.add(cnt);
        }

        try (PrintWriter pw = new PrintWriter(file)) {
            contList.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        }
        assert(file.exists());

    }

    private String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }
    private String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }
}
