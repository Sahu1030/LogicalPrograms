package com.Practice.test;

public class XmlMapper {
	public static void main(String[] args)
            throws JsonProcessingException {

     String xml = "<User>\n" +
             "    <name>Sibin</name>\n" +
             "    <email>sibin@gmail.in</email>\n" +
             "    </User>";

     //Parse the XML into a User instance
     XmlMapper xmlMapper = new XmlMapper();
     User user = xmlMapper.readValue(xml, User.class);

    /* Once we have our User instance,
       we'll want to write it out as JSON
       using the familiar ObjectMapper:
     */
     ObjectMapper mapper = new ObjectMapper();
     String json = mapper.writeValueAsString(user);
     System.out.println(json);
 }
}

class User {

    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
