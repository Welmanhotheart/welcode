package enumerated;//: enumerated/OzWitch.java
// The witches in the land of Oz.

import static net.mindview.util.Print.*;

public enum OzWitch {
    // Instances must be defined first, before methods:
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby " +
            "Slippers, crushed by Dorothy's house"),
    SOUTH("Good by inference, but missing");//Here it's force to execute the constructor with arguments
    private String description;

    /**
     *  Constructor must be package or private access:
     *  constructor couldn't be public or protected.
     *  And through debugging, It can be shown that before executing the constructor below,
     *  constructor of Enum class here shown below must be executed as the first
     *  protected Enum(String name, int ordinal) {
     *    this.name = name;
     *    this.ordinal = ordinal;
     * }
    */
    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values())
            print(witch.name() + ": " + witch.getDescription());
    }
} /* Output:
WEST: Miss Gulch, aka the Wicked Witch of the West
NORTH: Glinda, the Good Witch of the North
EAST: Wicked Witch of the East, wearer of the Ruby Slippers, crushed by Dorothy's house
SOUTH: Good by inference, but missing
*///:~
