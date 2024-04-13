package Task_7.Observers;

import Task_7.Observer;

import java.util.Objects;

public class Init implements Observer {
    /** Сповіщення "наглядача" */
    @Override
    public void notify(String type, String message) {
        if (Objects.equals(type, "генерація")) {
            System.out.println("INIT: " + message);
        }
    }
}
