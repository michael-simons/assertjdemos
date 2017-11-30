/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.simons.assertjdemos;

import java.util.List;
import java.util.Map;

/**
 * @author Michael J. Simons
 */
public class WeirdService {
    public Object getSomething() {
        throw new UnsupportedOperationException("This is unsupported");
    }

    public Object getAString() {
        return "Hello";
    }

    public Object getTheRightThing() {
        return List.of(
            Map.of("firstName", "Michael", "lastName", "Simons"),
            Map.of("firstName", "Christina", "lastName", "Simons"),
            Map.of("firstName", "Anton", "lastName", "Simons"),
            Map.of("firstName", "Oskar", "lastName", "Simons")
        );
    }
}
