package Task_7;

import java.util.HashMap;

/**
 * Інтерфейс спостерігаємого об'єкта
 */
public interface Observable {
    /** Додає спостерігача */
    void register(Observer observer);

    /**
     * Оповіщає всіх спостерігачів
     */
    public void notify(String type, String message);
}
