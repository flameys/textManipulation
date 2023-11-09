package testApplication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class testExpressionTest {
    String test = "Hi, ik ben {{naam}} en ik hou van {{fave_thing_2do}}. Ik hou van {{fave_food}}" +
            "\nMijn favo genre in muziek is {{insert_fave_musicgenre}}.";

    @org.junit.jupiter.api.Test
    void methodLees() {
        assertEquals(4,testExpression.methodLees(test));

    }

}