package Task_5;

import java.io.IOException;

/**
 * Інтерфейс який представляє команду
 */
public interface Command {
    /** Виконує команду */
    public void execute() throws IOException, ClassNotFoundException;
}
