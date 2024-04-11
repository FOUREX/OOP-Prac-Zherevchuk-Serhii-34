package Task_6;

/**
 * Інтерфейс який представляє консольну команду також розширює інтерфейс {@link Command}
 */
public interface ConsoleCommand extends Command {
    /** Повертає ключ команди */
    public char getKey();
}
