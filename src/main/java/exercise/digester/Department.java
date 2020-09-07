package exercise.digester;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class Department {
    private String name;
    private String code;
    private Map<String, String> extension = new HashMap<String, String>();
    private List<User> users = new ArrayList<User>();

    public void addUser(User user) {
        this.users.add(user);
    }

    public void putExtension(String name, String value) {
        this.extension.put(name, value);
    }
}
