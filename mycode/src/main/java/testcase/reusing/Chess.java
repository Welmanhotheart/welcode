//: reusing/Chess.java
// Inheritance, constructors and arguments.
package testcase.reusing;
import static sourcecode.net.mindview.util.Print.*;
//Exercise6
class Game {
    Game(int i) {
        print("Game constructor");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        print("BoardGame constructor");
    }
}

public class Chess extends BoardGame {
    Chess() {
        super(11);//must be the first statement in the constructor body
        print("Chess constructor");
    }

    public static void main(String[] args) {
        Chess x = new Chess();
    }
} /* Output:
Game constructor
BoardGame constructor
Chess constructor
*///:~
