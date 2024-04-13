package Task_7.Observers;

import Task_7.Observer;

import java.util.Objects;

public class Undo implements Observer {
    /** Сповіщення "наглядача" */
    @Override
    public void notify(String type, String message) {
        if (Objects.equals(type, "скасування")) {
            System.out.println("UNDO: " + message);
        }
    }
}