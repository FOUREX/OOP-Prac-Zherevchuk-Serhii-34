package Task_7;

import java.util.HashMap;

/**
 * Інтерфейс "наглядача"
 */
public interface Observer {
    /** Сповіщення "наглядача" */
    void notify(String type, String message);
}
