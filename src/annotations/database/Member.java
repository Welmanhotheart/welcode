//: annotations/database/Member.java
package annotations.database;

import java.sql.Blob;

@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30)
    String firstName;
    @SQLString(50)
    String lastName;
    @SQLInteger
    Integer age;
    @SQLString(value = 30,
            constraints = @Constraints(primaryKey = true))
    String handle;

    @SQLBlob
    Blob image;

    @SQLChar(1)
    char gender;
    static int memberCount;

    public String getHandle() {
        return handle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return handle;
    }

    public Integer getAge() {
        return age;
    }
} ///:~
