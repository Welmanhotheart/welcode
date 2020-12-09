package exercise.annotations;

import annotations.HashSetTest;
import net.mindview.atunit.Test;


public class HashSetTestExternal extends HashSetTest {
    public HashSetTestExternal(){}

    @Test
    void _initialization() {
        initialization();
    }

    @Test
    void __contains() {
        _contains();
    }

    @Test
    void __remove() {
        _remove();
    }

}