package Task_7.Observers;

import Task_7.Observer;

import java.util.Objects;

public class Serialization implements Observer {
    /** Сповіщення "наглядача" */
    @Override
    public void notify(String type, String message) {
        if (Objects.equals(type, "серіалізація")) {
            System.out.println("SERIALIZE: " + message);
        }
    }
}
